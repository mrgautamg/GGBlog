<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	
	<title>Login</title>
</head>
<body>
	<div>
	<a href="<spring:url value="/listPost"/>"><input type="button" value="Home"/></a>
	Language: <a href="?language=en">English</a> | <a href="?language=ne_NP">Nepali</a>
		<form action="<spring:url value="/postLogin"/>" method="post" >
		<fieldset>			
			<table>
			<tr>
				<tr>
				<td><label for="username"><spring:message code="user.userName"/></label>
				 <input  type="text" name="username" /> </td>
				</tr>
				<tr>
				<td><label for="password"><spring:message code="user.password"/></label>
				 <input type="password"  name="password"/></td>
				 </tr>
			
			<tr>
				<td><input type="submit" name="submit" value="Login"/></td>
				</tr>
				
				<tr>
				
				</tr>
				</table>
		</fieldset>
		</form>
		
		<div><a href="<spring:url value="/addUser"/>"><input type="submit" value="Sign Up" ></a></div>
	</div>
</body>
</html>