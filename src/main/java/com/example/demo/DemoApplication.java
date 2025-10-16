package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


//spring-role-login/
//        ├── src/main/java/com/example/demo/
//        │    ├── controller/
//        │    │     ├── AuthController.java
// │    │     └── UserController.java
// │    ├── entity/User.java
// │    ├── repository/UserRepository.java
// │    ├── service/UserService.java
// │    ├── security/
//        │    │     ├── JwtAuthFilter.java
// │    │     ├── JwtUtil.java
// │    │     └── SecurityConfig.java
// │    └── DemoApplication.java
// ├── pom.xml
// └── application.yml
