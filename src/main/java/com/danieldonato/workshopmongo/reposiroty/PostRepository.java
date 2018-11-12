package com.danieldonato.workshopmongo.reposiroty;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.danieldonato.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> seatchTitle(String text); //?0 -> primeiro parametro do metodo
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
