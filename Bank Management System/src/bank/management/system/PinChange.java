package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    PinChange(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/output-onlinepngtools (1).png"));
        Image i2=i1.getImage().getScaledInstance(1600,920, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-10,0,1600,920);
        add(l1);

        JLabel l2=new JLabel("Change Your Pin");
        l2.setBounds(700,50,700,35);
        l2.setFont(new Font("Style",Font.BOLD,28));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        JLabel l3=new JLabel("New Pin :");
        l3.setBounds(600,100,150,35);
        l3.setFont(new Font("Style",Font.BOLD,23));
        l3.setForeground(Color.WHITE);
        l1.add(l3);

        p1=new JPasswordField();
        p1.setBounds(850,100,200,35);
        p1.setFont(new Font("Style",Font.BOLD,28));
        p1.setForeground(Color.BLACK);
        p1.setBackground(Color.WHITE);
        l1.add(p1);

        JLabel l4=new JLabel("Re-Enter New Pin :");
        l4.setBounds(600,150,250,35);
        l4.setFont(new Font("Style",Font.BOLD,23));
        l4.setForeground(Color.WHITE);
        l1.add(l4);

        p2=new JPasswordField();
        p2.setBounds(850,150,200,35);
        p2.setFont(new Font("Style",Font.BOLD,28));
        p2.setForeground(Color.BLACK);
        p2.setBackground(Color.WHITE);
        l1.add(p2);

        b1=new JButton("Change");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Style",Font.BOLD,28));
        b1.setBounds(100,300,300,50);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Back");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Style",Font.BOLD,28));
        b2.setBounds(1190,300,300,50);
        b2.addActionListener(this);
        l1.add(b2);


        setLayout(null);
        setSize(1600,920);
        setLocation(-10,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            String pin1=p1.getText();
            String pin2=p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                return;
            }if(e.getSource()==b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New Pin");
                    return;
                }
                if(p2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Re-Enter New Pin ");
                return;
                }
                connection connection =new connection();
                String q1="update deposit set pin='"+pin1+"' where pin='"+pin+"'";
                String q2="update login set pin='"+pin1+"' where pin='"+pin+"'";
                String q3="update signup_3 set pin='"+pin1+"' where pin='"+pin+"'";
                connection.stmt.executeUpdate(q1);
                connection.stmt.executeUpdate(q2);
                connection.stmt.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Your Pin has been changed");
                setVisible(false);
                new Main_Class(pin);
            }else if(e.getSource()==b2){
                new Main_Class(pin);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
