package atmsimulatorsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenqury, exit;
    String pinnumber;

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 1540, 850);
        add(l2);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(525, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(480, 380, 150, 30);
        deposit.addActionListener(this);
        l2.add(deposit);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(680, 380, 150, 30);
        withdrawl.addActionListener(this);
        l2.add(withdrawl);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(480, 420, 150, 30);
        fastcash.addActionListener(this);
        l2.add(fastcash);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(680, 420, 150, 30);
        ministatement.addActionListener(this);
        l2.add(ministatement);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(480, 460, 150, 30);
        pinchange.addActionListener(this);
        l2.add(pinchange);

        balanceenqury = new JButton("BALANCE ENQUIRY");
        balanceenqury.setBounds(680, 460, 150, 30);
        balanceenqury.addActionListener(this);
        l2.add(balanceenqury);

        exit = new JButton("EXIT");
        exit.setBounds(680, 495, 150, 30);
        exit.addActionListener(this);
        l2.add(exit);

        setSize(1540, 850);
        setLocation(0, 0);
        // setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenqury) {
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Transactions("");

    }

}
