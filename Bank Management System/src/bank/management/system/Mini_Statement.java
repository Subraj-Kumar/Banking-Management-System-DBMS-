package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_Statement extends JFrame implements ActionListener {
    JButton b1;
    String pin;
    Mini_Statement(String pin){

        this.pin = pin;

        JLabel l1=new JLabel();
        l1.setBounds(20,100,400,400);
        add(l1);

        JLabel l2=new JLabel("One Bank");
        l2.setBounds(200,20,200,20);
        l2.setFont(new Font("System", Font.BOLD,20));
        add(l2);

        JLabel l3=new JLabel();
        l3.setBounds(20,80,300,25);
        add(l3);

        JLabel l4=new JLabel();
        l4.setBounds(20,420,300,25);
        add(l4);

        b1=new JButton("Exit");
        b1.setBounds(360,500,100,25);
        add(b1);
        b1.addActionListener(this);

        try{
            connection conn=new connection();
            ResultSet rs=conn.stmt.executeQuery("select * from login where pin='"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number: "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try{
            int balance=0;
            connection conn=new connection();
            ResultSet resultSet = connection.stmt.executeQuery("select * from deposit where pin='" + pin + "'");
            while (resultSet.next()) {

                l1.setText(l1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            l4.setText("Total Balance: "+balance);
            l4.setBounds(20,500,300,25);
            add(l4);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        setSize(500,600);
        setLocation(600,180);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new Main_Class(pin);
    }

    public static void main(String[] args) {
        new Mini_Statement("");
    }

}
