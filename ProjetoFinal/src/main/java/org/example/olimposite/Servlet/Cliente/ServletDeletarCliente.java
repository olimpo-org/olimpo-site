package org.example.olimposite.Servlet.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.ClienteDAO;

import java.io.IOException;
@WebServlet(name = "ServletDeletarCliente", value = "/ServletDeletarCliente")
public class ServletDeletarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando id do botão HTML
        int id = Integer.parseInt(request.getParameter("id"));
        ClienteDAO clienteDAO = new ClienteDAO();
        // Executando os metodos e direcionando pra mesma pagina e ela atualizar e sumir a informação que foi deletada
        if (clienteDAO.deletarCliente(id)){
            response.sendRedirect("/JSP/CRUD/Mostrar/Cliente.jsp");
        }
    }
}
