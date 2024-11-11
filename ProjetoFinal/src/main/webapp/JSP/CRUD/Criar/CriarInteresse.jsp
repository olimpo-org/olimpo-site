<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String mensagem ="";
    if(request.getAttribute("mensagem")!=null){
        mensagem = (String) request.getAttribute("mensagem");
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Criar/criarAdminAreaRestrita.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap"
            rel="stylesheet"
    />
    <link rel="icon" href="../../../Imagens/ImagensAreaRestrita/LogoOlimpo2.1.png" />
    <title>Criar Interesse</title>
</head>
<body>
<nav>
    <a
            href="../../../JSP/CRUD/Mostrar/Interesse.jsp"
    >
        <div id="logolimpo"><br /></div>
    </a>
</nav>

<img src="../../../Imagens/Predios.png" alt="" id="imgPredios">
<section>
    <h1>CADASTRAR INTERESSE</h1>
    <form action="/ServletCriarInteresse" method="post" >
        <input type="text" placeholder="Nome" name="nome" />
        <button type="submit" class="pronto">Cadastrar</button>
        <p class="result"><%=mensagem%></p>
    </form>
</section>
<img src="../../../Imagens/Casas.png" alt="" id="imgcasa">

</body>
</html>
