<%@ page import="org.example.olimposite.DAO.CategoriaDAO" %>
<%@ page import="org.example.olimposite.Modells.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    List<Categoria> categorias = categoriaDAO.mostrarCategorias();
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0">
    <title>Anúncio</title>

    <link rel="stylesheet" href="../../CSS/TelasAnuncio/anuncio.css">
    <link rel="stylesheet" href="../../CSS/TelasAnuncio/anuncioMedia.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="icon" href="../../Imagens/ImagensLandingPage/LogoOlimpo2.1.png" />
</head>
<body>
<nav>
    <a
            href="../PerfilUsuario.jsp"
    >
        <div id="logolimpo"><br /></div>
    </a>
</nav>

<section class="dois">
    <div id="anuncio">

        <form action="/ServletCriarAnuncio" method="post" enctype="multipart/form-data">
            <div class="container forms">
                <h3>
                    Adicione informações do anúncio
                </h3>

                <input type="text" id="nome" placeholder="Nome" name="nome" required>

                <select name="categoria" required>
                    <option value="">Categorias</option>
                    <%
                        for (int i = 0; i < categorias.size(); i++) {
                            String categoria = categorias.get(i).getNome();
                            int id = categorias.get(i).getId();
                    %>
                    <option value="<%=id%>"><%=categoria%></option>
                    <%
                        }
                    %>
                </select>

                <input type="number" id="preco"  min="0" placeholder="Preço" name="preco" step="any" required>

                <textarea id="descricao" placeholder="Descrição" name="descricao" required></textarea>

                <button id="submitForm" class="btn" type="submit">
                    Avançar
                </button>
            </div>

            <div class="container image">
                <div id="visualizar" class="visualizar">
                    <input type="file" id="upload" accept="image/*" name="imagem">
                    <span id="prompt">
                            Faça upload de uma imagem
                        </span>
                </div>

                <div id="tamanho">
                    <p>Tamanho:</p>
                    <p>Máximo: 400 pixels</p>
                    <p>Mínimo: 300 pixels</p>
                </div>
            </div>
        </form>
    </div>
</section>
<script type="module" src="../../JavaScript/anuncio.js"></script>
</body>
</html>