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




Link do front :

Nesta api pude trabalhar com o banco H2 pela primeira vez, como utilizo para os meus estudos SGBDS "tradicionais"
(Postgres e Mysql), num primeiro momento senti a diferença, pois com os SGBDS utilizo muito querys nativa,
pela flexibilidade e por uma maior documentação de uso, com o H2 vi a necessidade do JPQL pois ele abstrai algumas 
particularidades dos bancos, trazendo mais transparência.
Gostei da experiência de utilizar o h2, por  ser leve e poder ser integrado muito facilmente no ambiente de desenvolvimento.





# Instalação e execução
Para iniciar este projeto eu criei um script para inserção dos dados

O script esta  em:


src/main/resources/data.sql 




url do banco :


http://localhost:8080/h2-ui/


Obs: Altere  a JDBC URL  para : jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE


Entre no banco , clicando em connect

depois



```mysql
delete from endereco;


delete from pessoa;
```

depois disto também poderá ser possível testar o status code 404 no docker e no heroku.

Para  inserir novamente os dados copie e cole o script abaixo




# Instruçoes para uso da api


Para documentar e realizar os testes da api, eu usei o Swagger, link para testar os endpoints:

http://localhost:8080/swagger-ui/index.html#/


Caso prefira o postman segue as orinetações abaixo:


- criar uma pessoa


verbo http: Post


url : localhost:8080/api/pessoa


```json

{"id":"",
    "nome":"Nome da pessoa",
    "dataNascimento":"1950-06-25",
    "enderecos":[
{"id":"","logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true},
{"id":"","logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},
{"id":"","logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false}]
    }
```


Obs : A api permite o cadastro de uma lista de endereços, onde pelo menos 1 precisa ser principal.
Também é possível cadastrar um endereço, mas a estrutura do json precisa ser mantida (Como pessoa pode ter mais
de um endereço, eu fiz desta forma, o exemplo de cima e de baixo funcionam)


Formato do json esperado pela Api


``` json
{"id":"",
    "nome":"Nome da pessoa",
    "dataNascimento":"1950-06-25",
    "enderecos":[
{"id":"","logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true}
               ]
    }

```




- Editar uma pessoa


  verbo http: Put
  
  
url : localhost:8080/api/pessoa



Formato do json esperado pela Api


``` json
{
  "id": 22,
  "nome": "Roger Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 32,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    },
    {
      "id": 33,
      "logradouro": "Travessa Rosa Novaes",
      "cep": "24804668",
      "numero": 756,
      "cidade": "Itaboraí",
      "principal": false
    },
    {
      "id": 34,
      "logradouro": "Rua Emanoel Araújo Carvalho",
      "cep": "78730710",
      "numero": 124,
      "cidade": "Rondonópolis",
      "principal": false
    }
  ]
}


```


Obs : A api permite a edição de uma lista de endereços, onde pelo menos 1 precisa ser principal.
Também é possível editar um endereço, mas a estrutura do json precisa ser mantida (Como pessoa pode ter mais
de um endereço, eu fiz desta forma, o exemplo de cima e de baixo funcionam)

Formato do json esperado.


``` json

{
  "id": 22,
  "nome": "Roger Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 32,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    }
      ]
}
```



- Consultar uma pessoa


  verbo http: Get
  
  
url : localhost:8080/api/pessoa/1


Onde 1 representa um numero de id, previamente cadastrado no banco de dados.



Resposta da Api


``` json
{
  "id": 1,
  "nome": "Filipe Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 1,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    },
    {
      "id": 22,
      "logradouro": "Travessa Rosa Novaes",
      "cep": "24804668",
      "numero": 756,
      "cidade": "Itaboraí",
      "principal": false
    },
    {
      "id": 29,
      "logradouro": "Rua Emanoel Araújo Carvalho",
      "cep": "78730710",
      "numero": 124,
      "cidade": "Rondonópolis",
      "principal": false
    }
  ]
}
```



- Listar pessoas


  verbo http: Get
  
  
  http://localhost:8080/api/pessoa?page=0&sort=id,asc
  

A api lista os dados paginados, como default , é retornado em cada pagina 10 registros,onde page=0 
(Zero representa o numero da pagina).



Resposta da Api


