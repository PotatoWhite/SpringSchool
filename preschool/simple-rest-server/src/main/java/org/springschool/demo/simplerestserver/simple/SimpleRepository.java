package org.springschool.demo.simplerestserver.simple;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SimpleRepository extends JpaRepository<Simple, Long> {
    Page<Simple> findAll(Pageable pageable);
}
