package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener {
    JButton transferButton, backButton;
    JTextField amountField, receiverCardField;
    JPasswordField pinField;
    String pin;

    Transfer(String pin) {
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2 = i1.getImage().getScaledInstance(1600, 920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(-10, 0, 1600, 920);
        add(background);

        JLabel titleLabel = new JLabel("Transfer Money");
        titleLabel.setBounds(700, 50, 700, 35);
        titleLabel.setFont(new Font("Style", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel);

        JLabel amountLabel = new JLabel("Amount :");
        amountLabel.setBounds(560, 100, 150, 35);
        amountLabel.setFont(new Font("Style", Font.BOLD, 23));
        amountLabel.setForeground(Color.WHITE);
        background.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(850, 100, 220, 35);
        amountField.setFont(new Font("Style", Font.BOLD, 23));
        amountField.setForeground(Color.BLACK);
        amountField.setBackground(Color.WHITE);
        background.add(amountField);

        JLabel receiverLabel = new JLabel("Receiver's Card Number :");
        receiverLabel.setBounds(560, 150, 300, 35);
        receiverLabel.setFont(new Font("Style", Font.BOLD, 23));
        receiverLabel.setForeground(Color.WHITE);
        background.add(receiverLabel);

        receiverCardField = new JTextField();
        receiverCardField.setBounds(850, 150, 220, 35);
        receiverCardField.setFont(new Font("Style", Font.BOLD, 23));
        receiverCardField.setForeground(Color.BLACK);
        receiverCardField.setBackground(Color.WHITE);
        background.add(receiverCardField);

        JLabel pinLabel = new JLabel("Pin :");
        pinLabel.setBounds(560, 200, 150, 35);
        pinLabel.setFont(new Font("Style", Font.BOLD, 23));
        pinLabel.setForeground(Color.WHITE);
        background.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(850, 200, 220, 35);
        pinField.setFont(new Font("Style", Font.BOLD, 23));
        pinField.setForeground(Color.BLACK);
        pinField.setBackground(Color.WHITE);
        background.add(pinField);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(100,300,300,50);
        transferButton.setFont(new Font("Style", Font.BOLD, 28));
        transferButton.setForeground(Color.BLACK);
        transferButton.setBackground(Color.WHITE);
        transferButton.addActionListener(this);
        background.add(transferButton);

        backButton = new JButton("Back");
        backButton.setBounds(1190,300,300,50);
        backButton.setFont(new Font("Style", Font.BOLD, 28));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(this);
        background.add(backButton);

        setLayout(null);
        setSize(1600, 920);
        setLocation(-10, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transferButton) {
            transferMoney();
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Main_Class(pin);
        }
    }
    private void transferMoney() {
        String amount = amountField.getText();
        String receiverCard = receiverCardField.getText();
        String enteredPin = new String(pinField.getPassword());

        if (amount.isEmpty() || receiverCard.isEmpty() || enteredPin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "@12345678")) {
            conn.setAutoCommit(false);


            int balance = 0;

            PreparedStatement calculateBalance = conn.prepareStatement("SELECT * FROM deposit WHERE pin = ?");
            calculateBalance.setString(1, enteredPin);
            ResultSet resultSet_1 = calculateBalance.executeQuery();

            while (resultSet_1.next()) {
                String type = resultSet_1.getString("type");
                int transactionAmount = resultSet_1.getInt("amount");
                if ("Deposit".equalsIgnoreCase(type)) {
                    balance += transactionAmount;
                } else if ("Withdraw".equalsIgnoreCase(type)) {
                    balance -= transactionAmount;
                }
            }
            resultSet_1.close();

            int balance2 = 0;
            PreparedStatement fetchReceiverPin = conn.prepareStatement("SELECT pin FROM login WHERE card_number = ?");
            fetchReceiverPin.setString(1, receiverCard);
            ResultSet receiverResult = fetchReceiverPin.executeQuery();
            if (!receiverResult.next()) {
                JOptionPane.showMessageDialog(null, "Invalid receiver's card number!");
                conn.rollback();
                return;
            }

            String receiverPin = receiverResult.getString("pin");

            PreparedStatement calculateBalance2 = conn.prepareStatement("SELECT * FROM deposit WHERE pin = ?");
            calculateBalance2.setString(1, receiverPin);
            ResultSet resultSet2 = calculateBalance2.executeQuery();

            while (resultSet2.next()) {
                String type = resultSet2.getString("type");
                int transactionAmount2 = resultSet2.getInt("amount");
                if ("Deposit".equalsIgnoreCase(type)) {
                    balance2 += transactionAmount2;
                } else if ("Withdraw".equalsIgnoreCase(type)) {
                    balance2 -= transactionAmount2;
                }
            }
            resultSet2.close();


            int transferAmount = Integer.parseInt(amount);
            if (transferAmount > balance) {
                JOptionPane.showMessageDialog(null, "Insufficient balance!");
                conn.rollback();
                return;
            }


            PreparedStatement deductSender = conn.prepareStatement("UPDATE deposit SET balance = balance - ? WHERE pin = ?");
            deductSender.setInt(1, transferAmount);
            deductSender.setString(2, enteredPin);
            deductSender.executeUpdate();


            PreparedStatement addReceiver = conn.prepareStatement("UPDATE deposit SET balance = balance + ? WHERE pin = ?");
            addReceiver.setInt(1, transferAmount); // Use int for consistency
            addReceiver.setString(2, receiverPin);
            int rowsUpdated = addReceiver.executeUpdate();

            if (rowsUpdated == 0) {
                JOptionPane.showMessageDialog(null, "Invalid receiver's card number!");
                conn.rollback();
                return;
            }


            Date date = new Date();
            PreparedStatement insertSenderWithdraw = conn.prepareStatement("INSERT INTO deposit (pin, date, type, amount, balance) VALUES (?, ?, 'Withdraw', ?, ?)");
            insertSenderWithdraw.setString(1, enteredPin);
            insertSenderWithdraw.setTimestamp(2, new Timestamp(date.getTime()));
            insertSenderWithdraw.setInt(3, transferAmount);
            insertSenderWithdraw.setInt(4, balance);
            insertSenderWithdraw.executeUpdate();

            PreparedStatement insertReceiverDeposit = conn.prepareStatement("INSERT INTO deposit (pin, date, type, amount, balance) VALUES (?, ?, 'Deposit', ?, ?)");
            insertReceiverDeposit.setString(1, receiverPin);
            insertReceiverDeposit.setTimestamp(2, new Timestamp(date.getTime()));
            insertReceiverDeposit.setInt(3, transferAmount);
            insertReceiverDeposit.setInt(4, balance2);
            insertReceiverDeposit.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Transferred Successfully!");
            setVisible(false);
            new Main_Class(pin);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Transfer failed!");
        }
    }


    public static void main(String[] args) {
        new Transfer("");
    }
}
