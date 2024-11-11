package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Modells.Admin;

import java.sql.SQLException;
import java.util.LinkedList;

public class AdminDAO {
    private ConexaoPrimeiro conexao;
    public AdminDAO(){
        this.conexao = new ConexaoPrimeiro();
    }
    public LinkedList<Admin> mostrarAdmin(){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id, usuario, senha FROM Admin WHERE isDeleted = false");
            conexao.rs = conexao.psmt.executeQuery();
//            Criando lista de admins
            LinkedList<Admin> admin = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String usuario = conexao.rs.getString(2);
                String senha = conexao.rs.getString(3);
//          Criando um objeto Admin e colocando na lista
                admin.add(new Admin(id, usuario, senha));
            }
            return admin;  //Retornando a lista
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    public int verificarAdmin(String user, String senha) {
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT * FROM Admin WHERE usuario = ? AND senha = ? AND isDeleted = false");
            conexao.psmt.setString(1, user);
            conexao.psmt.setString(2, senha);
            conexao.rs = conexao.psmt.executeQuery();

            if (conexao.rs.next()) {
                return 1; // Login correto
            } else {
                return -1; // Login incorreto
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public boolean deletarAdmin(int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Admin SET isDeleted = true WHERE id = ?");
            conexao.psmt.setInt(1, id);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterarAdmin(String campo, String informacao, int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE Admin SET "+ campo + " = ? , isUpdated = true WHERE id = ?");
            conexao.psmt.setString(1, informacao);
            conexao.psmt.setInt(2, id);
            return conexao.psmt.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    public boolean criarAdmin(String usuario, String senha){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Admin (id, usuario, senha) VALUES ((SELECT MAX(id)+1 FROM Admin),?,?)");
            conexao.psmt.setString(1, usuario);
            conexao.psmt.setString(2, senha);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
