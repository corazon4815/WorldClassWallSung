package uni.sta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uni.sta.model.StuDto;
import uni.sta.service.LoginStuService;

@Controller
public class LoginStuController {

	LoginStuService lss;

	@Autowired
	public void setLss(LoginStuService lss) {
		this.lss = lss;
	}

	// �α��� ���� ���� �κ�
	@RequestMapping(value = "loginstu.do")
	public String loginForm() throws Exception {
		return "loginformstu";
	}

	 //�α��� ó���ϴ� �κ�
	  
	 @RequestMapping(value="loginCheck",method=RequestMethod.POST) 
	 public String LoginStuDao(HttpSession session,StuDto dto){ 
		 String returnURL = "mainstu"; 
		 if( session.getAttribute("login") != null ){ // ������ login�̶� ���� ���� �����Ѵٸ�
			 session.removeAttribute("login"); // �������� ������ �ش�. }
		 }
			 // �α����� �����ϸ� UsersVO ��ü�� ��ȯ��. 
	 StuDto dto1 = lss.LoginStu(dto);
	 
	 if ( dto1 != null ){ // �α��� ���� 
		 session.setAttribute("login", dto1); 
		 // ���ǿ�login���̶� �̸����� UsersVO ��ü�� ������ ��. 
		 return returnURL;
	 // �α��� �����ø����������� �̵��ϰ� 
	 }else { // �α��ο� ������ ��� 
		 returnURL = "loginformstu"; //�α��� ������ �ٽ� ������ ��
	 }
	  return returnURL; // ������ ������ returnURL �� ��ȯ�ؼ� �̵���Ŵ }
	  }
	 // �α׾ƿ� �ϴ� �κ�
	  
		/*
		 * @RequestMapping(value="/logoutstu") public String logout(HttpSession
		 * session){ session.invalidate(); // ���� �ʱ�ȭ return "redirect:/loginstu"; //
		 * �α׾ƿ� �� �α���ȭ������ �̵� }
		 */
	 
} // end of controller
