create table biomaterials
(
    id                    bigserial,
    type                  varchar(255),
    collection_date       datetime,
    lab_delivery_date      datetime,
    comment               varchar(255),
    collector_employee_id bigint,
    primary key (id)
);


create table tests
(
    id                  bigserial,
    name                varchar(255),
    type                varchar(255),
    material_type        varchar(255),
    min_reference_value int,
    max_reference_value int,
    primary key (id)
);


create table analyzes
(
    id                       bigserial,
    appointment_date         datetime,
    test_id                  bigint references tests (id) on delete cascade,
    biomaterial_id           bigint references biomaterials (id) on delete cascade,
    status                   varchar(255),
    performed_by_employee_id bigint,
    patient_id               bigint,
    primary key (id)
);

create table test_results
(
    id                       bigserial,
    performed_date           datetime,
    patient_id               bigint,
    result_value             int,
    performed_by_employee_id bigint,
    comment                  varchar(255),
    analysis_id              bigint references analyzes (id) on delete cascade,
    primary key (id)
);