INSERT INTO tb_client (cpf, nome, username, password) VALUES ('11122233344', 'Lucas Silva', 'lucas', '$2a$10$pP/cgh4rr54lY.7ehNeLwe.L7QE/gBCwpPpLM8bLYM94HcHt4EDWe');
INSERT INTO tb_client (cpf, nome, username, password) VALUES ('22233344455', 'Isabella Oliveira', 'isabella', '$2a$10$0ts2Se05MFf9qZo46G1nxeXMczzL/x08vWuNb0j7Yc5KEvvlnUX0G');
INSERT INTO tb_client (cpf, nome, username, password) VALUES ('33344455566', 'Pedro Albuquerque', 'pedro', '$2a$10$0ts2Se05MFf9qZo46G1nxeXMczzL/x08vWuNb0j7Yc5KEvvlnUX0G');
INSERT INTO tb_client (cpf, nome, username, password) VALUES ('44455566677', 'Maria Costa', 'maria', '$2a$10$0ts2Se05MFf9qZo46G1nxeXMczzL/x08vWuNb0j7Yc5KEvvlnUX0G');
INSERT INTO tb_client (cpf, nome, username, password) VALUES ('55666777888', 'João Gomes', 'joao', '$2a$10$0ts2Se05MFf9qZo46G1nxeXMczzL/x08vWuNb0j7Yc5KEvvlnUX0G');
INSERT INTO tb_client (cpf, nome, username, password) VALUES ('66778899999', 'Ana Pereira', 'ana', '$2a$10$0ts2Se05MFf9qZo46G1nxeXMczzL/x08vWuNb0j7Yc5KEvvlnUX0G');


INSERT INTO tb_product (sku, nome, price) VALUES ('PROD001', 'Smartphone', 1299.99);
INSERT INTO tb_product (sku, nome, price) VALUES ('PROD002', 'Tablet', 999.99);
INSERT INTO tb_product (sku, nome, price) VALUES ('PROD003', 'Notebook', 2199.99);
INSERT INTO tb_product (sku, nome, price) VALUES ('PROD004', 'Smartwatch', 699.99);
INSERT INTO tb_product (sku, nome, price) VALUES ('PROD005', 'Fone de Ouvido', 249.99);

INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-01 12:00:00', 2199.99, 1);
INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-02 14:30:00', 1499.99, 2);
INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-03 18:00:00', 4199.97, 3);
INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-04 10:00:00', 1299.99, 4);
INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-05 16:15:00', 2498.98, 5);
INSERT INTO tb_cart (date_time, total, client_id) VALUES ('2022-02-06 20:30:00', 999.99, 6);

INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (1, 1299.99, 1, 1);
INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (1, 999.99, 2, 2);
INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (1, 2199.99, 3, 3);
INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (2, 699.99, 4, 4);
INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (3, 249.99, 5, 5);
INSERT INTO tb_item (quantity, total, product_id, cart_id) VALUES (1, 1499.99, 5, 6);

INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('80001234', 'Rua das Laranjeiras', 'Batel', 'Curitiba', 'PR', 1);
INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('80005678', 'Avenida das Orquídeas', 'Água Verde', 'Curitiba', 'PR', 2);
INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('80009012', 'Rua das Rosas', 'Ahú', 'Curitiba', 'PR', 3);
INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('01010101', 'Avenida Paulista', 'Bela Vista', 'São Paulo', 'SP', 4);
INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('02020202', 'Rua Augusta', 'Consolação', 'São Paulo', 'SP', 5);
INSERT INTO tb_address (cep, logradouro, bairro, cidade, uf, client_id) VALUES ('03030303', 'Rua dos Pinheiros', 'Pinheiros', 'São Paulo', 'SP', 6);