package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JLabel l3;
    JButton b1;
    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);

        JLabel l2=new JLabel("Your Current Balance Is Rs. ");
        l2.setBounds(600,100,700,35);
        l2.setFont(new Font("Style",Font.BOLD,28));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        l3=new JLabel();
        l3.setFont(new Font("Style",Font.BOLD,28));
        l3.setForeground(Color.WHITE);
        l3.setBounds(970,100,200,35);
        l1.add(l3);

        b1=new JButton("Back");
        b1.setBounds(1190,300,300,50);
        b1.setFont(new Font("Style",Font.BOLD,28));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        int balance=0;
        try{
            connection conn=new connection();
            ResultSet resultSet = conn.stmt.executeQuery("select * from deposit where pin= '"+pin+"' ");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        l3.setText(""+balance);

        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}

