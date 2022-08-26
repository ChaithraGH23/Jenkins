package com.cg.bookadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookadmin.model.model;

public interface UserRepository extends JpaRepository<model, Long> {
	/*@Query("from UserModel where name=:name And password=:password")*/
	public boolean existsByNameAndPassword(String name,String password);

}
