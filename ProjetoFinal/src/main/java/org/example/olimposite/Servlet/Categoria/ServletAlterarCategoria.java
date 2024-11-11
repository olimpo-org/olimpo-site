package org.example.olimposite.Servlet.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.CategoriaDAO;
import org.example.olimposite.DAO.InteresseDAO;
import org.example.olimposite.DAO.TelefoneDAO;

import java.io.IOException;

@WebServlet(name = "ServletAlterarCategoria", value = "/ServletAlterarCategoria")
public class ServletAlterarCategoria extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando informações dos campos HTML
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        // Criando objeto categoriaDAO
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        // Verificando se a informção que irá subir pro banco não é nula ou apenas um espaço
        if (nome != null && !nome.trim().isEmpty()) {
            String mensagem = "";
            // Chamando metodo pra subir a nova informação pro banco
            if (categoriaDAO.alterarCategoria(nome, id)) {
                mensagem = "Atributo alterado com sucesso!";
            } else {
                mensagem = "Não foi possivel alterar o atributo.";
            }
            // Despachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarCategoria.jsp").forward(request, response);
        }else {
            // Despachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", "Atributo vazio! Digite corretamente.");
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarCategoria.jsp").forward(request, response);
        }
    }
}
