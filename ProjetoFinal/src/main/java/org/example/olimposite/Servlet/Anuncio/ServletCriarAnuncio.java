package org.example.olimposite.Servlet.Anuncio;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.olimposite.DAO.AnuncioDAO;
import org.example.olimposite.Modells.ClienteDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@MultipartConfig
@WebServlet(name = "ServletCriarAnuncio", value = "/ServletCriarAnuncio")
public class ServletCriarAnuncio extends HttpServlet {
    public void init() throws ServletException {
        super.init();
        try {
            // Carregar o arquivo JSON usando ClassLoader, dentro do classpath
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("olimpo-56e63-firebase-adminsdk-8jbpv-fa60eeaa80.json");
            // InputStream é a classe java que representa uma sequencia de bytes
            // A classe InputStream permite é usada tambem para a leitura de diferente tipos de arquivo
            // Assim como ela é usada acima.

            if (serviceAccount == null) {
                throw new FileNotFoundException("Arquivo de credenciais não encontrado.");
            }

            // Inicializando firebase em uma aplicação java
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setStorageBucket("olimpo-56e63.appspot.com").build();
            // FirebaseOptions.builder(): inicia a construção de um objeto FirebaseOptions,
            // que contém as opções de configuração necessárias para conectar sua aplicação ao Firebase.
            // .setCredentials(GoogleCredentials.fromStream(serviceAccount)):
            // define as credenciais necessárias para autenticar sua aplicação com os serviços do Firebase
            // .setStorageBucket("olimpo-56e63.appspot.com"):  configura o bucket de armazenamento do Firebase
            // .build(): finaliza a instanciação desse objeto


            FirebaseApp.initializeApp(options);


        } catch (IOException e) {
            throw new ServletException("Erro ao inicializar Firebase", e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part imagem = request.getPart("imagem"); // "imagem" é o nome do campo no form HTML
        String nomeImagem = UUID.randomUUID().toString(); // Gerar um nome único

        // Upload da imagem para o Firebase Storage
        InputStream fileInputStream = imagem.getInputStream();
        String nomeBucket = FirebaseApp.getInstance().getOptions().getStorageBucket();

        StorageClient storageClient = StorageClient.getInstance();
        storageClient.bucket(nomeBucket).create("uploads/" + nomeImagem, fileInputStream, imagem.getContentType());

        // Gerar URL pública da imagem
        String imagemUrl = String.format("https://storage.googleapis.com/%s/uploads/%s", nomeBucket, nomeImagem);
        // Pegando informações dos campos HTML
        String titulo = request.getParameter("nome");
        String descricao  = request.getParameter("descricao");
        String idCategoria = request.getParameter("categoria");
        String preco = request.getParameter("preco");
        // Criando objeto HttpSession
        HttpSession session = request.getSession();
        // Pegando objeto da session
        ClienteDTO clienteDTO = (ClienteDTO) session.getAttribute("clienteDTO");
        // Pegando id do objeto
        String id = String.valueOf(clienteDTO.getIdCliente());

        // Criando objeto Anuncio com as informações fornecidas pelo usuario
        String [] infomacoes = new String[7];
        // Colocando informações no vetor
        infomacoes[0] = titulo;
        infomacoes[1] = descricao;
        infomacoes[2] = preco;
        infomacoes[3] = idCategoria;
        infomacoes[4] = imagemUrl;
        infomacoes[5] = id;
        session.setAttribute("informacoes", infomacoes);
        if (idCategoria.equals("2")){ // id de doação
            infomacoes[6] = "4";
            AnuncioDAO anuncioDAO = new AnuncioDAO();
            if (anuncioDAO.criarAnuncio(infomacoes)){
                response.sendRedirect("/JSP/PerfilUsuario.jsp");
            }else {
                response.sendRedirect("/HTML/TelasDeErro/erroAnuncio.html");
            }
        }else {
            response.sendRedirect("/JSP/Planos/Planos.jsp");
        }
    }
}