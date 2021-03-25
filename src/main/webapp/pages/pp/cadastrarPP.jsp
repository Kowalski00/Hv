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
    <!--CSS-->
    <link rel="stylesheet" href="./assets/css/global.css">
    <link rel="stylesheet" href="./assets/css/cadastro.css">
    <link rel="stylesheet" href="./assets/css/nav.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
        integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
        crossorigin="anonymous" />
    <title>Cadastro Profissionais</title>
</head>
<body>
    <!-- Header -->
    <header>
        <nav>
            <div class="container-nav">
                <div class="brand">
                    <img src="./img/logo.png" alt="">
                </div>

                <i class="fas fa-bars hamb"></i>

            </div>
        </nav>
    </header>

    <!--Main-->
    <main>
        <div class="container-main">
            <h2 class="title-cadastro">
                Cadastro dos Profissionais
            </h2>

            <s:form cssClass="container-form" action="inserirPP" >
                <div class="form-cadastro">

					<s:textfield cssClass="input" type="text" placeholder="Nome completo" name="pp.nome"/>
                    <s:textfield cssClass="input" type="number" placeholder="CPF (Somente números)" name="pp.cpf"/>
                    <s:select headerValue="Tipo do Profissional" headerKey="-1" list="#{'Dentista':'Dentista','Farmacêutico':'Farmacêutico','Fisioterapeuta':'Fisioterapeuta','Fonoaudiólogo':'Fonoaudiólogo','Médico':'Médico','Nutricionista':'Nutricionista','Psicólogo':'Psicólogo','Terapeuta Ocupacional':'Terapeuta Ocupacional','Outro':'Outro' }" name="pp.TipPP" placeholder="Profissional"></s:select>

                    <s:textfield cssClass="input" type="email" placeholder="E-mail" name="pp.email"/>
                    <s:textfield cssClass="input" type="date" placeholder="Data de nascimento" name="pp.DTNASCpp"/>
                        <!--Nascimento-->
                        <div class="three-col">
                        	<s:select disable="true" headerValue="Dia" headerKey="-1" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10','11':'11','12':'12','13':'13','14':'14','15':'15','16':'16','17':'17','18':'18','19':'19','20':'20','21':'21','22':'22','23':'23','24':'24','25':'25','26':'26','27':'27','28':'28','29':'29','30':'30','31':'31'}" name="" placeholder="Dia"></s:select>
							<s:select disable="true" headerValue="Mês" headerKey="-1" list="#{'1':'Janeiro','2':'Fevereiro','3':'Março','4':'Abril','5':'Maio','6':'Junho','7':'Julho','8':'Agosto','9':'Setembro','10':'Outubro','11':'Novembro','12':'Dezembro'}" name="" placeholder="Mês"></s:select>
							<s:select disable="true" headerValue="Ano" headerKey="-1" list="#{'2018':'2018','2017':'2017','2016':'2016','2015':'2015','2014':'2014','2013':'2013','2012':'2012','2011':'2011','2010':'2010','2009':'2009','2008':'2008','2007':'2007','2006':'2006','2005':'2005','2004':'2004','2003':'2003','2002':'2002','2001':'2001','2000':'2000','1999':'1999','1998':'1998','1997':'1997','1996':'1996','1995':'1995','1994':'1994','1993':'1993','1992':'1992','1991':'1991','1990':'1990','1989':'1989','1988':'1988','1987':'1987','1986':'1986','1985':'1985','1984':'1984','1983':'1983','1982':'1982','1981':'1981','1980':'1980','1979':'1979','1978':'1978','1977':'1977','1976':'1976','1975':'1975','1974':'1974','1973':'1973','1972':'1972','1971':'1971','1970':'1970','1969':'1969','1968':'1968','1967':'1967','1966':'1966','1965':'1965','1964':'1964','1963':'1963','1962':'1962','1961':'1961','1960':'1960','1959':'1959','1958':'1958','1957':'1957','1956':'1956','1955':'1955','1954':'1954','1953':'1953','1952':'1952','1951':'1951','1950':'1950','1949':'1949','1948':'1948','1947':'1947','1946':'1946','1945':'1945','1944':'1944','1943':'1943','1942':'1942','1941':'1941','1940':'1940','1939':'1939','1938':'1938','1937':'1937','1936':'1936','1935':'1935','1934':'1934','1933':'1933','1932':'1932','1931':'1931','1930':'1930','1929':'1929','1928':'1928','1927':'1927','1926':'1926','1925':'1925','1924':'1924','1923':'1923','1922':'1922','1921':'1921','1920':'1920','1919':'1919','1918':'1918','1917':'1917','1916':'1916','1915':'1915','1914':'1914','1913':'1913','1912':'1912','1911':'1911','1910':'1910','1909':'1909','1908':'1908','1907':'1907','1906':'1906','1905':'1905'}" name="" placeholder="Ano"></s:select>
                    </div>
                    <div class="two-col">
                    	<s:textfield cssClass="input" type="number" placeholder="Inscrição Conselho (Somente números)" name="pp.codRegPro"/>
                    	<s:select cssClass="input" headerValue="UF do Conselho" headerKey="-1" name="pp.crpUf" placeholder="UF" list="#{'AC':'AC','AL':'AL','AP':'AP','AM':'AM','BA':'BA','CE':'CE','DF':'DF','ES':'ES','GO':'GO','MA':'MA','MT':'MT','MS':'MS','MG':'MG','PA':'PA','PB':'PB','PR':'PR','PE':'PE','PI':'PI','RJ':'RJ','RN':'RN','RS':'RS','RO':'RO','RR':'RR','SC':'SC','SP':'SP','SE':'SE','TO':'TO'}" ></s:select>
							
                    </div>
                    <div class="two-col">
                    	<s:textfield cssClass="input" id="cep" type="text" placeholder="CEP" name="pp.CepCom"/>
						<s:select cssClass="input" headerValue="UF" headerKey="-1" name="pp.EstCom" placeholder="UF" list="#{'AC':'AC','AL':'AL','AP':'AP','AM':'AM','BA':'BA','CE':'CE','DF':'DF','ES':'ES','GO':'GO','MA':'MA','MT':'MT','MS':'MS','MG':'MG','PA':'PA','PB':'PB','PR':'PR','PE':'PE','PI':'PI','RJ':'RJ','RN':'RN','RS':'RS','RO':'RO','RR':'RR','SC':'SC','SP':'SP','SE':'SE','TO':'TO'}" ></s:select>

                    </div>
                    <s:textfield cssClass="input" id="cidade" type="text" placeholder="Cidade" name="pp.CidCom"/>
