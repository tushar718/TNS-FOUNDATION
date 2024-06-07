package com.cg.mm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository extends JpaRepository<Mall, Long> {
    // Optionally, you can define more complex queries here using Spring Data JPA's method name conventions
}
