-- -- SEQUENCE
CREATE SEQUENCE HIBERNATE_SEQUENCE START 10000;

CREATE TABLE MESSAGE (
                         ID BIGINT NOT NULL,
                         TYPE VARCHAR(250),
                         TEXT VARCHAR(250),
                         TAG VARCHAR(250),
                         CONSTRAINT CONSTRAINT_MS PRIMARY KEY (ID)
);