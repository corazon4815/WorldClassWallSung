package uni.stu.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;


import uni.stu.model.ApplyDto;
import uni.stu.model.MajorDto;

import java.util.*;


public class MajorDao extends SqlSessionDaoSupport{
	
	public List<MajorDto> cultureList(String isu){
		List<MajorDto> li = getSqlSession().selectList("student.listCulture", isu);
		for(MajorDto i : li) {
			i.setLec(i.getLec_1(), i.getLec_2(), i.getLec_3());
		}
		return li;
	}
	public MajorDto selectDept() {
		return getSqlSession().selectOne("student.listDept");
	}
	public int insert(ApplyDto dto) {
		return getSqlSession().insert("student.apply", dto);
	}
	public List<ApplyDto> applyList(int stu_no){
		List<ApplyDto> li = getSqlSession().selectList("student.selectApply", stu_no);
		for(ApplyDto i : li) {
			i.setLec(i.getLec_1(), i.getLec_2(), i.getLec_3());
		}
		return li;
	}
	public int delete(ApplyDto dto) {
		return getSqlSession().delete("student.deleteApply", dto);
	}
	public int update(ApplyDto dto) {
		return getSqlSession().update("student.updateApply", dto);		
	}
	public int update1(ApplyDto dto) {
		return getSqlSession().update("student.updateApply1", dto);
	}
	public int score(int stu_no) {
		return getSqlSession().selectOne("student.score",stu_no);
	}
	
	
}
