package ru.lims.doctorgateway.service;

import java.net.URI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AnalysisService {

    private final RestTemplate restTemplate = new RestTemplate();


    public Long create(Long testId, Long patientId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8083/analysis")
            .queryParam("testId", testId)
            .queryParam("patientId", patientId)
            .build().encode().toUri();
        return restTemplate.postForObject(uri, null, Long.class);
    }
}
