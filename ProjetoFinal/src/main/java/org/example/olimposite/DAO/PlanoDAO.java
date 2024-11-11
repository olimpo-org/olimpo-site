package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoPrimeiro;
import org.example.olimposite.Modells.Plano;

import java.sql.SQLException;
import java.util.LinkedList;

public class PlanoDAO {
    private ConexaoPrimeiro conexao;
    public PlanoDAO(){
        this.conexao = new ConexaoPrimeiro();
    }
    public boolean alterarPrecoPlano(double informacao, int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("UPDATE plano SET valor = ?, isUpdated = true WHERE id = ?");
            conexao.psmt.setDouble(1, informacao);
            conexao.psmt.setInt(2, id);
            return conexao.psmt.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    public LinkedList<Plano> mostrarPlanos(){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id, nome, valor FROM plano WHERE isDeleted = false");
            conexao.rs = conexao.psmt.executeQuery();
//            Criando lista
            LinkedList<Plano> planos = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String nome = conexao.rs.getString(2);
                double preco = conexao.rs.getDouble(3);
//              Criando Objeto plano e colocando na lista
                planos.add(new Plano(id, nome, preco));
            }
            return planos; //retornando lista
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    public double mostrarPlanos(int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT valor FROM plano WHERE isDeleted = false and id = ?");
            conexao.psmt.setInt(1, id);
            conexao.rs = conexao.psmt.executeQuery();
            double preco;
            if (conexao.rs.next()) {
                preco = conexao.rs.getDouble(1);
                return preco; //retornando preço
            }else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
}
