package uni.stu.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import uni.stu.model.SubjectDto;
import uni.stu.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	SubjectService ss;

	@RequestMapping("scoreMain")
	public String score() throws Exception {
		return "scoreMain";
	}
	
	@RequestMapping(value = "years", method = RequestMethod.POST)
	public void yearsList(HttpServletResponse resp) throws Exception {
		List<SubjectDto> list = ss.yearScore();
		Gson json = new Gson(); 
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}
	
	@RequestMapping(value = "sem", method = RequestMethod.POST)
	public void semList(HttpServletResponse resp) throws Exception {
		List<SubjectDto> list = ss.semScore();
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = resp.getWriter();		
		out.print(json.toJson(list));
	}
	
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String scoreList(int years, int sem) throws Exception {
		List<SubjectDto> list = ss.listScore(years, sem);
		Gson json = new Gson(); 
		System.out.println(json.toJson(list));
		return json.toJson(list);
	}
	
	public void setSs(SubjectService ss) {
		this.ss = ss;
	}
}
