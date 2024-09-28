create table departments
(
    id          bigserial,
    name        varchar(255),
    description varchar(255),
    primary key (id)
);

create table employees
(
    id            bigserial,
    first_name    varchar(255),
    last_name     varchar(255),
    middle_name   varchar(255),
    department_id bigint references departments (id) on delete cascade,
    position      varchar(255),
    primary key (id)
);

