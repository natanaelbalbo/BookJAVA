# Sistema de Biblioteca

Sistema de gerenciamento de livros e reservas para uma biblioteca, desenvolvido com Spring Boot.

## Funcionalidades

- Cadastro, edição, listagem e exclusão de livros
- Gerenciamento de reservas de livros com diferentes status:
  - **PENDENTE**: A reserva foi criada, mas ainda não confirmada
  - **CONFIRMADA**: A reserva foi confirmada
  - **FINALIZADA**: A reserva foi concluída (check-out ou evento ocorrido)
- Interface web responsiva e moderna

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.2
- Spring Data JPA
- Thymeleaf
- H2 Database (banco de dados em memória)
- Bootstrap 5
- jQuery
- Font Awesome

## Como Executar

1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute o comando: `./mvnw spring-boot:run`
4. Acesse a aplicação em: `http://localhost:8080`
5. Para acessar o console H2: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Usuário: `sa`
   - Senha: (deixe em branco)

## Estrutura do Projeto

- `model`: Entidades JPA (Livro, Reserva)
- `repository`: Interfaces de repositório Spring Data
- `service`: Camada de serviço com regras de negócio
- `controller`: Controladores REST e Web
- `resources/templates`: Templates Thymeleaf para a interface web

## Dados de Teste

O sistema é inicializado com alguns livros e reservas para teste.

## API REST

O sistema também disponibiliza endpoints REST para integração:

### Livros

- `GET /livros`: Lista todos os livros
- `GET /livros/{id}`: Busca um livro por ID
- `POST /livros`: Cria um novo livro
- `PUT /livros/{id}`: Atualiza um livro existente
- `DELETE /livros/{id}`: Remove um livro

### Reservas

- `GET /reservas`: Lista todas as reservas
- `GET /reservas/{id}`: Busca uma reserva por ID
- `GET /reservas/livro/{livroId}`: Lista reservas por livro
- `GET /reservas/status/{status}`: Lista reservas por status
- `GET /reservas/cliente?nome={nome}`: Busca reservas por nome do cliente
- `POST /reservas`: Cria uma nova reserva
- `PUT /reservas/{id}`: Atualiza uma reserva existente
- `PATCH /reservas/{id}/confirmar`: Confirma uma reserva
- `PATCH /reservas/{id}/finalizar`: Finaliza uma reserva
- `DELETE /reservas/{id}`: Remove uma reserva
