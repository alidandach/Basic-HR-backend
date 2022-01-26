SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA IF NOT EXISTS app;

SET search_path TO app;

CREATE TABLE IF NOT EXISTS app.department
(
    id              SERIAL PRIMARY KEY,
    department_name character varying(255) UNIQUE NOT NULL
);

INSERT INTO app.department (department_name)
VALUES ('HR');
INSERT INTO app.department (department_name)
VALUES ('IT');

CREATE TABLE IF NOT EXISTS app.employee
(
    id               SERIAL PRIMARY KEY,
    employee_address character varying(255)        NOT NULL,
    employee_email   character varying(255) UNIQUE NOT NULL,
    employee_name    character varying(255)        NOT NULL,
    department_id    integer references app.department (id)
);

INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X10@ccc.net', 'X10', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X11@ccc.net', 'X11', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X12@ccc.net', 'X12', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X13@ccc.net', 'X13', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X14@ccc.net', 'X14', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X15@ccc.net', 'X15', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X16@ccc.net', 'X16', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X17@ccc.net', 'X17', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X18@ccc.net', 'X18', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X19@ccc.net', 'X19', 1);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'X20@ccc.net', 'X20', 1);

INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y10@ccc.net', 'Y10', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y11@ccc.net', 'Y11', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y12@ccc.net', 'Y12', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y13@ccc.net', 'Y13', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y14@ccc.net', 'Y14', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y15@ccc.net', 'Y15', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y16@ccc.net', 'Y16', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y17@ccc.net', 'Y17', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y18@ccc.net', 'Y18', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y19@ccc.net', 'Y19', 2);
INSERT INTO app.employee (employee_address, employee_email, employee_name, department_id)
VALUES ('LEB', 'Y20@ccc.net', 'Y20', 2);

CREATE TABLE IF NOT EXISTS app.leave_request_type
(
    id              SERIAL PRIMARY KEY,
    leave_request_type_name character varying(255) UNIQUE NOT NULL
);

INSERT INTO app.leave_request_type (leave_request_type_name)
VALUES ('sick');
INSERT INTO app.leave_request_type (leave_request_type_name)
VALUES ('urgent');

CREATE TABLE IF NOT EXISTS app.leave_request
(
    id             SERIAL PRIMARY KEY,
    date_from      timestamp without time zone NOT NULL,
    date_to        timestamp without time zone NOT NULL,
    number_of_days integer                     NOT NULL,
    note           character varying(255)      NOT NULL,
    employee_id    integer references app.employee (id),
    leave_type_id  integer references app.leave_request_type (id)
);

CREATE TABLE IF NOT EXISTS app.expense_type
(
    id                SERIAL PRIMARY KEY,
    expense_type_name character varying(255) UNIQUE NOT NULL
);

CREATE TABLE app.expense_claim_entry
(
    id                  SERIAL PRIMARY KEY,
    expense_date        timestamp without time zone NOT NULL,
    expense_description character varying(255)      NOT NULL,
    expense_status      character varying(255)      NOT NULL,
    expense_total       integer                     NOT NULL,
    employee_id         integer references app.employee (id),
    expense_type_id     integer references app.expense_type (id)
);

