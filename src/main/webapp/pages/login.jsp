<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Favicon-->
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<!--CSS/Font-->
<link rel="stylesheet" href="./assets/css/global.css">
<link rel="stylesheet" href="./assets/css/login.css">
<link rel="stylesheet" href="./assets/css/nav.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<title>Heevo</title>
</head>
<body>
	<!-- Header -->
	<header> <nav>
	<div class="container-nav">
		<div class="brand">
			<img src="./img/logo.png" alt="">
		</div>

		<div class="nav-links">
			<a href="#">Sobre</a> <a href="#">FAQ</a>
		</div>

		<s:url action="paginaCadastroPP" var="pagCadPPUrl"></s:url>
		<div ><s:a cssClass="btnCad" href="%{pagCadPPUrl}">Cadastrar</s:a></div>

		<i class="fas fa-bars hamb"></i>

	</div>
	</nav> </header>

	<!--Main-->
	<main>
	<div class="container-main">

		<div id="logo-main">
			<img src="./img/LOGO HEEVO.png" alt="">
		</div>

		<s:form cssClass="login-form" action="loginPP" method="post">
			<s:textfield cssClass="input-login cpf" name="pp.cpf"
				placeholder="CPF (Somente números)" />
			<s:textfield cssClass="input-login cpf" name="pp.senha"
				placeholdeer="Senha" disabled="true" />
			<s:submit cssClass="btn-login" value="Login" />

			
		</s:form>
		<s:a cssClass="forgot" href="#">Esqueci a senha</s:a>
		<s:a cssClass="forgot" href="cadastro-profissional.html">É paciente ?<br>
				<span>realize seu cadastro aqui</span>
		</s:a>
	</div>
	</main>

	<script src="./assets/js/nav.js"></script>
	<script src="./assets/js/login.js"></script>
</body>
</html>