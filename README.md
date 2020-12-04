# rest-spring-boot
1> restdemo :=Rest Spring Boot with H2 Database. App implementing REST API for Books.
2> Junit 5 used for testing spring boot service class
3> Testing steps:
Run Test Application (RestdemoApplicationTests). All test cases should be passed

4> Rest-client-demo := Spring Boot Client App consuming Rest API.
5> Junit 5 used for testing.
6> Testing steps:
Run Spring Application(RestdemoApplication)
Goto http://localhost:8080/h2-console
Insert in JDBC URL:
jdbc:h2:mem:book_data
user name: admin
Click Connect button
Run SQL Queries:
insert into book values(4, 'Saeed', 'Java', 350) ;
insert into book values(1, 'Shakir', 'Spring', 550) ;
Run Client Test Application (RestClientDemoApplicationTests). All test cases should be passed
