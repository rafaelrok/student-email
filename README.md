<img src="https://i.ibb.co/cQQjzYT/Sending-Emails-with-Spring-cover.png" />

# Enviando e-mails personalizados com Spring Java Mail Sender e Thymeleaf Template Engine

Nesse projeto foi abordado:
- Enviar e-mails utilizando o Java Mail Sender
- Configurar o Gmail na aplicação
- Enviar um email com uma simples mensagem de texto
- Enviar um email com um template personalizado e dinâmico

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [H2 Database](https://www.h2database.com/html/quickstart.html)
- [Thymeleaf Template Engine](https://www.thymeleaf.org/documentation.html)

## Configuração do e-mail

````
    spring.mail.default-encoding=UTF-8
    spring.mail.host=smtp.gmail.com
    spring.mail.username=your_email@gmail.com
    spring.mail.password=your_password
    spring.mail.port=587
    spring.mail.protocol=smtp
    spring.mail.test-connection=false
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
````

### Importante: É preciso ativar em seu Gmail o "Acesso a app menos seguro"

![Segurança Gmail](https://i.ibb.co/c811CwK/gmail.png)

## Links úteis

- [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.5&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=mailsender&name=spring-mail-sender-thymeleaf&description=Demo%20project%20for%20Java%20Mail%20Sender%20and%20Thymeleaf%20template%20engine&packageName=com.example.mailsender&dependencies=web,devtools,data-jpa,h2,lombok,mail,thymeleaf,validation)
- [Spring Mail Doc](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mail.html)

## Ambiente, recursos e requisitos necessários

- Java 11+
- Postman/Insomnia
- Familiaridade com HTML e CSS

## Developer

| [<img src="https://avatars.githubusercontent.com/u/8467131?v=4" width="75px;"/>](https://github.com/rafaelrok) |
| :-: |
|[Rafael Vieira](https://github.com/rafaelrok)|
