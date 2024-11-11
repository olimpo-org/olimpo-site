package org.example.olimposite.Servlet.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.AdminDAO;

import java.io.IOException;
@WebServlet(name = "ServletDeletarAdmin", value = "/ServletDeletarAdmin")
public class ServletDeletarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Pegando id da informação que será deletada no banco
        int id = Integer.parseInt(request.getParameter("id"));
//      Criando objeto classe DAO
        AdminDAO adminDAO = new AdminDAO();
//      Deletando do banco e direcionando para mesma tela para ela atualizar e mostrar que aquele registro não está mais lá
        if (adminDAO.deletarAdmin(id)){
            response.sendRedirect("/JSP/CRUD/Mostrar/Admin.jsp");
        }
    }
}
