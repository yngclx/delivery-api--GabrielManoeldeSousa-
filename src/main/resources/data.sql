-- Inserir Clientes
INSERT INTO clientes (nome, email, telefone, endereço, data_cadastro, ativo) VALUES
('João Silva', 'joao@email.com', '(11) 99999-1111', 'Rua A, 123 - São Paulo/SP', CURRENT_TIMESTAMP, true),
('Maria Santos', 'maria@email.com', '(11) 99999-2222', 'Rua B, 456 - São Paulo/SP', CURRENT_TIMESTAMP, true),
('Pedro Oliveira', 'pedro@email.com', '(11) 99999-3333', 'Rua C, 789 - São Paulo/SP', CURRENT_TIMESTAMP, true);

-- Inserir restaurantes
INSERT INTO restaurantes (nome, categoria, endereço, telefone, taxa_entrega, avaliação, ativo) VALUES
('Pizzaria Bella', 'Italiana', 'Av.Paulista, 1000 - São Paulo/SP', '(11) 3333-1111', 5.08, 4.5, true),
('Burguer House', 'Hamburgueria', 'Rua Augusta, 500 - São Paulo/SP', '(11) 3333-2222', 3.58, 4.2, true),
('Sushi Master', 'Japonesa', 'Rua Liberdade, 200 - São Paulo/SP', '(11) 3333-3333', 8.00, 4.8, true);