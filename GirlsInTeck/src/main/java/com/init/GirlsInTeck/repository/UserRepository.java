package com.init.GirlsInTeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.GirlsInTeck.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

}
