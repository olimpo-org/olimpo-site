package org.example.olimposite.Servlet.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.ClienteDAO;
import org.example.olimposite.Modells.ClienteDTO;

import java.io.IOException;

@WebServlet(name = "ServletLoginCliente", value = "/ServletLogin")
public class ServletLoginCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura os parâmetros do formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Validação para campos vazios
        if (email == null || senha == null || email.trim().isEmpty() || senha.trim().isEmpty()) {
            response.sendRedirect("/HTML/TelasDeErro/erroLogin.html");
            return; // Adicionando return para finalizar a execução após o redirecionamento
        }

        // Criando objeto clienteDAO e verificando as credenciais do cliente
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteDTO clienteDTO = clienteDAO.verificarLoginCliente(email, senha);

        // Se o login for nulo, redireciona para a página de erro
        if (clienteDTO == null) {
            response.sendRedirect("/HTML/TelasDeErro/erroLogin.html");
        } else {
            // Definindo o login na sessão para garantir que persista entre redirecionamentos
            HttpSession session = request.getSession();
            session.setAttribute("clienteDTO", clienteDTO);

            // Encaminha a requisição para o JSP
            request.getRequestDispatcher("/JSP/Index.jsp").forward(request, response);
        }
    }
}
