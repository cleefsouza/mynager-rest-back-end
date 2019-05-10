--
-- PostgreSQL database
--

CREATE DATABASE db_mynager
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

--
-- Name: tb_item; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_item (
    id integer NOT NULL,
    current_episode integer,
    date_update date NOT NULL,
    name character varying(255),
    number_episodes integer,
    season integer NOT NULL,
    situation integer,
    type integer
);


ALTER TABLE tb_item OWNER TO postgres;

--
-- Name: tb_situation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_situation (
    id integer NOT NULL,
    name character varying(255)
);

ALTER TABLE tb_situation OWNER TO postgres;

--
-- Name: tb_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_type (
    id integer NOT NULL,
    name character varying(255)
);

ALTER TABLE tb_type OWNER TO postgres;

--
-- Data for Name: tb_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_item (id, current_episode, date_update, name, number_episodes, season, situation, type) VALUES(1, 18, '2019-05-10', 'Tate no Yuusha no Nariagari', 18, 1, 2, 1);

--
-- Data for Name: tb_situation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_situation (id, name) VALUES(1, 'Completed');
INSERT INTO tb_situation (id, name) VALUES(2, 'Watching');
INSERT INTO tb_situation (id, name) VALUES(3, 'Hiatus');
INSERT INTO tb_situation (id, name) VALUES(4, 'Whislist');
INSERT INTO tb_situation (id, name) VALUES(5, 'Stopped');

--
-- Data for Name: tb_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_type (id, name) VALUES(1, 'Anime');
INSERT INTO tb_type (id, name) VALUES(2, 'Serie');

--
-- Name: tb_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT tb_item_pkey PRIMARY KEY (id);

--
-- Name: tb_situation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_situation
    ADD CONSTRAINT tb_situation_pkey PRIMARY KEY (id);

--
-- Name: tb_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_type
    ADD CONSTRAINT tb_type_pkey PRIMARY KEY (id);

--
-- Name: fka80wvwnq00y9avl0uleb7lru4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT fka80wvwnq00y9avl0uleb7lru4 FOREIGN KEY (situation) REFERENCES tb_situation(id);

--
-- Name: fkivx4tka01xqu5x07ej51dyeqi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT fkivx4tka01xqu5x07ej51dyeqi FOREIGN KEY (type) REFERENCES tb_type(id);

--
-- PostgreSQL database complete
--

