package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;
    Main_Class(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);

        JLabel l2=new JLabel("Please Select Your Transaction");
        l2.setBounds(600,100,700,35);
        l2.setFont(new Font("Style",Font.BOLD,28));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        b1=new JButton("DEPOSIT");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Style",Font.BOLD,28));
        b1.setBounds(100,300,300,50);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("WITHDRAW");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Style",Font.BOLD,28));
        b2.setBounds(1190,300,300,50);
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("FAST CASH");
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("Style",Font.BOLD,28));
        b3.setBounds(100,400,300,50);
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("MINI STATEMENT");
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("Style",Font.BOLD,28));
        b4.setBounds(1190,400,300,50);
        b4.addActionListener(this);
        l1.add(b4);

        b5=new JButton("PIN CHANGE");
        b5.setForeground(Color.BLACK);
        b5.setBackground(Color.WHITE);
        b5.setFont(new Font("Style",Font.BOLD,28));
        b5.setBounds(100,500,300,50);
        b5.addActionListener(this);
        l1.add(b5);

        b6=new JButton("BALANCE ENQUIRY");
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

        b8=new JButton("TRANSFER");
        b8.setForeground(Color.BLACK);
        b8.setBackground(Color.WHITE);
        b8.setFont(new Font("Style",Font.BOLD,28));
        b8.setBounds(100,600,300,50);
        b8.addActionListener(this);
        l1.add(b8);



        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource()==b2) {
                new Withdraw(pin);
                setVisible(false);
            }else if (e.getSource()==b3) {
                new FastCash(pin);
                setVisible(false);
            }else if (e.getSource()==b4) {
                new Mini_Statement(pin);
                setVisible(false);
            }
            else if (e.getSource()==b5) {
                new PinChange(pin);
                setVisible(false);
            } else if (e.getSource()==b6) {
                new BalanceEnquiry(pin);
                setVisible(false);
            }else if (e.getSource()==b7) {
                System.exit(0);
            }else if (e.getSource()==b8) {
                new Transfer(pin);
                setVisible(false);
            }

        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
    new Main_Class("");
    }
}
