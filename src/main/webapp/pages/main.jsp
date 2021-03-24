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
<link rel="stylesheet" href="./assets/css/prontuario.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<title>Heevo</title>
</head>
<body>
    <!-- Header -->
    <header>
        <nav class="prontuario">
            <div class="container-nav2">
                <div class="brand">
                    <img src="./img/logo.png" alt="">
                </div>

                <div id="dp" class="dados-profissional">
                    <div class="container-dados">
                            <h2>${sessionScope.pp.nome }</h2>
                            ${sessionScope.pp.cpf }
                        <h3 class="date"></h3>
                    </div>
                </div>
                <button class="dados-btn">Ver dados</button>
            </div>
        </nav>
    </header>

    <!--Main-->
    <main>
        <div class="container-main">
            <section class="column-20">
                <div class="id">
                    <span><i class="fas fa-user"></i></span>
                    <h2 class="name">Nome</h2>

                    <div class="cpf">
                        <i class="fas fa-id-card"></i>
                        <h2>000.000.000-00</h2>
                    </div>

                    <div class="search">
                        <input type="search" placeholder="Buscar cpf..">
                    </div>
                    
                </div>
            </section>

            <section class="column-80">
                <div class="abas">
                    <div class="container-abas">

                        <a href="prontuario.html" style="background-color: var(--color-blue)" class="link-content">
                            <p style="color:#fff">Prontuário</p>
                        </a>
        
                        <a href="prescricao.html"  class="link-content active">
                            <p href="prescricao.html">Prescrição</p>
                        </a>
        
                        <a class="link-content">
                            <p>Histórico</p>
                        </a>
                    </div>
                </div>
                <textarea disabled   rows="12">
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                </textarea>
                <textarea  rows="12">
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                </textarea>
                <div class="btn-container">
                    <button>Anexar</button>
                    <button>Salvar</button>
                </div>
            </div>
        </section>
    </main>

<script src="./assets/js/nav.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js" integrity="sha512-qTXRIMyZIFb8iQcfjXWCO8+M5Tbc38Qi5WzdPOYZHIlZpzBHG3L3by84BBBOiRGiEb7KKtAOAs5qYdUiZiQNNQ==" crossorigin="anonymous"></script>
<script>

let date = moment().format('DD-MM-YYYY HH:mm');
function data() {
    document.querySelector(".date").innerHTML = date;
}
data()

</script>
</body>
</html>