package com.example.todo.TODO.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
/*	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and().csrf().disable();
		return http.build();
		}
 */


}

