package com.greedycodes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greedycodes.exception.ResourceNotFoundException;
import com.greedycodes.model.Student;
import com.greedycodes.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentRepository stuRepo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return stuRepo.findAll();		
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") int id) throws ResourceNotFoundException {
		Student stu = stuRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found"));
		return ResponseEntity.ok().body(stu);
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student stu) {
		return stuRepo.save(stu);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") int id, @Valid @RequestBody Student stuDetail) throws ResourceNotFoundException {
		Student stu = stuRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found"));
		stu.setName(stuDetail.getName());
		stu.setScore(stuDetail.getScore());
		final Student updatedStu = stuRepo.save(stu);
		return ResponseEntity.ok(updatedStu);
		
	}
	
	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value="id") int id) throws ResourceNotFoundException {
		Student stu = stuRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found"));
		stuRepo.delete(stu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
