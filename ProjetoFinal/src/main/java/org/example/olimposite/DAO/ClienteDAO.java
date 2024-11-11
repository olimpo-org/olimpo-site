package org.example.olimposite.DAO;

import org.example.olimposite.Conexao.ConexaoSegundo;
import org.example.olimposite.Modells.Cliente;
import org.example.olimposite.Modells.ClienteDTO;

import java.sql.SQLException;
import java.util.LinkedList;

public class ClienteDAO {
    private ConexaoSegundo conexao;
    public ClienteDAO() {
        this.conexao = new ConexaoSegundo();
    }
    public boolean criarCliente(String email, String senha, String nome, String sobrenome, String cpf, String genero, String principalInteresse) {
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("CALL insert_customer(?, ?, ?, ?, ?, ?, ?, null)");
            conexao.psmt.setString(1, email);
            conexao.psmt.setString(2, senha);
            conexao.psmt.setString(3, nome);
            conexao.psmt.setString(4, sobrenome);
            conexao.psmt.setString(5, cpf);
            conexao.psmt.setString(6, genero);
            conexao.psmt.setString(7, principalInteresse);
            conexao.psmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }


    //    Selecionando ID do cliente pelo CPF, pois CPF é único
    public int mostrarID(String cpf) {
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id FROM customer WHERE cpf = ?");
            conexao.psmt.setString(1, cpf);
            conexao.rs = conexao.psmt.executeQuery();
            int numID;
            if (conexao.rs.next()) {
                numID = conexao.rs.getInt(1);
                return numID;
            }else{
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }
    public LinkedList<Cliente> mostrarCliente(){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT id,  email, password, name, surname, cpf, gender_id, interest_id FROM customer");
            conexao.rs = conexao.psmt.executeQuery();
//            Criando Lista
            LinkedList<Cliente> clientes = new LinkedList<>();
            while (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String email = conexao.rs.getString(2);
                String senha = conexao.rs.getString(3);
                String nome = conexao.rs.getString(4);
                String sobrenome = conexao.rs.getString(5);
                String cpf = conexao.rs.getString(6);
                int genero = conexao.rs.getInt(7);
                int interesse = conexao.rs.getInt(8);
//                 Criando Objeto e colocando na lista
                clientes.add(new Cliente(id, email, senha, nome, sobrenome, cpf, genero, interesse));
            }
            return clientes; //retornando lista
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
    public boolean deletarCliente(int id){
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("CALL delete_customer(?)");
            conexao.psmt.setInt(1, id);
            conexao.psmt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public ClienteDTO verificarLoginCliente(String email, String senha) {
        conexao.conectar();
        try {
            conexao.psmt = conexao.conn.prepareStatement("SELECT c.id, c.name, c.surname, i.name, p.phone, a.state FROM Customer c JOIN phone_customer p ON c.id = p.customer_id JOIN address a ON c.id = a.customer_id  JOIN interest i ON c.interest_id = i.id WHERE c.email = ? AND c.password = ?");
            conexao.psmt.setString(1, email);
            conexao.psmt.setString(2, senha);
            conexao.rs = conexao.psmt.executeQuery();
            if (conexao.rs.next()) {
                int id = conexao.rs.getInt(1);
                String nome = conexao.rs.getString(2);
                String sobrenome = conexao.rs.getString(3);
                String interesse = conexao.rs.getString(4);
                String telefone = conexao.rs.getString(5);
                String estado = conexao.rs.getString(6);
                return new ClienteDTO(id, nome, sobrenome, email, interesse, telefone, estado);
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}