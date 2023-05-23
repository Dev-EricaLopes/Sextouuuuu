
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
        String sql = "UPDATE tb_login SET senha = ? WHERE usuario = ?";
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
        String sql = "DELETE FROM tb_login WHERE usuario = ?";
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


        public String Consultar()
        {

            //1: Definir o comando SQL
            String sql = "Select * FROM tb_login WHERE usuario = ?";
            //2: Abrir uma conexão
            obtemConexao factory = new obtemConexao();
            JOptionPane.showMessageDialog(null, login);

            try (Connection c = factory.Conectar())
            {
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, login);
                
                ResultSet rs = ps.executeQuery();
                //5: itera sobre o resultado
                while (rs.next())
                {
                    login = rs.getString("usuario");
                    senha = rs.getString("senha");
                    
                    JOptionPane.showMessageDialog(null, senha);
                    return (senha);
                }
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return ("");
        } 
}
