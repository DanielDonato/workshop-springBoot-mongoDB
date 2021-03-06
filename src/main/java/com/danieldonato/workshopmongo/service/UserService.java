package com.danieldonato.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldonato.workshopmongo.domain.User;
import com.danieldonato.workshopmongo.dto.UserDTO;
import com.danieldonato.workshopmongo.reposiroty.UserRepository;
import com.danieldonato.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(String id) {
		this.findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = this.findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
