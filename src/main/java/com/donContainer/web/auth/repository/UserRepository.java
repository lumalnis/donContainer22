package com.donContainer.web.auth.repository;

import com.donContainer.web.auth.entity.Userx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Userx, Long> {

    Userx findByUsername(String username);

    //List<Userx> findBySoftDeletedFalse();
}
