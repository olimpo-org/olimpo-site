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
    <title>Admin</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Alterar/telaAlterarAdmin.css">
    <link rel="icon" href="../../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
</head>
<body>
<div class="Navbar">
    <a href="../Mostrar/Admin.jsp"><img src="../../../Imagens/ImagensEditar/logoBranca.png" alt=""></a>
    <h1>Admin</h1>
</div>
<h1 class="Titulo1">Atributos da tabela Admin:</h1>
<div class="atributos">
    <a href="../Mostrar/Admin.jsp"><img src="../../../Imagens/Predios.png" alt="" class="imgPredios"></a>
    <form class="atributoNome" action="/ServletAlterarAdmin" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="usuario">
        <label for="user">User: </label>
        <input id="user" name="informacao"/>
        <button class="btnAlterar" type="submit">Alterar</button>
    </form>
    <form class="atributoSenha" action="/ServletAlterarAdmin" method="post">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="campo" value="senha">
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