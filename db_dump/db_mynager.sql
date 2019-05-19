--
-- TOC entry 2030 (class 0 OID 16670)
-- Dependencies: 174
-- Data for Name: tb_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_role (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

--
-- TOC entry 2033 (class 0 OID 16685)
-- Dependencies: 177
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_user (email, name, password, username, date_create) VALUES
('testando.api.restful@gmail.com',	'Admin Testando Api Restful',	'$2a$10$ImVkLighf2MYcfuS/5rvve3MRBf3/kEq3Ys8wB9r7ym043VyvUsAi',	'admin',	'2019-05-16'),
('testando.api.restful@gmail.com',	'User Testando Api Restful',	'$2a$10$ImVkLighf2MYcfuS/5rvve3MRBf3/kEq3Ys8wB9r7ym043VyvUsAi',	'user',	'2019-05-16');

--
-- TOC entry 2034 (class 0 OID 16693)
-- Dependencies: 178
-- Data for Name: tb_user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_user_roles (users, roles) VALUES
(1,	2),
(2, 1);

--
-- TOC entry 2008 (class 0 OID 16426)
-- Dependencies: 174
-- Data for Name: tb_situation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_situation (id, name) VALUES
(1,	'Completed'),
(2,	'Watching'),
(3,	'Hiatus'),
(4,	'Whislist'),
(5,	'Stopped');


--
-- TOC entry 2009 (class 0 OID 16431)
-- Dependencies: 175
-- Data for Name: tb_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_type (id, name) VALUES
(1,	'Anime'),
(2,	'Serie');

--
-- TOC entry 2007 (class 0 OID 16421)
-- Dependencies: 173
-- Data for Name: tb_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_item (current_episode, current_season, date_update, name, number_episodes, number_seasons, situation_id, type_id, user_id) VALUES 
(18,	1,	'2019-05-12',	'Teste Api Rest',	18,	1,	2,	1, 1),
(18,	1,	'2019-05-12',	'Teste Api Rest',	18,	1,	5,	2, 2);