# Aplicação MeuCarro


# Teste Java




# Descrição



A api desenvolvida para teste técnico em java,a api tem por objetivo gerenciar
, carros, marcas e modelos.
Para o desenvolvimento do projeto em java usei as seguintes tecnologias :


- Java
- Spring Boot 
- H2
- Angular
- Swagger




Link (local) do front :  http://localhost:8080/



# Instalação e execução
Para iniciar este projeto eu criei um script para inserção dos dados

O script esta  em:


src/main/resources/data.sql 




url do banco :


http://localhost:8080/h2-ui/


Obs: Altere  a JDBC URL  para : jdbc:h2:mem:meucarro


# 1) Crie uma aplicação Springboot, com
acesso a BD (spring-data) e que exponha endpoints Rest (Abaixo eu listo o crud de marca, mas o crud em todas a entidades seguem o mesmo padrao
, o unico endpoint diferente deste padrao de marca é o de listar carro , onde eu retorno um Dto  com as informações pedidas no exercicio 2 do teste técnico)





## Instruçoes para uso da api


Para documentar e realizar os testes da api, eu usei o Swagger, link para testar os endpoints:

http://localhost:8080/swagger-ui/index.html#/


Caso prefira o postman segue as orinetações abaixo:


- criar uma marca


verbo http: Post


url : localhost:8080/api/marca


```json

{
  "id": 0,
  "nome_marca": "string"
}
```










- Editar uma marca


  verbo http: Put
  
  
url : localhost:8080/api/marca



Formato do json esperado pela Api


``` json
{
  "id": 1,
  "nome_marca": "string"
}
```




- Consultar uma marca


  verbo http: Get
  
  
url : localhost:8080/api/marca/1


Onde 1 representa um numero de id, previamente cadastrado no banco de dados.



Resposta da Api


``` json
{
  "id": 1,
  "nome_marca": "FIAT"
}
```



- Listar marcas


  verbo http: Get
  
  
  http://localhost:8080/api/marca?page=0
  

A api lista os dados paginados, como default , é retornado em cada pagina 10 registros,onde page=0 
(Zero representa o numero da pagina).



Resposta da Api


``` json


{
  "content": [
    {
      "id": 1,
      "marca_id": 1,
      "marca_nome": "FIAT",
      "modelo_id": 1,
      "nome_modelo": "FASTBACK",
      "ano": 2022,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 50000,
      "cor": "Vermelho",
      "timestamp_cadastro": 1666569600
    },
    {
      "id": 2,
      "marca_id": 1,
      "marca_nome": "FIAT",
      "modelo_id": 2,
      "nome_modelo": "ARGO",
      "ano": 2021,
      "combustivel": "Alcool",
      "num_portas": 4,
      "valor_fipe": 30000,
      "cor": "Branca",
      "timestamp_cadastro": 1666569600
    },
    {
      "id": 3,
      "marca_id": 2,
      "marca_nome": "CHEVROLET",
      "modelo_id": 3,
      "nome_modelo": "ONIX",
      "ano": 2020,
      "combustivel": "Alcool",
      "num_portas": 2,
      "valor_fipe": 35000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 4,
      "marca_id": 2,
      "marca_nome": "CHEVROLET",
      "modelo_id": 4,
      "nome_modelo": "CELTA",
      "ano": 2015,
      "combustivel": "Flex",
      "num_portas": 2,
      "valor_fipe": 15000,
      "cor": "Prata",
      "timestamp_cadastro": 1639094400
    },
    {
      "id": 5,
      "marca_id": 3,
      "marca_nome": "TOYOTA",
      "modelo_id": 5,
      "nome_modelo": "COROLLA",
      "ano": 2019,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 6,
      "marca_id": 3,
      "marca_nome": "TOYOTA",
      "modelo_id": 6,
      "nome_modelo": "YARIS",
      "ano": 2022,
      "combustivel": "Etanol",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Azul",
      "timestamp_cadastro": 1605052800
    },
    {
      "id": 7,
      "marca_id": 4,
      "marca_nome": "HYUNDAI",
      "modelo_id": 7,
      "nome_modelo": "TUCSON",
      "ano": 2018,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 55000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 8,
      "marca_id": 4,
      "marca_nome": "HYUNDAI",
      "modelo_id": 8,
      "nome_modelo": "CRETA",
      "ano": 2022,
      "combustivel": "Diesel",
      "num_portas": 4,
      "valor_fipe": 75000,
      "cor": "Azul",
      "timestamp_cadastro": 1641427200
    },
    {
      "id": 9,
      "marca_id": 5,
      "marca_nome": "VOLKSWAGEM",
      "modelo_id": 9,
      "nome_modelo": "NIVUS",
      "ano": 2018,
      "combustivel": "Alcool",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Prata",
      "timestamp_cadastro": 1641513600
    },
    {
      "id": 10,
      "marca_id": 5,
      "marca_nome": "VOLKSWAGEM",
      "modelo_id": 10,
      "nome_modelo": "T-CROS",
      "ano": 2020,
      "combustivel": "Flex",
      "num_portas": 4,
      "valor_fipe": 45000,
      "cor": "Amarelo",
      "timestamp_cadastro": 1642204800
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "pageNumber": 0,
    "pageSize": 10,
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalPages": 2,
  "totalElements": 15,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "first": true,
  "number": 0,
  "numberOfElements": 10,
  "size": 10,
  "empty": false
}








```




    