<!--                     <input class="input" type="text" id="cidade" placeholder="Cidade"> -->
                    <s:textfield cssClass="input" id="bairro" type="text" placeholder="Bairro" name="pp.BaiCom"/>
<!--                     <input class="input" type="text" id="bairro" placeholder="Bairro"> -->
					<s:textfield cssClass="input" id="endereco" type="text" placeholder="Endereço" name="pp.RuaCom"/>
<!--                     <input class="input" type="text" id="endereco" placeholder="Endereço"> -->
                    <s:textfield cssClass="input" id="senha" type="password" placeholder="Senha" name="" disabled="true"/>
                    <s:textfield cssClass="input" id="confirmar-senha" type="password" placeholder="Confirmar Senha" name="" disabled="true"/>


                </div>

                <textarea id="editor" disabled="true">
                    Website Terms and Conditions of Use
1. Terms
By accessing this Website, accessible from Website.com, you are agreeing to be bound by these Website Terms and Conditions of Use and agree that you are responsible for the agreement with any applicable local laws. If you disagree with any of these terms, you are prohibited from accessing this site. The materials contained in this Website are protected by copyright and trade mark law.

2. Use License
Permission is granted to temporarily download one copy of the materials on Company Name's Website for personal, non-commercial transitory viewing only. This is the grant of a license, not a transfer of title, and under this license you may not:

modify or copy the materials;
use the materials for any commercial purpose or for any public display;
attempt to reverse engineer any software contained on Company Name's Website;
remove any copyright or other proprietary notations from the materials; or
transferring the materials to another person or "mirror" the materials on any other server.
This will let Company Name to terminate upon violations of any of these restrictions. Upon termination, your viewing right will also be terminated and you should destroy any downloaded materials in your possession whether it is printed or electronic format.

3. Disclaimer
All the materials on Company Name's Website are provided “as is”. Company Name makes no warranties, may it be expressed or implied, therefore negates all other warranties. Furthermore, Company Name does not make any representations concerning the accuracy or reliability of the use of the materials on its Website or otherwise relating to such materials or any sites linked to this Website.

4. Limitations
Company Name or its suppliers will not be hold accountable for any damages that will arise with the use or inability to use the materials on Company Name's Website, even if Company Name or an authorize representative of this Website has been notified, orally or written, of the possibility of such damage. Some jurisdiction does not allow limitations on implied warranties or limitations of liability for incidental damages, these limitations may not apply to you.

5. Revisions and Errata
The materials appearing on Company Name's Website may include technical, typographical, or photographic errors. Company Name will not promise that any of the materials in this Website are accurate, complete, or current. Company Name may change the materials contained on its Website at any time without notice. Company Name does not make any commitment to update the materials.

6. Links
Company Name has not reviewed all of the sites linked to its Website and is not responsible for the contents of any such linked site. The presence of any link does not imply endorsement by Company Name of the site. The use of any linked website is at the user's own risk.

7. Site Terms of Use Modifications
Company Name may revise these Terms of Use for its Website at any time without prior notice. By using this Website, you are agreeing to be bound by the current version of these Terms and Conditions of Use.

8. Governing Law
Any claim related to Company Name's Website shall be governed by the laws of Country without regards to its conflict of law provisions.
                </textarea>

                <div class="form-btns">
                    <div class="terms">
                        <h2>
                            <input id ="check" type="checkbox">
                            Aceito os termos de serviço
                        </h2>
                    </div>

                    <s:submit cssClass="btn" type="submit" value="Salvar e Enviar"/>

                    
                </div>
            </s:form>
        </div>
    </main>
<script src="./assets/js/nav.js"></script>
<script src="./assets/js/cadastro.js"></script>
<script>
    //Options
const dia = document.querySelector("#dia");
const mes = document.querySelector("#mes");
const ano = document.querySelector("#ano");


</script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script>
    $("#cep").blur(function(){
        // Remove tudo o que não é número para fazer a pesquisa
        var cep = this.value.replace(/[^0-9]/, "");
        
        if(cep.length != 8){
            return false;
        }
        
        var url = "https://viacep.com.br/ws/"+cep+"/json/";

        $.getJSON(url, function(dadosRetorno){
            try{
                // Preenche os campos de acordo com o retorno da pesquisa
                $("#endereco").val(dadosRetorno.logradouro);
                $("#bairro").val(dadosRetorno.bairro);
                $("#cidade").val(dadosRetorno.localidade);
                $("#uf").val(dadosRetorno.uf);
            }catch(ex){}
        });
    });
</script>
</body>
</html>