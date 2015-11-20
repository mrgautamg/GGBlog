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
<script type="text/javascript"
	src="http://tinymce.cachefly.net/4.2/tinymce.min.js"></script>
<script type="text/javascript">
tinyMCE.init({
        mode : "textareas"
});
</script>
<title>New Post</title>

</head>
<body>
	<form:form modelAttribute="post" action="newpost"
		enctype="multipart/form-data">
		<form:errors path="*" cssStyle="Color:RED"></form:errors>
		<fieldset>

			<legend>New Post</legend>
			<p>
			<table width=97% border="1" style="margin: 20px">
				<tr>
					<td width="200px"><strong>Title:</strong></td>
					<td><form:input path="title" id="title" style="width:100%" />
					</td>
				</tr>
				<tr>

					<td colspan="2">
						<p>
							<form:textarea rows="20" cols="50" path="content" id="content"></form:textarea>

						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p id="buttons">
							<input name="reset" type="reset" tabindex="3"> <input
								name="submit" type="submit" tabindex="4" value="Add Post">
						</p>
					</td>
				</tr>
			</table>

		</fieldset>
	</form:form>



</body>
</html>