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
    <title>Plano</title>
    <link rel="icon" href="../../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Alterar/telaAlterarPlano.css">
</head>
<body>
<!-- Navbar -->
<div class="Navbar">
    <a href="../Mostrar/Plano.jsp"><img src="../../../Imagens/ImagensEditar/logoBranca.png" alt=""></a>
    <h1>Plano</h1>
</div>
<h1 class="Titulo1">Atributos da tabela anúncio:</h1>
<div class="atributos">
    <a href="../Mostrar/Plano.jsp"><img src="../../../Imagens/Predios.png" alt="" class="imgPredios"></a>
    <form class="atributoDescricao" action="/ServletAlterarPlano" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <label for="preco">Preço:</label>
        <input id="preco" name="preco"></input>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <img src="../../../Imagens/Casas.png" alt="" class="imgCasas">
</div>
<div class="result">
    <p><%=mensagem%></p>
</div>
</body>
</html>
