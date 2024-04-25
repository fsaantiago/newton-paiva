package com.ibge.av1arq.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IbgeService {

        private final String BASE_URL = "https://servicodados.ibge.gov.br/api/v3/noticias";
        private final RestTemplate restTemplate = new RestTemplate();

        public String getNoticiasEReleases() {
            return restTemplate.getForObject(BASE_URL, String.class);
        }

        public String getNoticias() {
            return restTemplate.getForObject(BASE_URL + "/?tipo=noticia", String.class);
        }

        public String getReleases() {
            return restTemplate.getForObject(BASE_URL + "/?tipo=release", String.class);
        }

        public String postNoticias() {
            return restTemplate.postForObject(BASE_URL, "/?tipo=noticia/add", String.class);
        }

        public String postReleases() {
            return restTemplate.postForObject(BASE_URL + "/?tipo=release/add", null, String.class);
        }
}
