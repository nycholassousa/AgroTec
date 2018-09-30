#Agrotec
Este repositório contém a atividade final da cadeira de Engenharia de Software, UFPB.

## Como instalar
### Dependências
- Maven
- MySQL

### Executando o Projeto
O projeto foi feito utilizando a IDE Intelijj, então, recomenda-se o uso da mesma IDE.

Para executar o projeto, basta configurar primeiro a conexão do mysql no arquivo "application.properties" e criar um banco de dados com o nome que está descrito no mesmo arquivo.

Implicando que você já possua as dependências instaladas, basta executar o projeto, ele irá criar as tabelas dentro do banco de dados sql que você indicou no arquivo.

### Acessando o Projeto
O projeto está rodando pelo tomcat que o Intelijj fornece, para acessar, basta inserir a url http://localhost:8080/api/