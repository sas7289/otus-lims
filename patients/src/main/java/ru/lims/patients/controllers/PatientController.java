package ru.lims.patients.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.service.PatientService;

@Controller()
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }
}