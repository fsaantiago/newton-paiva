package com.ibge.av1arq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class IBGEApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IBGEApiApplication.class, args);
	}

	private final String BASE_URL = "https://servicodados.ibge.gov.br/api/v3/noticias";
	private final RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/noticiasereleases")
	public String getNoticiasEReleases() {
		return restTemplate.getForObject(BASE_URL, String.class);
	}

	@GetMapping("/noticias")
	public String getNoticias() {
		return restTemplate.getForObject(BASE_URL + "/?tipo=noticia", String.class);
	}

	@GetMapping("/releases")
	public String getReleases() {
		return restTemplate.getForObject(BASE_URL + "/?tipo=release", String.class);
	}
}
