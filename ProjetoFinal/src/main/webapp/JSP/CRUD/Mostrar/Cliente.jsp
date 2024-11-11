<%@ page import="org.example.olimposite.DAO.ClienteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.olimposite.Modells.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cliente</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Mostrar/crud.css">
    <link rel="icon" href="../../../Imagens/ImagemEndereco/LogoBorda.png"/>
</head>
<body>
<nav class="navbar">
    <a href="../../../index.html"><div class="logo"></div></a>
    <h1 id="texto">Área Restrita</h1>
    <a href="../../CRUD/Criar/CriarCliente.jsp"><img src="../../../Imagens/ImagensAreaRestrita/More.png" alt="" class="add"></a>
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
        <h1>Cliente</h1>
        <div class="tabela">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>E-mail</th>
                    <th>  </th>
                </tr>
                <%
                    ClienteDAO clienteDAO = new ClienteDAO();
                    List<Cliente>  clienteAreaRestritas = clienteDAO.mostrarCliente();
                    if (clienteAreaRestritas != null && !clienteAreaRestritas.isEmpty()){
                        for (int i = 0; i < clienteAreaRestritas.size(); i++) {
                %>
                    <tr>
                        <td><%=clienteAreaRestritas.get(i).getId()%></td>
                        <td><%=clienteAreaRestritas.get(i).getName()%></td>
                        <td><%=clienteAreaRestritas.get(i).getSurname()%></td>
                        <td><%=clienteAreaRestritas.get(i).getEmail()%></td>
                        <td>
                            <div class="botoes-container">
                            <form action="/ServletDeletarCliente" method="post">
                                <input type="hidden" name="id" value="<%=clienteAreaRestritas.get(i).getId()%>" >
                                <button type="submit"><img src="../../../Imagens/ImagensAreaRestrita/Delete.png"></button>
                            </form>
                            </div>
                        </td>
                    </tr>
                <%      }
                    }else{ %>
                    <td colspan="5" class="no-results">Nenhum cliente encontrado.</td>
                <%}%>
            </table>
        </div>
    </div>
</section>
</body>
</html>