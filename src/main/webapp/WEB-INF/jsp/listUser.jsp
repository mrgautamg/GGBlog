<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
</head>
<body>
	<section class="container">
		<div class="row">
			<table width=97%  border="1"  style="margin:20px">
			<tr>
				<td><strong>UserName</strong></td><td><strong>User Type</strong></td><td><strong>User Image</strong></td>
			</tr>
			<c:forEach items="${userDetails}" var="user">
				<tr>
					
					<td>${user.username}</td>
					<td>${user.role.name}</td>
					<td><img src="<c:url value="/resource/images/${user.imageUrl}"></c:url>" alt="image"  style = "width:100px"/></td>
				</tr>
			</c:forEach>
			</table>
			<div><a href="<spring:url value="/addUser"/>"><input type="submit" value="Add User" ></a>
		</div>
	</section>
</body>
</html>