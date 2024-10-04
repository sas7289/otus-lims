package ru.lims.doctorgateway.conf;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import ru.lims.doctorgateway.dto.Complex;
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
            .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.header("complex", new Complex()))
            .handle((payload, headers) -> new Complex())
            .handle(Http.outboundGateway("http://localhost:8081/patient/{id}")
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(PatientDto.class)
                .uriVariable("id", "headers['patientId']"))
            .enrich(enricherSpec ->
                enricherSpec.headerFunction("complex",
                    message -> {
                        Complex complex = (Complex) message.getHeaders().get("complex");
                        PatientDto patientDto = (PatientDto) message.getPayload();
                        complex.setPatient(patientDto);
                        return complex;
                    })
            )
            .handle(Http.outboundGateway("http://localhost:8082/employee/{id}")
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(EmployeeDto.class)
                .uriVariable("id", "headers['patientId']"))
            .enrich(enricherSpec ->
                enricherSpec.headerFunction("complex",
                    message -> {
                        Complex complex = (Complex) message.getHeaders().get("complex");
                        EmployeeDto employeeDto = (EmployeeDto) message.getPayload();
                        complex.setEmployee(employeeDto);
                        return complex;
                    })
            )
            .transform(Message.class, message -> message.getHeaders().get("complex"))
            .get();
    }

    @Bean
    public IntegrationFlow integrationFlow(RabbitTemplate rabbitTemplate) {
        return IntegrationFlow.from(Http.inboundGateway("/patient__/{id}")
                .requestMapping(m -> m.methods(HttpMethod.GET))
                .payloadExpression("#pathVariables.id")
                .requestPayloadType(String.class)
            )
//            .handle(message -> {
//                System.out.println(message.getPayload().toString());
//            })
            .handle(Amqp.outboundGateway(rabbitTemplate)
                .routingKey("testQueue"))
//            .handle(Http.outboundGateway("http://localhost:8081/patient/{id}")
//                .httpMethod(HttpMethod.GET)
//                .expectedResponseType(PatientDto.class)
//                .uriVariable("id", "payload"))
            .get();
    }

}
