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
public class loan {
    
    private String Acc_no;
    private String Name;
    private String loan_ID;
    private String amount;
    private String loantime;
    
   
    private Connection con ; 

    public loan() {
    }
    

    public loan(String Acc_no, String Name, String loan_ID, String amount, String loantime) {
        this.Acc_no = Acc_no;
        this.Name = Name;
        this.loan_ID = loan_ID;
        this.amount = amount;
        this.loantime = loantime;
        con = ConnectionManager.getCon();
   
    }
    
     public boolean giveloan(){
        boolean status = false;
        
        
        try {
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO `loan` (`Accno`, `Name`, `LoanID`,`Amount`,`LoanDuration`) VALUES ('"+Acc_no+"','"+Name+"','"+loan_ID+"','"+amount+"','"+loantime+"')";
            st.executeUpdate(sql);
            status=true;
        } catch (SQLException ex) {
            Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return status;
    }
    public void removecustomer(String Acc_no) throws SQLException{
            Connection con =getCon();
            String sql = "DELETE FROM loan WHERE AccNo ='"+Acc_no+"'" ;
            Statement st = con.createStatement();
            st.executeUpdate(sql);
              System.out.println(Acc_no);                  

    
    
    

    
}

}
