package atmsimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    
    JTextField nametext, fnametext, emailtext, pantext, aadhartext, statetext, pintext;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education,occupation;
    String formno;

    Signup2(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM PAGE-2");
        JLabel aditionDetails = new JLabel("Page 2: ADDITIONAL Details");
        aditionDetails.setFont(new Font("Raleway", Font.BOLD, 35));
        aditionDetails.setBounds(200, 50, 500, 40);
        add(aditionDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 120, 100, 40);
        add(rel);
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 120, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cate = new JLabel("Category:");
        cate.setFont(new Font("Raleway", Font.BOLD, 20));
        cate.setBounds(100, 170, 150, 40);
        add(cate);
        String valcategory[] = {"OBC", "SC", "ST", "GENERAL", "Other"};
        category = new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 175, 400, 30);
        add(category);

        JLabel incm = new JLabel("Income");
        incm.setFont(new Font("Raleway", Font.BOLD, 20));
        incm.setBounds(100, 210, 150, 40);
        add(incm);
        String valincome[] = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox(valincome);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 210, 400, 30);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 250, 150, 40);
        add(edu);
        //radio button for male and female

        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 270, 150, 40);
        add(qual);
        String[] qualification = {"Non-Graduate", "Graduate", "Post-Graduation", "Doctrate", "other"};
        education = new JComboBox(qualification);
        education.setBounds(300, 275, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occu = new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 340, 150, 40);
        add(occu);
        String[] occuVal = {"Salaried", "Self-Employed", "Student", "Businessman", "other"};
        occupation = new JComboBox(occuVal);
        occupation.setBounds(300, 345, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 150, 40);
        add(pan);
        pantext = new JTextField();
        pantext.setFont(new Font("Raleway", Font.BOLD, 14));
        pantext.setBounds(300, 390, 400, 30);
        add(pantext);

        JLabel adhar = new JLabel("Aadhar Number:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 450, 170, 40);
        add(adhar);
        aadhartext = new JTextField();
        aadhartext.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhartext.setBounds(300, 450, 400, 30);
        add(aadhartext);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 510, 150, 40);
        add(seniorCitizen);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 510, 100, 40);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 510, 100, 40);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup gendergroup1 = new ButtonGroup();
        gendergroup1.add(syes);
        gendergroup1.add(sno);

        JLabel existacc = new JLabel("Existing Account:");
        existacc.setFont(new Font("Raleway", Font.BOLD, 20));
        existacc.setBounds(100, 570, 170, 40);
        add(existacc);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 570, 100, 40);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 570, 100, 40);
        eno.setBackground(Color.WHITE);
        add(eno);

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
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();//
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existAcc = null;
        if (eyes.isSelected()) {
            existAcc = "Yes";
        } else if (eno.isSelected()) {
            existAcc = "No";
        }
        String span = pantext.getText();
        String saadhar = aadhartext.getText();

        try {

            Conn c = new Conn();
            String query = "insert into signup2 values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + seniorcitizen + "','" + existAcc + "','" + span + "','" + saadhar + "')";
            c.s.executeUpdate(query);
          //  JOptionPane.showMessageDialog(null, "Thank You!");
            
            //signup3 object
            setVisible(false);
            new Signup3(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
