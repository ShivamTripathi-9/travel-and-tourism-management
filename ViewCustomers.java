/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;



/**
 *
 * @author Shivam Tripathi
 */
public class ViewCustomers extends JFrame implements ActionListener
               
{
    JButton back;
    
    ViewCustomers(String username)
    {
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        
        JLabel lusername=new JLabel();
        lusername.setBounds(220,50,150,25);
        add(lusername);
          
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        
        
        JLabel lid=new JLabel();
        lid.setBounds(220,110,150,25);
        add(lid);
        
                JLabel lblnumber=new JLabel(" Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        
        
        JLabel lnumber=new JLabel();
        lnumber.setBounds(220,170,150,25);
        add(lnumber);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        
        
        JLabel lname=new JLabel();
        lname.setBounds(220,230,150,25);
        add(lname);
        
                JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);
        
        
        JLabel lgender=new JLabel();
        lgender.setBounds(220,290,150,25);
        add(lgender);
        
        
                JLabel lblcuntry=new JLabel("Country");
        lblcuntry.setBounds(500,50,150,25);
        add(lblcuntry);
        
        
        JLabel lcuntry=new JLabel();
        lcuntry.setBounds(690,50,150,25);
        add(lcuntry);
        
        
         JLabel lbladdress=new JLabel("Adress");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);
        
        
        JLabel ladress=new JLabel();
        ladress.setBounds(690,110,150,25);
        add(ladress);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);
        
        
        JLabel lphone=new JLabel();
        lphone.setBounds(690,170,150,25);
        add(lphone);
        
        
        JLabel lblemail=new JLabel("Email_Id");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);
        
        
        JLabel lemail=new JLabel();
        lemail.setBounds(690,230,150,25);
        add(lemail);
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(330,350,100,25);
        
        
        back.addActionListener(this);
        
        
      add(back);
      
      
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
                Image i2 = i1.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel l1 = new JLabel(i3);
                l1.setBounds(20,440,650,200);
                add(l1);
                
                 ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewall.jpg"));
                Image i5 = i4.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JLabel l2 = new JLabel(i6);
                l2.setBounds(600,440,650,200);
                add(l2);
                
                try
                {
                    Conn con=new Conn();
                    String query="select * from customer where username='"+username+"'";
                   ResultSet rs= con.s.executeQuery(query);
                   while(rs.next())
                   {
                       lusername.setText(rs.getString("username"));
                        lid.setText(rs.getString("id"));
                        lnumber.setText(rs.getString("number"));
                        lname.setText(rs.getString("name"));
                        lgender.setText(rs.getString("gender"));
                        lcuntry.setText(rs.getString("country"));
                        ladress.setText(rs.getString("address"));
                        lphone.setText(rs.getString("phone"));
                        lemail.setText(rs.getString("email"));
                        
                   }
                    
                    
                }
                catch(Exception e)
                {
                    
                }
        
                
        
        
       
        
        
        
        
        setVisible(true);
        
        
    }

    

public static void main(String args[])
{
    new ViewCustomers("username");
}


    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }




   
}
