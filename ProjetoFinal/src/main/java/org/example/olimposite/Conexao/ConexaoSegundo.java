package org.example.olimposite.Conexao;

import java.sql.*;

public class ConexaoSegundo {
    public Connection conn;
    public PreparedStatement psmt;
    public ResultSet rs;
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = System.getenv("DATABASE_URL2");
            String user = System.getenv("DATABASE_USER2");
            String password = System.getenv("PASSWORD2");

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
