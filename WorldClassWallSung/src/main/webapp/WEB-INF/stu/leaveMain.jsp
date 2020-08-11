<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>
	<h3>
		<text> 학적변동 내역 </text>
	</h3>
	<table border=1>
		
	</table>
	<h3>
		<text> 휴복학 신청 </text>
	</h3>
	<select id="years">
		<option value="">::연도선택::</option>
	</select>
	<select id="sem">
		<option value="">::학기선택::</option>
	</select>
	<select id="chan">
		<option value="">::학적변동::</option>
	</select>
	<input type="button" value="조회" onclick="selecEmp()">
</body>
</html>