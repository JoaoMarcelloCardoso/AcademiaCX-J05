CREATE DATABASE academycx;
USE academycx;

CREATE TABLE tb_product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price decimal(10,2) NOT NULL
);

CREATE TABLE tb_client (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE tb_address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cep VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    uf VARCHAR(255) NOT NULL,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES tb_client(id)
);

CREATE TABLE tb_cart (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    dateTime DATETIME NOT NULL,
    total decimal(10,2) NOT NULL,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES tb_client(id)
);



CREATE TABLE tb_item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    quantity INT NOT NULL,
    price decimal(10,2) NOT NULL,
    product_id BIGINT,
    cart_id BIGINT,
    FOREIGN KEY (product_id) REFERENCES tb_product(id),
    FOREIGN KEY (cart_id) REFERENCES tb_cart(id)
);
