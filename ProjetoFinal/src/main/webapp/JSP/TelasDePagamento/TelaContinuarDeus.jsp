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
    <title>Plano Deus</title>
    <link rel="stylesheet" href="../../CSS/TelasDePagamento/continuarPagamento.css">
    <link rel="icon" href="../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
</head>
<body>
<div class="faixa1"></div>
<div class="plano">
    <img src="../../Imagens/ImagensPagamento/planoDeus.png" alt="">
    <p>Plano de propaganda - DEUS</p>
    <h2>R$<%=String.format("%.2f",planoDAO.mostrarPlanos(2))%></h2>
</div>
<div class="descricao">
    <h1>Descrição</h1>
    <p>Plano de propaganda que te garante a criação de uma propaganda de médio alcance dentro do Olimpo.</p>
</div>
<h2>Selecione sua forma de pagamento: </h2>
<div class="formasPagamento">
    <a href="../../HTML/Pagamentos/cartaoCredito.html">
        <div class="forma">
            <img src="../../Imagens/ImagensPagamento/cartaoCredito.png" alt="" class="img1">
            <img src="../../Imagens/ImagensPagamento/cartaoCreditoAzul.png" alt="" class="img2">
            <p>Cartão de crédito</p>
        </div>
    </a>
    <a href="../../HTML/Pagamentos/telaDePix.html">
        <a href="../../HTML/Pagamentos/telaDePix.html" class="forma">
            <img src="../../Imagens/ImagensPagamento/pix.png" alt="" class="img1">
            <img src="../../Imagens/ImagensPagamento/pixAzul.png" alt="" class="img2">
            <p>PIX</p>
        </a>
    </a>
</div>
<div class="faixa2"></div>

</body>
</html>
