
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
    private String nome, login, senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

        public void inserir (){
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_usuario(nome, usuario, senha) VALUES (?, ?, ?)";
        //2: Abrir uma conexão
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, login);
            ps.setString(3, senha);
            //5: Executa o comando
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
    
    public void atualizar (){
        String sql = "UPDATE tb_usuario SET senha = ? WHERE usuario = ?";
        obtemConexao factory = new obtemConexao();
        try (Connection c = factory.Conectar()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, senha);
            ps.setString(2, login);
            ps.execute();
            JOptionPane.showMessageDialog(null, nome + "alterado com sucesso!!");
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM tb_usuario WHERE usuario = ?";
        obtemConexao factory = new obtemConexao();
                try (Connection c = factory.Conectar()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, login);
        ps.execute();
        JOptionPane.showMessageDialog(null, login + ", excluído com sucesso!!");
        
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }
    
    public boolean Entrar(Usuario usuario){
    //1: Definir o comando SQL
        System.out.println("entrar");
    String sql = "Select * FROM tb_usuario WHERE usuario = ? and senha = ?";
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
                    while (rs.next())
                    {
                    nome = rs.getString("nome");
                    login = rs.getString("usuario");
                    senha = rs.getString("senha");
                    }
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
            return false;
        } 


        public String Consultar(String nome, String login)
        {

            //1: Definir o comando SQL
            String sql = "Select * FROM tb_usuario WHERE nome = ? or usuario = ?";
            //2: Abrir uma conexão
            obtemConexao factory = new obtemConexao();

            try (Connection c = factory.Conectar())
            {
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, login);
                
                ResultSet rs = ps.executeQuery();
                //5: itera sobre o resultado
                System.out.println(sql);
                while (rs.next())
                {
                    nome = rs.getString("nome");
                    login = rs.getString("usuario");
                    senha = rs.getString("senha");
                }
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return ("");
        } 
}
