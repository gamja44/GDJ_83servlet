package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class WeatherDAO{
	// DTO : Data Transfer Object
		// DAO : Data Access Object

		// getWeathers
		// 파일에 날씨정보들을 읽어와서 파싱 한 후에 DTO에 담아서 리턴

		//
		public List<WeatherDTO> getWeathers() throws Exception {
			File file = new File("C:\\study\\Weather.txt");

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				WeatherDTO weatherDTO = new WeatherDTO();
				s = s.replace(",", "-");
				s = s.replace(".", "-");
				String[] ar = s.split("-");
				weatherDTO.setNum(Long.parseLong(ar[0].trim()));
				weatherDTO.setCity(ar[1].trim());
				weatherDTO.setGion(Double.parseDouble(ar[2].trim()));
				weatherDTO.setHuminity(Integer.parseInt(ar[3].trim()));
				weatherDTO.setStatus(ar[4].trim());
				list.add(weatherDTO);
			}

			br.close();
			fr.close();

			return list;
		}
		
		//detail
		public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
			List<WeatherDTO> ar = this.getWeathers();
			
			WeatherDTO result = null;
			
			for(WeatherDTO w : ar) {
				if(w.getNum()==weatherDTO.getNum()) {
					result=w;
					break;
				}
			}
		return result;	
		}
		//add
		Scanner sc = new Scanner(System.in);
		public void add(WeatherDTO weatherDTO) throws Exception {
			//도시명-기온-상태-습도
			
			File file = new File("C:\\study\\Weather.txt");
			FileWriter fw = new FileWriter(file);
			
			List<WeatherDTO> ar= this.getWeathers();
			weatherDTO.setNum(ar.size()+1);
			
			String data = weatherDTO.getNum()+","+weatherDTO.getCity()+"-"+ weatherDTO.getGion()
			+"-"+weatherDTO.getStatus()+"-"+weatherDTO.getHuminity();
			
			fw.write(data);
			fw.close();
			
//			StringBuffer sb = new StringBuffer();
//			sb.append(ar.size()+1);
//			sb.append("-");
//			sb.append(weatherDTO.getCity());
//			sb.append("-");
//			sb.append(weatherDTO.getGion());
//			sb.append("-");
//			sb.append(weatherDTO.getHuminity());
//			sb.append("-");
//			sb.append(weatherDTO.getStatus());
			
			
		}
		
		
}