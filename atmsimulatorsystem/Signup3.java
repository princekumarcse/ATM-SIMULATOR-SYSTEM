package atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 400, 40);
        add(type);
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        r2 = new JRadioButton("Recurring Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 150, 20);
        add(r3);
        r4 = new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 200, 20);
        add(r4);

        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4104");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        JLabel carddetails = new JLabel("Your 16-digit Card Number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 15));
        carddetails.setBounds(100, 330, 300, 20);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        JLabel pindetails = new JLabel("Your 4-digit Password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 15));
        pindetails.setBounds(100, 400, 300, 15);
        add(pindetails);

        JLabel pinumber = new JLabel("XXXX");
        pinumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinumber.setBounds(330, 370, 300, 30);
        add(pinumber);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 250, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Bnaking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("SMS & Email Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.\",true");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 650, 550, 30);
        add(c7);
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Recurring Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Fixed Deposit Account";
            }

            Random random = new Random();
            long first7 = (random.nextLong() % 90000000L) + 5040936000000000L;
            String cardnumber = "" + Math.abs(first7);

            long first3 = (random.nextLong() % 9000L) + 1000L;
            String pinnumber = "" + Math.abs(first3);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility = facility + " EMAIL Alerts";
            }
            if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try {
                if (ae.getSource() == submit) {

                    if (accountType.equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    } else {
                        Conn conn = new Conn();
                        String q1 = "insert into signup3 values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                        String q2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                        conn.s.executeUpdate(q1);
                        conn.s.executeUpdate(q2);
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:" + pinnumber);
                        setVisible(false);
                        new Login(formno).setVisible(true);

                    }

                } else if (ae.getSource() == cancel) {
                    setVisible(false);
                    new Login(formno).setVisible(true);
                    //System.exit(0);
                }
               

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new Signup3("").setVisible(true);
    }

}
