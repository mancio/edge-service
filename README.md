## Edge-Service

### Intro
The edge service is a Microservice able to authenticate the user by using [okta](https://www.okta.com/)

### Architecture
* The edge is the entry point of the system. The user send the request to the edge.
* The edge ask to the user to authenticate by using okta. After verify the identity,
it authenticate to the core microservice [301javamicro](https://github.com/mancio/301JavaMicro_part2)
* [MyEurekaService](https://github.com/mancio/MyEurekaService) is the service discovery able to track the status of both the services.

### Endpoints
GET
```http://localhost:8080/employees/``` get all the employees
```http://localhost:8080/employees/{id}``` get the employee with id = {id} 
(employees 0 and 1 for testing already in the database)

POST
```http://localhost:8081/employees``` post a new employee

POST BODY

    {
        "employee_name": "Bill",
        "employee_last_name": "Spencer",
        "employee_address": "st. avenue 7 77-000 Chicago USA",
        "employee_phone": "+48788798908",
        "job_position": "java dev",
        "salary": 2500,
        "currency": "EUR"
    }

DELETE
```http://localhost:8080/employees/{id}``` delete the employee with id = {id} 

### Swagger UI
To test the endpoints Swagger is much better than Postman because
Okta do not show the authentication webpage if the request is sent by
Postman.

To access Swagger web interface go to 
[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

### Jar executable file
You can build a full working .jar by using the ```packege``` comand of maven.
This jar include all the springboot classes and tomcat. It is ready to use.
Just execute ```java -jar {filename}```


### Docker
The Dockerfile in the main directory can be executed to build a container
that run the microservice.

To see all the containers installed locally type
```docker ps -a```

To build the container go in the Dockerfile directory and type 
```docker build -t ImageName:TagName dockerfile_dir```
example ```docker build -t edge:0.1 .```

to execute a container in local type ```docker run -p 8081:8081 ImageName:TagName```
example ```docker run -p 8081:8081 edge:0.1```

### Github configuration
To enable GitHub log in you need to go to [settings](https://github.com/settings/developers)
in your account and create a new OAuth Apps.

Set as URI ```http://localhost:8081``` and as redirect ```http://localhost:8081/login/oauth2/code/github```




### Links
* [How to build microservices](https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot)
* [How to implement social auth with okta](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth)
* [How to implement social auth with okta](https://spring.io/guides/tutorials/spring-boot-oauth2/)

 

