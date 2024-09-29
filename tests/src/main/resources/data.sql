-- Наполнение таблицы tests
INSERT INTO tests (name, type, material_type, min_reference_value, max_reference_value)
VALUES ('Blood Test', 'Hematology', 'Blood', 4, 10),
       ('Biochemical Analysis', 'Biochemistry', 'Blood', 30, 100),
       ('Urine Test', 'General', 'Urine', 1, 5);

-- Наполнение таблицы biomaterials
INSERT INTO biomaterials (type, collection_date, lab_delivery_date, comment, collector_employee_id)
VALUES ('Blood', '2024-09-01 09:00:00', '2024-09-01 12:00:00', 'Collected without issues', 101),
       ('Urine', '2024-09-02 10:30:00', '2024-09-02 13:00:00', 'Sample provided by patient', 102),
       ('Blood', '2024-09-03 11:00:00', '2024-09-03 14:30:00', 'Delayed collection', 103);

-- Наполнение таблицы analyzes
INSERT INTO analyzes (appointment_date, test_id, biomaterial_id, performed_by_employee_id, patient_id)
VALUES ('2024-09-05 10:00:00', 1, 1, 201, 301),
       ('2024-09-06 11:00:00', 2, 2, 202, 302),
       ('2024-09-07 12:00:00', 3, 3, 203, 303);

-- Наполнение таблицы test_results
INSERT INTO test_results (performed_date, patient_id, result_value, performed_by_employee_id, comment, analysis_id)
VALUES ('2024-09-06 14:00:00', 301, 8, 201, 'Within normal range', 1),
       ('2024-09-07 15:00:00', 302, 85, 202, 'Slightly elevated', 2),
       ('2024-09-08 16:00:00', 303, 3, 203, 'Normal result', 3);