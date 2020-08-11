package uni.stu.service;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import uni.stu.model.SubjectDto;

public class SubjectDao extends SqlSessionDaoSupport{
	public List<SubjectDto> yearScore(){
		return getSqlSession().selectList("score.yearScore");
	}
	public List<SubjectDto> semScore(){
		return getSqlSession().selectList("score.semScore");
	}
	public List<SubjectDto> listScore(Map<String, Integer> d){
		return getSqlSession().selectList("score.listScore", d);
	}
}