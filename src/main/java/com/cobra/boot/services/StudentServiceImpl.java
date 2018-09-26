package com.cobra.boot.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobra.boot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRespository;

	@Override
	public List<Map<String, Object>> findStudentAndClass(Integer cid) {
		return studentRespository.findStudentAndClass(cid);
	}
	
}
