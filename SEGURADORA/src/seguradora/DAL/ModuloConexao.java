/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguradora.DAL;

import java.sql.*;
    
/**
 *
 * 
 */
public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao = null;
        // as linhas abaixo serve para  chamar o DRIVER 
        String url = "jdbc:mysql://localhost:3306/seguradora?characterEncoding=utf-8";
        String user = "root_";
        String password = "123@ERICKSOUSA";

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
