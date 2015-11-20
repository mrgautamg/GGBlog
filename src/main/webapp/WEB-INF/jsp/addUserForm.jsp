<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="addUser" action="addUser"  enctype="multipart/form-data">
<form:errors path="*" cssStyle="Color:RED"></form:errors>
<fieldset>
        <legend><spring:message code="user.mainTitle" /></legend>
        <p>
        <label for="firstName"><spring:message code="user.firstName"/></label>
        <form:input path="firstName" id="firstName"/>
        </p>
        <p>
        <label for="lastName"><spring:message code="user.lastName"></spring:message></label>
        <form:input path="lastName" id="lastName"/>
        </p>
        <p>
        <label for="address"><spring:message code="user.address"></spring:message></label>
        <form:input path="address" id="address"/>
        </p>
        <p>
        <label for="email"><spring:message code="user.email"></spring:message></label>
        <form:input path="email" id="email"/>
        </p>
        <p>
        <label for="phone"><spring:message code="user.phone"></spring:message></label>
        <form:input path="phone" id="phone"/>
        </p>
        
        <p>
        <label for="role"><spring:message code="user.role"></spring:message></label>
        
        <form:select id="role" path="role.id" 
                items="${role}" itemLabel="name" itemValue="id"/> 
        
<%--         <form:input path="role" id="role"/> --%>
        </p>
        
        <p>
        <label for="username"><spring:message code="user.username"></spring:message></label>
        <form:input path="username" id="username"/>
        </p>
        
        <p>
        <label for="password"><spring:message code="user.password"></spring:message></label>
        <form:input path="password" id="password" type="password"/>
        </p>
        <p>
        <label for="rePassword">Re-Password</label>
        <form:input path="rePassword" id="rePassword" type="password"/>
        </p>
          <p>
          <label for="image"><spring:message code="user.image" /> </label>
        <form:input id="image" path="image" type="file"  />
        </p>
        
        <p id="buttons">
            <input name="reset" type="reset" tabindex="3">
            <input name="submit" type="submit" tabindex="4" value="Add User">
        </p>
</fieldset>
</form:form>
</body>
</html>