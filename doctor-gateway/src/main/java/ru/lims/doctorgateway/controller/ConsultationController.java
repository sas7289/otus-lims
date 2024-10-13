package ru.lims.doctorgateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lims.doctorgateway.dto.ConsultationUpdateDto;
import ru.lims.doctorgateway.service.ConsultationService;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Operation(summary = "Создать новый анализ для медицинской истории с ID medicalHistoryId",
        description = "Создаёт заготовку для новой консультации")
    @ApiResponse(responseCode = "200", description = "Консультация успешно создана")
    @PostMapping("/consultation")
    public ResponseEntity<Long> create(@RequestParam(name = "medicalHistoryId") Long medicalHistoryId) {
        long consultationId = consultationService.create(medicalHistoryId);
        return ResponseEntity.ok(consultationId);
    }

    @Operation(summary = "Обновить информацию о консультации и назначенных исследованиях",
        description = "Обновляет информацию о консультации и назначенных исследованиях")
    @ApiResponse(responseCode = "200", description = "Консультация успешно обнолвена")
    @PutMapping("/consultation")
    @Valid
    public ResponseEntity<Long> update(@Valid @RequestBody ConsultationUpdateDto consultationUpdateDto) {
        consultationService.update(consultationUpdateDto);
        return ResponseEntity.ok().build();
    }

}
