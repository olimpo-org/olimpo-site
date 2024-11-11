<%@ page import="org.example.olimposite.DAO.PlanoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PlanoDAO planoDAO = new PlanoDAO();
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Planos</title>
    <link rel="stylesheet" href="../../CSS/Plano/planos.css">

    <!-- Fonte Archivo  (Título do Olimpo)-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@0,100..900;1,100..900&family=Dancing+Script:wght@400..700&family=Great+Vibes&family=Grey+Qo&display=swap" rel="stylesheet">
    <link rel="icon" href="../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />

</head>
<body>
<div class="meusAnuncios">
    <h1>Planos de anúncio</h1>
    <h2>Escolha o plano certo para você!</h2>
    <br><br><br><br>

    <div class="plano">
        <form action="/ServletIdPlano" method="get" >
            <input type="hidden" name="plano" value="1">
            <button class="p1" type="submit">
                <img src="../../Imagens/ImagensPlanos/semideus.png" alt="" class="img1">
                <img src="../../Imagens/ImagensPlanos/semideusAzul.png" alt="" class="img2">
                <h2>Plano Semideus</h2>
                <br>
                <p>
                    Plano que te garante o direito a realização de um anúncio de baixo alcance em nosso aplicativo.
                </p><br>
                <h3>Por apenas: </h3>
                <h3>R$<%=String.format("%.2f", planoDAO.mostrarPlanos(1))%></h3>
            </button>
        </form>
        <div class="faixa1"></div>
        <div class="faixa2"></div>

        <form action="/ServletIdPlano" method="get">
            <input type="hidden" name="plano" value="2">
            <button class="p2" type="submit">
                <img src="../../Imagens/ImagensPlanos/deus.png" alt="" class="img1">
                <img src="../../Imagens/ImagensPlanos/deusAzul.png" alt="" class="img2">
                <h2>Plano Deus</h2><br>
                <p>
                    Plano que te garante o direito a realização de um anúncio de médio alcance em nosso aplicativo.
                </p>
                <br>
                <h3>Por apenas:</h3>
                <h3>R$<%=String.format("%.2f", planoDAO.mostrarPlanos(2))%></h3>
            </button>
        </form>
        <form action="/ServletIdPlano" method="get">
            <input type="hidden" name="plano" value="3">
            <button class="p3" type="submit">
                <img src="../../Imagens/ImagensPlanos/tita.png" alt="" class="img1">
                <img src="../../Imagens/ImagensPlanos/titaAzul.png" alt="" class="img2">
                <h2>Plano Titã</h2><br>
                <p>
                    Plano que te garante o direito a realização de um anúncio de alto alcance em nosso aplicativo.
                </p>
                <br>
                <h3>Por apenas:</h3>
                <h3>R$<%=String.format("%.2f", planoDAO.mostrarPlanos(3))%></h3>
            </button>
        </form>
    </div>
</div>
</body>
</html>
