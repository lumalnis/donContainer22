package com.donContainer.web.repository;

import com.donContainer.web.model.Proyect;
import com.donContainer.web.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlideRepository extends JpaRepository<Slide, Long> {

    List<Slide> findAllByProyectId(Proyect proyect);

    @Query(value = "SELECT max(s.order) FROM Slide s")
    int getMaxOrder();

    boolean existsByOrder(int order);
}
