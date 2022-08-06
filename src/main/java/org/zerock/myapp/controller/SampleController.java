package org.zerock.myapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.SampleDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/sample/")
@Controller
public class SampleController {
	
	
//	@1번
	@RequestMapping("")
	public String basic() {
		log.trace("basic() invoked.");
		
		return "sample";
	}//basic
	
//	@2번
//	@RequestMapping(path="/basicGet",method=RequestMethod.GET)
	@RequestMapping(
			path={"/basicGet1","/basicGet2"},
			method= {RequestMethod.GET, RequestMethod.POST}
			)
	public String basicGet() {
		log.trace("basicGet() invoked.");
		
		return "sample";
	}//basicGet
	
//	@3번
	@RequestMapping(
			path={"/basicGetPost"},
			method= {RequestMethod.GET, RequestMethod.POST}
			)
	public String basicGetPost() {
		log.trace("basicGetPost() invoked.");
		
		return "sample";
	}//basicGetPost
	
//	@4번
	@GetMapping("/basicOnlyGet")
	public String basicOnlyGet() {
		log.trace("basicOnlyGet() invoked.");
		
		return "sample";
	}//basicOnlyGet
//	@5번
	@PostMapping("/basicOnlyPost")
	public String basicOnlyPost() {
		log.trace("basicOnlyPost() invoked.");
		
		return "sample";
	}//basicOnlyPost
	
//	@6번
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.trace("ex01(dto) invoked.");
		
		log.info("\t+ dto:{}",dto);
		
		return "sample";
	}//
	
//	@7번
//	@GetMapping("/ex02")
//	public String ex02(String name, Integer age) {
//		log.trace("ex01(name,age) invoked.");
//		
//		log.info("\t+ name:{}",name);
//		log.info("\t+ age:{}",age);
//		return "sample";
//	}//
	@GetMapping("/ex02")	
	public String ex02(
			@RequestParam("name") String recvName, 
			@RequestParam("age") Integer currentAge) {
		log.trace("ex02(recvName,currentAge) invoked.");
		
		log.info("\t+ recvName:{}",recvName);
		log.info("\t+ currentAge:{}",currentAge);
		return "sample";
	}//
	
//	@8번
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/ex02List")
	public String ex02List(
			@RequestParam("id") List<String> id    //ok
//			List<String> id						   xx
//			ArrayList<String> id				  ok이지만 값이 비어있음
//			Integer[] id                          (Arrays.tosting(id))
			) {
		log.trace("ex02List(id) invoked.");
		
		log.info("\t+ ids:{}",id);
		log.info("\t+ type:{}",id.getClass().getName());
		return "sample";
	}//
	
//	@9번
	@GetMapping("/ex04")
	public String ex04(
//			@DateTimeFormat(iso=ISO.DATE) Date date
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date
			) {
		log.trace("ex04() invoked.");
		
		log.info("\t+ date:{}",date); //date:YYYY-MM-DD
		log.info("\t+ type:{}",date.getClass().getName());

		return "sample";
	}//
	
//	@10번
	@GetMapping("/ex05")
	public String ex05(String name,Integer age,Integer page,Model model) {
		log.trace("ex05() invoked.");
		
		log.info("\t+ name:{},age:{},page:{}", name,age,page);
		log.info("\t+ model:{}", model.getClass().getName());
		
		SampleDTO dto = new SampleDTO();
		dto.setName(name);
		dto.setAge(age);
		
		model.addAttribute("sampleDTO",dto);
		model.addAttribute("page",page);
		
		return "commandObject";
	}//
	
//	@11번
	@PostMapping("/ex06")
//	public String ex05(SampleDTO dto, Integer page) {
//	public String ex05(SampleDTO dto,@ModelAttribute("page") Integer page) {
	public String ex05(
			@ModelAttribute("name") String name,
			@ModelAttribute("age")Integer age, 
			@ModelAttribute("page") Integer page) {

		log.trace("ex06() invoked.");
		
		log.info("\t+ name:{}",name);
		log.info("\t+ age:{}",age);
		log.info("\t+ page:{}",page);
		
		return "commandObject";
	}//
	
//	@12번
	@GetMapping("/ex07")

	public String ex07(
			String name,
			Integer age,
			
			//
			RedirectAttributes rttrs
			){
		log.trace("ex07() invoked.");

		log.info("\t+ 1. rttrs:{},type:{}",rttrs,rttrs.getClass().getName());
		log.info("\t+ 2. name:{},age:{}",name,age);
		
		
//		rttrs.addFlashAttribute("name",name);
//		rttrs.addFlashAttribute("age",age);
		
		rttrs.addAttribute("name",name);
		rttrs.addAttribute("age",age);
		
//		return "redirect:http://localhost:8008/";
//		return "redirect:/sample/main";
		return "forward:/sample/main";
	}//
	
	@GetMapping("/main")
	public String toMain(String name,Integer age) {
		log.trace("toMain() invoked.");
		
		return "main";
	}
	
	
	@GetMapping("/returnVoid")
	public void returnVoid() {
		log.trace("returnVoid() invoked.");
		
		
	}
	
//	@GetMapping("/sample")
//	public String getSample() {
//		log.trace("getSample() invoked.");
//		
//		return "sample";
//	}//getSample
	
}//end class
