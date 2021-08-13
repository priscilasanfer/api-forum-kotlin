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


