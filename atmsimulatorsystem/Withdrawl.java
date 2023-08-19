package atmsimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton back, withdraw;
    JTextField amountText;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        JLabel text = new JLabel("Enter the Amount To Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 400, 20);
        l2.add(text);

        amountText = new JTextField();
        amountText.setFont(new Font("Raleway", Font.BOLD, 22));
        amountText.setBounds(175, 350, 320, 25);
        l2.add(amountText);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        l2.add(withdraw);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        l2.add(back);

        setSize(900, 900);
        // setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {

            String number = amountText.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to withdraw");

            } else {
                try {
                    Conn conn = new Conn();
                    // String query="insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                    // conn.s.executeUpdate(query);
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
