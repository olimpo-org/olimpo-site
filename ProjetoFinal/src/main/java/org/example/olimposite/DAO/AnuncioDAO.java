package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Conexao.ConexaoSegundo;
import org.example.olimposite.Modells.AnuncioDTO;

import java.sql.SQLException;
import java.util.LinkedList;

public class AnuncioDAO {
    private ConexaoSegundo conexao;
    public AnuncioDAO(){
        this.conexao = new ConexaoSegundo();
    }
    public boolean criarAnuncio(String [] informacoes){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Advertisement VALUES ((SELECT MAX(ID) + 1 FROM Advertisement), ?, ?, current_date, ?, ?, ?, ?, ?)");
            conexao.psmt.setString(1, informacoes[0]); //title
            conexao.psmt.setString(2, informacoes[1]); //description
            conexao.psmt.setDouble(3, Double.parseDouble(informacoes[2])); //price
            conexao.psmt.setInt(4, Integer.parseInt(informacoes[3])); //category_id
            conexao.psmt.setString(5, informacoes[4]); //imagemURL
            conexao.psmt.setInt(6, Integer.parseInt(informacoes[5])); //user_id
            conexao.psmt.setInt(7, Integer.parseInt(informacoes[6])); //id_plan
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();

        }
    }
    public LinkedList<AnuncioDTO> mostrarAnuncio(int idCliente){
        conexao.conectar();
        try { //se tiver serial posso tirar o id do insrete
            conexao.psmt = conexao.conn.prepareStatement("SELECT a.id, a.title, a.description, c.name, a.price, a.image FROM advertisement a JOIN customer b ON a.user_id = b.id JOIN category c ON a.category_id = c.id  WHERE a.user_id = ?");
            conexao.psmt.setInt(1, idCliente);
            conexao.rs = conexao.psmt.executeQuery();
            LinkedList<AnuncioDTO> anuncios = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String nomeProduto = conexao.rs.getString(2);
                String descricao = conexao.rs.getString(3);
                String categoria = conexao.rs.getString(4);
                double preco = conexao.rs.getDouble(5);
                String linkImagem = conexao.rs.getString(6);
                anuncios.add(new AnuncioDTO(id, nomeProduto, descricao, categoria, preco, linkImagem));
            }
            return anuncios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}