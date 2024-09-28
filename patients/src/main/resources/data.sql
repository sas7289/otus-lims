insert into patients(name, last_name, middle_name, gender, date_of_birth, phone_number, address, email)
values ('PatientName1', 'PatientLastName1', 'PatientMiddleName1', 'male', '2000-09-25 15:30:00',
        '89998887766', 'Moscow, Kremlin', 'm22@mail.ru'),
       ('PatientName2', 'PatientLastName2', 'PatientMiddleName2', 'male', '2001-09-25 15:30:00',
        '89998887755', 'Moscow, Kremlin', 'm33@mail.ru'),
       ('PatientName3', 'PatientLastName3', 'PatientMiddleName3', 'male', '2002-09-25 15:30:00',
        '89998887744', 'Moscow, Kremlin', 'm33@mail.ru');



insert into medical_histories(patient_id, history_number, insurance_policy_number)
values ('1', 'A1', '1234567'),
       ('2', 'A2', '12345678'),
       ('3', 'A3', '12345679');



insert into consultations(doctor_id, consultation_date, consultation_text, medical_history_id)
values ('1', '2024-09-25 15:30:00', 'Lorem ipsum1', '1'),
       ('2', '2024-09-20 15:30:00', 'Lorem ipsum2', '2'),
       ('3', '2024-09-10 15:30:00', 'Lorem ipsum3', '3');

