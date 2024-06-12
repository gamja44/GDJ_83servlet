package com.winter.home.student;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;


public class StudentControllar {
	
	private StudentService studentService;
	
	public StudentControllar() {
		this.studentService = new StudentService();
	}
	public StudentControllar(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	public Action start(HttpServletRequest request) {
	// /student/???
	// list => 학생정보전체출력
	// add => 학생한명정보추가
	// delete =>학생한명삭제
	// detail => 학생한명정보출력
		
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+ 1);
		
		Action action = new Action();
		action.setFlag(true);
		
		String method = request.getMethod();
		
		if(uri.equals("list")) {
			List<Student> ar = studentService.getStudents();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/student/list.jsp");
			
		}else if(uri.equals("add")) {
			if(method.toUpperCase().equals("POST")) {
				Student student = new Student();
				 String name = request.getParameter("name");
				 System.out.println(name);
				 student.setName(name);
				 student.setNum(Integer.parseInt(request.getParameter("num")));
				 student.setAvg(Double.parseDouble(request.getParameter("avg")));
				 
				 System.out.println(request.getParameter("ch"));
				 System.out.println(request.getParameter("mobile"));
				 
				 String[] ch2 = request.getParameterValues("ch2");
				 
				 for(String s:ch2) {
					 System.out.println(s);
				 }
				 
				 action.setFlag(false);
				 action.setPath("./list");
			}else {
				action.setPath("/WEB-INF/views/student/add.jsp");
			}
		}else if(uri.equals("delete")) {
			
			
		}else if(uri.equals("detail")) {
			Student student = this.studentService.makeStudent();
			request.setAttribute("s", student);
			action.setPath("/WEB-INF/views/student/detail.jsp");
		}
		return action;
	}
}
