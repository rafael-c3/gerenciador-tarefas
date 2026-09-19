# Gerenciador de Tarefas

API REST para gerenciamento de projetos, responsáveis e tarefas, desenvolvida como atividade final da disciplina Programação Web Back-end I.

## Descrição

O serviço permite cadastrar projetos e responsáveis, e gerenciar o ciclo de vida completo das tarefas de cada projeto (criar, listar, filtrar, consultar, atualizar e remover), com persistência em banco relacional.

## Requisitos de ambiente

- Java 25
- Maven
- PostgreSQL 16+ (ou superior)

## Banco de dados

PostgreSQL. Crie o banco antes de rodar a aplicação:

```sql
CREATE DATABASE gerenciador_tarefas;
```

Configure usuário e senha em `src/main/resources/application.properties`.

## Como rodar

1. Clone o repositório:
```bash
   git clone https://github.com/seu-usuario/gerenciador-tarefas.git
```
2. Crie o banco de dados conforme instruções acima.
3. Ajuste `application.properties` com suas credenciais do PostgreSQL.
4. Rode a aplicação:
```bash
   ./mvnw spring-boot:run
```
5. A API estará disponível em `http://localhost:8080`.

## Testando a API

O arquivo `testes.http` na raiz do projeto contém uma coleção de requisições cobrindo o roteiro completo de verificação. Pode ser executado diretamente pelo IntelliJ IDEA (clicando na seta verde ao lado de cada requisição).

## Endpoints

### Projetos

| Método | Rota | Descrição |
|---|---|---|
| POST | `/projetos` | Cria um projeto |
| GET | `/projetos` | Lista todos os projetos |

### Responsáveis

| Método | Rota | Descrição |
|---|---|---|
| POST | `/responsaveis` | Cria um responsável |
| GET | `/responsaveis` | Lista todos os responsáveis |

### Tarefas

| Método | Rota | Descrição |
|---|---|---|
| POST | `/tarefas` | Cria uma tarefa vinculada a um projeto |
| GET | `/tarefas` | Lista tarefas (aceita filtros `status` e `projetoId` via query string) |
| GET | `/tarefas/{id}` | Consulta uma tarefa específica |
| PUT | `/tarefas/{id}` | Atualiza uma tarefa (inclui troca de status e atribuição de responsável) |
| DELETE | `/tarefas/{id}` | Remove uma tarefa |

## Regras de negócio

- Toda tarefa pertence a exatamente um projeto (obrigatório).
- O responsável é opcional.
- Ao criar, a tarefa nasce com status `NOVA` e `criadaEm` preenchido automaticamente.
- Ao mudar o status para `CONCLUIDA`, o campo `concluidaEm` é preenchido automaticamente.
- Consultar um projeto ou tarefa inexistente retorna `404 Not Found` com corpo padronizado, nunca erro interno.

## Tecnologias

- Java 25
- Spring Boot 4.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven