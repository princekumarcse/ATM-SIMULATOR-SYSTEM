package atmsimulatorsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 850);
        add(l2);

        back = new JButton("BACK");
        back.setBounds(355, 495, 150, 30);
        back.addActionListener(this);
        l2.add(back);

        int balance = calculateBalance(); // Calculate account balance
        JLabel text = new JLabel("YOUR ACCOUNT BALANCE IS RS. " + balance);
        text.setBounds(180, 340, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    private int calculateBalance() {
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                int transactionAmount = Integer.parseInt(rs.getString("amount"));
                balance += rs.getString("mode").equals("Deposit") ? transactionAmount : -transactionAmount;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
