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
	<form action="findusers" method="get">
		<h1>Search for a user by first name</h1>
		<p>
			<label for="firstname">FirstName</label>
			<input id="firstname" name="firstname" value="${fn:escapeXml(param.firstname)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="userCreate"><a href="usercreate">Create User</a></div>
	<div id="StrategyPostCreate"><a href="strategypostcreate">Create Strategy Post</a></div>
	<br/>
	
	<h1>Matching User</h1>
        <table border="1">
            <tr>
                <th>UserName</th>
                <th>Created</th>
                <th>IsMember</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
				<th>Phone</th>
				<th>CompetencyLevel</th>
                <th>Posts</th>
                <th>Reviews</th>
                <th>Delete User</th>
                <th>Update User</th>
            </tr>
            <c:forEach items="${users}" var="user" >
                <tr>
                    <td><c:out value="${user.getUserName()}" /></td>
                    <td><fmt:formatDate value="${user.getCreated()}" pattern="yyyy-MM-dd" /></td>
                    <td><c:out value="${user.isMember()}" /></td>
                    <td><c:out value="${user.getFirstName()}" /></td>
                    <td><c:out value="${user.getLastName()}" /></td>
                    <td><c:out value="${user.getEmail()}" /></td>
                    <td><c:out value="${user.getPhone()}" /></td>
                    <td><c:out value="${user.getCompetencyLevel()}" /></td>
                    <td><a href="userposts?username=<c:out value="${user.getUserName()}"/>">StrategyPosts</a></td>
                    <td><a href="blogcomments?username=<c:out value="${user.getUserName()}"/>">PostComments</a></td>
                    <td><a href="userdelete?username=<c:out value="${user.getUserName()}"/>">Delete</a></td>
                    <td><a href="userupdate?username=<c:out value="${user.getUserName()}"/>">Update</a></td>
                </tr>
            </c:forEach>
       </table>
       
       <br/>
	<div id="FindStocks"><a href="findStocks">Stocks Feature</a></div><br/>
</body>
</html>

