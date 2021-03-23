<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h3>Login</h3>
	<s:form action="loginPP">
		<s:textfield label="CPF" name="pp.cpf"></s:textfield>
		<s:submit value="Entrar"></s:submit>
	</s:form>
	<s:if test="msgnErro != ''">
		<p>
			<s:property value="msgnErro" />
		</p>
	</s:if>
</body>
</html>