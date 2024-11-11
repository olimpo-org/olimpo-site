<%@ page import="org.example.olimposite.DAO.CategoriaDAO" %>
<%@ page import="org.example.olimposite.Modells.Telefone" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.olimposite.Modells.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Categoria</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Mostrar/crud.css">
    <link rel="icon" href="../../../Imagens/ImagemEndereco/LogoBorda.png"/>
</head>
<body>
<nav class="navbar">
    <a href="../../../index.html"><div class="logo"></div></a>
    <h1 id="texto">Área Restrita</h1>
    <a href="../Criar/CriarCategoria.jsp"><img src="../../../Imagens/ImagensAreaRestrita/More.png" alt="" class="add"></a>
</nav>
<section class="corpo">
    <div class="div-lateral">
        <a href="Cliente.jsp"><button>Cliente</button></a>
        <a href="Plano.jsp"><button>Plano</button></a>
        <a href="Categoria.jsp"><button>Categoria</button></a>
        <a href="Interesse.jsp"><button>Interesse</button></a>
        <a href="Admin.jsp"><button>Admin</button></a>
    </div>
    <div class="div-table">
        <h1>Categoria</h1>
        <div class="tabela">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>

                    <th>  </th>
                </tr>
                <%
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    List<Categoria> categorias = categoriaDAO.mostrarCategorias();
                    if (categorias != null && !categorias.isEmpty() ){
                        for (int i = 0; i < categorias.size(); i++) {
                %>
                <tr>
                    <td><%=categorias.get(i).getId()%></td>
                    <td><%=categorias.get(i).getNome()%></td>
                    <td>
                        <div class="botoes-container">
                        <form action="/ServletDeletarCategoria" method="post">
                            <input type="hidden" name="id" value="<%=categorias.get(i).getId()%>">
                            <button type="submit"><img src="../../../Imagens/ImagensAreaRestrita/Delete.png"></button>
                        </form>
                            <a href="../Alterar/AlterarCategoria.jsp?id=<%=categorias.get(i).getId()%>"><button><img src="../../../Imagens/ImagensAreaRestrita/Edit.png" alt=""></button></a>
                        </div>
                    </td>

                </tr>
                <%      }
                }else{ %>
                <td colspan="4" class="no-results">Nenhuma categoria encontrada.</td>
                <%}%>
            </table>
        </div>
    </div>
</section>
</body>
</html>