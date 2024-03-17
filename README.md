# CRUD Cliente/Produto

# Estatística
https://wakatime.com/@018e3b67-403a-487e-98fa-367dcb8d460f/projects/vriliwpiln?start=2024-03-10&end=2024-03-16

# Sobre o Sistema
O sistema passou por uma refatoração para receber tambem um cadastro de Produtos!

# O que foi modificado?
Foi implementada uma superclasse genérica/abstrata que aproveita os métodos específicos da classe anterior (ClienteMapDao, agora uma subclasse), eliminando a necessidade de especificá-los e de implementar a lógica específica para cada classe.

Uma vez que a superClasse Possui os metodos genéricos para Cadastro - Remoção - Busca - BuscarTodos, é possível criar a classe Produto e sua respectiva DAO passando um produto para esta superclasse genérica.

Design Patterns: utilizado

FACADE - BUILD.
FACADE: Projeto.

BUILD: Utilizado no metodo Cadastro.

# Testado
  - JUnit

# Remoção 
  - Inteface gui
  - Classe ClienteSetDao

# Versão antes da REFATORAÇÃO 
# Área de cadastro do cliente 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/CodeMoon1/Cliente-Cadastro/blob/main/LICENSE) 

# Sobre o projeto

O software é uma aplicação de cadastro de clientes. Ele permite a inserção de dados de clientes por meio de uma caixa de diálogos, e os armazena na memória. Após o cadastro, o usuário pode realizar diversas ações, como buscar, editar, remover ou sair da aplicação.

A busca é feita pelo CPF do cliente. Você pode escolher entre duas classes para implementar a funcionalidade de armazenamento de dados: HashMap, que permite uma busca rápida e inserção eficiente de dados, ou HashSet.

## Layout desktop
![Desktop 1](https://github.com/CodeMoon1/Cliente-Cadastro/blob/main/Assets/GUI.png) 


# Tecnologias utilizadas
## Back end
- Java

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/CodeMoon1/Cliente-Cadastro.git

# entrar na pasta do projeto

# executar o projeto
```

# Autor

Kalleb Prado.

https://www.linkedin.com/in/kalleb-souza-a12078126/

