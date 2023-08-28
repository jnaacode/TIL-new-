package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenAPIController {

	// 발급 받은 인증키 변수 처리
	public static final String SERVICEKEY = "YJjCL4Rla2nG3z5KHzMBU6fT9ah%2BwAk%2BMCSSotsMaPziDNy2zv4vf%2FnZerx9%2FAKVSTbEtcgQNSoeyDB2l0lF0Q%3D%3D";
	
	// json 형식으로 대기오염 OpenAPI 활용하기
	//@RequestMapping(value ="air", produces = "application/json; charset=UTF-8") -> Json이용!
	
	@ResponseBody
	public String airMethod(String location) throws IOException{

		// OpenAPI 서버로 요청하고자 하는 url 작성
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"; //
		url += "?serviceKey=" + SERVICEKEY; // 서비키 추가 
		url += "&sidoName=" + URLEncoder.encode(location , "UTF-8"); // 지역명 추가(한글이 들어가면 인코딩 처리해야함)
		url += "&returnType=json"; // 리턴 타입
		url += "&numOfRows="+2; 
		
		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청 시 필요한 Header 설정 
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 후 입력 스트림을 통해서 응답데이터 읽어오기 
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	
		String responseText="";
		String line;
		while((line= br.readLine())!=null){
			responseText+= line;
		}
		
		//5. 다사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
		

		return responseText;

	}
	
	// xml 형식으로 대기오염 OpenAPI 활용
	@RequestMapping(value ="air", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String airPollution(String location) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"; 
		url += "?serviceKey="+ SERVICEKEY;
		url += "&sidoName="+URLEncoder.encode(location,"UTF-8");
		url += "&returnType=xml";
		
		URL requestUrl = new URL(url);
		
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText="";
		String line; 
		while((line = br.readLine())!=null) {
			responseText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
		System.out.println(responseText);
		
		return responseText;
	}
	
	// xml 형식으로 지진해일 대피소 openApi 활용하기
	
	@ResponseBody
	@RequestMapping(value ="sea", produces = "text/xml; charset=UTF-8" )
	public String shelterList() throws IOException {
		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?ServiceKey="+SERVICEKEY;
		url += "&pageNo=1";
		url += "&numOfRows=20";
		url += "&type=xml";
		
		URL requestUrl = new URL(url);
		
		System.out.println(requestUrl);
		
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText ="";
		String line;
		
		while((line = br.readLine())!=null) {
			responseText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
		
		System.out.println(responseText);
		return responseText;
		
		
		
	}
	
	
}
