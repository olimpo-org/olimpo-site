package org.example.olimposite.Servlet.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.ClienteDAO;
import org.example.olimposite.DAO.TelefoneDAO;

import java.io.IOException;

@WebServlet(name = "ServletCriarClienteAreaRestrita", value = "/ServletCriarClienteAreaRestrita")
public class ServletCriarClienteAreaRestrita extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando informações de campo HTML
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String senha = request.getParameter("senha");
        String principalInteresse = request.getParameter("interesse");
        String telefone = request.getParameter("tel");
        // Verificando se nenhum campo é vazio ou é apenas um espaço
        if (nome == null || sobrenome == null || cpf == null || email == null || genero == null || senha == null || principalInteresse == null || telefone == null ||
                nome.trim().isEmpty() || sobrenome.trim().isEmpty() || cpf.trim().isEmpty() || email.trim().isEmpty() || genero.trim().isEmpty() || senha.trim().isEmpty()
                || principalInteresse.trim().isEmpty() || telefone.trim().isEmpty()){
            // Mandando pra tela de erro caso tenha campo nulo
            response.sendRedirect("/HTML/TelasDeCadastro/erroCadastro.html");
        }else {
            // Criando objeto clienteDAO
            ClienteDAO clienteDAO = new ClienteDAO();
            // Criando objeto telefoneDAO
            TelefoneDAO telefoneDAO = new TelefoneDAO();
            // Verificando se todas as informações subiram pro banco
            if (clienteDAO.criarCliente(email, senha, nome, sobrenome, cpf, genero, principalInteresse) && telefoneDAO.criarTelefone(telefone,clienteDAO.mostrarID(cpf))) {
                // Armazenando cpf do cliente na session
                HttpSession session = request.getSession();
                session.setAttribute("cpfCliente", cpf);
                // Direcionando a tela de continuação do cadastro do cliente
                response.sendRedirect("/HTML/TelasDeCadastro/criarEnderecoCliente.html");
            } else {
                // Caso não suba pro banco direcionando a tela de erro
                response.sendRedirect("/HTML/TelasDeErro/erroCadastroClienteAreaRestrita.html");
            }
        }
    }
}
