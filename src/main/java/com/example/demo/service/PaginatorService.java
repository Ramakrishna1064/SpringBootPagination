package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.PaginatorRepository;

@Service
public class PaginatorService {

	@Autowired
	PaginatorRepository paginatorRepository;
	
	public List<StudentDTO>findByName(String name,PageRequest pageable){
		return paginatorRepository.findByName(name, pageable);
	}
}
