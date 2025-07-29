package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame  implements ActionListener {
    connection connection = new connection();
    String pin;
    TextField amount;
    JButton withdraw, canc;
    Withdraw(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);
        JLabel l2 = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        l2.setFont(new Font("System", Font.BOLD, 20));
        l2.setForeground(Color.WHITE);
        l2.setBounds(600,50,500,30);
        l1.add(l2);


        amount = new TextField();
        amount.setBounds(700,100,250,25);
        amount.setFont(new Font("System", Font.PLAIN, 20));
        amount.setBackground(Color.WHITE);
        l1.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("System", Font.BOLD, 18));
        //deposit.setForeground(Color.WHITE);
        withdraw.setBackground(Color.WHITE);
        withdraw.setBounds(900,150,150,22);
        withdraw.addActionListener(this);
        l1.add(withdraw);

        canc = new JButton("CANCEL");
        canc.setFont(new Font("System", Font.BOLD, 18));
        canc.setBackground(Color.WHITE);
        canc.setBounds(600,150,150,22);
        canc.addActionListener(this);
        l1.add(canc);

        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw){
            try {
                String Amount = amount.getText();
                Date date = new Date();
                if (e.getSource() == withdraw) {
                    if (amount.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                    } else {
                        String q = ("select * from deposit where pin= '" + pin + "'");
                        ResultSet resultSet = connection.stmt.executeQuery(q);
                        int balance = 0;
                        while (resultSet.next()) {
                            if (resultSet.getString("type").equals("Deposit")) {
                                balance += Integer.parseInt(resultSet.getString("Amount"));
                            } else {
                                balance -= Integer.parseInt(resultSet.getString("Amount"));
                            }
                        }
                        if (balance < Integer.parseInt(Amount)) {
                            JOptionPane.showMessageDialog(null, "You don't have enough money to withdraw");
                            return;
                        }

                        connection.stmt.executeUpdate("insert into deposit values('" + pin + "','" + date + "', 'Withdraw', '" + Amount + "', '"+balance+"' )");
                        JOptionPane.showMessageDialog(null, "Rs. " + Amount + " Withdraw successful");
                        setVisible(false);
                        new Main_Class(pin);

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (e.getSource() == canc){
            setVisible(false);
            new Main_Class(pin);
        }

    }
    public static void main(String[] args){
    new Withdraw("");
    }
}
