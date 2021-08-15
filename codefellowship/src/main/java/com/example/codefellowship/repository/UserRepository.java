package com.example.codefellowship.repository;

import com.example.codefellowship.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser,Integer> {
}
