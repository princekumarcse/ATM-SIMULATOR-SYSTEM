package atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    JLabel card,mini,bank;

    MiniStatement(String pinnumber) {

        setTitle("Mini Statement");
        setLayout(null);

        mini = new JLabel();
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        card =  new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("Card_Number").substring(0, 4) + "XXXXXXXX" + rs.getString("Card_Number").substring(12));
            }
        }catch(Exception e){
        System.out.println(e);
        }
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
           // l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        

//        try {
//            Conn conn = new Conn();
//            ResultSet rs = conn.s.executeQuery("select * from login where Pin_Number='"+pinnumber+"'");
//            while (rs.next()) {
//                card.setText("Card number: " + rs.getString("Card_Number").substring(0,4)+ "XXXXXXXX" + rs.getString("Card_Number").substring(12));
//                
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        try{
//            int balance=0;
//            Conn conn =new Conn();
//            ResultSet rs=conn.s.executeQuery("Select* from bank where pin='"+pinnumber+"'");
//            while(rs.next()){
//                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
//                if(rs.getString("type").equals("Deposit")){
//                    balance += Integer.parseInt(rs.getString("amount"));
//                }else{
//                    balance -= Integer.parseInt(rs.getString("amount"));
//                }
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        
        mini.setBounds(20,140,400,200);

        setSize(400, 600);
        //setUndecorated(true);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

}
