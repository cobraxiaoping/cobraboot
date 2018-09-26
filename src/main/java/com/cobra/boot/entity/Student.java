package com.cobra.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name = "table_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "seq")
	@TableGenerator(name = "seq", allocationSize = 1, table = "table_id_generator", pkColumnName = "table_name", valueColumnName = "table_id")
	private Integer id;
	private String name;
	private String age;
	private Integer classid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", classid=" + classid + "]";
	}
	
	
}
