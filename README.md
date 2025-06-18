# Locadora de Filmes - CRUD em Java Spring

Este projeto consiste em um sistema CRUD para uma locadora de filmes, implementado com Java e Spring Boot, com persistência via banco de dados relacional. O sistema gerencia as entidades principais de uma locadora: *Filmes, **Clientes, **Empréstimos, **Funcionários* e *Categorias*.

---

## 📦 Entidades

### 🎬 Filme
- id: Identificador único
- titulo: Nome do filme
- genero: Gênero do filme (ex: Ação, Drama)
- anoLancamento: Ano de lançamento
- disponivel: Booleano que indica se o filme está disponível para empréstimo
- categoria: Categoria do filme (ex: Lançamento, Promoção)

### 👤 Cliente
- id: Identificador único
- nome: Nome completo
- cpf: CPF válido
- telefone: Telefone de contato
- email: Email do cliente

### 📋 Empréstimo
- id: Identificador único
- cliente: Referência ao cliente
- filme: Referência ao filme
- dataEmprestimo: Data do empréstimo
- dataDevolucao: Data da devolução (opcional até ser devolvido)
- devolvido: Booleano indicando se o filme já foi devolvido

### 👩‍💼 Funcionário
- id: Identificador único
- nome: Nome do funcionário
- cargo: Cargo ocupado (ex: atendente, gerente)
- email: Email corporativo

### 🏷️ Categoria
- id: Identificador único
- nome: Nome da categoria (ex: Lançamento, Promoção, Catálogo)

---

## 🔄 Funcionalidades CRUD por entidade

### Cliente
- GET /clientes - Lista todos os clientes
- GET /clientes/{id} - Busca cliente por ID
- POST /clientes - Cadastra um novo cliente
- PUT /clientes/{id} - Atualiza os dados de um cliente
- DELETE /clientes/{id} - Remove um cliente

### Filme
- GET /filmes
- GET /filmes/{id}
- POST /filmes
- PUT /filmes/{id}
- DELETE /filmes/{id}

### Empréstimo
- GET /emprestimos
- GET /emprestimos/{id}
- POST /emprestimos/{clienteId}/{filmeId} - Cria um empréstimo entre cliente e filme
- PUT /emprestimos/devolver/{id} - Realiza a devolução do filme
- DELETE /emprestimos/{id}

### Funcionário
- GET /funcionarios
- GET /funcionarios/{id}
- POST /funcionarios
- PUT /funcionarios/{id}
- DELETE /funcionarios/{id}

### Categoria
- GET /categorias
- GET /categorias/{id}
- POST /categorias
- PUT /categorias/{id}
- DELETE /categorias/{id}

---
