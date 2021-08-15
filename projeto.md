## 01. Do server-side para o REST

Quais das seguintes alternativas representam vantagens de se utilizar APIs REST?
 - Possibilidade de paralelizar o desenvolvimento da aplicação. 
   É possível “dividir” o time de desenvolvimento em back-end e front-end, com a possibilidade deles trabalharem na construção da aplicação de maneira paralela.
   
- Maior facilidade no reaproveitamento do código.
  As funcionalidades de uma API podem ser reaproveitadas em aplicações cliente, como por exemplo um app mobile.

Resumo:
- Que utilizamos APIs REST para construir aplicações backend desacopladas do frontend;
- Como criar um projeto Kotlin com Spring Boot utilizando o site do Spring Initializr;
- A importar um projeto na IDE IntelliJ;
- Como fazer um Hello World utilizando uma classe Controller com as anotações @Controller e @RequestMapping.

## 02. Lidando com requisições GET

Conceitos Rest:
As classes de domínio da aplicação geralmente representam as informações que serão gerenciadas pela API. 
Qual conceito do REST está relacionado com isso?
- Recursos
  No REST, o conceito de recursos se refere exatamente às informações que serão gerenciadas pela API.

Formato JSON:
Onde é feita a configuração para que o Spring retorne a representação dos recursos no formato JSON?
- Não é necessário realizar tal configuração.
  Por padrão, o Spring considera que o retorno deve ser serializado no formato JSON.
  
Resumo:
- A criar classes de domínio que representam os recursos da API;
- A trabalhar com requisições GET na API utilizando a anotação @GetMapping;
- A criar uma camada Service na API para isolar as regras de negócio;
- Como receber um parâmetro pela URI utilizando a anotação @PathVariable.


## 03. Lidando com requisições POST

Anotação @RequestBody
Por que foi necessário utilizar a anotação @RequestBody no método para cadastrar um novo tópico?
- Para que o Spring consiga recuperar as informações no corpo da requisição.
  Sem essa anotação o Spring considera que os parâmetros serão enviados pela URI da requisição HTTP.

Vantagens de se utilizar DTOs
Qual a vantagem de se utilizar DTOs para receber parâmetros na API?
- Flexibilizar a representação dos recursos recebidos e enviados pela API.
  DTOs permitem que a representação dos recursos possa ser flexibilizada, pois a API pode ter diversos endpoints que manipulam um determinado recurso, porém representando-o de formas distintas.

Resumo:
- Como trabalhar com requisições POST na API com as anotações @PostMapping e @RequestBody;
- Como testar a API utilizando a ferramenta Postman para disparar requisições HTTP;
- A criar classes DTO para representar os dados da API;
- A criar classes Mapper para a conversão de objetos DTO;
- Como realizar validações utilizando o Bean Validation com as anotações @Valid, @NotEmpty e @Size.

## 04. Lidando com requisições PUT e DELETE
Na API, temos vários pontos de conflitos de URI, ou seja, vários métodos em classes controllers possuem a mesma URI. 
Por que o Spring não identificou isso como um problema e lançou uma exceção ao inicializar a API?
- URIs podem ser repetidas na API, desde que os métodos HTTP sejam distintos.
  Na API temos a mesma URI mapeada em vários métodos, mas cada método possui um verbo HTTP distinto.
  

