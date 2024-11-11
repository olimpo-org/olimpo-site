package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Modells.Interesse;

import java.sql.SQLException;
import java.util.LinkedList;

public class InteresseDAO {
    private ConexaoPrimeiro conexao;
    public InteresseDAO(){
        this.conexao = new ConexaoPrimeiro();
    }
    public boolean criarInteresse(String nome){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Interesse (id, nome) VALUES ((SELECT MAX(id)+1 FROM Interesse), ?)");
            conexao.psmt.setString(1, nome);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
    public boolean alterarInteresse(String nome, int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Interesse SET nome = ?, isUpdated = true WHERE id = ?");
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
    public boolean deletarInteresse(int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Interesse SET isDeleted = true WHERE id = ?");
            conexao.psmt.setInt(1, id);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public LinkedList<Interesse> mostrarInteresse(){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id, nome FROM Interesse WHERE isDeleted = false");
            conexao.rs = conexao.psmt.executeQuery();
//            Criando lista
            LinkedList<Interesse> interesses = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String nome = conexao.rs.getString(2);
//              Criando Objeto plano e colocando na lista
                interesses.add(new Interesse(id, nome));
            }
            return interesses; //retornando lista
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
