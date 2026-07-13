# 💰 Financial Control API

API REST para controle financeiro pessoal, desenvolvida em **Java** com **Spring Boot** e **MySQL**. Permite gerenciar pessoas, categorias e lançamentos financeiros (receitas e despesas), com validações, paginação e tratamento centralizado de erros.

## 🚀 Tecnologias

- **Java**
- **Spring Boot**
  - Spring Web (REST)
  - Spring Data JPA
  - Bean Validation (`@Valid`)
- **MySQL**
- **Maven**

## ✨ Funcionalidades

- Cadastro, listagem, atualização e exclusão de **Pessoas**
- Cadastro, listagem, atualização e exclusão de **Categorias**
- Cadastro, listagem, atualização e exclusão de **Lançamentos** (receitas/despesas), vinculados a uma pessoa e categoria
- Listagem paginada e ordenável dos recursos
- Validação de dados de entrada via Bean Validation
- Tratamento centralizado de exceções (`TratadorDeErros`) com exceptions customizadas por entidade (ex.: `CategoriaNaoEncontrada`, `PessoaNaoEncontrada`, `LancamentoNaoEncontrado`)
- Uso de DTOs para separar o modelo de domínio dos dados trafegados na API (cadastro, atualização, listagem, detalhamento e erro)

## 📁 Estrutura do projeto

```
src/main/java/Sistema/api
├── Controller/          # Controllers REST (Categoria, Lancamento, Pessoa)
├── DTO/                 # Records/DTOs de entrada e saída (cadastro, listagem, detalhamento, erro)
├── entities/            # Entidades JPA (Categoria, Endereco, Lancamento, Pessoa, TipoLancamento)
├── infra/                # Tratamento global de erros
├── exception/            # Exceptions de negócio customizadas
└── ProjetoApplication.java
```

## 📌 Endpoints principais

> Base path: `/`

### Categorias

| Método | Endpoint          | Descrição                                  |
|--------|-------------------|---------------------------------------------|
| POST   | `/categorias`     | Cadastra uma nova categoria                 |
| GET    | `/categorias`     | Lista categorias (paginado, ordenado por nome) |
| PUT    | `/categorias`     | Atualiza uma categoria existente            |
| DELETE | `/categorias/{id}`| Remove uma categoria                        |

### Pessoas

| Método | Endpoint        | Descrição                             |
|--------|-----------------|-----------------------------------------|
| POST   | `/pessoas`      | Cadastra uma nova pessoa                |
| GET    | `/pessoas`      | Lista pessoas (paginado)                |
| PUT    | `/pessoas`      | Atualiza uma pessoa existente           |
| DELETE | `/pessoas/{id}` | Remove uma pessoa                       |

### Lançamentos

| Método | Endpoint            | Descrição                                    |
|--------|---------------------|-------------------------------------------------|
| POST   | `/lancamentos`      | Cadastra um novo lançamento (receita/despesa)   |
| GET    | `/lancamentos`      | Lista lançamentos (paginado)                    |
| PUT    | `/lancamentos`      | Atualiza um lançamento existente                |
| DELETE | `/lancamentos/{id}` | Remove um lançamento                            |

> ⚠️ Confira as rotas exatas de `Lancamento` e `Pessoa` no código, pois foram inferidas a partir do padrão usado em `CategoriaController`.

### Exemplo de requisição — Cadastrar categoria

```http
POST /categorias
Content-Type: application/json

{
  "nome": "Alimentação"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Alimentação"
}
```

## ⚙️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven (ou use o `mvnw` incluso no projeto)
- MySQL em execução

### Passo a passo

1. Clone o repositório
```bash
git clone https://github.com/joaovitor2410/Financial-control-api.git
cd Financial-control-api
```

2. Configure o banco de dados em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/financial_control
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Crie o banco de dados no MySQL:
```sql
CREATE DATABASE financial_control;
```

4. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 🧪 Testando a API

Recomendo usar **Insomnia** ou **Postman** para testar os endpoints.

## 🛣️ Próximos passos

- [ ] Implementar autenticação e autorização (Spring Security + JWT)
- [ ] Adicionar documentação automática com Swagger/OpenAPI
- [ ] Escrever testes automatizados (unitários e de integração)
- [ ] Adicionar relatórios/resumos financeiros (ex.: saldo por período, gastos por categoria)
- [ ] Deploy em nuvem

## 👨‍💻 Autor

Desenvolvido por **João Vitor** como projeto de estudo/portfólio na área de desenvolvimento backend.

## 📄 Licença

Este projeto está sob a licença MIT.
