package com.cgbookadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookadmin.model.model;
import com.cg.bookadmin.repository.UserRepository;

@Service
public abstract class UserServiceImpl implements UserService {
	 @Autowired (required=true)
	 private UserRepository userRepository	;

	 @Override
	 public long save(model user) {
		 return userRepository.save(user).getUserId();
	 }

	 @Override
	 public model get1(long id) {
		 return userRepository.findById(id).get();
	 }

	 @Override
	 public List<model> list() {
		 return userRepository.findAll();
	 }

	 @Transactional
	 @Override
	 public model update1(long id, model user) {
		 return userRepository.save(user);
	 }

	 @Transactional
	 @Override
	 public void delete(long id) {
		 userRepository.deleteById(id);
	 }
	 
	 @Override
	 public boolean existsByNameAndPassword(String name , String password) {
		 return userRepository.existsByNameAndPassword(name,password);
		
	 }

	

	@Override
	public model get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public model update(long id, model user) {
		// TODO Auto-generated method stub
		return null;
	}

}

