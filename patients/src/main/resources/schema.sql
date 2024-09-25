create table patients
(
    id            bigserial,
    name          varchar(255),
    lastName      varchar(255),
    middleName    varchar(255),
    gender        varchar(255),
    date_of_birth datetime,
    phone_number  varchar(255),
    address       varchar(255),
    email         varchar(255),
    primary key (id)
);

create table medical_histories
(
    id                      bigserial,
    patient_id              bigint references patients (id) on delete cascade,
    history_number          varchar(255),
    insurance_policy_number varchar(255),
    primary key (id)
);

create table consultations
(
    id                 bigserial,
    doctor_id          bigint,
    consultation_date  datetime,
    consultation_text  varchar(255),
    medical_history_id bigint references medical_histories (id) on delete cascade,
    primary key (id)
);