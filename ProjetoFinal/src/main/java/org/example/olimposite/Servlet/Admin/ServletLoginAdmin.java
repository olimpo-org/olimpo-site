package org.example.olimposite.Servlet.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.AdminDAO;
import org.example.olimposite.Hash.Hash;

import java.io.IOException;
@WebServlet(name = "ServletLoginAdmin", value = "/ServletAdmin")
public class ServletLoginAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Pegando informações do HTML
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
//      Criando objeto classe DAO
        AdminDAO adminDAO = new AdminDAO();
//        Criando objeto classe HASH
        Hash hash = new Hash();
        String senhaHash = hash.gerarHash(senha);
//      Verificando se o usuario existem no banco
        if (adminDAO.verificarAdmin(usuario, senhaHash)==1){
//          Direcionando para área restrita
            response.sendRedirect("/JSP/CRUD/Mostrar/Cliente.jsp");
        }else {
//          Direcionando para tela de erro
            response.sendRedirect("/HTML/TelasDeErro/erroLoginAreaRestrita.html");

        }
    }
}
