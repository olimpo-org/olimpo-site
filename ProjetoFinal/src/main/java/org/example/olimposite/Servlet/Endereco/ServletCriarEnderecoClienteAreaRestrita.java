package org.example.olimposite.Servlet.Endereco;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.ClienteDAO;
import org.example.olimposite.DAO.EnderecoDAO;

import java.io.IOException;

@WebServlet(name = "ServletCriarEnderecoCliente", value = "/ServletCriarEnderecoCliente")
public class ServletCriarEnderecoClienteAreaRestrita extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Criando objet HttpSession
        HttpSession session = request.getSession();
        // Pegando cpf do cliente que esta sendo criado da session
        String cpf = (String) session.getAttribute("cpfCliente");
        // Pegando informações dos campos HTML
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String bairro = request.getParameter("bairro");
        // Criando objeto clienteDAO
        ClienteDAO clienteDAO = new ClienteDAO();
        // Verificando se os campos não são nulos ou são apenas espaços
        if (estado == null || municipio == null || bairro == null ||
                estado.trim().isEmpty() || municipio.trim().isEmpty() || bairro.trim().isEmpty()) {
            // Direcionando para tela de errp
            response.sendRedirect("/HTML/erroCadastro.html");
        } else {
            // Criando objeto enderecoDAO
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            // Subindo informações pro banco
            if (enderecoDAO.criarEndereco(estado, bairro, municipio, clienteDAO.mostrarID(cpf))) {
                // Direcionando para tela de sucesso
                response.sendRedirect("/HTML/TelasDeSucesso/cadastroSucessoClienteAreaRestrita.html");
            }else {
                // Direcionando para tela de erro
                response.sendRedirect("/HTML/TelasDeErro/erroCadastro.html");
            }
        }
    }
}