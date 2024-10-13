package ru.lims.patients.messaging;

import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.patients.dto.ConsultationUpdateDto;
import ru.lims.patients.service.ConsultationService;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientListener {

    private ConsultationService consultationService;

    @RabbitListener(queues = "${rabbitmq.queue.doctor-gateway-to-patient}")
    public void consume(ConsultationUpdateDto consultationUpdateDto) {
        try {
            consultationService.update(consultationUpdateDto);
            System.out.println("Rabbit message: " + consultationUpdateDto);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
