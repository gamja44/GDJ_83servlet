package com.winter.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.winter.home.weather.WeatherDTO;

public class StudentDAO {
	
	//list
	public List<StudentDTO> getStudents() throws IOException{
		
		File file = new File("C:\\study\\student.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		while(true) {
			String s= br.readLine();
			if(s == null) {
				break;
			}
			StudentDTO studentDTO = new StudentDTO();
			String[] ar = s.split("-");
			studentDTO.setNum(Integer.parseInt(ar[0]));
			studentDTO.setName(ar[1]);
			studentDTO.setKor(Integer.parseInt(ar[2]));
			studentDTO.setEng(Integer.parseInt(ar[3]));
			studentDTO.setMath(Integer.parseInt(ar[4]));
			studentDTO.setTotal(Integer.parseInt(ar[5]));
			studentDTO.setAvg(Double.parseDouble(ar[6]));
			list.add(studentDTO);
		}
		return list;
	}
	
	//detail
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents();
		
		StudentDTO result = null;
		
		for(StudentDTO s : ar) {
			if(s.getNum()==studentDTO.getNum()) {
				result=s;
				break;
			}
		}
		return result;
	}
	
}
