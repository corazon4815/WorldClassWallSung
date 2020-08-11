<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
	$(function() {
		var url = "years";
		$.ajax({
			type : "post",
			url : url,
			dataType : "json"
		}).done(
				function(args) {
					for (var i = 0; i < args.length; i++) {
						$("#years").append(
								"<option value='"+args[i].years+"'>"
										+ args[i].years + "</option>");
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	});//ready ��

	$(function() {
		var url = "sem";
		$.ajax({
			type : "post",
			url : url,
			dataType : "json"
		}).done(
				function(args) {
					for (var i = 0; i < args.length; i++) {
						$("#sem").append(
								"<option value='"+args[i].sem+"'>"
										+ args[i].sem + "�б�" + "</option>");
					}
				}).fail(function(e) {
			alert(e.responseText);
		})
	});//ready ��

	function selecEmp() {
		var url = "listAll";
		var years = $("#years").val();
		var sem = $("#sem").val();
		var params = "years=" + years + "&sem=" + sem;
		$.ajax({
			type : "post",
			url : url,
			data : params,
			dataType : "json"
		}).done(function(args) {
			$("#listInfo").html("");
			$("#sumInfo").html("");
			var main = "<tr><td>�̼�����</td><td>���Ǹ�</td><td>�����ڵ�</td><td>����</td><td>���</td><td>����</td></tr>";
			$("#listInfo").append(main);
			var sum = 0;
			var avg = 0;
			var i = 0;
			for(i=0; i<args.length; i++) {
				var isu = "<tr><td width=100>" + args[i].isu + "</td>";
				var sub_nm = "<td width=300>" + args[i].sub_nm + "</td>";
				var sub_cd = "<td width=100>" + args[i].sub_cd + "</td>";
				var credit = "<td width=50>" + args[i].credit + "</td>";
				var attend_grade = "<td width=50>" + args[i].attend_grade + "</td>";
				var attend_rating = "<td width=50>" + args[i].attend_rating + "</td></tr>";	
				var credit_sum = args[i].credit;
				var attend_rating_avg = args[i].attend_rating;
				sum += credit_sum;
				avg = Math.round(avg + (attend_rating_avg * 100));
				$("#listInfo").append(isu + sub_nm + sub_cd + credit + attend_grade + attend_rating);
			}
			var data = "<tr><td>���� �հ�</td><td>���� ���</td></tr>";
			sum = "<tr><td width=100>" + sum + "</td>";
			avg = "<td width=100>" + ((avg / i) / 100).toFixed(2) + "</td></tr>";
			$("#sumInfo").append(data);
			$("#sumInfo").append(sum + avg);
		})
	}
</script>

</head>
<body>
	<select id="years">
		<option value="">::��������::</option>
	</select>
	<select id="sem">
		<option value="">::�б⼱��::</option>
	</select>
	<input type="button" value="��ȸ" onclick="selecEmp()">
	<hr>
	<div style="width:650px;">
		<table border="1" id="listInfo" style="text-align: center;">
		</table><br>
		<table border="1" id="sumInfo" style="text-align:center; float:right;">
		</table>
	</div>
</body>
</html>