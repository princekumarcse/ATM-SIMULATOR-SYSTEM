package atmsimulatorsystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;
    String pinnumber;

    Login(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i1);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(400, 10, 100, 100);
        add(l11);
        add(label);
        
        

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 48));
        text.setBounds(560, 40, 700, 40);
        add(text);

        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
        JLabel image = new JLabel(i5);
        image.setBounds(0, 0, 500, 750);//600,450
        add(image);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
        JLabel secimage = new JLabel(i6);
        secimage.setBounds(0, 0, 2500, 750);//600,450
        add(secimage);

        JLabel cardno = new JLabel("CARD No.");
        cardno.setFont(new Font("Osward", Font.BOLD, 28));
        cardno.setBounds(590, 250, 400, 40);
        add(cardno);

        cardText = new JTextField();
        cardText.setBounds(750, 255, 250, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setFont(new Font("Arial", Font.BOLD, 28));
        pin.setBounds(590, 300, 400, 40);
        add(pin);
        //text field of pin
        pinText = new JPasswordField();
        pinText.setBounds(750, 300, 250, 30);

        add(pinText);

        //for button
        login = new JButton("SIGN IN");
        login.setBounds(670, 400, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(820, 400, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(670, 450, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(1540, 850);
        setLocation(0, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardText.getText();
            String pinnum = pinText.getText();
            String query = "Select* from login where Card_Number ='" + cardnumber  + "' and Pin_Number='" + pinnum
                    + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                }

            } catch (HeadlessException | SQLException e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);

        } else if (ae.getSource() == clear) {
            //to clean the textarea 
            cardText.setText("");
            pinText.setText("");

        }
    }

    public static void main(String args[]) {
        new Login("");
    }

}
