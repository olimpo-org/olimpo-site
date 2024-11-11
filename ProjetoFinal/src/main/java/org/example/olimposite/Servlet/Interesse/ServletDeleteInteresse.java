package org.example.olimposite.Servlet.Interesse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.EnderecoDAO;
import org.example.olimposite.DAO.InteresseDAO;

import java.io.IOException;

@WebServlet(name = "ServletDeletarInteresse", value = "/ServletDeletarInteresse")
public class ServletDeleteInteresse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando id da informação que vai ser deletada
        int id = Integer.parseInt(request.getParameter("id"));
        // Criando objeto InteresseDAO
        InteresseDAO interesseDAO = new InteresseDAO();
        // Deletando do banco
        if(interesseDAO.deletarInteresse(id)){
            // Redirecionando para atualizar a pagina
            response.sendRedirect("/JSP/CRUD/Mostrar/Interesse.jsp");
        }
    }
}
