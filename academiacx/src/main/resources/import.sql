INSERT INTO tb_cliente (cpf, nome, username, password) VALUES ('12345678900', 'Fulano de Tal', 'fulano', '$2a$10$3GdjKhUg.BMG4Z95e0bWf.PkapfixNoWknAw/2pCK9xRBo25EtZJe');
INSERT INTO tb_cliente (cpf, nome, username, password) VALUES ('98765432100', 'Ciclano da Silva', 'ciclano', '$2a$10$3GdjKhUg.BMG4Z95e0bWf.PkapfixNoWknAw/2pCK9xRBo25EtZJe');
INSERT INTO tb_cliente (cpf, nome, username, password) VALUES ('12332112332', 'Joana de Castro', 'joana', '$2a$10$3GdjKhUg.BMG4Z95e0bWf.PkapfixNoWknAw/2pCK9xRBo25EtZJe');



INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('12345678', 'Rua das Flores', 123, 'Centro', 'Curitiba', 'PR', 1);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('87654321', 'Avenida Guepardo', 456, 'Batel', 'Curitiba', 'PR', 1);

INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('12332123', 'Avenida do Estado', 1337, 'Guepardo', 'Mafra', 'SC', 2);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('32112321', 'Avenida Visconde de Guarapuava', 4445, 'Passo', 'Mafra', 'SC', 2);

INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('13377331', 'Rua Ciclano Flores', 128, 'Bairro Alto', 'Porto Alegre', 'RS', 3);
INSERT INTO tb_endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES ('96400020', 'Travessa Francisco Ferdinando', 256, 'Centro', 'Passo Fundo', 'RS', 3);



INSERT INTO tb_carrinho (data, cliente_id) VALUES ('2023-01-18 09:42:00.0000', 1);
INSERT INTO tb_carrinho (data, cliente_id) VALUES ('2023-01-18 13:37:00.0000', 2);
INSERT INTO tb_carrinho (data, cliente_id) VALUES ('2023-01-19 16:20:00.0000', 3);



INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-A-4321', 'Calça Jeans');
INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-B-1234', 'Coturno');
INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-C-5432', 'Bombacha');
INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-D-2345', 'Boné');
INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-E-6543', 'Chapéu');
INSERT INTO tb_produto (sku, nome) VALUES ('CX-NTT-F-3456', 'Escova de Dentes');



INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('200.00', 1, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('75.00', 2, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('125.00', 3, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('50.00', 4, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('89.90', 5, 1);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('12.00', 6, 1);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('185.00', 1, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('70.00', 2, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('115.00', 3, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('45.00', 4, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('70.00', 5, 2);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('9.90', 6, 2);

INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('100.00', 1, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('37.50', 2, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('62.50', 3, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('25.00', 4, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('44.50', 5, 3);
INSERT INTO tb_preco (valor, produto_id, cliente_id) VALUES ('6.00', 6, 3);



INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (2, 1, 1, 1);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (3, 2, 2, 1);

INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (3, 3, 9, 2);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (2, 4, 10, 2);

INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (1, 5, 17, 3);
INSERT INTO tb_item (quantidade, produto_id, preco_id, carrinho_id) VALUES (2, 6, 18, 3);

