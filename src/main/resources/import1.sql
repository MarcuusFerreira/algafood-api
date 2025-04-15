INSERT INTO cozinha (NOME) VALUES ('Americana');
INSERT INTO cozinha (NOME) VALUES ('Brasileira');

INSERT INTO restaurante (NOME, COZINHA_ID, TAXA_FRETE, ATIVO, ABERTO, DATA_CADASTRO) VALUES ('Mc Donald`s - Campinas', 1, 8.99, 1, 1, now());
INSERT INTO restaurante (NOME, COZINHA_ID, TAXA_FRETE, ATIVO, ABERTO, DATA_CADASTRO) VALUES ('Burger King', 1, 10.99, 1, 1, now());
INSERT INTO restaurante (NOME, COZINHA_ID, TAXA_FRETE, ATIVO, ABERTO, DATA_CADASTRO) VALUES ('Churrascaria do tiao', 2, 14.99, 1, 1, now());
INSERT INTO restaurante (NOME, COZINHA_ID, TAXA_FRETE, ATIVO, ABERTO, DATA_CADASTRO) VALUES ('Giraffas - Shopping Beira Mar', 2, 17.99, 1, 1, now());
INSERT INTO restaurante (NOME, COZINHA_ID, TAXA_FRETE, ATIVO, ABERTO, DATA_CADASTRO) VALUES ('Mc Donald`s - Estreito', 1, 5.99, 1, 1, now());

INSERT INTO forma_pagamento (DESCRICAO) values ('CREDITO');
INSERT INTO forma_pagamento (DESCRICAO) values ('DEBITO');
INSERT INTO forma_pagamento (DESCRICAO) values ('PIX');
INSERT INTO forma_pagamento (DESCRICAO) values ('DINHEIRO');

INSERT INTO permissao (NOME, DESCRICAO) VALUES ('EDITAR_RESTAURANTE', 'Essa permissao da acesso a edicao de um restaurante para o usuario');
INSERT INTO permissao (NOME, DESCRICAO) VALUES ('CADASTRAR_RESTAURANTE', 'Essa permissao da acesso ao cadastro de um restaurante para o usuario');
INSERT INTO permissao (NOME, DESCRICAO) VALUES ('VIZUALIZAR_RESTAURANTE', 'Essa permissao da acesso a vizualizacao de restaurantes para o usuario');

INSERT INTO estado (NOME) VALUES ('SANTA CATARINA');
INSERT INTO estado (NOME) VALUES ('RIO GRANDE DO SUL');
INSERT INTO estado (NOME) VALUES ('RIO DE JANEIRO');

INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('RIO DE JANEIRO', 3);
INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('NITEROI', 3);
INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('FLORIANOPOLIS', 1);
INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('PALHOCA', 1);
INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('SAO JOSE', 1);
INSERT INTO cidade (NOME, ESTADO_ID) VALUES ('PORTO ALEGRE', 2);
