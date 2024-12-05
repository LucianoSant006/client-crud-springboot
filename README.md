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
