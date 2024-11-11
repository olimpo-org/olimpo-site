<%@ page import="org.example.olimposite.DAO.InteresseDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.olimposite.Modells.Endereco" %>
<%@ page import="org.example.olimposite.Modells.Interesse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Interesse</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Mostrar/crud.css">
    <link rel="icon" href="../../../Imagens/ImagemEndereco/LogoBorda.png"/>
</head>
<body>
<nav class="navbar">
    <a href="../../../index.html"><div class="logo"></div></a>
    <h1 id="texto">Área Restrita</h1>
    <a href="../Criar/CriarInteresse.jsp"><img src="../../../Imagens/ImagensAreaRestrita/More.png" alt="" class="add"></a>
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
        <h1>Interesse</h1>
        <div class="tabela">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>  </th>
                </tr>
                <%
                    InteresseDAO interesseDAO = new InteresseDAO();
                    List<Interesse> interesses = interesseDAO.mostrarInteresse();
                    if (interesses != null && !interesses.isEmpty()){
                        for (int i = 0; i < interesses.size(); i++) {
                %>
                <tr>
                    <td><%=interesses.get(i).getId()%></td>
                    <td><%=interesses.get(i).getNome()%></td>

                    <td>
                        <div class="botoes-container">
                        <form action="/ServletDeletarInteresse" method="post">
                            <input type="hidden" name="id" value="<%=interesses.get(i).getId()%>" >
                            <button type="submit"><img src="../../../Imagens/ImagensAreaRestrita/Delete.png"></button>
                        </form>
                        <a href="../Alterar/AlterarInteresse.jsp?id=<%=interesses.get(i).getId()%>"><button><img src="../../../Imagens/ImagensAreaRestrita/Edit.png" alt=""></button></a>
                        </div>
                    </td>
                </tr>
                <%      }
                }else{ %>
                <td colspan="5" class="no-results">Nenhum interesse encontrado.</td>
                <%}%>

            </table>
        </div>
    </div>
</section>
</body>
</html>