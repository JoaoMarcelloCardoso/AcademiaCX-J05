
INSERT INTO tb_produto (sku,nome) VALUES ('pv-475-89','Placa de video');
--INSERT INTO tb_produto (sku,nome) VALUES ('pm-758-35','Placa mãe');
--INSERT INTO tb_produto (sku,nome) VALUES ('fn-668-23','Fone de ouvido');



INSERT INTO tb_user(nome, cpf, username, password) VALUES ('Maria', 25656556, 'maria', '$2a$10$cS5at9lZYAl4jVwwaKdjqOTCAU12jG46RJQ5qFCyZLikUw5TeR6OW');
--INSERT INTO tb_user(nome, cpf) VALUES ('João', 8484848848, 'joão', 'senha1234');
--INSERT INTO tb_user(nome, cpf) VALUES ('Paulo', 7475544751, 'paulo', 'senha12345');

INSERT INTO tb_endereco (cep,numero,bairro,cidade,uf,cliente_id) VALUES ('58989212','59','jardim nelia','Araraquara','SP',1);
--INSERT INTO tb_endereco (cep,numero,bairro,cidade,uf,cliente_id) VALUES ('95863117','105','Camargo novo','São josé dos campos','SP',2);
--INSERT INTO tb_endereco (cep,numero,bairro,cidade,uf,cliente_id) VALUES ('97235139','98','Ferraz','São Paulo capital','SP',3);
--

--
INSERT INTO tb_preco (valor,produto_id,user_id) VALUES ('85.50',1,1);
--INSERT INTO tb_preco (valor,produto_id,cliente_id) VALUES ('55.50',2,2);
--INSERT INTO tb_preco (valor,produto_id,cliente_id) VALUES ('20.00',3,3);
--
--
INSERT INTO tb_carrinho (datahora,total,cliente_id) VALUES ('2023-01-02 09:36:00.0000','85.50',1);
--INSERT INTO tb_carrinho (datahora,total,cliente_id) VALUES ('2023-08-12 16:50:00.0000','55.50',2);
--INSERT INTO tb_carrinho (datahora,total,cliente_id) VALUES ('2022-10-06 18:20:00.0000','20.00',3);
--
--

--
--
INSERT INTO tb_item (quantidade,total,produto_id,preco_id,carrinho_id) VALUES (5,'5.50',1,1,1);
--INSERT INTO tb_item (quantidade,total,produto_id,preco_id,carrinho_id) VALUES ('2','1',2,2,1);
--INSERT INTO tb_item (quantidade,total,produto_id,preco_id,carrinho_id) VALUES ('3','2',3,3,2);
--
--

--


