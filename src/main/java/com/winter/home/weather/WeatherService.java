package com.winter.home.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.winter.home.student.StudentDTO;


public class WeatherService {
	
	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}
	
	//list
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
	//detail
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
		}
		return weatherDTO;
	}
	//add
	public void add(WeatherDTO weatherDTO){
		try {
			weatherDAO.add(weatherDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
