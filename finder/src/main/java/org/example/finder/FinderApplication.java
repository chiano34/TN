package org.example.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class FinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}
	@GetMapping("/instruments")
	public String findNeed(@RequestParam String name) {
		return "Результат"+name;
	}

}
