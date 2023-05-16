/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author erica
 */
public class Usuario {
    private String login, senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario() {

    }
    
        public void inserir (){
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_login(usuario, senha) VALUES (?, ?)";
        //2: Abrir uma conexão
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, login);
            ps.setString(2, senha);
            //5: Executa o comando
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
    
    public void atualizar (){
        String sql = "UPDATE tb_pessoa SET senha = ? WHERE usuario = ?";
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, senha);
            ps.setString(2, login);
            ps.execute();
            JOptionPane.showMessageDialog(null, login + "alterado com sucesso!!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM tb_pessoa WHERE usuario = ?";
        obtemConexao factory = new obtemConexao();
                try (Connection c = factory.Conectar()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, login);
        ps.execute();
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }
    
    public boolean Entrar(Usuario usuario){
    //1: Definir o comando SQL
    String sql = "Select * FROM tb_login WHERE usuario = ? and senha = ?";
    //2: Abrir uma conexão
    obtemConexao factory = new obtemConexao();
    try (Connection c = factory.Conectar()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, login);     
        ps.setString(2, senha);
        try(
                ResultSet rs = ps.executeQuery();
            ){
                //6. Manipular os dados obtidos
                return rs.next();
            }
    }
    catch (Exception e){
        e.printStackTrace();
    }
        return false;
    } 
    
   

 
    
}
