# 🎬 Locadora de DVDs - Projeto Java Spring Boot

Este projeto é um sistema de CRUD completo para uma locadora de DVDs, utilizando Java 21, Spring Boot 3.4.5, MySQL e Swagger.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot (Web, Data JPA)
- MySQL
- Swagger (Springdoc OpenAPI)
- Maven

---

## 📦 Funcionalidades

- Cadastro de Clientes
- Registro de DVDs
- Empréstimos de filmes
- Devolução de filmes
- Gestão de Categorias e Funcionários

---

## ⚙️ Como Rodar

1. Instale JDK 21 e Maven
2. Clone o projeto:
```bash
git clone <repo>
cd locadora-main
```
3. Configure o banco no MySQL:
```sql
CREATE DATABASE locadora;
```
4. Rode o projeto:
```bash
mvn clean install
mvn spring-boot:run
```

---

## 🌐 Endpoints

Exemplo:

| Método | Endpoint                        | Descrição                      |
|--------|----------------------------------|--------------------------------|
| GET    | `/clientes`                     | Listar todos os clientes       |
| POST   | `/filmes`                       | Cadastrar novo filme           |
| PUT    | `/emprestimos/devolver/{id}`    | Registrar devolução            |
| GET    | `/categorias`                   | Listar categorias              |

---

## 📘 Documentação Interativa

Após iniciar o projeto, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 👨‍💻 Autores

Projeto acadêmico para entrega do 2º bimestre — Desenvolvido por [Seu Nome/Grupo].
