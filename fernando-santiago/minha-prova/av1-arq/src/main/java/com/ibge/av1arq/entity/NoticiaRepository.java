package com.ibge.av1arq.entity;

import com.ibge.av1arq.entity.Noticia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticiaRepository extends MongoRepository<Noticia, String>{
}
