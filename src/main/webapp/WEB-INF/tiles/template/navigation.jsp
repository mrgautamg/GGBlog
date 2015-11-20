<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 



<p >

<%-- <a href="<spring:url value="/welcome"/>"><input type="button" value="Home"/></a>  --%>

<%-- <li><a href="<spring:url value="/addUser"/>">Add User</a></li> --%>



<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="<spring:url value="/listUser"/>"><input type="button" value="User"/> </a> 
</sec:authorize>

<a href="<spring:url value="/listPost"/>"><input type="button" value="Home"/></a> 


 
        

<sec:authorize access="isAuthenticated()">
<a href="<spring:url value="/doLogout"/>"><input type="button" value="Logout"/></a> |
    <sec:authentication property="principal.username" var="username" />
   <br> Hello ${username} Logged in date and Time:-${today}
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
    <a href="<spring:url value="/login"/>"><input type="button" value="LogIn"/></a>
</sec:authorize>
Language: <a href="?language=en">English</a> |<a href="?language=ne_NP">Nepali</a>    
</P>

 
 <style>
a{
text-decoration:none;
}
.jumbotron{
border-bottom:1px solid gray;
margin-bottom: 10px;
background: #cccccc;
}
.header>p{
border-bottom:3px solid gray;
}
</style>