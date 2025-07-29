package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;
import java.sql.ResultSet;

//TO make the buttons work we need to implement ActionListener;
public class Login extends JFrame implements ActionListener {
    connection connection= new connection();
    //create a label globally so that we can use it whenever we want to create buttons;
    JLabel button, button2, button3;
    JTextField textfield2;
    JPasswordField passwordfield3;
    JButton b1, b2, b3;
    //Create constructor with name same as file name;
    Login(){
        //basically super is used to give title to app and nothing should be written on top of this;
        super("ONE Bank Management System");
        //import image first and then set its dimensions in second step
        ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("icons/one_bank_logo1.png"));
        Image logo2= logo1.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon logo3 = new ImageIcon(logo2);
        JLabel logo = new JLabel(logo3);
        logo.setBounds(600,0,300,200);
        add(logo);

        ImageIcon atmc1 = new ImageIcon(ClassLoader.getSystemResource("icons/6081563.png"));
        Image atmc2 = atmc1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon atmc3 = new ImageIcon(atmc2);
        JLabel atmc = new JLabel(atmc3);
        atmc.setBounds(1200,500,300,300);
        add(atmc);

        //We can use the following code to insert and then change the colour, font, size and all;
        button = new JLabel("WELCOME TO YOUR OWN BANK");
        button.setBounds(475,235,1000,40);
        button.setForeground(new Color(8,24,168));
        button.setFont(new Font("Aptos", Font.BOLD, 35));
        add(button);

        button2= new JLabel("Card Number:");
        button2.setFont(new Font("Aptos", Font.BOLD, 28));
        button2.setForeground(new Color(8,24,168));
        button2.setBounds(425,325,400,30);
        add(button2);

        textfield2 = new JTextField(15);
        textfield2.setFont(new Font("Aptos", Font.BOLD, 18));
        textfield2.setBounds(625,325,400,30);
        add(textfield2);

        button3= new JLabel("Pin Number:");
        button3.setForeground(new Color(8,24,168));
        button3.setFont(new Font("Aptos", Font.BOLD, 28));
        button3.setBounds(425, 400, 400, 30);
        add(button3);

        passwordfield3 = new JPasswordField(15);
        passwordfield3.setFont(new Font("Aptos", Font.BOLD, 18));
        passwordfield3.setBounds(625, 400, 400, 30);
        add(passwordfield3);


        b1= new JButton("Sign In");
        b1.setFont(new Font("Aptos", Font.BOLD, 28));
        b1.setForeground(Color.WHITE);
        b1.setBounds(475, 520,150,40);
        b1.setBackground(new Color(8,24,168));
        //this below command will help to know then this button is clicked;
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Clear");
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Aptos", Font.BOLD, 28));
        b2.setBounds(825,520,150,40);
        b2.setBackground(new Color(8, 24, 168));
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Sign Up");
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Aptos", Font.BOLD, 28));
        b3.setBounds(650,600,150,40);
        b3.setBackground(new Color(8,24,168));
        b3.addActionListener(this);
        add(b3);


        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/SL-072923-62010-97.jpg"));
        Image bg2 = bg1.getImage().getScaledInstance(1500,800, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel bg = new JLabel(bg3);
        bg.setBounds(0,0,1500,800);
        add(bg);



        //set layout to null, set frame size, turn visibility to true and set location to centre to make it look good;
        setLayout(null);
        setSize(1500,800);
        setLocation(20,50);
        //always put set visibility at bottom;
        setVisible(true);
    }
    //we need to override actionListener in this whenever the button is clicked and the then the action performed command will perform action;
    @Override
    public void actionPerformed(ActionEvent e) {
        //we use try and catch so that it can tell us about any error in pressing the buttons;
    try{
        if(e.getSource() == b1){
            String cardNumber = textfield2.getText();
            String pin = passwordfield3.getText();
            //this following code will retrieve data from our database and will help in login;
            String q = "select * from login where card_number = '"+cardNumber+"' and pin = '"+pin+"'";
            ResultSet resultSet = connection.stmt.executeQuery(q);
            if(resultSet.next()){
                setVisible(false);
                new Main_Class(pin);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Card Number Or Pin");
            }


        }else if(e.getSource()== b2){
            textfield2.setText("");
            passwordfield3.setText("");
        }else if(e.getSource()== b3){
            new SignUp();
            setVisible(false);
        }

    }catch(Exception ex){
        ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        //create an object;
        new Login();
    }
}
