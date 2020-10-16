<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>휴강 사유</title>
</head>
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
<body>
<fieldset style="border: 1px solid; ">
<div class="container">
<c:forEach  items = "${list}" var="list">
교수 <input type="text" id = "prof" value="${list.prof_nm}">
휴강일 <input type="text" id = "date1" value="${list.can_dt}"><br>
강의명 <input type="text" id = "sub" value="${list.sub_nm}">
보강일 <input type="text" id = "date2" value="${list.sup_dt}"><br>
휴강사유 <input type="text" id = "rsn" value="${list.can_iu}"><br>
</c:forEach>
<input type="button" value = "목록으로" onclick="document.location.href='StaRest1.do'" class='btn btn-dark'>
</div>
</fieldset>
</body>
</html>