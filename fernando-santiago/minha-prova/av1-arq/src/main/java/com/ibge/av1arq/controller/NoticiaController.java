package com.ibge.av1arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

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

    @PostMapping("/noticias/add")
    public String postNoticias() {
        return restTemplate.postForObject(BASE_URL + "/?tipo=noticia/add", String.class);
    }

    @PostMapping("/releases/add")
    public String postReleases() {
        return restTemplate.postForObject(BASE_URL + "/?tipo=release", String.class);
    }
}
