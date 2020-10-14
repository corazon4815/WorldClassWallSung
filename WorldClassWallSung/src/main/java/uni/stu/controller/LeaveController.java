package uni.stu.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.ParseInfo;

import uni.main.model.Login_All_Dto;
import uni.stu.model.LeaveDto;
import uni.stu.service.LeaveService;

@Controller
public class LeaveController {
	@Autowired
	LeaveService ls;
	// ��û ��¥ / �б� / ���� ������ ��Ƴ��� �޼ҵ�
	private void referenceData(Model m) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 6);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); // ���� �⵵�� ����
		String year = sdf.format(cal.getTime());
		String[] years = { year };
		String[] sem = { "1�б�" };
		String[] chan = { "�Ϲ�����", "������", "����" };
		m.addAttribute("leave_year", years);
		m.addAttribute("leave_sem", sem);
		m.addAttribute("leave_change", chan);
	}
	// ��/���� ���� list�� ���
	@RequestMapping(value = "leaveMain.do", method = RequestMethod.GET)
	public String leaveList(Model m, HttpSession session) throws Exception {
		int stu_no = ((Login_All_Dto)session.getAttribute("login")).getStu_no();
		m.addAttribute("allData", ls.leaveList(stu_no));
		referenceData(m);
		return "leaveMain";
	}
	// ��/���� ���� ����
	@RequestMapping(value = "leaveSave.do", method = RequestMethod.POST)
	public String leaveInsert(LeaveDto dto) throws Exception {
		ls.leaveInsert(dto);
		return "redirect:leaveMain.do";
	}
	

	public void setLs(LeaveService ls) {
		this.ls = ls;
	}
}
