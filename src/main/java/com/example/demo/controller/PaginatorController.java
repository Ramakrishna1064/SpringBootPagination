package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.PaginatorRepository;
import com.example.demo.service.PaginatorService;

@RestController
public class PaginatorController {
	
	@Autowired
	PaginatorService paginatorService;
	@Autowired
	PaginatorRepository paginatorRepository;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getListOfUsers", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Page<StudentDTO> getListOfUsers(@RequestBody StudentDTO studentDTO) {
		System.out.println("emplooyee id--->"+studentDTO.getName());
		Page<StudentDTO>studentList = paginatorRepository.findAll(new PageRequest(0, 3));
		return studentList;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getListOfUsersByName", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<StudentDTO> getListOfUsersByName(@RequestBody StudentDTO studentDTO) {
		System.out.println("emplooyee id--->"+studentDTO.getName());
		List<StudentDTO>studentList = paginatorService.findByName(studentDTO.getName(), new PageRequest(1, 3));
		return studentList;
	}
}
