package ru.lims.doctorgateway.service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.lims.doctorgateway.dto.ConsultationUpdateDto;

@Service
public class ConsultationService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ConsultationGateway consultationGateway;

    public Long create(Long medicalHistoryId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/consultation")
            .queryParam("medicalHistoryId", medicalHistoryId)
            .build().encode().toUri();
        return restTemplate.postForObject(uri, null, Long.class);
    }

    public void update(ConsultationUpdateDto consultationUpdateDto) {
        consultationGateway.processConsultation(consultationUpdateDto);
    }
}
