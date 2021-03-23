<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc"/>

<fmt:message bundle="${loc}" key="registration.entername" var="enter_name" />
<fmt:message bundle="${loc}" key="registration.placeholder.firstname" var="first_name" />
<fmt:message bundle="${loc}" key="registration.entersurname" var="enter_sur" />
<fmt:message bundle="${loc}" key="registration.placeholder.lastname" var="last_name" />
<fmt:message bundle="${loc}" key="registration.enter.year" var="enter_year" />
<fmt:message bundle="${loc}" key="registration.yearofbirth" var="birth_year" />
<fmt:message bundle="${loc}" key="registration.enter.phone" var="enter_phone" />
<fmt:message bundle="${loc}" key="registration.placeholder.phone" var="phone_num" />
<fmt:message bundle="${loc}" key="registration.enter.login" var="enter_login" />
<fmt:message bundle="${loc}" key="registration.placeholder.login" var="login_val" />
<fmt:message bundle="${loc}" key="registration.enter.password" var="enter_pass" />
<fmt:message bundle="${loc}" key="registration.placeholder.password" var="password_val" />
<fmt:message bundle="${loc}" key="registration.button.submit" var="submit_button" />

</head>
<body>
	<form action="myController" name="post">
		<input type="hidden" name="command" value="savenewuser"  />
		${enter_name}:<br />
		<input type="text" placeholder="${first_name}" name="name" value="" /><br />
		${enter_sur}:<br />
		<input type="text" placeholder="${last_name}" name="surname" value="" /><br />
		${enter_year}:<br />
		<input type="number" placeholder="${birth_year}" name="year" value="" /><br />
		${enter_phone}:<br />
		<input type="tel" placeholder="${phone_num}" name="phone" value="" /><br />
		${enter_login}:<br />
		<input type="text" placeholder="${login_val}" name="login" value="" /><br />
		${enter_pass}:<br />
		<input type="password" placeholder="${password_val}" name="password" value="" /><br />
		
		<input type="submit" value="${submit_button}" /><br />
	</form>
</body>
</html>