``` json
{"content":[{"id":1,"nome":"Filipe Samuel","dataNascimento":"1950-06-25","enderecos":[{"id":1,"logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true},{"id":22,"logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},{"id":29,"logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false}]},
{"id":2,"nome":"Clarice Amanda Bianca Nunes","dataNascimento":"1948-06-07","enderecos":[{"id":2,"logradouro":"Rua Paulo Alves Cassola","cep":"08752580","numero":448,"cidade":"Mogi das Cruzes","principal":true},{"id":23,"logradouro":"Rua Mendanha","cep":"50741260","numero":259,"cidade":"Recife","principal":false},{"id":30,"logradouro":"Avenida dos Funcionários Públicos","cep":"04963010","numero":552,"cidade":"São Paulo","principal":false}]},
{"id":3,"nome":"Miguel Felipe Caio Cavalcanti","dataNascimento":"1951-02-19","enderecos":[{"id":3,"logradouro":"Rua Vênus","cep":"49040630","numero":175,"cidade":"Aracaju","principal":true},{"id":24,"logradouro":"Avenida Gury Marques","cep":"79064245","numero":244,"cidade":"Campo Grande","principal":false},{"id":31,"logradouro":"Rua Dom Pedro II","cep":"78700426","numero":252,"cidade":"Rondonópolis","principal":false}]},
{"id":4,"nome":"Sarah Flávia Ramos","dataNascimento":"1993-05-08","enderecos":[{"id":4,"logradouro":"Comunidade São Domingues","cep":"29714110","numero":304,"cidade":"Colatina","principal":true},{"id":25,"logradouro":"Avenida Cândido Muniz, s/n","cep":"64480970","numero":676,"cidade":"Arraial","principal":false}]},
{"id":5,"nome":"Luciana Jéssica Peixoto","dataNascimento":"1954-07-15","enderecos":[{"id":5,"logradouro":"Rua Morávia","cep":"69097321","numero":865,"cidade":"Manaus","principal":true},{"id":26,"logradouro":"Rua Anadia","cep":"57080120","numero":598,"cidade":"Maceió","principal":false}]},
{"id":6,"nome":"Raquel Louise Almada","dataNascimento":"1994-04-27","enderecos":[{"id":6,"logradouro":"Via Local Oito","cep":"68906806","numero":995,"cidade":"Macapá","principal":true},{"id":27,"logradouro":"Rua Pavão","cep":"77825430","numero":539,"cidade":"Araguaína","principal":false}]},
{"id":7,"nome":"Joaquim Murilo Baptista","dataNascimento":"1995-04-17","enderecos":[{"id":7,"logradouro":"Rua Calebe","cep":"69316775","numero":367,"cidade":"Boa Vista","principal":true},{"id":28,"logradouro":"Avenida Dezoito de Julho","cep":"68904620","numero":209,"cidade":"Macapá","principal":false}]},
{"id":8,"nome":"Fabiana Carla Adriana de Paula","dataNascimento":"2003-06-22","enderecos":[{"id":8,"logradouro":"Rua Campos Sales","cep":"35040090","numero":257,"cidade":"Governador Valadares","principal":true}]},
{"id":9,"nome":"Renata Lara Cecília","dataNascimento":"1957-05-25","enderecos":[{"id":9,"logradouro":"Rua 7","cep":"74555190","numero":306,"cidade":"Goiânia","principal":true}]},
{"id":10,"nome":"Fernando Thomas Nascimento","dataNascimento":"1994-03-08","enderecos":[{"id":10,"logradouro":"Travessa Paulo Cesar","cep":"40720426","numero":956,"cidade":"Salvador","principal":true}]}],
"pageable":{"sort":{"empty":false,"sorted":true,"unsorted":false},"offset":0,"pageNumber":0,"pageSize":10,"unpaged":false,"paged":true},"last":false,"totalElements":21,"totalPages":3,"size":10,"number":0,"sort":{"empty":false,"sorted":true,"unsorted":false},"first":true,"numberOfElements":10,"empty":false}


```




- Criar Endereco


  verbo http: Post
  
  
  http://localhost:8080/api/endereco
  

Formato do json esperado.


``` json

{"id":"","logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true,"idPessoa" :1}
 ```
 
 
Resposta da Api


``` json
{"id":"","logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true,"idPessoa" :1}           
```
    

- Listar endereços da pessoa


  verbo http: get
  
  
  http://localhost:8080/api/endereco/1
  
  

Onde 1 representa o id de uma pessoa(registro) previamente cadastrado

Resposta da Api


``` json
[{"id":1,"logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":false},
{"id":22,"logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},
{"id":29,"logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false},
{"id":32,"logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true}]
```

- Poder informar qual endereço é o principal


  verbo http: Post
  
  
  http://localhost:8080/api/endereco/update/1
  
  

Onde 1 representa o id de uma pessoa(registro) previamente cadastrado



Resposta da Api



``` json
{
  "id": 1,
  "logradouro": "Praça  Maria do Carmo Campos Paula",
  "cep": "03950005",
  "numero": 625,
  "cidade": "São Paulo",
  "principal": true
}
```


# Testanto a api Com Docker ou Heroku


Caso prefira realizar os teste sem baixar ou sem clonar o repositório



Heroku


https://beckend-attornatus.herokuapp.com/swagger-ui/index.html#/



Banco H2 Remoto 



https://beckend-attornatus.herokuapp.com/h2-ui


Obs: Altere  a JDBC URL  para : jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE



Caso prefira rodar a aplicação localmente pelo docker para teste:


Baixe  e descompacte o repositorio ou clone:

 

1 - Na raiz do projeto onde contém o Dockerfile

```docker
docker build --tag backend .
```

Para verificar se a imagem foi gerado digite:

```docker
docker images
```

2-Para rodar o container 

```docker
docker run -d -p 8080:8080 backend
```


Se tudo correr bem será impresso o id do container no terminal


Depois de alguns segundos digite a seguinte url de teste
(Este procedimento foi realizado na minha maquina local):
http://localhost:8080/api/pessoa


Url banco  : http://localhost:8080/h2-ui


Obs: Altere  a JDBC URL  para : jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE

Url Swagger : http://localhost:8080/swagger-ui/index.html#/



O postaman agora pode ser testado localmente.













