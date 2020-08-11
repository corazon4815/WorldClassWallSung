package uni.stu.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.stu.model.SubjectDto;

@Service
public class LeaveService{
	@Autowired
	SubjectDao sdao;
	
	public LeaveService() {}

	public List<SubjectDto> yearScore() {
		return sdao.yearScore();
	}

	public List<SubjectDto> semScore() {
		return sdao.semScore();
	}
	public List<SubjectDto> listScore(int years,int sem) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("years", years);
		m.put("sem", sem);
		
		return sdao.listScore(m);
	}
	
	public void setSdao(SubjectDao sdao) {
		this.sdao = sdao;
	}
}
