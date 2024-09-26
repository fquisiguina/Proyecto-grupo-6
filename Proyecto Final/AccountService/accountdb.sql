-- Database: accountdb

-- DROP DATABASE IF EXISTS accountdb;

CREATE DATABASE accountdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



-- SCHEMA: account

-- DROP SCHEMA IF EXISTS account ;

CREATE SCHEMA IF NOT EXISTS account
    AUTHORIZATION postgres;


-- SEQUENCE: account.acc_account_seq

-- DROP SEQUENCE IF EXISTS account.acc_account_seq;

CREATE SEQUENCE IF NOT EXISTS account.acc_account_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE account.acc_account_seq
    OWNED BY account.acc_account_tbl.acc_id_account;

ALTER SEQUENCE account.acc_account_seq
    OWNER TO postgres;


-- Table: account.acc_account_tbl

-- DROP TABLE IF EXISTS account.acc_account_tbl;

CREATE TABLE IF NOT EXISTS account.acc_account_tbl
(
    acc_id_account bigint NOT NULL DEFAULT nextval('account.acc_account_seq'::regclass),
    acc_number_account character varying(10) COLLATE pg_catalog."default",
    acc_currency_type character varying(3) COLLATE pg_catalog."default",
    acc_amount double precision,
    acc_custormer_id bigint,
    acc_user_creates character varying COLLATE pg_catalog."default",
    acc_user_modifies character varying COLLATE pg_catalog."default",
    acc_status boolean,
    acc_date_creates timestamp without time zone,
    acc_date_modifies timestamp without time zone,
    CONSTRAINT acc_account_tbl_pkey PRIMARY KEY (acc_id_account)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS account.acc_account_tbl
    OWNER to postgres;