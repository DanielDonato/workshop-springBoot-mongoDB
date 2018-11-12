package com.danieldonato.workshopmongo.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.danieldonato.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
