package com.usjt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class obtemConexao {
    
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "db_pessoas";
    private static String usuario = "root";
    private static String senha = "root";
    
    Scanner sc = new Scanner(System.in);
    
    public static Connection Conectar() throws Exception{
        //1. montar a string de conexão
        String url = String.format(
            "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
            host, porta, db
                
        );
        System.out.println("Conexão efetuada com sucesso.");
        //2. estabelecer o canal de comunicação (conexão) com o SGBD (MySQL)
        return DriverManager.getConnection(url, usuario, senha);
    }
    }

