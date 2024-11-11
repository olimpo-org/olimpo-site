package org.example.olimposite.Servlet.Anuncio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.olimposite.DAO.AnuncioDAO;

import java.io.IOException;

@WebServlet(name = "ServletIdPlano", value = "/ServletIdPlano")
public class ServletIdPlano extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o id do plano de acordo com o botão que ele clicou
        String idPlano =  request.getParameter("plano");
        // Criando objeto HttpSession
        HttpSession session = request.getSession();
        // Pegando link da imagem na sessão
        String[] informacoes = (String []) session.getAttribute("informacoes");
        // Criando objeto AnuncioDAO
        AnuncioDAO anuncioDAO = new AnuncioDAO();
        // colocando id plano no vetor
        informacoes[6] = idPlano;
        // Subindo anuncio pro banco
        if (anuncioDAO.criarAnuncio(informacoes)){
            if (idPlano.equals("1")) {
                response.sendRedirect("/JSP/TelasDePagamento/TelaContinuarSemideus.jsp");
            } else if (idPlano.equals("2")) {
                response.sendRedirect("/JSP/TelasDePagamento/TelaContinuarDeus.jsp");
            } else {
                response.sendRedirect("/JSP/TelasDePagamento/TelaContinuarTita.jsp");
            }
        }
    }
}

