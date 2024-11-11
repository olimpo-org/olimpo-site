package org.example.olimposite.Servlet.Plano;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.EnderecoDAO;
import org.example.olimposite.DAO.PlanoDAO;

import java.io.IOException;

@WebServlet(name = "ServletAlterarPlano", value = "/ServletAlterarPlano")
public class ServletAlterarPlano extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando id do plano que será editado e o novo preço que irá pro banco
        int id = Integer.parseInt(request.getParameter("id"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        // Criando objeto planoDAO
        PlanoDAO planoDAO = new PlanoDAO();
        // Verificando se o preço é maior que 0
        if (preco > 0) {
            // Criando variavel de mensagem de retorno
            String mensagem = "";
            // Alterando preço no banco
            if (planoDAO.alterarPrecoPlano(preco, id)) {
                mensagem = "Atributo alterado com sucesso!";
            } else {
                mensagem = "Não foi possivel alterar o atributo.";
            }
            // Dispachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarPlano.jsp").forward(request, response);
        }else {
            // Dispachando a mensagem de retorno pra tela que o admin está
            request.setAttribute("mensagem", "O preço deve ser maior que 0! Digite corretamente.");
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarPlano.jsp").forward(request, response);
        }
    }
}
