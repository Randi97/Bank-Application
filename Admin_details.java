/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;
import Database_classes.ConnectionManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author com
 */
public class Admin_details {
    private String Staff_ID;
    private String Name;
    private String Address;
    private String password;
    private String email;
    private Connection con ; 

    public Admin_details(String Staff_ID,String email, String Name, String Address,  String password) {
        this.Staff_ID = Staff_ID;
        this.Name = Name;
        this.Address = Address;
        this.password = password;
        this.email = email;
        con = ConnectionManager.getCon();
    }

    public Admin_details(String email, String password ) {
        
        this.password = password;
        this.email = email;
            con = ConnectionManager.getCon();
       
    }
    
      
    public boolean authenticate(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "SELECT `Password` FROM `admindetail` WHERE `Email`='"+email+"'";
            st.executeQuery(sql);
            ResultSet rs=st.getResultSet();
                   
              String dbPassWord="";
              try{
            while (rs.next()) {
             dbPassWord= rs.getString("Password");
            }
            if(password.equals(dbPassWord)){
            status=true;
            }
              }catch(SQLException e){
                  System.out.println(e.getMessage());
              }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_details.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_details.class.getName()).log(Level.SEVERE, null, ex);
        }

    return status;
    }
     public boolean addUsers(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `admindetail`(`StaffID`, `Email`, `Name`,`Address`,`Password`) VALUES ('"+Staff_ID+"','"+email+"','"+Name+"','"+Address+"','"+password+"')";
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(Admin_details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }
}
