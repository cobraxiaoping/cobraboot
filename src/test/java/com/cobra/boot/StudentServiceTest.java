package com.cobra.boot;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.cobra.boot.entity.Student;
import com.cobra.boot.repository.StudentRepository;
import com.cobra.boot.services.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	@Test
	public void findStudentAndClass() {
		List<Map<String,Object>> findStudentAndClass = studentService.findStudentAndClass(4);
		findStudentAndClass.forEach(x->{
			for(String obj:x.keySet()) {
				System.out.println("key:"+obj+" value:"+x.get(obj));
			}
			System.out.println("==============================");
		});
	}
	
	@Test
	public void findall() {
		Student filter = new Student();
		filter.setId(4);
		Pageable pageable = PageRequest.of(0, 10);
		Page<Student> studentList = new StudentRepository.Executor(studentRepository).findAll(filter, pageable);
		List<Student> contents = studentList.getContent();
		contents.forEach((x)->{
			System.out.println(x.toString());
		});
	}
	
	@Test
	public void save() {
		Student filter = new Student();
		filter.setClassid(1);
		filter.setName("xiao");
		filter.setAge("19");
		Student save = studentRepository.save(filter);
	}
	
}
