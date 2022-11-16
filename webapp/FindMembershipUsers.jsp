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
	<form action="findmembershipusers" method="post">
		<h1>Search for a MembershipUser by UserName</h1>
		<p>
			<label for="username">UserName</label>
			<input id="username" name="username" value="${fn:escapeXml(param.username)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="membershipUserCreate"><a href="membershipusercreate">Create MembershipUser</a></div>
	<br/>
	<h1>Matching MembershipUser</h1>
        <table border="1">
            <tr>
                <th>UserName</th>
                <th>Created</th>
                <th>isMember</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
				<th>Phone</th>
				<th>CompetencyLevel</th>
                <th>Posts</th>
                <th>Reviews</th>
                <th>Delete MembershipUser</th>
                <th>Update MembershipUser</th>
            </tr>
            <c:forEach items="${membershipUser}" var="membershipUser" >
                <tr>
                    <td><c:out value="${membershipUser.getUserName()}" /></td>
                    <td><fmt:formatDate value="${membershipUser.getCreated()}" pattern="yyyy-MM-dd" /></td>
                    <td><c:out value="${membershipUser.isMember()}" /></td>
                    <td><c:out value="${membershipUser.getFirstName()}" /></td>
                    <td><c:out value="${membershipUser.getLastName()}" /></td>
                    <td><c:out value="${membershipUser.getEmail()}" /></td>
                    <td><c:out value="${membershipUser.getPhone()}" /></td>
                    <td><c:out value="${membershipUser.getCompetencyLevel()}" /></td>
                    <td><a href="userposts?username=<c:out value="${membershipUser.getUserName()}"/>">StrategyPosts</a></td>
                    <td><a href="blogcomments?username=<c:out value="${membershipUser.getUserName()}"/>">PostComments</a></td>
                    <td><a href="userdelete?username=<c:out value="${membershipUser.getUserName()}"/>">Delete</a></td>
                    <td><a href="userupdate?username=<c:out value="${membershipUser.getUserName()}"/>">Update</a></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
