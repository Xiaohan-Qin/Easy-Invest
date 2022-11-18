<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Ten Years Return</title>
</head>
<body>
	<form action="getdailydate" method="get">
		<h1>Get All daily recommendations by Date</h1>
		<p>
			<label for="givenDate">Date</label>
			<input id="givenDate" name="givenDate" value="${fn:escapeXml(param.ticker)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
       
     <h1>The Daily Recommendations</h1>
        <table border="1">
           <tr>
                <th>ID</th>
                <th>Ticker</th>
                <th>Date</th>
                <th>Recommend_Position</th>
            </tr>
            <c:forEach items="${recDate}" var="rec" >
                <tr>
                	<td><c:out value="${rec.getDailyStockRecommendationID()}" /></td>
                	<td><c:out value="${rec.getTickerName()}" /></td>
                	<td><fmt:formatDate value="${rec.getDate()}" pattern="yyyy-MM-dd"/></td>
                	<td><c:out value="${rec.getPosition()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>