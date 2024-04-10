package com.sigmaoct.testwebapi.repository;

import com.sigmaoct.testwebapi.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
