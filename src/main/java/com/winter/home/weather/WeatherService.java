package com.winter.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.winter.home.student.Student;


public class WeatherService {
	
	private WeatherDAO weatherDAO;
	
	
	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}
	
	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;

	}
}
