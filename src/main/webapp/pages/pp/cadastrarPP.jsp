<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Cadastro de PP's</h3>
	<div>
		<s:form action="inserirPP">
			<s:textfield cssClass="" label="Nome" name="pp.nome"></s:textfield>
			<s:textfield cssClass="" label="CPF" name="pp.cpf"></s:textfield>
			<s:submit value="Cadastrar"></s:submit>
		</s:form>
		<s:if test="msgnErro != ''">
			<p>
				<s:property value="msgnErro" />
			</p>
		</s:if>
	</div>
</body>
</html>