<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recent Posts</title>
</head>
<body>

			<table width=97%  border="1"  style="margin:20px">
			<tr>
				<td><strong>Title</strong></td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td>Action</td>
				</sec:authorize>
			</tr>
			<c:forEach items="${posts}" var="post">
				<tr>
				<td>
				<a href=" <spring:url value="/fullPost?id=${post.id}" /> "> ${post.title }</a>
				<p>${post.content}</p>
				</td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td><a href=" <spring:url value="/editPost?id=${post.id}" /> "> Edit</a></td>
				</sec:authorize>
				</tr>
			</c:forEach>
			</table>
			<div><a href="<spring:url value="/newpost"/>"><input type="submit" value="New Post" ></a>
		</div>
	
</body>
</html>