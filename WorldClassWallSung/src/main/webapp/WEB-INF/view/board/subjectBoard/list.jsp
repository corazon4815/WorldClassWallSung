<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix=  "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type = "text/css">
	table{border:2px solid; border-collapse:collapse; }
	li{list-style:none; float:left; padding:6px;}
	th,td{border:1px solid; text-align:center; padding: 10px 5px;}
	tr:nth-child(1){background:blue;color:white;}
</style>
</head>
<body>
<div>
	<form action = "writeSubjectBoardForm.do" method = "post">
		<c:if test = "${login.mem_no != 1 }">
		<input type = "submit" value = "글 작성">
		</c:if>
		<table border = "1">
			<tr>
				<td>번호</td>
				<td>학과</td>
				<td>제목</td>
				<td>작성일</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>
		<c:choose>
		<c:when test = "${fn:length(list) > 0 }">
			<c:forEach items = "${list }" var = "list">
			<tr>
				<td>${list.no }</td>
				<td>${list.dept_nm }</td>
				<td><a  href ="#" onclick="changeContent('selectSubjectBoardForm.do?no=${list.no }')">${list.title }</a></td>
				<td>${list.board_dt }</td>
				<td>${list.writer }</td>
				<td>${list.hit }</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan = "6">게시글이 없습니다.</td>
			</tr>
		</c:otherwise>
		</c:choose>
		</table>
	</form>
</div>
<div>
	<ul>
		<c:if test = "${pageMaker.prev }">
		<li><a href = "subjectBoardMain.do${pageMaker.makeQuery(pageMaker.startPage - 1) }">이전</a></li>
		</c:if>
		<c:forEach begin = "${pageMaker.startPage }" end = "${pageMaker.endPage }" var = "idx">
		<li><a href = "subjectBoardMain.do${pageMaker.makeQuery(idx) }">${idx }</a></li>
		</c:forEach>
		<c:if test = "${pageMaker.next && pageMaker.endPage > 0 }">
		<li><a href = "subjectBoardMain.do${pageMaker.makeQuery(pageMaker.endPage + 1) }">다음</a></li>
		</c:if>
	</ul>
</div><br><br>
<div>
	<select name = "searchType">		
		<option value = "dept"<c:out value = "${scri.searchType eq 'dept'?'selected':'' }"/>>학과</option>
		<option value = "t"<c:out value = "${scri.searchType eq 't' ? 'selected':'' }"/>>제목</option>
		<option value = "c"<c:out value = "${scri.searchType eq 'c' ? 'selected':'' }"/>>내용</option>
		<option value = "w"<c:out value = "${scri.searchType eq 'w' ? 'selected':'' }"/>>작성자</option>
		<option value = "tc"<c:out value = "${scri.searchType eq 'tc' ? 'selected':'' }"/>>제목+내용</option>
	</select>
	<input type = "text" name = "keyword" id = "keywordInput" value = "${scri.keyword }"/>
	<button id = "searchBtn" type = "button">검색</button>
</div>
<script>
	$(function(){
		$("#searchBtn").click(function(){
			self.location = 'subjectBoardMain.do'+'${pageMaker.makeQuery(1)}'+"&searchType="+$("select option:selected").val()+"&keyword="+encodeURIComponent($('#keywordInput').val())
			});
	});
</script>
</body>
</html>