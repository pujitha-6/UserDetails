package com.teks;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	private MyService ms;
	
	@PostMapping("/insert")
	public void insertUserCon(@RequestBody User u) {
		if (u.getEmail() == null || u.getEmail().isEmpty()) {
	        throw new IllegalArgumentException("Email cannot be null or empty");
	    }
		ms.insertUser(u);
	}
	@GetMapping("/gets")
	public List<User> getAllCon() {
		return ms.getAll();
	}
	@GetMapping("/get/{id}")
	public Optional<User> getUserByIdCon(@PathVariable Integer id) {
		if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
		return ms.getUserById(id);
	}
	@PutMapping("/update/{id}")
	public User updateCon(@PathVariable Integer id,@RequestBody String name) {
		return ms.update(id, name);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteByIdCon(@PathVariable Integer id) {
		 ms.deleteById(id);
	}

}
