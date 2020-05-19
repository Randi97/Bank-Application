/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import Database_classes.ConnectionManager;
import static Database_classes.ConnectionManager.getCon;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author com
 */
public class customer {
    
    private String Full_Name;
    private String Address;
    private String contact_no;
    private String age;
    private String nic;
    private String Acc_no;
    private Connection con ; 

    public customer() {
    }
    

    public customer(String Full_Name, String Address, String age ,String contact_no, String nic, String Acc_no) {
        
        this.Full_Name = Full_Name;
        this.Address = Address;
        this.contact_no = contact_no;
        this.nic =nic;
        this.age = age;
        this.Acc_no = Acc_no;
        con = ConnectionManager.getCon();
    }
    
     public boolean addcustomer(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `customer` (`FullName`, `Address`, `Age`,`Contact_No`,`NIC`,`AccNo`) VALUES ('"+Full_Name+"','"+Address+"','"+age+"','"+contact_no+"','"+nic+"','"+Acc_no+"')";
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
     
    /* public boolean search(){
         boolean status = false;
         try{
             Statement st = con.createStatement();
         
                  String sql = "select * from customer where AccNo ='"+Acc_no+ "'";
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
    */
     
         
      
       public void removecustomer(String Acc_no) throws SQLException{
            Connection con =getCon();
            String sql = "DELETE FROM customer WHERE AccNo ='"+Acc_no+"'" ;
            Statement st = con.createStatement();
            st.executeUpdate(sql);
              System.out.println(Acc_no);                  

    
    
    

    
}

    }
