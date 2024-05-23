# Projeto de Auxílio para Seguradoras

## Descrição Breve do Projeto

Este projeto é uma aplicação desenvolvida para auxiliar seguradoras na gestão de seus clientes, veículos e ocorrências. Utilizando Java (versão 8) para a lógica de aplicação e MySQL para o gerenciamento de dados, a aplicação oferece uma interface intuitiva para o usuário realizar operações CRUD (Create, Read, Update, Delete) de maneira eficiente. O projeto também integra ferramentas como HelpNDoc para documentação e JasperSoft para geração de relatórios, proporcionando uma solução completa para as necessidades de seguradoras. O projeto foi feito no curso de desenvolvedor Java, no Senai em 2021, com auxilio do professor Willians Luiz Gomes.

## Início

Bem-vindo(a)!

Este projeto foi desenvolvido em 2021 para auxiliar seguradoras, integrando Java (versão 8) com um banco de dados SQL. A interação com o banco de dados é recomendada via MySQL Workbench 8.0 ou PHPmyAdmin. Este README fornece as instruções necessárias para configurar e executar o projeto.

## Ferramentas Necessárias

Para executar este projeto, você precisará das seguintes ferramentas:

### Java
- **Download Java 8**: [Link para Download](https://javadl.oracle.com/webapps/download/AutoDL?BundleId=245479_4d5417147a92418ea8b615e228bb6935)
- **Download JDK**: [Link para Download](https://www.oracle.com/java/technologies/downloads/)

### SQL
- **Download PHPmyAdmin**: [Link para Download](https://files.phpmyadmin.net/phpMyAdmin/5.1.1/phpMyAdmin-5.1.1-all-languages.zip)
- **Download MySQL Installer**: [Link para Download](https://dev.mysql.com/downloads/installer/)

### IDE
- **NetBeans 12.5**: Este projeto é guiado pelo uso da IDE NetBeans 12.5.

## Configuração do Ambiente

### Configuração do Banco de Dados

Antes de iniciar o projeto, é necessário configurar o banco de dados. A seguir estão os passos para assegurar que o banco de dados esteja funcionando corretamente:

#### MySQL Workbench
1. Abra o MySQL Workbench.
2. Clique com o botão direito na sua conexão e selecione "Open Connection".
3. Insira a senha, se necessário.
4. Teste a conexão:
   - Clique na engrenagem.
   - Vá em "Test Connection".
   - Insira sua senha.

Se a conexão for estabelecida corretamente, o banco de dados estará pronto para uso. Caso contrário, verifique se a conexão foi configurada corretamente e se o MySQL está em execução.

#### XAMPP
1. Certifique-se de que MySQL ou PHPmyAdmin já estejam configurados.
2. Abra o XAMPP e clique em "Start" no módulo MySQL.

### Configuração da Aplicação

1. Clone o repositório do projeto em sua máquina.
2. Abra o projeto no NetBeans 12.5.
3. Configure a conexão com o banco de dados no arquivo de configuração do projeto, fornecendo o nome de usuário e senha do banco de dados SQL.

## Execução do Projeto

Após configurar o banco de dados e a aplicação, você pode iniciar o projeto no NetBeans. A aplicação começará com a Tela de Login.

### Tela de Login

1. Inicie a aplicação.
2. Insira seu nome de usuário e senha nos campos designados e clique em "Login".
3. Se não tiver uma conta, clique no botão de cadastro para criar uma nova conta.

### Tela Principal

Após o login, você será direcionado para a tela principal da aplicação, que apresenta os seguintes menus e funcionalidades:

- **Clientes**
- **Automóvel**
- **Ocorrências**
- **Ajuda**

### Funcionalidades CRUD

Cada tela possui botões que correspondem às operações CRUD:

- **C - Create**: Cadastrar novos registros.
- **R - Read**: Pesquisar registros existentes.
- **U - Update**: Editar registros existentes.
- **D - Delete**: Deletar registros.

## Demonstração

Para uma demonstração completa do projeto, assista ao vídeo no YouTube:

[Veja a demonstração no YouTube](https://youtu.be/SoAw3v9fLH4)
