/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField tmname;
    private JTextField tfusername;
    private JTextField tfpassword;
    private JTextField tfanswer;
    
    //b1 is create button and b2 is back button
    
    private JButton create, back;  
    private JComboBox security;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 250, 700, 406);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(99, 160, 92, 26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.DARK_GRAY);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(99, 234, 92, 26);
	contentPane.add(lblAnswer);

	security = new JComboBox();
	security.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	security.setBounds(265, 202, 148, 20);
	contentPane.add(security);

	JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 197, 140, 26);
	contentPane.add(lblSecurityQuestion);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        add(l6);

        tmname = new JTextField();
	tmname.setBounds(265, 91, 148, 20);
	contentPane.add(tmname);
	tmname.setColumns(10);

	tfusername = new JTextField();
	tfusername.setColumns(10);
	tfusername.setBounds(265, 128, 148, 20);
	contentPane.add(tfusername);

        tfpassword = new JTextField();
	tfpassword.setColumns(10);
	tfpassword.setBounds(265, 165, 148, 20);
	contentPane.add(tfpassword);

	tfanswer = new JTextField();
	tfanswer.setColumns(10);
	tfanswer.setBounds(265, 239, 148, 20);
	contentPane.add(tfanswer);

	create = new JButton("Create");
	create.addActionListener(this);
	create.setFont(new Font("Tahoma", Font.BOLD, 13));
	create.setBounds(140, 289, 100, 30);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
	contentPane.add(create);

	back = new JButton("Back");
	back.addActionListener(this);
	back.setFont(new Font("Tahoma", Font.BOLD, 13));
	back.setBounds(300, 289, 100, 30);
	back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	contentPane.add(back);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
        //if we click
        
            
            if(ae.getSource() == create){
                String sql = "insert into account(username, name, password, security, answer) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, tmname.getText());
                st.setString(2, tfusername.getText());
		st.setString(3, tfpassword.getText());
		st.setString(4, (String) security.getSelectedItem());
		st.setString(5, tfanswer.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                     this.setVisible(false);
                new Login().setVisible(true);
                }

                tmname.setText("");
                tfusername.setText("");
		tfpassword.setText("");
		tfanswer.setText("");
               
            }
             
        
        
            if(ae.getSource() == back){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }
        }catch(Exception e){
                System.out.println(e);
        }
    }
}
