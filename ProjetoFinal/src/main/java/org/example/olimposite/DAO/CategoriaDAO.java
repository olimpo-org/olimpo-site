package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Modells.Categoria;

import java.sql.SQLException;
import java.util.LinkedList;

public class CategoriaDAO {
    private ConexaoPrimeiro conexao;
    public CategoriaDAO(){
        this.conexao = new ConexaoPrimeiro();
    }
    public boolean criarCategoria(String nome){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Categoria (id, nome) VALUES ((SELECT MAX(id)+1 FROM Categoria), ?)");
            conexao.psmt.setString(1, nome);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
    public boolean alterarCategoria(String nome, int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Categoria SET nome = ?, isUpdated = true WHERE id = ?");
            conexao.psmt.setString(1, nome);
            conexao.psmt.setInt(2, id);
            return conexao.psmt.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    public boolean deletarCategoria(int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Categoria SET isDeleted = true WHERE id = ?");
            conexao.psmt.setInt(1, id);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public LinkedList<Categoria> mostrarCategorias(){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id, nome FROM Categoria WHERE isDeleted = false");
            conexao.rs = conexao.psmt.executeQuery();
//            Criando lista
            LinkedList<Categoria> categorias = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String nome = conexao.rs.getString(2);
//              Criando Objeto plano e colocando na lista
                categorias.add(new Categoria(id, nome));
            }
            return categorias; //retornando lista
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
