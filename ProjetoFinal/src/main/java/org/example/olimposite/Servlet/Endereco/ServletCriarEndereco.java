package org.example.olimposite.Servlet.Endereco;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.ClienteDAO;
import org.example.olimposite.DAO.EnderecoDAO;
import org.example.olimposite.Modells.Cliente;

import java.io.IOException;

@WebServlet(name = "ServletCriarEndereco", value = "/ServletCriarEndereco")
public class ServletCriarEndereco extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Criando objeto HttpSession
        HttpSession session = request.getSession();
        // Pegando cpf do cliente da session
        String cpf = (String) session.getAttribute("cpfCliente");
        // Pegando informações dos campos HTML
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String bairro = request.getParameter("bairro");
        // Criando objeto clienteDAO
        ClienteDAO clienteDAO = new ClienteDAO();
        // Verificando se nunhuma das variaveis são apenas espaços ou nulos
        if (estado == null || municipio == null || bairro == null ||
                estado.trim().isEmpty() || municipio.trim().isEmpty() || bairro.trim().isEmpty()) {
            //direcionando tela de erro
            response.sendRedirect("/HTML/TelasDeErro/erroCadastro.html");
        } else {
            // Criando objeto EnderecoDAO
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            // Subindo as informações pro banco
            if (enderecoDAO.criarEndereco(estado, bairro, municipio, clienteDAO.mostrarID(cpf))) {
                response.sendRedirect("/HTML/TelasDeSucesso/cadastroSucesso.html");
            }else {
                // Caso não suba, direcionar para tela de erro
                response.sendRedirect("/HTML/TelasDeErro/erroCadastro.html");
            }
        }
    }
}