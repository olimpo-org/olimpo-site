package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Conexao.ConexaoSegundo;

import java.sql.SQLException;

public class TelefoneDAO {
    private ConexaoSegundo conexao;
    public TelefoneDAO() {
        this.conexao = new ConexaoSegundo();
    }
    public boolean criarTelefone(String telefone, int idCliente){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Phone_Customer (phone, customer_id) values (?, ?)");
            conexao.psmt.setString(1, telefone);
            conexao.psmt.setInt(2, idCliente);
            return conexao.psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
}
