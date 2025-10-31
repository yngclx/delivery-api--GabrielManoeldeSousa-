CREATE TABLE clientes (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          telefone VARCHAR(50),
                          endereço VARCHAR(255),
                          data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          ativo BOOLEAN NOT NULL
);

CREATE TABLE restaurantes (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              nome VARCHAR(255) NOT NULL,
                              categoria VARCHAR(100),
                              endereço VARCHAR(255),
                              telefone VARCHAR(50),
                              taxa_entrega DECIMAL(10,2),
                              avaliação DECIMAL(3,2),
                              ativo BOOLEAN NOT NULL
);