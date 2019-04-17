package com.example.demo.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.StudentDTO;

public interface PaginatorRepository extends JpaRepository<StudentDTO, Integer> {
	List<StudentDTO> findByName(String name, Pageable pageable);
}
