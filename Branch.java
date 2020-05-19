/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import Database_classes.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author com
 */
public class Branch {
    
    private String br_name;
    private String br_code;
    private String br_address;
    
       private Connection con ; 

    public Branch(String br_name, String br_code, String br_address) {
        this.br_name = br_name;
        this.br_code = br_code;
        this.br_address = br_address;
       
        con = ConnectionManager.getCon();
        
    }
       
    
     public boolean addbranch(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `branch` (`br_name`, `br_code`, `br_address`) VALUES ('"+br_name+"','"+br_code+"','"+br_address+"')";
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }
    
    
    
}
