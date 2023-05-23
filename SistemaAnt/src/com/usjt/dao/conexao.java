
package com.usjt.dao;

import javax.swing.JOptionPane;

public class conexao {

    
    
    public static void main(String[] args) {
        String nome ; 
        String fone; 
        String email ;   
        int codigo;
        int op;
        
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n5-Consultar\n0-Sair";
          

        do{

            
        op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch (op){
        case 1:  
            nome = JOptionPane.showInputDialog("Nome?"); 
            fone = JOptionPane.showInputDialog("Fone?"); 
            email = JOptionPane.showInputDialog("Email?");
            Pessoa p = new Pessoa();
            p.setNome(nome); 
            p.setFone(fone); 
            p.setEmail(email); 

            p.inserir();
                
            break;
        case 2:
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
            nome = JOptionPane.showInputDialog("Nome?"); 
            fone = JOptionPane.showInputDialog("Fone?"); 
            email = JOptionPane.showInputDialog("Email?");

                
            Pessoa p2 = new Pessoa(); 
            p2.setNome(nome); 
            p2.setFone(fone); 
            p2.setEmail(email); 
            p2.setCodigo(codigo);
            p2.atualizar();
            break;
        case 3:

            break;
        case 4:
            Pessoa p4 = new Pessoa(); 
            p4.listar();
            break;
        case 5:
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
            Pessoa p5 = new Pessoa();
            p5.setCodigo(codigo);
            p5.Consultar();
            break;            
        case 0:
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opção inválida");
        }
        }while (op != 0);
        
  }
}
    

