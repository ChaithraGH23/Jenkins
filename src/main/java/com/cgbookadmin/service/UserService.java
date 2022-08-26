package com.cgbookadmin.service;

import java.util.List;

import com.cg.bookadmin.model.model;

public interface UserService {
	public long save(model user);
	public model get(long id);
	public List<model> list();
	public model update(long id, model user);
	public void delete(long id);
	public boolean  existsByNameAndPassword(String name,String password);
	long save1(model user);
	model get1(long id);
	model update1(long id, model user);
}
