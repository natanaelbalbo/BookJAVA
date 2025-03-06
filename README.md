# Sistema de Gestão Bibliotecária

Um sistema projetado para organizar livros e gerenciar reservas em uma biblioteca, construído utilizando o framework Spring Boot.

## Recursos Principais

- Administração de livros: inclusão, alteração, consulta e remoção.
- Controle de reservas com os seguintes estados:
  - **Aguardando**: Reserva registrada, mas pendente de aprovação.
  - **Aprovada**: Reserva validada e confirmada.
  - **Concluída**: Reserva finalizada, seja por retirada ou término do processo.
- Interface web adaptável e com design atualizado.

## Tecnologias Empregadas

- Java (versão 17)
- Spring Boot (versão 3.2.2)
- Spring Data JPA para persistência de dados
- Thymeleaf como motor de templates
- Banco de dados H2 (em memória)
- Bootstrap 5 para estilização
- jQuery para interatividade
- Font Awesome para ícones

## Instruções para Execução

1. Faça o clone do repositório.
2. Entre no diretório do projeto.
3. Rode o comando: `./mvnw spring-boot:run`.
4. Abra o navegador e acesse: `http://localhost:8080`.
5. Para visualizar o banco H2, vá até: `http://localhost:8080/h2-console`.
   - URL JDBC: `jdbc:h2:mem:testdb`
   - Usuário: `sa`
   - Senha: (sem preenchimento)

## Organização do Projeto

- `model`: Classes que representam as entidades (Livro e Reserva).
- `repository`: Interfaces para acesso a dados com Spring Data.
- `service`: Lógica de negócios encapsulada.
- `controller`: Camada de controle para endpoints REST e páginas web.
- `resources/templates`: Arquivos Thymeleaf para renderização das views.

## Dados Iniciais

Ao iniciar, o sistema carrega automaticamente alguns livros e reservas de exemplo para facilitar os testes.

## Endpoints da API REST

A aplicação oferece uma API para integração com outros sistemas:

### Gerenciamento de Livros

- `GET /livros`: Retorna a lista completa de livros.
- `GET /livros/{id}`: Consulta um livro específico pelo ID.
- `POST /livros`: Adiciona um novo livro.
- `PUT /livros/{id}`: Modifica os dados de um livro existente.
- `DELETE /livros/{id}`: Exclui um livro.

### Gerenciamento de Reservas

- `GET /reservas`: Exibe todas as reservas cadastradas.
- `GET /reservas/{id}`: Retorna uma reserva específica pelo ID.
- `GET /reservas/livro/{livroId}`: Filtra reservas associadas a um livro.
- `GET /reservas/status/{status}`: Lista reservas conforme o estado informado.
- `GET /reservas/cliente?nome={nome}`: Pesquisa reservas pelo nome do cliente.
- `POST /reservas`: Registra uma nova reserva.
- `PUT /reservas/{id}`: Atualiza uma reserva já existente.
- `PATCH /reservas/{id}/confirmar`: Altera o status para "Aprovada".
- `PATCH /reservas/{id}/finalizar`: Define a reserva como "Concluída".
- `DELETE /reservas/{id}`: Remove uma reserva.

