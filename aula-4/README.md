# Primeira aula

## Grade

1. Bancos de dados
   - JPA
   - Realizando Query
   - Repository
   - Repository vs RestController



## Docker
Criar containers com os bancos de dados (MySQL) :

```
docker-compose up --build
```

Criar o container de apenas um dos serviços:
```
docker-compose up <nome do serviço>

exemplo:
docker-compose up mysqldb
docker-compose up mongodb
  ```
Outros comandos úteis do Docker :
```
docker container ls                                # Lista todos os containers rodando
docker container ls -a                             # Lista todos os containers, mesmo o que não estão rodando
docker container stop <hash>                       # Para a execução do container
docker container rm <hash>                         # Remove o container da máquina
docker container rm $(docker container ls -a -q)   # Remove todos os containers
docker image ls -a                                 # Lista todas as imagens da máquina
docker image rm <image id>                         # Remove uma imagem da máquina
docker image rm $(docker image ls -a -q)           # Remove todas as imagens da máquina
```


Referências:

* [Getting Started With Spring Boot and Microservices](https://dzone.com/refcardz/getting-started-with-spring-boot-and-microservices?chapter=1)
* [Injeção de dependências com Spring](https://blog.algaworks.com/injecao-de-dependencias-com-spring/)
* [Spring MVC Caelum](https://www.caelum.com.br/apostila-java-web/spring-mvc/)
* [Spring Boot](https://www.casadocodigo.com.br/products/livro-spring-boot)
* [Spring MVC](https://www.casadocodigo.com.br/products/livro-spring-mvc)
* [Vire o jogo com Spring Framework](https://www.casadocodigo.com.br/products/livro-spring-framework)
* [10 Best Practices for Better RESTful API](https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/)
* [RESTful API Designing guidelines — The best practices](https://hackernoon.com/restful-api-designing-guidelines-the-best-practices-60e1d954e7c9)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [The Spring @Controller and @RestController Annotations](https://www.baeldung.com/spring-controller-vs-restcontroller)
* [Bancos de Dados Relacionais](https://www.devmedia.com.br/bancos-de-dados-relacionais/20401)
* [Bancos de dados e JDBC](https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#a-conexo-em-java)

