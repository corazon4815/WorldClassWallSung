package uni.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uni.stu.service.LeaveService;

@Controller
public class LeaveController {
	@Autowired
	LeaveService ls;

	@RequestMapping("leaveMain")
	public String score() throws Exception {
		return "leaveMain";
	}

	public void setLs(LeaveService ls) {
		this.ls = ls;
	}
}
