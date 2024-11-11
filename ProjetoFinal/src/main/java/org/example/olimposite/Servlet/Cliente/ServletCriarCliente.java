package org.example.olimposite.Servlet.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.ClienteDAO;
import org.example.olimposite.DAO.TelefoneDAO;
import org.example.olimposite.Regex.Regex;

import java.io.IOException;
import java.util.Stack;

@WebServlet(name = "ServletCriarCliente", value = "/ServletCliente")
public class ServletCriarCliente extends HttpServlet {
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
        // Imporantando objeto da classe Regex
        Regex regex = new Regex();
        // Verificando se nenhum campo é vazio ou é apenas um espaço
        if (nome == null || sobrenome == null || cpf == null || email == null || genero == null || senha == null || principalInteresse == null || telefone == null ||
                nome.trim().isEmpty() || sobrenome.trim().isEmpty() || cpf.trim().isEmpty() || email.trim().isEmpty() || genero.trim().isEmpty() || senha.trim().isEmpty()
        || principalInteresse.trim().isEmpty() || telefone.trim().isEmpty()){
            // Mandando pra tela de erro caso tenha campo nulo
            response.sendRedirect("/HTML/TelasDeErro/erroCadastro.html");
        }else {
            Stack <String> pilhaErros = regex.validar(email, senha, cpf, telefone); // mandando informações para serem verificadas na regex
            // Verificando se há algum erro de regex
            if (pilhaErros.isEmpty()){
                // Criando objeto clienteDAO
                ClienteDAO clienteDAO = new ClienteDAO();
                // Criando objeto telefoneDAO
                TelefoneDAO telefoneDAO = new TelefoneDAO();
                // Verificando se todas as informações de cadastro subiram pro banco
                if (clienteDAO.criarCliente(email, senha, nome, sobrenome, cpf, genero, principalInteresse)) {
                    if (telefoneDAO.criarTelefone(telefone,clienteDAO.mostrarID(cpf))){
                        // Criando objeto HttpSession
                        HttpSession session = request.getSession();
                        // Guardando cpf do cliente na session
                        session.setAttribute("cpfCliente", cpf);
                        // Mandando para tela de continuação do cadastro
                        response.sendRedirect("/HTML/TelasDeCadastro/criarEndereco.html");
                    }
                } else {
                    // Direcionando a tela de erro
                    response.sendRedirect("/HTML/TelasDeErro/erroCadastro.html");
                }
            }else{
                HttpSession session = request.getSession();
                // guardando pilha de erros na session
                session.setAttribute("pilhaErros", pilhaErros);
                response.sendRedirect("/JSP/ErroRegex/ErroRegexCadastro.jsp");
            }
        }
    }
}