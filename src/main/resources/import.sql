INSERT INTO Autor(id, nome, email, descricao, dataCadastro) VALUES (1, 'Jose', 'jose@email.com', 'Descrição autor JOSE', now());
INSERT INTO Autor(id, nome, email, descricao, dataCadastro) VALUES (2, 'Maria', 'maria@email.com', 'Descrição autor MARIA', now());

INSERT INTO CATEGORIA(id, nome) VALUES (1, 'JAVA');
INSERT INTO CATEGORIA(id, nome) VALUES (2, 'GoLang');

INSERT INTO Livro(isbn, titulo, resumo, sumario, dataPublicacao, preco, numeroPaginas, autor_id, categoria_id) VALUES ('2135asa5', 'Java Como programar', 'Descrição livro de java', 'Sumario livro de java', now(), 250.00, 500, 1, 1);
INSERT INTO Livro(isbn, titulo, resumo, sumario, dataPublicacao, preco, numeroPaginas, autor_id, categoria_id) VALUES ('1d315389', 'GoLang, aprenda a programar', 'Descrição livro de GoLang', 'Sumario livro de goLang', now(), 182.74, 210, 2, 2);