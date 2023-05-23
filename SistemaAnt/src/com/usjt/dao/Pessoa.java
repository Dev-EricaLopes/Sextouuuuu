/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;
    
    //getters/setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void inserir (){
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
   
        
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //5: Executa o comando
            ps.execute();
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
    
    public void atualizar (){
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
        obtemConexao factory = new obtemConexao();
                try (Connection c = factory.Conectar()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }
    
    public void Consultar (){
        String aux = "";
    //1: Definir o comando SQL
    String sql = "Select * FROM tb_pessoa WHERE codigo = ?";
    //2: Abrir uma conexão
    obtemConexao factory = new obtemConexao();
            try (Connection c = factory.Conectar()){
    PreparedStatement ps = c.prepareStatement(sql);
    ps.setInt(1, codigo);
    ResultSet rs = ps.executeQuery();
    //5: itera sobre o resultado
    while (rs.next()){
    int codigo = rs.getInt("codigo");
    String nome = rs.getString("nome");
    String fone = rs.getString("fone");
    String email = rs.getString("email");
    aux = String.format(
    "Código: %d, Nome: %s, Fone: %s, Email: %s \n",
    codigo,
    nome,
    fone,
    email
    ); 
    }
    JOptionPane.showMessageDialog (null, aux);
    }
    catch (Exception e){
    e.printStackTrace();
    }
    } 

    public void listar (){
    //1: Definir o comando SQL
    String sql = "SELECT * FROM tb_pessoa";
    //2: Abrir uma conexão
    obtemConexao factory = new obtemConexao();
            try (Connection c = factory.Conectar()){
    //3: Pré compila o comando
    PreparedStatement ps = c.prepareStatement(sql);
    //4: Executa o comando e guarda
    //o resultado em um ResultSet
    ResultSet rs = ps.executeQuery();
    //5: itera sobre o resultado
    while (rs.next()){
    int codigo = rs.getInt("codigo");
    String nome = rs.getString("nome");
    String fone = rs.getString("fone");
    String email = rs.getString("email");
    String aux = String.format(
    "Código: %d, Nome: %s, Fone: %s, Email: %s",
    codigo,
    nome,
    fone,
    email
    );
    JOptionPane.showMessageDialog (null, aux);
    }
    }
    catch (Exception e){
    e.printStackTrace();
    }
    }   
    
}
