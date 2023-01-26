INSERT INTO tb_cliente (nome, cpf, password) VALUES ('Guilherme','40963547265', '$2a$10$MOc9fYjmKkIkOPQwPYYPNuablhahra1ug/JHrOGvdxAaF/Votdftq');
INSERT INTO tb_cliente (nome, cpf, password) VALUES ('Paulo','38526416235', '$2a$10$MOc9fYjmKkIkOPQwPYYPNuablhahra1ug/JHrOGvdxAaF/Votdftq');
INSERT INTO tb_cliente (nome, cpf, password) VALUES ('Julia','41468534263', '$2a$10$MOc9fYjmKkIkOPQwPYYPNuablhahra1ug/JHrOGvdxAaF/Votdftq');

INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua São Francisco','156','Penha','São Paulo','SP',(SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua Dominicanos','57','Pampulha','Belo Horizonte','MG',(SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua Xavier Sigaud','354','Urca','Rio de Janeiro','RJ',(SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua Jorge Mussi','414','Canasvieiras','Florianópolis','SC',(SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua Paulo Pontes','253','Esperança','Londrina','PR',(SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_endereco (logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('Rua Santo Amaro','865','Serraria','Maceió','AL',(SELECT id FROM tb_cliente WHERE cpf='41468534263'));

INSERT INTO tb_carrinho (data_hora, total, cliente_id) VALUES ('2023-01-14 10:24:00.0000', 155.90, (SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_carrinho (data_hora, total, cliente_id) VALUES ('2023-01-04 14:44:00.0000', 414.90, (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_carrinho (data_hora, total, cliente_id) VALUES ('2023-01-12 18:28:00.0000', 214.90, (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_carrinho (data_hora, total, cliente_id) VALUES ('2023-01-05 21:19:00.0000', 603.90, (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_carrinho (data_hora, total, cliente_id) VALUES ('2023-01-17 12:32:00.0000', 89.90, (SELECT id FROM tb_cliente WHERE cpf='40963547265'));

INSERT INTO tb_produto (nome, sku) VALUES ('Mesa','1');
INSERT INTO tb_produto (nome, sku) VALUES ('Gaveta','2');
INSERT INTO tb_produto (nome, sku) VALUES ('Estojo','3');
INSERT INTO tb_produto (nome, sku) VALUES ('Relógio de mesa','4');
INSERT INTO tb_produto (nome, sku) VALUES ('Teclado','5');
INSERT INTO tb_produto (nome, sku) VALUES ('Mouse','6');

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (400.00, (SELECT id FROM tb_produto WHERE sku='1'), (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (300.00, (SELECT id FROM tb_produto WHERE sku='1'), (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (70.00, (SELECT id FROM tb_produto WHERE sku='2'), (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (50.00, (SELECT id FROM tb_produto WHERE sku='2'), (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (10.00, (SELECT id FROM tb_produto WHERE sku='3'), (SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (15.00, (SELECT id FROM tb_produto WHERE sku='3'), (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (60.00, (SELECT id FROM tb_produto WHERE sku='4'), (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (45.00, (SELECT id FROM tb_produto WHERE sku='4'), (SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (250.00, (SELECT id FROM tb_produto WHERE sku='5'), (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (199.90, (SELECT id FROM tb_produto WHERE sku='5'), (SELECT id FROM tb_cliente WHERE cpf='40963547265'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (150.00, (SELECT id FROM tb_produto WHERE sku='6'), (SELECT id FROM tb_cliente WHERE cpf='38526416235'));
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES (170.00, (SELECT id FROM tb_produto WHERE sku='6'), (SELECT id FROM tb_cliente WHERE cpf='41468534263'));
