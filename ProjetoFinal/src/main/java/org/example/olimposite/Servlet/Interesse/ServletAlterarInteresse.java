package org.example.olimposite.Servlet.Interesse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.EnderecoDAO;
import org.example.olimposite.DAO.InteresseDAO;

import java.io.IOException;

@WebServlet(name = "ServletAlterarInteresse", value = "/ServletAlterarInteresse")
public class ServletAlterarInteresse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando informações dos campos HTML
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        // Criando objeto interesseDAO
        InteresseDAO interesseDAO = new InteresseDAO();
        // Verificando se a informção que irá subir pro banco não é nula ou apenas um espaço
        if (nome != null && !nome.trim().isEmpty()) {
            String mensagem = "";
            // Chamando metodo pra subir a nova informação pro banco
            if (interesseDAO.alterarInteresse(nome, id)) {
                mensagem = "Atributo alterado com sucesso!";
            } else {
                mensagem = "Não foi possivel alterar o atributo.";
            }
            // Despachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarInteresse.jsp").forward(request, response);
        }else {
            // Despachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", "Atributo vazio! Digite corretamente.");
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarInteresse.jsp").forward(request, response);
        }
    }
}
