<%@ page import="org.example.olimposite.DAO.AdminDAO" %>
<%@ page import="org.example.olimposite.Modells.Admin" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Mostrar/crud.css">
    <link rel="icon" href="../../../Imagens/ImagemEndereco/LogoBorda.png" />
</head>
<body>
<nav class="navbar">
    <a href="../../../index.html"><div class="logo"></div></a>
    <h1 id="texto">Área Restrita</h1>
    <a href="../Criar/CriarAdmin.jsp"><img src="../../../Imagens/ImagensAreaRestrita/More.png" alt="" class="add"></a>
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
        <h1>Admin</h1>
        <div class="tabela">
            <table>
                <tr>
                    <th>ID</th>
                    <th>User</th>
                    <th>Senha</th>

                    <th>  </th>
                </tr>
                <%
                    AdminDAO adminDAO = new AdminDAO();
                    List<Admin> admins = adminDAO.mostrarAdmin();
                    if (admins != null && !admins.isEmpty()){
                        for (int i = 0; i < admins.size(); i++) {
                %>
                <tr>
                    <td><%=admins.get(i).getId()%></td>
                    <td><%=admins.get(i).getUsuario()%></td>
                    <td><%=admins.get(i).getSenha()%></td>

                    <td>
                        <div class="botoes-container">
                        <form action="/ServletDeletarAdmin" method="post">
                            <input type="hidden" name="id" value="<%=admins.get(i).getId()%>" >
                            <button type="submit"><img src="../../../Imagens/ImagensAreaRestrita/Delete.png"></button>
                        </form>
                            <a href="../Alterar/AlterarAdmin.jsp?id=<%= admins.get(i).getId() %>"><button type="button"><img src="../../../Imagens/ImagensAreaRestrita/Edit.png" alt=""></button></a>
                        </div>
                    </td>
                </tr>
                <%      }
                }else{ %>
                <td colspan="4" class="no-results">Nenhum administrador encontrado.</td>
                <%}%>
            </table>
        </div>
    </div>
</section>
</body>
</html>