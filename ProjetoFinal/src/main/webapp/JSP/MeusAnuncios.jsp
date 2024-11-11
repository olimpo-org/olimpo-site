<%@ page import="org.example.olimposite.DAO.AnuncioDAO" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="org.example.olimposite.Modells.AnuncioDTO" %>
<%@ page import="org.example.olimposite.Modells.ClienteDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AnuncioDAO anuncioDAO = new AnuncioDAO();
    ClienteDTO login = (ClienteDTO) session.getAttribute("clienteDTO");
    LinkedList<AnuncioDTO> anuncios = anuncioDAO.mostrarAnuncio(login.getIdCliente());
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../CSS/TelasAnuncio/meusAnuncios.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="../Imagens/ImagensLoginAreaRestrita/LogoOlimpo2.1.png">
    <title>Meus Anúncios</title>
</head>
<body>
<nav>
    <a href="../JSP/PerfilUsuario.jsp">
        <div id="logolimpo"><br></div>
    </a>
    <a href="#">
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

<h1 class="tituloPropaganda">Meus anúncios</h1>
<div class="faixa1"></div>
<div class="faixa2"></div>
<div class="propagandas">
    <%
        if (anuncios != null && !anuncios.isEmpty()){
            for (int i = 0; i < anuncios.size(); i++) {
    %>
    <div class="p1">
        <img src="<%=anuncios.get(i).getLinkImagem()%>" alt="">
        <h2><%=anuncios.get(i).getTitulo()%></h2>
        <%if (anuncios.get(i).getCategoria().equals("Venda") || anuncios.get(i).getCategoria().equals("Serviço")){%>
        <p>R$<%=String.format("%.2f", anuncios.get(i).getPreco())%></p>
        <%
            }else {
        %>
        <p><%=anuncios.get(i).getCategoria()%></p>
        <%
            }
        %>
    </div>
    <%
            }
        }else{
    %>
    <div class="div-result">
    <h1 class="no-result">Nenhum anúncio encontrado</h1>
    </div>
    <%
        }
    %>
</div>
</body>
</html>