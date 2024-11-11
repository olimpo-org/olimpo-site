<%@ page import="java.util.Stack" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Stack<String> pilhaErros = (Stack<String>) session.getAttribute("pilhaErros");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro</title>
    <link rel="stylesheet" href="../../CSS/TelasDeErro/erroRegex.css">
    <link rel="icon" href="../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png">
</head>
<body>

<img src="../../Imagens/ImagensErroAreaRestrita/enfeiteLadoEsquerdo.png" alt="" id="EnfeiteLadoEsquerdo">


<div class="telaErro">
    <div class="texto">
        <h1>ERRO </h1>
        <h2>Não foi possível realizar seu cadastro:</h2>
        <%
            while(!pilhaErros.isEmpty()){
        %>
        <p class="result"><%= pilhaErros.pop()%> </p>
        <%}%>
    </div>
    <div class="botoes">
        <a href="../Criar/CriarCliente.jsp" class="btn1">Tentar novamente</a>
    </div>
</div>


<img src="../../Imagens/ImagensErroAreaRestrita/enfeiteLadoDireito.png" alt=""  id="EnfeiteLadoDireito">
</body>
</html>