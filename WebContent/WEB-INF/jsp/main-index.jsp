<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, by.htp.ex01.bean.News"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MainIndex</title>
<style>
	* {
		box-sizing: border-box;
	}
		
	body {
		font-family: Arial, Helvetica, sans-serif;
	}
	
	header {
		background-color: #667;
		padding: 15px;
		text-align: center;
		font-size: 10px;
		color: white;
	}
	
	td {
		border: 1px solid grey;
		border-radius: 5px;
		background-color: rgba(45,45,45, 0.4);
	}
	
	nav{
		float: right;
		width: 240px;
		height: 80%;
		background: #ccc;
		padding: 20px;
	}
	
	section::after {
		content: "";
		display: table;
		clear: both;
	}
	
	article {
		float: right;
		padding: 20px;
		width: 70%;
		background-color: #f1f1f1;
		height: 300px;
	}
	
	input[type=text],
	input[type=password] {
		width: 180px;
		padding: 12px 20px;
		margin: 8px 0;
		border: 1px solid #ccc;
		box-sizing: border-box;
	}
	
	label {
		color:	white;
	}
	
	a {
		color: white;
	}
	
	footer {
		background-color: #777;
		margin-top: 120px;
		padding: 10px;
		text-align: center;
		color: white;
	}
</style>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>

<fmt:message bundle="${loc}" key="name.header" var="name_header"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>
<fmt:message bundle="${loc}" key="logination.name.login" var="name_login"/>
<fmt:message bundle="${loc}" key="logination.name.password" var="name_pass"/>
<fmt:message bundle="${loc}" key="logination.placeholder.login" var="enter_login"/>
<fmt:message bundle="${loc}" key="logination.placeholder.password" var="enter_pass"/>
<fmt:message bundle="${loc}" key="logination.button" var="log_in"/>
<fmt:message bundle="${loc}" key="registrarion.link.name" var="name_reg"/>
<fmt:message bundle="${loc}" key="name.footer" var="name_footer"/>

</head>

<body>

<header>
	<h1>${name_header}</h1>
</header>

<form action="myController" method="post">
	<input type="hidden" name="command" value="changelang"/>
	<input type="hidden" name="local" value="ru" />
	<input type="submit" value="${ru_button}"/>
	<br/>
</form>

<form action="myController" method="post">
	<input type="hidden" name="command" value="changelang"/>
	<input type="hidden" name="local" value="en" />
	<input type="submit" value="${en_button}"/>
	<br/>
</form>

<section>
	<nav>

		<div style="color:red"><c:out value="${param.message}" /></div>
		
	<br/>
		<form action="myController" name="post">
			<input type="hidden" name="command" value="logination" />
			<label>${name_login}:</label><br>
			<input type="text" placeholder="${enter_login}" name="login" value="" /><br />
			<label>${name_pass}:</label><br>
			<input type="password" placeholder="${enter_pass}" name="password" value="" /><br>
			
			<input type="submit" value="${log_in}" /><br>
		</form>
		
		<a href="myController?command=registration" >${name_reg}</a>
	</nav>

<article>		
	<table>
		<c:forEach var="n" items="${requestScope.news}">
		<tr>
			<td>
				<font size="2">
					
					<c:choose>
						<c:when test="${n.status eq 'deleted'}">DELETED</c:when>
						<c:otherwise>
							<h2><c:out value="${n.title}" /></h2>
							<p><c:out value="${n.brief }" /></p>
						</c:otherwise>
					</c:choose>
					
				</font>
			</td>
		</tr>
		</c:forEach>
	</table>
</article>
</section>

<footer>${name_footer}</footer>
</body>
</html>