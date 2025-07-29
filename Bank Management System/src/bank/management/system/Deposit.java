package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField amount;
    JButton deposit, canc;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);
        JLabel l2 = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 20));
        l2.setForeground(Color.WHITE);
        l2.setBounds(600,50,500,30);
        l1.add(l2);


        amount = new TextField();
        amount.setBounds(700,100,220,25);
        amount.setFont(new Font("System", Font.PLAIN, 20));
        amount.setBackground(Color.WHITE);
        l1.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("System", Font.BOLD, 18));
        //deposit.setForeground(Color.WHITE);
        deposit.setBackground(Color.WHITE);
        deposit.setBounds(900,150,120,22);
        deposit.addActionListener(this);
        l1.add(deposit);

        canc = new JButton("CANCEL");
        canc.setFont(new Font("System", Font.BOLD, 18));
        canc.setBackground(Color.WHITE);
        canc.setBounds(600,150,120,22);
        canc.addActionListener(this);
        l1.add(canc);



        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int balance=0;
        try{
            String Amount = amount.getText();
            Date date=new Date();
            if(e.getSource() == deposit){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                }else{
                    connection conn=new connection();
                    ResultSet resultSet = conn.stmt.executeQuery("select * from deposit where pin= '"+pin+"' ");
                    while(resultSet.next()){
                        if(resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("Amount"));
                        }else{
                            balance -= Integer.parseInt(resultSet.getString("Amount"));
                        }
                    }


                    conn.stmt.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Deposit','"+Amount+"','"+balance+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+Amount+" Deposited Successfully");


                    setVisible(false);
                    new Main_Class(pin);
                }
            }else if(e.getSource() == canc){
                setVisible(false);
                new Main_Class(pin);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
    new Deposit("");

    }
}
