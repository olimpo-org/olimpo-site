<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%int id = Integer.parseInt(request.getParameter("id"));
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
    <title>Categoria</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Alterar/telaAlterarCategoria.css">
    <link rel="icon" href="../../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
</head>
<body>
<div class="Navbar">
    <a href="../Mostrar/Categoria.jsp"><img src="../../../Imagens/ImagensEditar/logoBranca.png" alt=""></a>
    <h1>Telefone</h1>
</div>
<h1 class="Titulo1">Atributos da tabela Telefone:</h1>
<div class="atributos">
    <img src="../../../Imagens/Predios.png" alt="" class="imgPredios">
    <form class="atributoNome" action="/ServletAlterarCategoria" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <label for="nome">Nome: </label>
        <input id="nome" name="nome">
        <button class="btnAlterar">Alterar</button>
    </form>
    <img src="../../../Imagens/Casas.png" alt="" class="imgCasas">
</div>
<div class="result">
    <p><%=mensagem%></p>
</div>
</body>
</html>
