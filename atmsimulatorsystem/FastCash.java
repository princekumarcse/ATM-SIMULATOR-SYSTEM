package atmsimulatorsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 850);
        add(l2);

        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(215, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 380, 150, 30);
        deposit.addActionListener(this);
        l2.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(350, 380, 150, 30);
        withdrawl.addActionListener(this);
        l2.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 420, 150, 30);
        fastcash.addActionListener(this);
        l2.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(350, 420, 150, 30);
        ministatement.addActionListener(this);
        l2.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 460, 150, 30);
        pinchange.addActionListener(this);
        l2.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(350, 460, 150, 30);
        balanceenquiry.addActionListener(this);
        l2.add(balanceenquiry);

        back = new JButton("BACK");
        back.setBounds(350, 495, 150, 30);
        back.addActionListener(this);
        l2.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } else {
                Date date = new Date();
                Conn conn = new Conn();
                conn.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
