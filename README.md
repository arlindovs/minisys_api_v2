# Minisys - Aplicação Spring Boot

## Descrição
Este repositório contém o código-fonte de uma aplicação Spring Boot chamada Minisys. A aplicação utiliza diversas dependências gerenciadas pelo Maven e tem como objetivo proporcionar uma estrutura básica para o desenvolvimento de sistemas.

## Dependências

As dependências da aplicação são gerenciadas pelo arquivo `pom.xml`. Abaixo estão listadas as principais dependências utilizadas:

```xml
<dependencies>
    <!-- Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Flyway Database Migration -->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-mysql</artifactId>
    </dependency>

    <!-- Spring Boot DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>com.auth0</groupId>
        <artifactId>java-jwt</artifactId>
        <version>4.4.0</version>
    </dependency>

    <!-- Springdoc OpenAPI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.3.0</version>
    </dependency>
</dependencies>
```

## Documentação Swagger

A documentação da API está disponível através do Swagger. Para acessar, execute a aplicação e utilize o seguinte link: [Swagger UI](http://localhost:8080/swagger-ui/index.html#)

## Build e Execução

O projeto utiliza o plugin Maven do Spring Boot para facilitar o build e a execução. Para construir o projeto, execute o seguinte comando:

```bash
mvn clean install
```

Após a construção, a aplicação pode ser executada usando:

```bash
mvn spring-boot:run
```

Certifique-se de ter o Java JDK 17 instalado em seu sistema.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback sobre a aplicação.

## Licença

Este projeto é distribuído sob a licença [MIT](LICENSE).
