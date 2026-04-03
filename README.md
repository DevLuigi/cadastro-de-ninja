# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Sistema de Cadastro de Ninjas**!

Este projeto é uma aplicação desenvolvida com **Spring Boot**, utilizando arquitetura em camadas e boas práticas de desenvolvimento. O sistema permite o gerenciamento de ninjas e suas respectivas missões, com foco em organização, clareza e escalabilidade.

Além disso, o projeto inclui conteúdos complementares sobre banco de dados para aprofundamento técnico.


## 📌 Visão Geral

O sistema foi criado para gerenciar **ninjas** e **missões**, com as seguintes regras:

* Um **Ninja** pode possuir **apenas uma missão**
* Uma **Missão** pode ser atribuída a **vários ninjas**

### 🔹 Funcionalidades principais

* Cadastro de ninjas com:

  * Nome
  * Idade
  * Email
  * Rank
* Atribuição de missão a um ninja
* Gerenciamento de missões
* Relacionamento entre ninjas e missões


## 🚀 Tecnologias Utilizadas

* **Spring Boot** → Criação da aplicação e gerenciamento de dependências
* **Spring Data JPA** → Abstração de acesso a dados
* **JPA (Java Persistence API)** → Mapeamento objeto-relacional (ORM)
* **H2 Database** → Banco de dados em memória (ambiente de desenvolvimento)
* **Flyway** → Controle de versionamento e migração do banco de dados
* **Maven** → Build e gerenciamento de dependências
* **Docker** → Suporte para execução externa do banco de dados
* **SQL** → Manipulação e estruturação do banco
* **Git** → Controle de versão
* **GitHub** → Hospedagem do repositório

## 🗄️ Modelagem do Banco de Dados

### Entidades principais:

#### 🥷 Ninja

* `id`
* `nome`
* `idade`
* `email`
* `rank`

#### 🎯 Missão

* `id`
* `titulo`
* `descricao`

### 🔗 Relacionamento

* Um Ninja → **1 Missão**
* Uma Missão → **N Ninjas**

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/DevLuigi/cadastro-de-ninja.git
```

### 2. Acessar o diretório

```bash
cd cadastro-de-ninja
```

### 3. Build do projeto

```bash
mvn clean install
```

### 4. Executar a aplicação

```bash
mvn spring-boot:run
```

## 🌐 Acesso

Após iniciar a aplicação, acesse:

```
http://localhost:8080
```

## 📚 Observações

* O banco H2 é executado em memória, ideal para testes e desenvolvimento.
* As migrações são controladas automaticamente pelo Flyway.
* O projeto segue uma arquitetura organizada em camadas (Controller, Service, Repository).


## 💡 Possíveis melhorias futuras

* Implementação de autenticação e autorização (Spring Security)
* Documentação da API com Swagger/OpenAPI
* Deploy em ambiente cloud (AWS, Azure, etc.)
* Substituição do H2 por banco relacional em produção (PostgreSQL, MySQL)


## 📄 Licença

Este projeto é livre para estudos e melhorias. Sinta-se à vontade para contribuir!

Feito com 💻 e ☕ para aprendizado e evolução contínua.
