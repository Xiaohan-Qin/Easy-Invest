<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a User</title>
</head>
<body>
	<form action="findstrategyposts" method="get">
		<h1>Search for a user by first name</h1>
		<p>
			<label for="username">User name</label>
			<input id="username" name="username" value="${fn:escapeXml(param.username)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<br/>
	
	<h1>Matching strategy posts</h1>
        <table border="1">
            <tr>
                <th>UserName</th>
                <th>Created</th>
                <th>IsPublished</th>
                <th>Title</th>
                <th>Content</th>
                <th>Delete Strategy Post</th>
                <th>Update Strategy Post</th>
            </tr>
            <c:forEach items="${strategyposts}" var="strategypost" >
                <tr>
                    <td><c:out value="${strategypost.getUserName()}" /></td>
                    <td><fmt:formatDate value="${strategypost.getCreated()}" pattern="yyyy-MM-dd" /></td>
                    <td><c:out value="${strategypost.getTitle()}" /></td>
                    <td><c:out value="${strategypost.getContent()}" /></td>
                    <td><c:out value="${strategypost.isPublished()}" /></td>
                    <td><c:out value="${strategypost.getLikes()}" /></td>
                    <td><a href="strategypostdelete?postId=<c:out value="${strategypost.getPostId()}"/>">Delete</a></td>
                    <td><a href="strategypostupdate?postId=<c:out value="${strategypost.getPostId()}"/>">Update</a></td>
                </tr>
            </c:forEach>
       </table>
       <br/>
</body>
</html>