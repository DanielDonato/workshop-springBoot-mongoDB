package com.danieldonato.workshopmongo.reposiroty;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.danieldonato.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> seatchTitle(String text); //?0 -> primeiro parametro do metodo
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
