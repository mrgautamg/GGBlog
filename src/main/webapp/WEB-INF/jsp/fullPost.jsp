<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>



<title>Insert title here</title>
</head>
<body>
	<section class="container">

		<table width=97% border="1" style="margin: 20px">
			<tr>
				<td><strong>${post.title}</strong></td>
			</tr>
			<tr>
				<td>
					<p>${post.content}</p>
				</td>
			</tr>
			<c:forEach items="${post.comments}" var="comment">
				<tr>

					<td>${comment.description}</td>

				</tr>
			</c:forEach>

		</table>

		<form:form modelAttribute="comment" action="addComment?id=${post.id }">
			<table>
				<tr>
					<td><label for="description">add Comment:</label></td>
				</tr>
				<tr>
					<td>
					<form:textarea path="description" id="description" cols="60" rows="10" ></form:textarea>
					</td>
				</tr>
				<tr>
					<td>
						<p id="buttons">
							<input name="reset" type="reset" tabindex="3"> <input
								name="submit" type="submit" tabindex="4" value="Add Comment">
						</p>
					</td>
				</tr>
			</table>
		</form:form>
	</section>
</body>
</html>