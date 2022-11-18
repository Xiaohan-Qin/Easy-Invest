<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get All Unique Stock Tickers</title>
</head>
<body>
	<form action="findStocks" method="get">
		<h1>Get All Unique Stock Tickers</h1>
		<p>
			<input type="submit" value="Get Tickers!">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages}</b></span>
		</p>
	</form>
	<br/>
	<div id="GetReturn"><a href="getreturn">Get 10 years return by ticker</a></div>
	<div id="GetDaily"><a href="getdaily">Get daily recommendations by ticker</a></div>
	<div id="GetDailyDate"><a href="getdailydate">Get daily recommendations by date</a></div>
	<br/>
	<h1>All Unique Tickers In The Database</h1>
        <table border="1">
            <tr>
                <th>Ticker</th>

         	</tr>
        <c:forEach items="${tickers}" var="ticker" >
                <tr>
                    <td><c:out value="${ticker}" escapeXml="false" /></td>
                </tr>
            </c:forEach>
    
       </table> 
</body>
</html>