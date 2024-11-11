package org.example.olimposite.Servlet.Interesse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.EnderecoDAO;
import org.example.olimposite.DAO.InteresseDAO;

import java.io.IOException;

@WebServlet(name = "ServletCriarInteresse", value = "/ServletCriarInteresse")
public class ServletCriarInteresse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando informções campo HTML
        String nome = request.getParameter("nome");
        // Criando objeto InteresseDAO
        InteresseDAO interesseDAO = new InteresseDAO();
        // Criando variavel de retorno pro usuario
        String mensagem;
        // Verificando se os campos não estão nulos ou são só espaços
        if (nome != null && !nome.trim().isEmpty()) {
            // Chamando metodo para subir as informações pro banco
            if (interesseDAO.criarInteresse(nome)) {
                // Direcionando para tela de sucesso
                response.sendRedirect("/HTML/TelasDeSucesso/cadastroSucessoInteresse.html");
            } else {
                // Despachando mensagem de retorno de erros ao admin
                mensagem = "Não foi possivel cadastrar esse interesse";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/JSP/CRUD/Criar/CriarInteresse.jsp").forward(request, response);
            }
        }else {
            // Despachando mensagem de retorno de erros ao admin
            mensagem = "Erro! Algum campo está vazio ou inválido!";
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Criar/CriarInteresse.jsp").forward(request, response);
        }
    }
}
