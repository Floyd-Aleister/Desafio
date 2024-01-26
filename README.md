# Desafio



Padrões utilizados:

Projeto consiste em uma API REST que utiliza o padrão de projeto MVC e disponibiliza de alguns endpoints para manter os dados das Entidades Cliente, Conta e Endereço.
Como o foco do projeto é no Back end e pensando em fazer uma aplicação simplificada, não foi construído interface gráfica; 
Porém, é possível testar todas as requisições utilizando qualquer ferramenta para teste de requisições API como Postman ou Insomnina, ou mesmo acessando as rotas direto pelo navegador.

Foio construído um objeto PL/SQL PRC_RELATORIOS para facilitar o gerenciamento dos dados que serão exibidos nos relatórios requeridos a partir da aplicação Java.
O objeto funciona da seguinte forma:
Ele recebe tês parâmetros:

cd_cliente  - Código do cliente(Dono da conta) 
nr_conta    - Número da conta associada ao cliene(Cliente pode ter mais de uma conta)
nr_periodo  - Período em dias para buscar as movimentações bancárias da conta.

Obs: Caso cd_cliente e nr_conta não sejam passados como parâmetro, o objeto deve buscar os dados para todos os clientes, dentro do período especificado.

A procedure PRC_RELATORIOS deverá primeiramente validar os parâmetros passados e em seguida filtrar e inserir o resultado em uma tabela de relatórios chamada RELATORIO_BANCARIO.
A aplicação Java deverá consultar os dados inseridos nesta tabela e retorna-los em forma de relatório.


Tecnologias utilizadas:

Spring Boot como frameWork Java.
Maven para gerenciar as dependencias utilizadas a aplicação.
JPA para persistência e manutenção dos dados.
Database Oracle 11g.


 
