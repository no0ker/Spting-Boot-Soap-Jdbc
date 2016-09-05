# Spting-Boot-Soap-Jdbc

1 - install PostgreSql

2 - execute

CREATE TABLE public.events
(
    name character varying COLLATE "default".pg_catalog NOT NULL,
    date date,
    CONSTRAINT events_pkey PRIMARY KEY (name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.events
    OWNER to postgres;

3 - checkout

5 - modify file application.properties 

4 - execute
mvn clean install

5 - execute
mvn spring-boot:run

6 - create soap project 
http://localhost:8075/ws/events.wsdl