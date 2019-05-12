--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2019-05-12 03:47:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2017 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 172 (class 1259 OID 16419)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16421)
-- Name: tb_item; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_item (
    id bigint NOT NULL,
    current_episode integer,
    current_season integer,
    date_update date NOT NULL,
    name character varying(255),
    number_episodes integer,
    number_seasons integer,
    situation bigint,
    type bigint
);


ALTER TABLE tb_item OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16426)
-- Name: tb_situation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_situation (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE tb_situation OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16431)
-- Name: tb_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_type (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE tb_type OWNER TO postgres;

--
-- TOC entry 2018 (class 0 OID 0)
-- Dependencies: 172
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 16, true);


--
-- TOC entry 2007 (class 0 OID 16421)
-- Dependencies: 173
-- Data for Name: tb_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_item (id, current_episode, current_season, date_update, name, number_episodes, number_seasons, situation, type) FROM stdin;
8	18	1	2019-05-12	Tate no Yuusha no Nariagari	18	1	2	1
11	18	2	2019-05-12	Teste Sama Sensei	18	5	2	1
12	18	2	2019-05-12	Teste Sama Sensei	18	5	2	1
13	18	2	2019-05-12	Teste Sama Sensei	18	5	3	2
15	18	2	2019-05-12	Teste Sama Sensei	18	5	3	2
16	18	2	2019-05-12	Teste Sama Sensei	18	5	4	2
14	18	2	2019-05-12	Teste Sama Sensei	18	5	4	2
\.


--
-- TOC entry 2008 (class 0 OID 16426)
-- Dependencies: 174
-- Data for Name: tb_situation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_situation (id, name) FROM stdin;
1	Completed
2	Watching
3	Hiatus
4	Whislist
5	Stopped
\.


--
-- TOC entry 2009 (class 0 OID 16431)
-- Dependencies: 175
-- Data for Name: tb_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_type (id, name) FROM stdin;
1	Anime
2	Serie
\.


--
-- TOC entry 1890 (class 2606 OID 16425)
-- Name: tb_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT tb_item_pkey PRIMARY KEY (id);


--
-- TOC entry 1892 (class 2606 OID 16430)
-- Name: tb_situation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_situation
    ADD CONSTRAINT tb_situation_pkey PRIMARY KEY (id);


--
-- TOC entry 1894 (class 2606 OID 16435)
-- Name: tb_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_type
    ADD CONSTRAINT tb_type_pkey PRIMARY KEY (id);


--
-- TOC entry 1895 (class 2606 OID 16436)
-- Name: fka80wvwnq00y9avl0uleb7lru4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT fka80wvwnq00y9avl0uleb7lru4 FOREIGN KEY (situation) REFERENCES tb_situation(id);


--
-- TOC entry 1896 (class 2606 OID 16441)
-- Name: fkivx4tka01xqu5x07ej51dyeqi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_item
    ADD CONSTRAINT fkivx4tka01xqu5x07ej51dyeqi FOREIGN KEY (type) REFERENCES tb_type(id);


--
-- TOC entry 2016 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-05-12 03:47:17

--
-- PostgreSQL database dump complete
--

