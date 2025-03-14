package com.teks;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	private MyRepo mr;
	public void insertUser(User u) {
		mr.save(u);
	}
	public List<User> getAll() {
		return mr.findAll();
	}
	public Optional<User> getUserById(Integer id) {
		if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
		return mr.findById(id);
	}
	public User update(Integer id,String name) {
		Optional<User> u=mr.findById(id);
		if(u.isPresent()) {
			User u1=u.get();
			u1.setName(name);
			return mr.save(u1);
		}
		else {
	        throw new NoSuchElementException("Product with ID " + id + " not found");
	    }
	}
	public void deleteById(Integer id) {
		 mr.deleteById(id);
	}
}
