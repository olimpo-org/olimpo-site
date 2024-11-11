<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String mensagem ="";
    if(request.getAttribute("mensagem")!=null){
        mensagem = (String) request.getAttribute("mensagem");
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cliente</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Alterar/telaEdicaoCliente.css">
    <link rel="icon" href="../../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
</head>
<body>
<!-- Navbar -->
<div class="Navbar">
    <a href="../Mostrar/Cliente.jsp"><img src="../../../Imagens/ImagensEditar/logoBranca.png" alt=""></a>
    <h1>Cliente</h1>
</div>
<h1 class="Titulo1">Atributos da tabela cliente:</h1>
<div class="atributos">
    <img src="../../../Imagens/Predios.png" alt="" class="imgPredios">
    <form class="atributoNome" action="/ServletAlterarCliente" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="name">
        <label for="nome">Nome: </label>
        <input class="nome" id="nome" name="informacao"></input>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <form class="atributoSobrenome" action="/ServletAlterarCliente" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="surname">
        <label for="sobrenome">Sobrenome:</label>
        <input class="sobrenome" id="sobrenome" name="informacao"></input>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <form class="atributoEmail" action="/ServletAlterarCliente" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="email">
        <label for="email">Email:</label>
        <input id="email" name="informacao"></input>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <form class="atributoSenha" action="/ServletAlterarCliente" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="password">
        <label for="senha">Senha:</label>
        <input id="senha" name="informacao"></input>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <img src="../../../Imagens/Casas.png" alt="" class="imgCasas">
</div>
<div class="result">
    <p><%=mensagem%></p>
</div>
</body>
</html>