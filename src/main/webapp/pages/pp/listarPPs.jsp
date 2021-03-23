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
	<h3>Listagem de PPs</h3>
	<s:url action="paginaCadastroPP" var="inserirPpUrl"></s:url>
	<s:a href="%{inserirPpUrl}">Cadastrar novo PP</s:a>
	
	<p>
		<input type="text" id="txt-nome">
		<button id="btn-pesquisar">Pesquisar</button>
	</p>
	
	<table border="l" id="tbl-pps">
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pps">
				<tr>
					<td><s:property value="nome"/></td>
					<td><s:property value="cpf"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<s:if test="msgnErro != ''">
		<p><s:property value="msgnErro"/></p>
	</s:if>
	
	<!-- Scripts -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){
			$('#btn-pesquisar').click(function(){
				var nome = $('txt-nome').val();
				$.ajax({
					method:'GET',
					url: 'pesquisarPpPorNome.action?nome='+nome,
					success: function(dados){
						$('#tbl-pps > tbody tr').remove();
						$.each(dados, function(idx, pps){
							$('#tbl-pps > tbody').append(
								'<tr>'+
									'<td>'+ pps.nome + '</td>' +
									'<td>'+ pps.cpf + '</td>' +
								'</tr>'
							);
						});
					},
					error: function(){
						alert("Erro ao pesquisar");
					}
				});
			});
		});
	</script>
</body>
</html>