<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit news page</title>

<style>
	input[type=text] {
		width: 100%;
		padding: 15px;
		border: 1px solid #ccc;
	}
</style>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>

<fmt:message bundle="${loc}" key="editcontent.button.cancel" var="cancel_but" />
<fmt:message bundle="${loc}" key="editcontent.button.submit" var="sub_but" />

</head>
<body>
	<form action="myController" name="post">
		<input type="hidden" name="command" value="saveeditnews"/>
		<input type="hidden" name="idnews" value="${requestScope.idnews}"/>
		<h2><input type="text" name="title" value="${requestScope.title}" /></h2>
		<br>
		<h4><input type="text" name="brief" value="${requestScope.brief}"></h4>
		<br>
		<p><input type="text" name="content" value="${requestScope.content}"></p>
		<br>
		<input style="float: left;" type="button" onclick="window.location.href='myController?command=gotocontentpage&idnews=${requestScope.idnews}'" value="${cancel_but}" /> 
		<input style="float: left;" type="submit" value="${sub_but}"> 
	</form>
</body>
</html>