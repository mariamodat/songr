# songr

# OverView
this project is to create a new application with artifact songr with Web and Thymeleaf (and optionally Devtools) dependencies. 
you can check the albums with a given route .

# Installation 
* open your terminal

* Clone the repo
* https://github.com/mariamodat/songr.git

# Architecture
# UML diagram

![img](ff.png)

# Application Properties Set-up:
On your application.properties, make sure postgres is set up on with your individual user environment variables

spring.datasource.url=jdbc:postgresql://localhost:5432/songr
spring.datasource.username=${postgresUsername}
spring.datasource.password=${postgresPassword}
#spring.jpa.hibernate.ddl-auto=create //<-- uncomment on first run of application to create table once
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true        
On your browser, the root port is 8080. -- this should output a 'Hello World' on your browser display.

http://localhost:8080

Other routes to check out:

http://localhost:8080/hello/{a string}

http://localhost:8080/capitalize/{a string}

http://localhost:8080/reverse?sentence={a string}

http://localhost:8080/albums

http://localhost:8080/albums/add
