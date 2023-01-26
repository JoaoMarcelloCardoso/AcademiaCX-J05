

--  Cliente
INSERT INTO tb_cliente (id,cpf, nome) values(1,'64947612088', 'Pedro');
INSERT INTO tb_cliente (id,cpf, nome) values(2,'25960044021', 'Maria');
INSERT INTO tb_cliente (id,cpf, nome) values(3,'17923174091', 'João');

-- Produto
insert into tb_produto (id,sku, nome,quantidade_total) values (1,'camiseta_24','Camiseta',50);
insert into tb_produto (id,sku, nome,quantidade_total) values (2,'calca_17','Calca',29);
insert into tb_produto (id,sku, nome,quantidade_total) values (3,'chinelo_5','Chinelo',18);

-- Preço por cliente
insert into tb_preco(id,valor,produto_id,cliente_id) values(1,25.00, 1,1);
insert into tb_preco(id,valor,produto_id,cliente_id) values(2,35.00, 2,1);
insert into tb_preco(id,valor,produto_id,cliente_id) values(3,15.00, 3,1);

insert into tb_preco(id,valor,produto_id,cliente_id) values(4,35.00, 1,2);
insert into tb_preco(id,valor,produto_id,cliente_id) values(5,45.00, 2,2);
insert into tb_preco(id,valor,produto_id,cliente_id) values(6,25.00, 3,2);

insert into tb_preco(id,valor,produto_id,cliente_id) values(7,45.00, 1,3);
insert into tb_preco(id,valor,produto_id,cliente_id) values(8,55.00, 2,3);
insert into tb_preco(id,valor,produto_id,cliente_id) values(9,65.00, 3,3);


-- Carrinho - Optei por criar carrinhos vazios para os clientes
insert into tb_carrinho(id,hora_compra,total,cliente_id)values(1,'2023-11-11 13:23:44',0.00,1);
insert into tb_carrinho(id,hora_compra,total,cliente_id)values(2,'2023-10-09 15:45:21',0.00,1);


insert into tb_carrinho(id,hora_compra,total,cliente_id)values(3,'2023-01-19 05:05:11',0.00,2);
insert into tb_carrinho(id,hora_compra,total,cliente_id)values(4,'2023-07-14 08:36:13',0.00,2);

insert into tb_carrinho(id,hora_compra,total,cliente_id)values(5,'2023-02-16 08:05:37',0.00,3);
insert into tb_carrinho(id,hora_compra,total,cliente_id)values(6,'2023-02-27 23:34:10',0.00,3);


-- Item - Considerei que o item passou pelo sistema e checou o preco vinculado ao produto
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(1,2,1,1,1);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(2,2,3,3,1);

insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(3,2,5,1,2);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(4,2,6,2,2);

insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(5,1,7,1,3);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(6,1,8,2,3);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(7,1,7,1,4);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(8,2,8,2,4);

insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(9,1,7,1,5);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(10,1,8,2,5);

insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(11,1,7,1,6);
insert into tb_item(id,quantidade,preco_id,produto_id,carrinho_id) values(12,1,8,2,6);


-- Endereço
-- Esses Códigos são utilizados na emissão de Documentos Fiscais Eletrônicos (NFC-e, NF-e, CT-e, MDF-e e CF-e) e são informados no campo cUF.
insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(1,'81520370','Rua das Tropas','Guabirotuba','Curitiba','100', 'PR', 1);
insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(2,'82990095','Rua Arthur S. Correia de Freitas','Cajuru','Curitiba','350', 'PR', 1);

insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(3,'79103040','Rua Guaianas','Vila Sílvia Regina','Campo Grande','121', 'MS', 2);
insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(4,'79071117','Rua Izabelino Hipolito Novaes','Jardim Nashiville','Campo Grande','520', 'MS', 2);

insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(5,'13303540','Rua Pastor Benevides dos Santos','Itu Novo Centro','Itu','234', 'SP', 3);
insert into tb_endereco(id,cep,logradouro,bairro,cidade,numero_endereco,uf,cliente_id)
values(6,'13301762','Rua Antônio de Paula Leite','Chácaras Primavera','Itu','1320', 'SP', 3);

-- User
INSERT INTO tb_user(id, name, email, username, password) VALUES (1, 'Maria', 'maria@gmail.com', 'maria', '$2a$10$GPNmzVYog.Q81JrX3DXh/.z2Zz7e3O0luuYBuEGls05kkcwZlkmy2');

INSERT INTO tb_user(id, name, email, username, password) VALUES (2, 'Bob', 'bob@gmail.com', 'bob', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');

INSERT INTO tb_user(id, name, email, username, password) VALUES (3, 'Alex', 'alex@gmail.com', 'alex', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');

INSERT INTO tb_user(id, name, email, username, password) VALUES (4, 'Ana', 'ana@gmail.com', 'ana', '$2a$10$SbzS94gwPiSUmi535IQjS.jo0xeLwq38QRGOPLW6616CTs.aHXotu');
