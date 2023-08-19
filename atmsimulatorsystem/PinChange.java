package atmsimulatorsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField repinText, pinText;
    String pinnumber;
    JLabel l2 ;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 850);
        add(l2);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);

        JLabel pintext = new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 15));
        pintext.setBounds(170, 320, 100, 25);
        l2.add(pintext);
        pinText = new JPasswordField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 22));
        pinText.setBounds(260, 320, 250, 25);
        l2.add(pinText);

        JLabel repintext = new JLabel("RE-Enter NEW PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 15));
        repintext.setBounds(170, 350, 150, 25);
        l2.add(repintext);
        repinText = new JPasswordField();
        repinText.setFont(new Font("Raleway", Font.BOLD, 22));
        repinText.setBounds(310, 350, 200, 25);
        l2.add(repinText);

        change = new JButton("CHANGE");
        change.setBounds(355, 460, 150, 30);
        change.addActionListener(this);
        l2.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 495, 150, 30);
        back.addActionListener(this);
        l2.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String newpin = pinText.getText();
                String rnewpin = repinText.getText();
                if (!newpin.equals(rnewpin)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return;
                }
                else if (ae.getSource() == change) {
                    if (newpin.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Enter Pin");
                        return;
                    }
                    if (rnewpin.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
                    }
                    Conn conn = new Conn();
                    String query1 = "Update bank set pin='" + rnewpin + "' where pin='" + pinnumber + "'";
                    String query2 = "Update login set Pin_Number='" + rnewpin + "' where Pin_Number='" + pinnumber + "'";
                    String query3 = "Update signup3 set Pin='" + rnewpin + "' where Pin='" + pinnumber + "'";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                
                if (ae.getSource() ==  back) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}