package com.winter.home.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.winter.home.weather.WeatherDTO;

public class StudentService {
	
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	//list
	public List<StudentDTO> getStudents() {
		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getStudents();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	//detail
	public StudentDTO getDetail(StudentDTO studentDTO) {
		
		try {
			StudentDTO studnetDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		return studentDTO;
	}
//	public List<StudentDTO> getStudents() {
//		ArrayList<StudentDTO> ar = null;
//		ar = studentDAO.getStudents();
//		
//		 return ar;
//	}
	public StudentDTO makeStudent() {
		StudentDTO student = new StudentDTO();
		student.setNum(1);
		student.setName("winter");
		student.setAvg(56.32);
			
		return student;
	}
	
}
