package org.example.olimposite.Servlet.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.CategoriaDAO;

import java.io.IOException;

@WebServlet(name = "ServletDeletarCategoria", value = "/ServletDeletarCategoria")
public class ServletDeletarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando id do telefone que será deletado
        int id = Integer.parseInt(request.getParameter("id"));
        // Criando objeto CategoriaDAO
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        // Deletando do banco e redirecionando para mesma pagina para ela atualizar
        if(categoriaDAO.deletarCategoria(id)){
            response.sendRedirect("/JSP/CRUD/Mostrar/Categoria.jsp");
        }
    }
}