- Deletar marca marca


  verbo http: delete
  
  
  http://localhost:8080/api/marca/1
  
  

Para que uma marca seja excluida  é necessario que não haja nenhum modelo vinculado a marca, caso contrario a api retorna uma 
mensagem  informando o erro.



Resposta da Api : status code 400


Para excluir esta marca é necessario excluir os modelos de carros desta marca


``` json
Para excluir esta marca é necessario excluir os modelos de carros desta marca
```

- Caso não haja modelo vinculado a resposta da api é : status code 204


  
  

Onde 1 representa o id de uma pessoa(registro) previamente cadastrado





# Testanto a api Com Docker ou Heroku


Caso prefira realizar os teste sem baixar ou sem clonar o repositório



Heroku


https://meucarro-java.herokuapp.com/swagger-ui/index.html#/



Banco H2 Remoto 



https://meucarro-java.herokuapp.com/h2-ui


Obs: Altere  a JDBC URL  para : jdbc:h2:mem:meucarro



Caso prefira rodar a aplicação localmente pelo docker para teste:


Baixe  e descompacte o repositorio ou clone:

 

1 - No terminal ,na raiz do projeto onde contém o Dockerfile

```docker
docker build --tag backend .
```

Para verificar se a imagem foi gerado digite:

```docker
docker images
```

2-Para rodar o container 
Obs : Para rodar o container certifique de que a porta 8080 esteja desocupada, se não  indique outra porta no comando abaixo


```docker
docker run -d -p 8080:8080 backend
```


Se tudo correr bem será impresso o id do container no terminal


Depois de alguns segundos digite a seguinte url de teste
(Este procedimento foi realizado na minha maquina local):
http://localhost:8080


Url banco  : http://localhost:8080/h2-ui


Obs: Altere  a JDBC URL  para : jdbc:h2:mem:meucarro

Url Swagger : http://localhost:8080/swagger-ui/index.html#/



O postaman agora pode ser testado localmente.



# 2) Crie um endpoint que entregue uma listagem de modelos, com o seguinte formato :
 (A lista aqui é paginada, onde o cliente da api que informa a quandidade de dados que ele quer consumir,
fiz isto pensando em usuarios mobile, onde a largura de banda é menor , trazendo assim uma maior performance para o cliente da api)


