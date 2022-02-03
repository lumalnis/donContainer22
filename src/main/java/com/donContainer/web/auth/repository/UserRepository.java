package com.donContainer.web.auth.repository;

import com.donContainer.web.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //List<User> findBySoftDeletedFalse();
}
