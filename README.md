## Edge-Service

### Intro
The edge service is a Microservice able to authenticate the user by using [okta](https://www.okta.com/)

### Architecture
* The edge is the entry point of the system. The user send the request to the edge.
* The edge ask to the user to authenticate by using okta. After verify the identity,
it authenticate to the core microservice [301javamicro](https://github.com/mancio/301JavaMicro_part2)
* [MyEurekaService](https://github.com/mancio/MyEurekaService) is the service discovery able to track the status of both the services.

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


### Links
* [How to build microservices](https://developer.okta.com/blog/2017/06/15/build-microservices-architecture-spring-boot)
* [How to implement social auth with okta](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth)

 

