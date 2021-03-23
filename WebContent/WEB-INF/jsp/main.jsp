<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="by.htp.ex01.bean.News"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BriefPage</title>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="main.greeting" var="greeting" />
<fmt:message bundle="${loc}" key="main.link.logout" var="logout_linkname" />
<fmt:message bundle="${loc}" key="main.deleted.news" var="del_news_name" />
<fmt:message bundle="${loc}" key="main.link.readmore" var="readmore_linkname" />

</head>
<body>

	<c:out value="${greeting}, ${sessionScope.name}" />
	
	<br>
	<a href="myController?command=logout">${logout_linkname}</a>
	<br>
	
	<font color="red">
		<c:out value="${requestScope.message}" />
	</font>
	
	<table>
		<c:forEach var="n" items="${requestScope.news}">
		<tr>
			<td>
			
				<c:choose>
					<c:when test="${n.status eq 'deleted'}">${del_news_name}</c:when>
					<c:otherwise>
						<h3> <c:out value="${n.title}"></c:out> </h3>
						<p>	<c:out value="${n.brief}"></c:out> <a href="myController?command=gotocontentpage&idnews=${n.idnews}">${readmore_linkname}...</a> </p>
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>