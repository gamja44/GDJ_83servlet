package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
				if(s.isEmpty()) {
					continue;
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
			
//			File file = new File("C:\\study\\Weather.txt");
//			FileWriter fw = new FileWriter(file, true);
//			
//			List<WeatherDTO> ar= this.getWeathers();
//			weatherDTO.setNum(ar.size()+1);
//			
//			String data = weatherDTO.getNum()+","+weatherDTO.getCity()+"-"+ weatherDTO.getGion()+"-"+weatherDTO.getStatus()+"-"+weatherDTO.getHuminity();
//			
//			fw.write(data);
//			fw.close();
			
//			2번째방법
			List<WeatherDTO> ar = this.getWeathers();

			// 도시명-기온-상태-습도
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(ar.size() + 1);
			stringBuffer.append("-");
			stringBuffer.append(weatherDTO.getCity());
			stringBuffer.append("-");
			stringBuffer.append(weatherDTO.getGion());
			stringBuffer.append("-");
			stringBuffer.append(weatherDTO.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(weatherDTO.getHuminity());

			File file = new File("C:\\study\\weather.txt");

			FileWriter fileWriter = new FileWriter(file, true);

			fileWriter.write(stringBuffer.toString() + "\r\n");
			fileWriter.flush();

			fileWriter.close();
		}
			
			//delete
			//list를 불러와서 지우려는 num과 일치하는 것을 리스트에서 삭제
			//list를 파일에 다시 저장
			
			
		public void delete(WeatherDTO weatherDTO) throws Exception {
			List<WeatherDTO> list = this.getWeathers();
			
			for(WeatherDTO dto : list) {
				if(dto.getNum()== weatherDTO.getNum()) {
					list.remove(dto);
					break;
				}
			}
			//list파일에 작성
				File file = new File("C:\\study\\Weather.txt");
				FileWriter fw = new FileWriter(file, false);
				
				//도시명-기온-습도-상태
				StringBuffer stringBuffer = new StringBuffer();
				for(WeatherDTO dto : list) {
					//중복을 피하기위해서 시간을 넣어준다
					Calendar ca = Calendar.getInstance();
					stringBuffer.append(ca.getTimeInMillis());
					stringBuffer.append("-");
					stringBuffer.append(dto.getNum());
					stringBuffer.append("-");
					stringBuffer.append(weatherDTO.getCity());
					stringBuffer.append("-");
					stringBuffer.append(weatherDTO.getGion());
					stringBuffer.append("-");
					stringBuffer.append(weatherDTO.getStatus());
					stringBuffer.append("-");
					stringBuffer.append(weatherDTO.getHuminity());
					stringBuffer.append("\r\n");
				}
				fw.write(stringBuffer.toString()+"\r\n");
				fw.flush();
		}	
			//update
		public void update(WeatherDTO weatherDTO) throws Exception {
			List<WeatherDTO> ar = this.getWeathers();
			//add(object);
			//add(index, object); 삽입
			//set(index, object); 수정
			for(int i=0;i<ar.size();i++) {
				if(weatherDTO.getNum()==ar.get(i).getNum()) {
					ar.get(i).setCity(weatherDTO.getCity());
					ar.set(i, weatherDTO);
				}
			}
			File file = new File("C:\\study\\Weather.txt");
			FileWriter fw = new FileWriter(file, false);
			
			//도시명-기온-습도-상태
			StringBuffer stringBuffer = new StringBuffer();
			for(WeatherDTO dto : ar) {
				//중복을 피하기위해서 시간을 넣어준다
				Calendar ca = Calendar.getInstance();
				stringBuffer.append(ca.getTimeInMillis());
				stringBuffer.append("-");
				stringBuffer.append(dto.getNum());
				stringBuffer.append("-");
				stringBuffer.append(weatherDTO.getCity());
				stringBuffer.append("-");
				stringBuffer.append(weatherDTO.getGion());
				stringBuffer.append("-");
				stringBuffer.append(weatherDTO.getStatus());
				stringBuffer.append("-");
				stringBuffer.append(weatherDTO.getHuminity());
				stringBuffer.append("\r\n");
			}
			fw.write(stringBuffer.toString()+"\r\n");
			fw.flush();
			
		}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
		

