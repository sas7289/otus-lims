package ru.lims.doctorgateway.conf;

import java.util.List;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannelSpec;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import ru.lims.doctorgateway.dto.AnalysisDto;
import ru.lims.doctorgateway.dto.GlobalPatientDto;
import ru.lims.doctorgateway.dto.EmployeeDto;
import ru.lims.doctorgateway.dto.PatientDto;

@Configuration
public class IntegrationConfiguration {


    @Bean
    public IntegrationFlow preparePatientData() {
        return IntegrationFlow.from(Http.inboundGateway("/patient/{id}")
                .requestMapping(m -> m.methods(HttpMethod.GET))
                .payloadExpression("#pathVariables.id")
                .requestPayloadType(String.class)
            )
            .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.headerExpression("patientId", "payload"))
            .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.header("complex", new GlobalPatientDto()))
            .handle((payload, headers) -> new GlobalPatientDto())
            .handle(Http.outboundGateway("http://localhost:8081/patient/{id}")
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(PatientDto.class)
                .uriVariable("id", "headers['patientId']"))
            .enrich(enricherSpec ->
                enricherSpec.headerFunction("complex",
                    message -> {
                        GlobalPatientDto globalPatientDto = (GlobalPatientDto) message.getHeaders().get("globalPatientDto");
                        PatientDto patientDto = (PatientDto) message.getPayload();
                        globalPatientDto.setPatient(patientDto);
                        return globalPatientDto;
                    })
            )
            .handle(Http.outboundGateway("http://localhost:8082/employee/{id}")
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(EmployeeDto.class)
                .uriVariable("id", "headers['patientId']"))
            .enrich(enricherSpec ->
                enricherSpec.headerFunction("complex",
                    message -> {
                        GlobalPatientDto globalPatientDto = (GlobalPatientDto) message.getHeaders().get("globalPatientDto");
                        EmployeeDto employeeDto = (EmployeeDto) message.getPayload();
                        globalPatientDto.setEmployee(employeeDto);
                        return globalPatientDto;
                    })
            )
            .handle(Http.outboundGateway("http://localhost:8083/analysis/patient/{id}")
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(List.class)
                .uriVariable("id", "headers['patientId']"))
            .enrich(enricherSpec ->
                enricherSpec.headerFunction("complex",
                    message -> {
                        GlobalPatientDto globalPatientDto = (GlobalPatientDto) message.getHeaders().get("globalPatientDto");
                        List<AnalysisDto> analysisDtos = (List<AnalysisDto>) message.getPayload();
                        globalPatientDto.setAnalysisDto(analysisDtos);
                        return globalPatientDto;
                    })
            )
            .transform(Message.class, message -> message.getHeaders().get("complex"))
            .get();
    }


    @Bean
    public MessageChannelSpec<?, ?> consultationUpdateChannel() {
        return MessageChannels.queue(10);
    }

    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jackson2JsonMessageConverter);
        return template;
    }

    @Bean
    public IntegrationFlow saveConsultationDto(RabbitTemplate rabbitTemplate) {
        return IntegrationFlow.from(consultationUpdateChannel())
            .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.headerExpression("consultation", "payload"))
            .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.headerExpression("analyzes", "payload.analyzes"))
            .transform(Message.class, message -> message.getHeaders().get("consultation"))
            .handle((p, h) -> {
                rabbitTemplate.convertAndSend("updateConsultationDoctorGatewayToPatient", p);
                return p;
            })
            .transform(Message.class, message -> message.getHeaders().get("analyzes"))
            .handle(
                (p, h) -> {
                    rabbitTemplate.convertAndSend("updateAnalyzesDoctorGatewayToTest", p);
                    return p;
                }
            )
            .get();
    }
}
