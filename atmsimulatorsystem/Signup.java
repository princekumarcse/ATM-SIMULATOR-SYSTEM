package atmsimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {

    long random;
    JTextField nametext, fnametext, emailtext, addtext, citytext, statetext, pintext;
    JButton next;
    JRadioButton unmarried, male, female, other, married;
    JDateChooser dateChooser;


    Signup() {
        //this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM");

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        String first = "" + Math.abs(random);

        //label for application number
        JLabel formno = new JLabel("APPLICATION FORM NO. " + first);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 10, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Dtails");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 35));
        personalDetails.setBounds(240, 50, 400, 40);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 40);
        add(name);
        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(300, 120, 400, 30);
        add(nametext);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 150, 40);
        add(fname);
        fnametext = new JTextField();
        fnametext.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametext.setBounds(300, 175, 400, 30);
        add(fnametext);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 210, 150, 40);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 210, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 250, 150, 40);
        add(gender);
        //radio button for male and female

        male = new JRadioButton("Male");
        male.setBounds(300, 250, 100, 40);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(440, 250, 100, 40);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 290, 150, 40);
        add(email);
        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtext.setBounds(300, 295, 400, 30);
        add(emailtext);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 340, 150, 40);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 340, 100, 40);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 340, 100, 40);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(590, 340, 100, 40);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup gendergroup1 = new ButtonGroup();
        gendergroup1.add(married);
        gendergroup1.add(unmarried);
        gendergroup1.add(other);

        JLabel add = new JLabel("Address:");
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBounds(100, 390, 150, 40);
        add(add);
        addtext = new JTextField();
        addtext.setFont(new Font("Raleway", Font.BOLD, 14));
        addtext.setBounds(300, 390, 400, 30);
        add(addtext);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 450, 150, 40);
        add(city);
        citytext = new JTextField();
        citytext.setFont(new Font("Raleway", Font.BOLD, 14));
        citytext.setBounds(300, 450, 400, 30);
        add(citytext);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 510, 150, 40);
        add(state);
        statetext = new JTextField();
        statetext.setFont(new Font("Raleway", Font.BOLD, 14));
        statetext.setBounds(300, 510, 400, 30);
        add(statetext);

        JLabel pincode = new JLabel("PinCode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 570, 150, 40);
        add(pincode);
        pintext = new JTextField();
        pintext.setFont(new Font("Raleway", Font.BOLD, 14));
        pintext.setBounds(300, 570, 400, 30);
        add(pintext);

        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        //frame 
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;//long
        String name = nametext.getText();
        String fname = fnametext.getText();//
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailtext.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "UnMarried";
        } else if (other.isSelected()) {
            marital = "other";
        }
        String address = addtext.getText();
        String city = citytext.getText();
        String state = statetext.getText();
        String pin = pintext.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(query);
                //JOptionPane.showMessageDialog(null, "Thank You!");
                
                setVisible(false);
                new Signup2(formno).setVisible(true);
                
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
