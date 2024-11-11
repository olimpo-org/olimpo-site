<%@ page import="java.util.List" %>
<%@ page import="org.example.olimposite.DAO.PlanoDAO" %>
<%@ page import="org.example.olimposite.Modells.Plano" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Plano</title>
    <link rel="stylesheet" href="../../../CSS/AreaRestrita/Mostrar/crud.css">
    <link rel="icon" href="../../../Imagens/ImagemEndereco/LogoBorda.png" />
</head>
<body>
<nav class="navbar">
    <a href="../../../index.html"><div class="logo"></div></a>
    <h1 id="texto">Área Restrita</h1>
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
        <h1>Plano</h1>
        <div class="tabela">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>  </th>
                </tr>
                <%
                    PlanoDAO planoDAO = new PlanoDAO();
                    List<Plano> planos = planoDAO.mostrarPlanos();
                    if (planos != null && !planos.isEmpty()){
                        for (int i = 0; i < planos.size(); i++) {
                %>
                <tr>
                    <td><%=planos.get(i).getId()%></td>
                    <td><%=planos.get(i).getNome()%></td>
                    <td><%=String.format("%.2f", planos.get(i).getPreco())%></td>
                    <td>
                        <div class="botoes-container">
                        <a href="../Alterar/AlterarPlano.jsp?id=<%=planos.get(i).getId()%>"><button><img src="../../../Imagens/ImagensAreaRestrita/Edit.png" alt=""></button></a>
                        </div>
                    </td>
                </tr>
                <%      }
                }else{ %>
                <td colspan="5" class="no-results">Nenhum plano encontrado.</td>
                <%}%>
            </table>
        </div>
    </div>
</section>
</body>
</html>