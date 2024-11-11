package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Conexao.ConexaoSegundo;

import java.sql.SQLException;

public class EnderecoDAO{
    private ConexaoSegundo conexao;
    public EnderecoDAO(){
        this.conexao = new ConexaoSegundo();
    }
    public boolean criarEndereco(String estado, String bairro, String municipio, int idCliente){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("INSERT INTO Address (state, municipality , neighborhood, customer_id) VALUES (?,?,?,?)");
            conexao.psmt.setString(1, estado);
            conexao.psmt.setString(2, municipio);
            conexao.psmt.setString(3, bairro);
            conexao.psmt.setInt(4, idCliente);
            return conexao.psmt.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
