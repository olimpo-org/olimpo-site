<%@ page import="org.example.olimposite.Modells.ClienteDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteDTO clienteDTO = (ClienteDTO) session.getAttribute("clienteDTO");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/Perfil/perfil.css">
    <link rel="stylesheet" href="../CSS/Perfil/perfilResponse.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="../Imagens/ImagensPerfil/LogoOlimpo2.1.png">
    <title>Perfil</title>
</head>
<body>
<nav>
    <a href="Index.jsp">
        <div id="logolimpo"><br></div>
    </a>
    <a href="MeusAnuncios.jsp">
        <h3>Meus anúncios</h3>
        <span><br></span>
    </a>
    <a href="../JSP/Planos/PlanosNav.jsp">
        <h3>Planos</h3>
        <span><br></span>
    </a>
    <a href="Criar/CriarAnuncio.jsp">
        <h3>Criar anúncio</h3>
        <span><br></span>
    </a>
</nav>
<section id="ftnm">
    <img src="../Imagens/ImagensPerfil/ProfilePic.png" alt="">
    <div>
        <h2>Olá, <%=clienteDTO.getNome()%></h2>
        <h4>Publique seus anúncios no Olimpo!</h4>
    </div>
</section>
<section id="infos">
    <div>
        <h2>Informações do seu perfil:</h2>
        <span>
                <div class="container1">
                    <h4>Nome:</h4>
                    <h5><%=clienteDTO.getNome()%></h5>
                    <h4>Sobrenome:</h4>
                    <h5><%=clienteDTO.getSobrenome()%></h5>
                    <h4>Estado:</h4>
                    <h5><%=clienteDTO.getEstado()%></h5>
                </div>
                <div class="container2">
                    <h4>E-mail:</h4>
                    <h5><%=clienteDTO.getEmail()%></h5>
                    <h4>Telefone:</h4>
                    <h5><%=clienteDTO.getTelefone()%></h5>
                    <h4>Principal interesse:</h4>
                    <h5><%=clienteDTO.getPrincipal_interesse()%></h5>
                </div>
            </span>
    </div>
</section>
</body>
</html>