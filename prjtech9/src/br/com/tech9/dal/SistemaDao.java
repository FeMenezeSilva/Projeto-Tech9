/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tech9.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SistemaDao {

    private Connection conectado;
    private PreparedStatement st;
    private ResultSet resultado;

    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdtech9", "root", "07032003Fe#");
    }

    public ResultSet validarUsuario(String usuario, String senha) throws SQLException, ClassNotFoundException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM tbusuarios WHERE usuario = ? AND senha = ?");
        st.setString(1, usuario);
        st.setString(2, senha);
        resultado = st.executeQuery();
        return resultado;
    }
    public ResultSet listarProdutos() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM produto ORDER BY nome DESC");
        resultado = st.executeQuery();
        return resultado;
    }
    public void salvarUsuario(String u, String s, String n, String c) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO tbusuarios VALUES(?,?,?,?)");
        st.setString(1, u);
        st.setString(2, s);
        st.setString(3, n);
        st.setString(4, c);
        st.executeUpdate();
    }
      public ResultSet buscarUsuario(String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM tbusuarios WHERE usuario = ?");
        st.setString(1, u);
        resultado = st.executeQuery();
        return resultado;
    }
      public ResultSet buscarProduto(String p) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("SELECT * FROM produto WHERE idproduto = ?");
        st.setString(1, p);
        resultado = st.executeQuery();
        return resultado;
    }
      public void excluirUsuario(String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM tbusuarios WHERE usuario = ?");
        st.setString(1, u);
        st.executeUpdate(); //INSERT, UPDATE, DELETE
    }
      
      public void salvarProduto(String id, String n, String q, String p) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("INSERT INTO produto VALUES(?,?,?,?)");
        st.setString(1, id);
        st.setString(2, n);
        st.setString(3, p);
        st.setString(4, q);
        st.executeUpdate();
    }
      public void excluirProduto(String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("DELETE FROM produto WHERE idproduto = ?");
        st.setString(1, u);
        st.executeUpdate(); //INSERT, UPDATE, DELETE
    }
      public void alterarProduto(String id, String n, String p, String q) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE produto SET nome = ?, preco = ?, quantidade = ? WHERE idproduto = ?");
        st.setString(1, n);
        st.setString(2, p);
        st.setString(3, q);
        st.setString(4, id);
        st.executeUpdate();
    }
      public void alterarUsuario(String s, String n, String c, String u) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectado.prepareStatement("UPDATE tbusuarios SET nome = ?, senha = ?, cargo = ? WHERE usuario = ?");
        st.setString(1, n);
        st.setString(2, s);
        st.setString(3, c);
        st.setString(4, u);
        st.executeUpdate();
    }
    
}
