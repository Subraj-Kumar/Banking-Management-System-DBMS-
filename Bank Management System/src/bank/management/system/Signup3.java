package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton next, cancel;
    String formno;
    //Constructor
    Signup3(String formno){

        super("Application Form");
        this.formno= formno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/one_bank_logo1.png"));
        Image i2=i1.getImage().getScaledInstance(180, 110, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la = new JLabel(i3);
        la.setBounds(10,0,180,110);
        add(la);

        JLabel label1 = new JLabel("APPLICATION FORM NO. "+formno);
        label1.setFont(new Font("Aptos",Font.BOLD,24));
        label1.setBounds(255,14,500,40);
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        JLabel l2 = new JLabel("Page 3");
        l2.setBounds(30,730,100,25);
        l2.setFont(new Font("Aptos", Font.BOLD, 14));
        l2.setForeground(new Color(0, 0, 0));
        add(l2);

        JLabel label3=new JLabel("Account Details");
        label3.setBounds(330,50,250,25);
        label3.setForeground(new Color(0, 0, 0));
        label3.setFont(new Font("Aptos",Font.BOLD,22));
        add(label3);

        JLabel Type = new JLabel("Account Type :");
        Type.setBounds(100,130,200,25);
        Type.setForeground(new Color(0, 0, 0));
        Type.setFont(new Font("Aptos",Font.BOLD,22));
        add(Type);
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,180,200,25);
        r1.setBackground(new Color(215, 252, 252));
        r1.setFont(new Font("Aptos",Font.BOLD,16));
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,180,300,25);
        r2.setBackground(new Color(215, 252, 252));
        r2.setFont(new Font("Aptos",Font.BOLD,16));
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,230,200,25);
        r3.setBackground(new Color(215, 252, 252));
        r3.setFont(new Font("Aptos",Font.BOLD,16));
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,230,300,25);
        r4.setBackground(new Color(215, 252, 252));
        r4.setFont(new Font("Aptos",Font.BOLD,16));
        add(r4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JLabel CardNo = new JLabel("Card Number :");
        CardNo.setFont(new Font("Aptos",Font.BOLD,22));
        CardNo.setForeground(new Color(0, 0, 0));
        CardNo.setBounds(100,300,200,25);
        add(CardNo);
        JLabel cardNo=new JLabel("(Your 16-Digit Card Number)");
        cardNo.setFont(new Font("Aptos",Font.BOLD,12));
        cardNo.setForeground(new Color(0, 0, 0));
        cardNo.setBounds(100,320,200,25);
        add(cardNo);
        JLabel Cardno= new JLabel("XXXX-XXXX-XXXX-1212");
        Cardno.setFont(new Font("Aptos",Font.BOLD,20));
        Cardno.setForeground(new Color(0, 0, 0));
        Cardno.setBounds(350,300,300,25);
        add(Cardno);
        JLabel cardno=new JLabel("(It would appear on ATM card, Cheque book and Statement)");
        cardno.setFont(new Font("Aptos",Font.BOLD,12));
        cardno.setForeground(new Color(0, 0, 0));
        cardno.setBounds(350,320,500,25);
        add(cardno);

        JLabel PIN=new JLabel("PIN :");
        PIN.setFont(new Font("Aptos",Font.BOLD,22));
        PIN.setForeground(new Color(0, 0, 0));
        PIN.setBounds(100,370,200,25);
        add(PIN);
        JLabel PIn=new JLabel("(4-Digit PIN)");
        PIn.setFont(new Font("Aptos",Font.BOLD,12));
        PIn.setForeground(new Color(0, 0, 0));
        PIn.setBounds(100,390,200,25);
        add(PIn);
        JLabel Pin=new JLabel("XXXX");
        Pin.setFont(new Font("Aptos",Font.BOLD,22));
        Pin.setForeground(new Color(0, 0, 0));
        Pin.setBounds(350,370,200,25);
        add(Pin);
        JLabel Service=new JLabel("Services Required :");
        Service.setFont(new Font("Aptos",Font.BOLD,22));
        Service.setForeground(new Color(0, 0, 0));
        Service.setBounds(100,460,250,25);
        add(Service);
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Aptos",Font.BOLD,16));
        c1.setForeground(new Color(0, 0, 0));
        c1.setBackground(new Color(215, 252, 252));
        c1.setBounds(100,510,200,25);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Aptos",Font.BOLD,16));
        c2.setForeground(new Color(0, 0, 0));
        c2.setBackground(new Color(215, 252, 252));
        c2.setBounds(350,510,200,25);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Aptos",Font.BOLD,16));
        c3.setForeground(new Color(0, 0, 0));
        c3.setBackground(new Color(215, 252, 252));
        c3.setBounds(100,560,200,25);
        add(c3);
        c4 = new JCheckBox("Email Alert");
        c4.setFont(new Font("Aptos",Font.BOLD,16));
        c4.setForeground(new Color(0, 0, 0));
        c4.setBackground(new Color(215, 252, 252));
        c4.setBounds(350,560,200,25);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Aptos",Font.BOLD,16));
        c5.setForeground(new Color(0, 0, 0));
        c5.setBackground(new Color(215, 252, 252));
        c5.setBounds(100,610,200,25);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Aptos",Font.BOLD,16));
        c6.setForeground(new Color(0, 0, 0));
        c6.setBackground(new Color(215, 252, 252));
        c6.setBounds(350,610,200,25);
        add(c6);

        //we do not declare this last checkbox globally because we need not to stored it in table;
        Checkbox c7=new Checkbox("I here by declare that the above information are correct to the best of my knowledge",true);
        c7.setFont(new Font("Aptos",Font.BOLD,12));
        c7.setForeground(new Color(0, 0, 0));
        c7.setBackground(new Color(215, 252, 252));
        c7.setBounds(100,640,600,25);
        add(c7);

        next=new JButton("Submit");
        next.setBounds(550,680,150,35);
        next.setForeground(new Color(215, 252, 252));
        next.setFont(new Font("Aptos",Font.BOLD,28));
        next.setBackground(new Color(0,0,0));
        add(next);
        next.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(100,680,150,35);
        cancel.setForeground(new Color(215, 252, 252));
        cancel.setFont(new Font("Aptos",Font.BOLD,28));
        cancel.setBackground(new Color(0,0,0));
        add(cancel);
        cancel.addActionListener(this);



        setSize(800,800);
        setLocation(400,40);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(215,252,252));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type="";
        if(r1.isSelected()){
            type="Saving Account";
        } else if (r2.isSelected()) {
            type="Fixed Deposit Account";
        }else if (r3.isSelected()) {
            type="Current Account";
        }else if (r4.isSelected()) {
            type="Recurring Deposit Account";
        }

        Random ran=new Random();
        long first7=(ran.nextLong()%90000000L)+1409963000000000L;
        String cardno=""+Math.abs(first7);

        long first3=(ran.nextLong()%9000L)+1000L;
        String pin=""+Math.abs(first3);

        String facility="";
        if(c1.isSelected()){
            facility=facility+"ATM Card, ";
        }if(c2.isSelected()){
            facility=facility+"Internet Banking, ";
        }if(c3.isSelected()){
            facility=facility+"Mobile Banking, ";
        }if(c4.isSelected()){
            facility=facility+"Email Alert, ";
        }if(c5.isSelected()){
            facility=facility+"Cheque Book, ";
        }if(c6.isSelected()){
            facility=facility+"E-Statement";
        }

    try{
        if(e.getSource()==next){
            if(type.equals("")){
                JOptionPane.showMessageDialog(null,"Please select account type");
            }else{
                connection conn=new connection();
                String q1="insert into signup_3 values ('"+formno+"','"+type+"','"+cardno+"','"+pin+"','"+facility+"')";
                conn.stmt.executeUpdate(q1);
                String q2="insert into login values ('"+formno+"','"+cardno+"','"+pin+"')";
                conn.stmt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Account successfully created\n Card Number: "+cardno+"\n Pin:"+pin );
                new Deposit(pin);
                setVisible(false);
            }
        }else if(e.getSource()==cancel){
            System.exit(0);
        }

    }catch(Exception ex){
        ex.printStackTrace();
    }


    }

    public static void main(String[] args) {
    //object
    new Signup3("");
    }
}
