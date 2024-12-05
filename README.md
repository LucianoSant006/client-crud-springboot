# DESAFIO: CRUD de clientes
## Você deverá entregar um projeto Spring Boot contendo um CRUD completo de web services REST paraacessar um recurso de clientes, contendo as cinco operações:
### Requisitos
####  Busca paginada de recursos
####  Busca de recurso por id
####  Inserir novo recurso
####  Atualizar recurso
####  Deletar recurso
### O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, e Java como linguagem.Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir (você deve seguir à risca os nomes de classe e atributos mostrados no diagrama):
# Modelo de Domínio
<div style="display: flex; gap: 50px;  padding: 50px;">
    <img src="https://github.com/user-attachments/assets/ae1a6fcd-0f32-4341-8373-f6c883c465d8" width="250" height="250">
</div>

## Requisitos de SEED no Banco de Dados H2
### Seu projeto deverá fazer um seed de pelo menos 10 clientes com dados SIGNIFICATIVOS (não é parausar dados sem significado como “Nome 1”, “Nome 2”, etc.).
## Seu projeto deverá tratar as seguintes exceções:
###  Id não encontrado (para GET por id, PUT e DELETE), retornando código 404.
###  Erro de validação, retornando código 422 e mensagens customizada para cada campo inválido. As
#### regras de validação são:
#### o Nome: não pode ser vazio
#### o Data de nascimento: não pode ser data futura 

## CHECKLIST:
### 1. Busca por id retorna cliente existente
### 2. Busca por id retorna 404 para cliente inexistente
### 3. Busca paginada retorna listagem paginada corretamente
### 4. Inserção de cliente insere cliente com dados válidos
### 5. Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
### 6. Atualização de cliente atualiza cliente com dados válidos
### 7. Atualização de cliente retorna 404 para cliente inexistente
### 8. Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos
### 9. Deleção de cliente deleta cliente existente
### 10. Deleção de cliente retorna 404 para cliente inexistente
# API Client
## Requests
### Get specific client GET / client Route : http://localhost:8080/clients/{id} 
```json
{
    "id": 1,
    "name": "Ana Maria",
    "cpf": "12345678901",
    "income": 4500.5,
    "birthDate": "1985-06-15",
    "children": 2
}
```
### Get Pageable client GET / client Route : http://localhost:8080/clients?page=0&size=6&sort=name
```json
{
    "content": [
        {
            "id": 1,
            "name": "Ana Maria",
            "cpf": "12345678901",
            "income": 4500.5,
            "birthDate": "1985-06-15",
            "children": 2
        },
        {
            "id": 2,
            "name": "Carlos Silva",
            "cpf": "98765432109",
            "income": 5500.75,
            "birthDate": "1990-03-22",
            "children": 1
        },
        {
            "id": 5,
            "name": "Fernanda Oliveira",
            "cpf": "78912345678",
            "income": 6200.0,
            "birthDate": "1975-12-03",
            "children": 2
        },
        {
            "id": 10,
            "name": "Gabriel Almeida",
            "cpf": "45632165421",
            "income": 4500.0,
            "birthDate": "2002-08-20",
            "children": 0
        },
        {
            "id": 4,
            "name": "João Pereira",
            "cpf": "32165498732",
            "income": 8000.3,
            "birthDate": "1980-05-12",
            "children": 3
        },
        {
            "id": 6,
            "name": "Lucas Lima",
            "cpf": "65432198765",
            "income": 4000.45,
            "birthDate": "2000-01-25",
            "children": 1
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 6,
        "sort": {
            "empty": false,
            "unsorted": false,
            "sorted": true
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 10,
    "size": 6,
    "number": 0,
    "sort": {
        "empty": false,
        "unsorted": false,
        "sorted": true
    },
    "numberOfElements": 6,
    "first": true,
    "empty": false
}
```
### Update specific client Update / clients Route : localhost:8080/clients/{id}
```json
{
    "id": 7,
    "name": "Guilherme Santos Almeida",
    "cpf": "9904345",
    "income": 5000.75,
    "birthDate": "1998-03-22",
    "children": 3
}
```
### Add new client POST/clients route: localhost:8080/clients
```json
{
  
  "name": "Ronaldo silva oliveira",
  "cpf": "99923045",
  "income": 5000.75,
  "birthDate": "2000-03-22",
  "children": 1
}
```
### Delete specif client Delete  / clients Route : localhost:8080/clients/{id}


