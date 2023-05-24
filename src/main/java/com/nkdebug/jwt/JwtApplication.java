package com.nkdebug.jwt;

import com.nkdebug.jwt.entity.User;
import com.nkdebug.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
	 	List<User> users = Stream.of(
				 new User(101,"nkdebug","nkdebug","nkdebug@gmail.com"),
				new User(102,"rkdebug","rkdebug","rkdebug@gmail.com"),
				new User(103,"dkdebug","dkdebug","dkdebug@gmail.com"),
				new User(104,"ckdebug","ckdebug","ckdebug@gmail.com")
		).collect(Collectors.toList());
		 repository.saveAll(users);
	}






	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
