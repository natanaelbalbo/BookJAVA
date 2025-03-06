-- Inserir livros
INSERT INTO livro (titulo, autor, editora, ano_publicacao, isbn, numero_paginas) 
VALUES ('Dom Casmurro', 'Machado de Assis', 'Companhia das Letras', 1899, '9788535908462', 256);

INSERT INTO livro (titulo, autor, editora, ano_publicacao, isbn, numero_paginas) 
VALUES ('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 'Agir', 1943, '9788525406262', 96);

INSERT INTO livro (titulo, autor, editora, ano_publicacao, isbn, numero_paginas) 
VALUES ('1984', 'George Orwell', 'Companhia das Letras', 1949, '9788535914849', 416);

INSERT INTO livro (titulo, autor, editora, ano_publicacao, isbn, numero_paginas) 
VALUES ('Memórias Póstumas de Brás Cubas', 'Machado de Assis', 'Penguin', 1881, '9788582850114', 312);

INSERT INTO livro (titulo, autor, editora, ano_publicacao, isbn, numero_paginas) 
VALUES ('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', 'Rocco', 1997, '9788532511010', 264);

-- Inserir reservas
INSERT INTO reserva (livro_id, nome_cliente, email_cliente, telefone_cliente, data_reserva, status, observacao)
VALUES (1, 'João Silva', 'joao.silva@email.com', '(11) 98765-4321', '2024-03-01', 'PENDENTE', 'Primeira reserva de teste');

INSERT INTO reserva (livro_id, nome_cliente, email_cliente, telefone_cliente, data_reserva, status, observacao)
VALUES (2, 'Maria Oliveira', 'maria.oliveira@email.com', '(21) 91234-5678', '2024-02-25', 'CONFIRMADA', 'Reserva para trabalho escolar');

INSERT INTO reserva (livro_id, nome_cliente, email_cliente, telefone_cliente, data_reserva, status, data_finalizada, observacao)
VALUES (3, 'Pedro Santos', 'pedro.santos@email.com', '(31) 99876-5432', '2024-02-15', 'FINALIZADA', '2024-02-28', 'Livro devolvido no prazo');

INSERT INTO reserva (livro_id, nome_cliente, email_cliente, telefone_cliente, data_reserva, status, observacao)
VALUES (4, 'Ana Souza', 'ana.souza@email.com', '(41) 98877-6655', '2024-03-02', 'PENDENTE', 'Cliente solicitou reserva por telefone');

INSERT INTO reserva (livro_id, nome_cliente, email_cliente, telefone_cliente, data_reserva, status, observacao)
VALUES (5, 'Carlos Ferreira', 'carlos.ferreira@email.com', '(51) 97788-9900', '2024-02-20', 'CONFIRMADA', 'Cliente é professor da universidade'); 