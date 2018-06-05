CREATE TABLE agenda.usuario (
  id_usuario integer NOT NULL,
  ativo boolean DEFAULT true NOT NULL,
  email character varying(100),
  nome character varying(50),
  senha character varying(255) NOT NULL,
  _ebean_intercept bytea,
  created_at timestamp without time zone,
  updated_at timestamp without time zone,
  version bigint,
  deleted boolean DEFAULT false NOT NULL
);

ALTER TABLE ONLY agenda.usuario
  ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);

CREATE TABLE agenda.tarefa (
  id_tarefa integer NOT NULL,
  id_usuario integer,
  descricao character varying(50),
  data timestamp without time zone,
  _ebean_intercept bytea,
  created_at timestamp without time zone,
  updated_at timestamp without time zone,
  version bigint,
  deleted boolean DEFAULT false NOT NULL
);

CREATE SEQUENCE agenda.tarefa_id_tarefa_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE agenda.tarefa ALTER COLUMN id_tarefa SET DEFAULT nextval('agenda.tarefa_id_tarefa_seq');
ALTER SEQUENCE agenda.tarefa_id_tarefa_seq OWNED BY agenda.tarefa.id_tarefa;

ALTER TABLE ONLY agenda.tarefa
  ADD CONSTRAINT tarefa_pkey PRIMARY KEY (id_tarefa);


--ALTER TABLE ONLY agenda.tarefa
--  ADD CONSTRAINT fk2qe6tjawyl6ojl32uhbwllldh FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);
ALTER TABLE agenda.tarefa ADD CONSTRAINT fk_usuario_2qe6tjawyl6ojl32uhbwllld FOREIGN KEY ( id_usuario ) REFERENCES agenda.usuario ( id_usuario );