<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>휴강 신청 내역</title>	
<style>
.table {
   width:700px;
}
	html {
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
	}

	.container {
	    width: auto;
	    max-width: 1140px;
	}
	
	.table td, .table th {
	    padding: .30rem;
	}
	.btn-file {
            position: relative;
            overflow: hidden;
        }

    /*     .btn-file input[type=file] {
            position: absolute;
            top: 0;
            right: 0;
            min-width: 100%;
            min-height: 100%;
            font-size: 100px;
            text-align: right;
            filter: alpha(opacity = 0);
            opacity: 0;
            outline: none;
            background: white;
            cursor: inherit;
            display: block;
        } */
        .btn-primary {
            background-color : blue;
            border-color: red;
        }
        .btn {
       		height: 25px;
       		width: 80px;
       		vertical-align: bottom;
       		padding: .0rem .75rem;
       		font-size: 13px;
       	}
       	.col-md-6 {
		    max-width: none;
		}
		.btn-dark:focus {
			color: #fff;
		    background-color: #343a40;
		    border-color: #343a40;
		}
</style>
	<script>
	$(function(){		
		var url="viewlist.do";		
		$.ajax({
			type:"post"		
			,url:url		
			,dataType:"json" })
			.done(function(args){	
						 $("#data table").append(
							"<tr><td>번호</td><td>교수</td><td>강의명</td><td>휴강일</td><td>승인</td><td>미승인</td></tr>");
				 for(var i=0; i < args.length; i++) {							
									var c = i+1
									var str = "<tr><td>" + c
									+ "</td>" + "<td>" + args[i].prof_nm
									+ "</td>" + "<td>" + "<a href='StaRest2.do?sub_nm="+args[i].sub_cd+"'>" + args[i].sub_nm +"</a>"
									+ "</td>" + "<td>" + args[i].noclass_dt
									+ "</td>" + "<td>" + "<input type='button' value='승인' onclick = 'check1(this)' id = '"+args[i].sub_cd+"' class='btn btn-dark'>"
									+ "</td>" + "<td>" + "<input type='button' value='미승인' onclick = 'check2(this)'id = '"+args[i].sub_cd+"' class='btn btn-dark'>"
									+ "</td></tr>";
									$("#data table").append(str);	
				 }
	 			})
		    .fail(function(e) {
		    	alert("경고");
		    })
	});
function check1(e){	
	if (confirm("승인하시겠습니까?") == true){    //확인
	  /*  	$(e).hide(); */	
	    $("#content").children().remove();
	    $("#content").load("accept.do?sub_cd="+e.id);
	 }else{   //취소
	     return false;
		 }
	}	

function check2(e){		
	if (confirm("미승인하시겠습니까?") == true){    //확인
	 /*   $(e).hide(); */	 
	   $("#content").children().remove();
	    $("#content").load("naccept.do?sub_cd="+e.id);
	 }else{   //취소
	     return false;
		 }
	}
	</script>
</head>
<body>
	<div id="data" class="container">
		<table id="table" style="text-align: center;" class="table table-striped custab"></table>
	</div>
</body>
</html>