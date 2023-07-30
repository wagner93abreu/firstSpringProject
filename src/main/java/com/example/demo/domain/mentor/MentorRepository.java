package com.example.demo.domain.mentor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long>{
    Page<Mentor> findAllByActiveTrue(Pageable paginacao);
}
