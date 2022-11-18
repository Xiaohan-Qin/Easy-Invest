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
	<form action="getreturn" method="get">
		<h1>Get Ten Years Return by Ticker</h1>
		<p>
			<label for="givenTicker">Ticker</label>
			<input id="givenTicker" name="givenTicker" value="${fn:escapeXml(param.ticker)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<h1>10 Years Return (Based on Adj Close Price) from 2012 to 2022</h1>
        <table border="1">
            <tr>
                <th>Return</th>
            </tr>
          
                <tr>
                    <td><c:out value="${ret}" /></td>
           
                </tr>
         </table>
       
     <h1>The Starting and Ending Price Data</h1>
        <table border="1">
           <tr>
                <th>Date</th>
                <th>Open</th>
                <th>High</th>
                <th>Low</th>
                <th>Close</th>
                <th>Adj_Close</th>
                <th>Volume</th>
                <th>MarketCap_Rank</th>
                <th>Ticker</th>
            </tr>
            <c:forEach items="${stocks}" var="stock" >
                <tr>
                	<td><fmt:formatDate value="${stock.getDate()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${stock.getOpen()}" /></td>
                    <td><c:out value="${stock.getHigh()}" /></td>
                    <td><c:out value="${stock.getLow()}" /></td>
                	<td><c:out value="${stock.getClose()}" /></td>
                	<td><c:out value="${stock.getAdjClose()}" /></td>
                	<td><c:out value="${stock.getVolume()}" /></td>
                	<td><c:out value="${stock.getStockCapRank()}" /></td>
                	<td><c:out value="${stock.getTickerName()}" /></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>