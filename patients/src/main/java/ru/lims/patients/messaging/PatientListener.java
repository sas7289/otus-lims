package ru.lims.patients.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PatientListener {

    @RabbitListener(queues = "${rabbitmq.queue.doctor-gateway-to-patient}")
    public void consume(String message) {
        System.out.println("Rabbit message: " + message);
    }

}
