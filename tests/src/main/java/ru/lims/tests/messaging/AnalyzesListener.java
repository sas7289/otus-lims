package ru.lims.tests.messaging;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.service.AnalysisService;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnalyzesListener {

    private AnalysisService analysisService;

    @RabbitListener(queues = "${rabbitmq.queue.doctor-gateway-to-test}")
    public void consume(List<AnalysisDto> analysisDtos) {
        try {
            analysisService.update(analysisDtos);
            System.out.println("Rabbit message: " + analysisDtos);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
