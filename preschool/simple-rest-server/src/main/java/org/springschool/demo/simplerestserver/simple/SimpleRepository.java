package org.springschool.demo.simplerestserver.simple;

        import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository<Simple, Long> {
}
