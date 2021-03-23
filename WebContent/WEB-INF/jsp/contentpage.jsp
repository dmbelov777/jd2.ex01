<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, by.htp.ex01.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ContentPage</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="content.button.back" var="back_but" />
<fmt:message bundle="${loc}" key="content.button.edit" var="edit_but" />
<fmt:message bundle="${loc}" key="content.button.delete" var="del_but" />

</head>
<body>
	
	<div style="color:red"><c:out value="${param.message}" /></div>	

			<h2><c:out value="${requestScope.title}"></c:out></h2>
			<br>
			<p><c:out value="${requestScope.brief}"></c:out></p>
			<br>
			<c:out value="${requestScope.content}"></c:out> 
			<br>
			<c:out value="${requestScope.date}"></c:out>
			<br>
			
	<form action="myController" name="post">
		<input type="hidden" name="command" value="gotomainpage" >
		<input type="submit" value="${back_but}">
	</form>
	
	<c:if test="${sessionScope.role eq 'admin'}">
	<form action="myController" name="post" >
			<input type="hidden" name="command" value="editnews" />
			<input type="hidden" name="title" value="${requestScope.title}"/>
			<input type="hidden" name="brief" value="${requestScope.brief}"/>
			<input type="hidden" name="content" value="${requestScope.content}"/>
			<input type="hidden" name="idnews" value="${requestScope.idnews}"/>
			<input type="submit" value="${edit_but}" />
		</form>
		
		<form action="myController" name="post">
			<input type="hidden" name="command" value="deletenews">
			<input type="hidden" name="idnews" value="${requestScope.idnews }"/>
			<input type="submit" value="${del_but}">
		</form>
	</c:if>
	
</body>
</html>