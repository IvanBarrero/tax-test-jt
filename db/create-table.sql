-- Table: public.impuestos

-- NOTA: se modifico el tipo de dato de sticker porque los datos de la primera
-- columna no cabian en el tipo integer.

DROP TABLE IF EXISTS public.impuestos;
CREATE TABLE IF NOT EXISTS public.impuestos
(
sticker bigint NOT NULL,
fecha_movimiento date NOT NULL,
fecha_recaudo date NOT NULL,
tipo_horario character varying(1) COLLATE pg_catalog."default",
nro_id numeric(15,0) DEFAULT 0,
nro_form numeric DEFAULT 0,
valor numeric(15,0) DEFAULT 0,
CONSTRAINT impuestos_pkey PRIMARY KEY (sticker)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.impuestos OWNER to pgsql;

