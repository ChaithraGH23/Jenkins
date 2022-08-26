package com.cg.bookadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.bookadmin.model.Credentials;
import com.cg.bookadmin.model.model;
import com.cgbookadmin.service.UserService;

public class UserController {
	


	
		@Autowired 
		private UserService userService;

		/*---Add new user---*/
		@PostMapping("/user")
		public ResponseEntity<?> save(@RequestBody model user) {
			userService.save(user);
			return ResponseEntity.ok().body("New User has been saved ");
		}

		/*---Get a user by id---*/
		@GetMapping("/user/{id}")
		public ResponseEntity<model> get(@PathVariable("id") long id) {
			model user = userService.get(id);
			return ResponseEntity.ok().body(user);
		}

		/*---get all users---*/
		@GetMapping("/user")
		public ResponseEntity<List<model>> list() {
		    List<model> user = userService.list();
		    return ResponseEntity.ok().body(user);
		}

		/*---Update a user by id---*/
		@PutMapping("/user/{id}")
		public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody model user) {
		     userService.update(id, user);
		     return ResponseEntity.ok().body("User has been updated successfully.");
		}

		/*---Delete a user by id---*/
		@DeleteMapping("/user/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") long id) {
			 userService.delete(id);
		     return ResponseEntity.ok().body("User has been deleted successfully.");
		}
		/*---Get a user by id---*/
		@PostMapping("/login")
		public ResponseEntity <?> get(@RequestBody Credentials cred) {
			boolean log = userService.existsByNameAndPassword(cred.getName(), cred.getPassword());
			if(log!=true) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
			}
			else{
				return ResponseEntity.ok().body(true);
			}
		}

	}