{
      "id": 1,
      "marca_id": 1,
      "marca_nome": "FIAT",
      "modelo_id": 1,
      "nome_modelo": "FASTBACK",
      "ano": 2022,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 50000,
      "cor": "Vermelho",
      "timestamp_cadastro": 1666569600
    },
    {
      "id": 2,
      "marca_id": 1,
      "marca_nome": "FIAT",
      "modelo_id": 2,
      "nome_modelo": "ARGO",
      "ano": 2021,
      "combustivel": "Alcool",
      "num_portas": 4,
      "valor_fipe": 30000,
      "cor": "Branca",
      "timestamp_cadastro": 1666569600
    },
    {
      "id": 3,
      "marca_id": 2,
      "marca_nome": "CHEVROLET",
      "modelo_id": 3,
      "nome_modelo": "ONIX",
      "ano": 2020,
      "combustivel": "Alcool",
      "num_portas": 2,
      "valor_fipe": 35000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 4,
      "marca_id": 2,
      "marca_nome": "CHEVROLET",
      "modelo_id": 4,
      "nome_modelo": "CELTA",
      "ano": 2015,
      "combustivel": "Flex",
      "num_portas": 2,
      "valor_fipe": 15000,
      "cor": "Prata",
      "timestamp_cadastro": 1639094400
    },
    {
      "id": 5,
      "marca_id": 3,
      "marca_nome": "TOYOTA",
      "modelo_id": 5,
      "nome_modelo": "COROLLA",
      "ano": 2019,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 6,
      "marca_id": 3,
      "marca_nome": "TOYOTA",
      "modelo_id": 6,
      "nome_modelo": "YARIS",
      "ano": 2022,
      "combustivel": "Etanol",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Azul",
      "timestamp_cadastro": 1605052800
    },
    {
      "id": 7,
      "marca_id": 4,
      "marca_nome": "HYUNDAI",
      "modelo_id": 7,
      "nome_modelo": "TUCSON",
      "ano": 2018,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "valor_fipe": 55000,
      "cor": "Prata",
      "timestamp_cadastro": 1636588800
    },
    {
      "id": 8,
      "marca_id": 4,
      "marca_nome": "HYUNDAI",
      "modelo_id": 8,
      "nome_modelo": "CRETA",
      "ano": 2022,
      "combustivel": "Diesel",
      "num_portas": 4,
      "valor_fipe": 75000,
      "cor": "Azul",
      "timestamp_cadastro": 1641427200
    },
    {
      "id": 9,
      "marca_id": 5,
      "marca_nome": "VOLKSWAGEM",
      "modelo_id": 9,
      "nome_modelo": "NIVUS",
      "ano": 2018,
      "combustivel": "Alcool",
      "num_portas": 4,
      "valor_fipe": 25000,
      "cor": "Prata",
      "timestamp_cadastro": 1641513600
    },
    {
      "id": 10,
      "marca_id": 5,
      "marca_nome": "VOLKSWAGEM",
      "modelo_id": 10,
      "nome_modelo": "T-CROS",
      "ano": 2020,
      "combustivel": "Flex",
      "num_portas": 4,
      "valor_fipe": 45000,
      "cor": "Amarelo",
      "timestamp_cadastro": 1642204800
    }



# 3) Crie endpoints para CRUD de carros, marcas e modelos. 

Os endpoints podem ser testados de  dua formas :

Pelo front em angular (localhost:8080  ou https://meucarro-java.herokuapp.com/)


Pelo swagger(localhost:8080/swagger-ui/index.html#/     ou       https://meucarro-java.herokuapp.com/swagger-ui/index.html#/)




# 4)Explique brevemente o seu código, estrutura de código, organização e suas decisões.

  Procurei seguir uma  coerência em toda a aplicação, buscando principalmente na parte do back performance, quanto ao front eu poderia ir em busca da mesma,
  mas optei por segurança, no front eu poderia ter desenvolvido a aplicação usando lazy loadin(Carregamento lento, por demanda...) o que deixaria a aplicação
  mais performatica(A aplicação em java), mas por conta de algumas duvidas tecnicas preferi  o carregamento total, como dito neste documento optei pela paginação 
  em alguns casos pensando no cliente da aplicação, quem desenvolver o front dependendo da largura de banda poderá escolher como irá listar os registros.Também
  optei pelo swagger para padronizar a documentação tornando mais claro o entendimento dos dados de consumo da api e facilitando alguns testes e por fim
  optei por dar opções a quem for avaliar a api, este projeto pode ser baixado e testado rodando na ide de preferência, pode ser testado online, e até pelo docker
  



5) Desafio bônus: Converta / Implemente o mesmo sistema em kotlin no lugar de java.


Link  da api Kotlin : 









