package org.zerock.myapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/return/*")
@Controller
public class ReturnTypesController {

	@GetMapping("/String")
	public String returnString() {
		log.trace("returnString() invoked.");
		
		return "return/String";  //   /WEB-INF/views/  + retrun/string + .jsp
	}//returnString
	
	
	@GetMapping("/void")
	public void returnVoid() {    // /WEB-INF/views/  + retrun/void + .jsp
		log.trace("returnVoid() invoked.");
		
	}//
	
	
	@PostMapping("/redirect")
	public String returnRedirect() {    
		log.trace("returnRedirect() invoked.");
		
		return "redirect:/return/void";
//		return "redirect:void";
//		return "redirect:http://naver.com";
	}//
	
	
	@GetMapping("/forward")
	public String returnforward() {    
		log.trace("returnforward() invoked.");
		
//		return "forward:/WEB-INF/views/return/void.jsp";
		
//		return "forward:/return/void";
//		return "forward:void";
		return "forward:http://naver.com";
	}//
	
	@PostMapping("/ResponseBody")
//	@PostMapping(path="/ResponseBody",produces= {"text/plain; charset=utf8"})
	@ResponseBody	//아래의 메소드가 리턴값을 응답메시지의 Body(=Payload)에 넣어달라
//	public String returnResponseBody(
//	public List<String> returnResponseBody(
	public Person returnResponseBody(
			@NonNull	//이 매개변수의 값은 null이 되어서는 안된다
			@RequestParam("name") String NAME,
			
			@NonNull	//이 매개변수의 값은 null이 되어서는 안된다
			@RequestParam("age") Integer AGE
			) {    
		log.trace("returnResponseBody({},{}) invoked.",NAME,AGE);
		//1.DTO객체를 응답으로 전송  xml pr json
//		SampleDTO dto = new SampleDTO();
//		dto.setName(NAME);
//		dto.setAge(AGE);
		
//		log.info("\t+ dot:{}",dto);
		
		//2.문자열
//		String string="안녕하세요";
//		ServletOutputStream sos = response.getOutputStream();
		//자바객체를 반환하면 응답메시지의 바디에 넣기 전에, 변환 라이브러리를 이용해서,
		//JSON or XML 문서로 변환해서 넣어줍니다
//		return string;
		
		//3.컬렉션 데이터
//		List<String> list = new ArrayList<>();
//		list.add("NAME_1");
//		list.add("NAME_2");
//		list.add("NAME_3");
//		return list;
		//4. 사용자 정의
		return new Person("Yoseph",23);
	}//returnResponseBody
	
	//4. 사용자 정의
		@AllArgsConstructor
		@Data
		class Person{
			private String name;
			private int age;
				
		}//Person
			
		
	//5.ResponseEntity
	@PostMapping("/ResponseEntity")
	public ResponseEntity<Person> returnResponseEntity(){
		log.trace("ResponseEntity() invoked.");
		
//		String json = "{'name':'Yoseph','age':'23'}";
		Person person = new Person("Yoseph",23);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf8");
		
		return new ResponseEntity<>(person,headers,HttpStatus.OK);
	}
		
		
		
		
}//end class
