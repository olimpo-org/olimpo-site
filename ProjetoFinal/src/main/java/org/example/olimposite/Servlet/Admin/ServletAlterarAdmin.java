package org.example.olimposite.Servlet.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.AdminDAO;
import org.example.olimposite.Hash.Hash;

import java.io.IOException;
@WebServlet(name = "ServletAlterarAdmin", value = "/ServletAlterarAdmin")
public class ServletAlterarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Pegando informações do HTML
        int id = Integer.parseInt(request.getParameter("id"));
        String campo = request.getParameter("campo");
        String informacao = request.getParameter("informacao");
//      Verificando se não estão vazias
        if (informacao != null && !informacao.trim().isEmpty()) {
//          Criando objeto classe DAO
            AdminDAO adminDAO = new AdminDAO();
            String mensagem = "";
            if (campo.equals("senha")){
                Hash hash = new Hash();
                informacao = hash.gerarHash(informacao);
            }
//          Chamando metodo para alterar no banco
            if (adminDAO.alterarAdmin(campo, informacao, id)) {
                mensagem = "Atributo alterado com sucesso!";
            } else {
                mensagem = "Não foi possivel alterar o atributo";
            }
//          Enviando mensagem pro usuario
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarAdmin.jsp").forward(request, response);
        } else {
//          Enviando mensagem pro usuario
            request.setAttribute("mensagem", "Atributo vazio! Digite corretamente.");
            request.getRequestDispatcher("/JSP/CRUD/Alterar/AlterarAdmin.jsp").forward(request, response);
        }
    }
}
