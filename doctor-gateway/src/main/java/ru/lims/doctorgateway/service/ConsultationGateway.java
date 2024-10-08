package ru.lims.doctorgateway.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.lims.doctorgateway.dto.ConsultationUpdateDto;

@MessagingGateway
public interface ConsultationGateway {

    @Gateway(requestChannel = "consultationUpdateChannel")
    public void processConsultation(ConsultationUpdateDto consultationUpdateDto);

}