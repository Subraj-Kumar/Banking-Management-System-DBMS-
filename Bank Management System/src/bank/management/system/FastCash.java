package bank.management.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);

        JLabel l2=new JLabel("Select Your Withdrawal Amount");
        l2.setBounds(600,100,700,35);
        l2.setFont(new Font("Style",Font.BOLD,28));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        b1=new JButton("Rs. 100");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Style",Font.BOLD,28));
        b1.setBounds(100,300,300,50);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Rs. 500");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Style",Font.BOLD,28));
        b2.setBounds(1190,300,300,50);
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Rs. 1000");
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("Style",Font.BOLD,28));
        b3.setBounds(100,400,300,50);
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Rs. 2000");
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("Style",Font.BOLD,28));
        b4.setBounds(1190,400,300,50);
        b4.addActionListener(this);
        l1.add(b4);

        b5=new JButton("Rs. 5000");
        b5.setForeground(Color.BLACK);
        b5.setBackground(Color.WHITE);
        b5.setFont(new Font("Style",Font.BOLD,28));
        b5.setBounds(100,500,300,50);
        b5.addActionListener(this);
        l1.add(b5);

        b6=new JButton("Rs. 10000");
        b6.setForeground(Color.BLACK);
        b6.setBackground(Color.WHITE);
        b6.setFont(new Font("Style",Font.BOLD,28));
        b6.setBounds(1190,500,300,50);
        b6.addActionListener(this);
        l1.add(b6);

        b7=new JButton("EXIT");
        b7.setForeground(Color.BLACK);
        b7.setBackground(Color.WHITE);
        b7.setFont(new Font("Style",Font.BOLD,28));
        b7.setBounds(1190,600,300,50);
        b7.addActionListener(this);
        l1.add(b7);



        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


            if (e.getSource() == b7) {
                new Main_Class(pin);
                setVisible(false);
            } else {
                String amount = ((JButton) e.getSource()).getText().substring(4);
                connection connection = new connection();
                Date date = new Date();

                try {
                    ResultSet resultSet = connection.stmt.executeQuery("select * from deposit where pin='" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (e.getSource() != b7 && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    connection.stmt.executeUpdate("insert into deposit values('" + pin + "','" + date + "','Withdraw','" + amount + "', '"+balance+"')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        setVisible(false);
        new Main_Class(pin);
    }

    public static void main(String[] args) {
        new FastCash("");

    }
}
