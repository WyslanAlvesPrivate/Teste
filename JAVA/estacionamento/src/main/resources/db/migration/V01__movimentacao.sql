CREATE TABLE movimentacao
(
    id bigserial NOT NULL,
    data_entrada date NOT NULL,
    hora_entrada character varying(8) NOT NULL,
    modelo character varying(80) NOT NULL,
    placa character varying(20) NOT NULL,
    tempo_total numeric(19,2),
    valor numeric(19,2),
    saiu boolean,
    CONSTRAINT movimentacao_pkey PRIMARY KEY (id),
    CONSTRAINT uk_4vqw7lvfcise33sdcq0gsqcq UNIQUE (placa)
);


INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKJ-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'CPL-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKK-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKI-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKR-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKD-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKC-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKM-8970', null, null, false);
INSERT INTO movimentacao (data_entrada, hora_entrada, modelo, placa, tempo_total, valor, saiu) values ('20/06/2022', '05:06:12', 'Civic Gol 2006', 'LKW-8970', null, null, false);

