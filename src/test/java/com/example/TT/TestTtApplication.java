package com.example.TT;

import org.springframework.boot.SpringApplication;

public class TestTtApplication {

	public static void main(String[] args) {
		SpringApplication.from(TtApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
