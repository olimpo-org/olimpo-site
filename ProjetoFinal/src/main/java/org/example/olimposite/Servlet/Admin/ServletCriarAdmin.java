package org.example.olimposite.Servlet.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.olimposite.DAO.AdminDAO;
import org.example.olimposite.Hash.Hash;

import java.io.IOException;
@WebServlet(name = "ServletCriarAdmin", value = "/ServletCriarAdmin")
public class ServletCriarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Peganddo informações do HTML
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
//      Criando objeto classe DAO
        AdminDAO adminDAO = new AdminDAO();
//      Criando objeto classe HASH
        Hash hash = new Hash();
        String senhaHash = hash.gerarHash(senha);
//      Criando variavel de mensagem de retorno pro usuario
        String mensagem = "";
//      Verificando se não atributos vazios
        if (usuario != null && senhaHash != null && !usuario.trim().isEmpty() && !senha.trim().isEmpty()) {
            if (adminDAO.criarAdmin(usuario, senhaHash)) {
//              Mandando para tela de sucesso
                response.sendRedirect("/HTML/TelasDeSucesso/cadastroSucessoAdmin.html");
            } else {
//              Enviando mensagem pro usuario
                mensagem = "Não foi possivel criar esse Admin";
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/JSP/CRUD/Criar/CriarAdmin.jsp").forward(request, response);
            }
        }else {
//          Enviando mensagem pro usuario
            mensagem = "Erro! Algum campo está vazio!";
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("/JSP/CRUD/Criar/CriarAdmin.jsp").forward(request, response);
        }
    }
}
