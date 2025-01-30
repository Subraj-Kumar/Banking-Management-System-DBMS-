package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JComboBox;

public class SignUp2 extends JFrame implements ActionListener {
    String formno;
    //To create a drop-down menu we use LComboBox;
    JComboBox combobox1,combobox2,combobox3,combobox4,combobox5;
    JTextField pan,aadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    SignUp2(String formno){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/one_bank_logo1.png"));
        Image i2=i1.getImage().getScaledInstance(180, 110, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la = new JLabel(i3);
        la.setBounds(10,0,180,110);
        add(la);

        this.formno = formno;

        JLabel label1 = new JLabel("APPLICATION FORM NO. "+ formno);
        label1.setFont(new Font("Aptos",Font.BOLD,24));
        label1.setBounds(255,14,500,40);
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        JLabel l2 = new JLabel("Page 2");
        l2.setBounds(30,730,100,25);
        l2.setFont(new Font("Aptos", Font.BOLD, 14));
        l2.setForeground(new Color(0, 0, 0));
        add(l2);

        JLabel label3=new JLabel("Additional Details");
        label3.setBounds(330,50,250,25);
        label3.setForeground(new Color(0, 0, 0));
        label3.setFont(new Font("Aptos",Font.BOLD,22));
        add(label3);

        JLabel Religion = new JLabel("Religion :");
        Religion.setBounds(100,150,150,25);
        Religion.setForeground(new Color(0, 0, 0));
        Religion.setFont(new Font("Aptos",Font.BOLD,22));
        add(Religion);
        //we form an array with all the options available with us to form the drop-down menu;
        String religion[] ={"Select","Hindu","Muslim","Sikh","Christian","Other"};
        combobox1 = new JComboBox(religion);
        combobox1.setBounds(325,150,350,25);
        combobox1.setForeground(new Color(0, 0, 0));
        combobox1.setFont(new Font("Aptos",Font.BOLD,14));
        combobox1.setBackground(new Color(252,208,76));
        add(combobox1);

        JLabel Category = new JLabel("Category :");
        Category.setBounds(100,200,150,25);
        Category.setForeground(new Color(0, 0, 0));
        Category.setFont(new Font("Aptos",Font.BOLD,22));
        add(Category);
        String category[] = {"Select","General","OBC","SC","ST","PWD","Other"};
        combobox2 = new JComboBox(category);
        combobox2.setBounds(325,200,350,25);
        combobox2.setForeground(new Color(0, 0, 0));
        combobox2.setFont(new Font("Aptos",Font.BOLD,14));
        combobox2.setBackground(new Color(252,208,76));
        add(combobox2);

        JLabel Income = new JLabel("Income :");
        Income.setBounds(100,250,150,25);
        Income.setForeground(new Color(0, 0, 0));
        Income.setFont(new Font("Aptos",Font.BOLD,22));
        add(Income);
        String income[]={"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000",">10,00,000"};
        combobox3 = new JComboBox(income);
        combobox3.setBounds(325,250,350,25);
        combobox3.setForeground(new Color(0, 0, 0));
        combobox3.setFont(new Font("Aptos",Font.BOLD,14));
        combobox3.setBackground(new Color(252,208,76));
        add(combobox3);

        JLabel Education=new JLabel("Education :");
        Education.setBounds(100,300,150,25);
        Education.setForeground(new Color(0, 0, 0));
        Education.setFont(new Font("Aptos",Font.BOLD,22));
        add(Education);
        String education[]={"Select","Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        combobox4 = new JComboBox(education);
        combobox4.setBounds(325,300,350,25);
        combobox4.setForeground(new Color(0, 0, 0));
        combobox4.setFont(new Font("Aptos",Font.BOLD,14));
        combobox4.setBackground(new Color(252,208,76));
        add(combobox4);

        JLabel Occupation=new JLabel("Occupation :");
        Occupation.setBounds(100,350,150,25);
        Occupation.setForeground(new Color(0, 0, 0));
        Occupation.setFont(new Font("Aptos",Font.BOLD,22));
        add(Occupation);
        String occupation[]={"Select","Salaried","Self-Employed","Business","Student","Retired","Homemaker","Other"};
        combobox5 = new JComboBox(occupation);
        combobox5.setBounds(325,350,350,25);
        combobox5.setForeground(new Color(0, 0, 0));
        combobox5.setFont(new Font("Aptos",Font.BOLD,14));
        combobox5.setBackground(new Color(252,208,76));
        add(combobox5);

        JLabel Pan=new JLabel("PAN Number :");
        Pan.setBounds(100,400,200,25);
        Pan.setForeground(new Color(0, 0, 0));
        Pan.setFont(new Font("Aptos",Font.BOLD,22));
        add(Pan);
        pan=new JTextField();
        pan.setBounds(325,400,350,25);
        pan.setForeground(new Color(0, 0, 0));
        pan.setBackground(new Color(255,255,255));
        pan.setFont(new Font("Aptos",Font.BOLD,14));
        add(pan);

        JLabel Aadhar=new JLabel("Aadhar Number:");
        Aadhar.setBounds(100,450,200,25);
        Aadhar.setForeground(new Color(0, 0, 0));
        Aadhar.setFont(new Font("Aptos",Font.BOLD,22));
        add(Aadhar);
        aadhar=new JTextField();
        aadhar.setBounds(325,450,350,25);
        aadhar.setForeground(new Color(0, 0, 0));
        aadhar.setBackground(new Color(255,255,255));
        aadhar.setFont(new Font("Aptos",Font.BOLD,14));
        add(aadhar);

        JLabel Seniority=new JLabel("Senior Citizen :");
        Seniority.setBounds(100,500,200,25);
        Seniority.setForeground(new Color(0, 0, 0));
        Seniority.setFont(new Font("Aptos",Font.BOLD,22));
        add(Seniority);
        r1=new JRadioButton("Yes");
        r1.setBounds(325,500,150,25);
        r1.setForeground(new Color(0, 0, 0));
        r1.setFont(new Font("Aptos",Font.BOLD,16));
        r1.setBackground(new Color(252,208,76));
        add(r1);
        r2=new JRadioButton("No");
        r2.setBounds(550,500,150,25);
        r2.setForeground(new Color(0, 0, 0));
        r2.setFont(new Font("Aptos",Font.BOLD,16));
        r2.setBackground(new Color(252,208,76));
        add(r2);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel Existing =new JLabel("Existing Account :");
        Existing.setBounds(100,550,200,25);
        Existing.setForeground(new Color(0, 0, 0));
        Existing.setFont(new Font("Aptos",Font.BOLD,22));
        add(Existing);
        e1=new JRadioButton("Yes");
        e1.setBounds(325,550,150,25);
        e1.setForeground(new Color(0, 0, 0));
        e1.setFont(new Font("Aptos",Font.BOLD,16));
        e1.setBackground(new Color(252,208,76));
        add(e1);
        e2=new JRadioButton("No");
        e2.setBounds(550,550,150,25);
        e2.setForeground(new Color(0, 0, 0));
        e2.setFont(new Font("Aptos",Font.BOLD,16));
        e2.setBackground(new Color(252,208,76));
        add(e2);
        ButtonGroup b1=new ButtonGroup();
        b1.add(e1);
        b1.add(e2);

        next=new JButton("Next");
        next.setBounds(625,670,100,35);
        next.setForeground(new Color(252,208,76));
        next.setFont(new Font("Aptos",Font.BOLD,28));
        next.setBackground(new Color(0,0,0));
        add(next);
        next.addActionListener(this);


        setSize(800,800);
        setLocation(400,40);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(252,208,76));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String rel=(String) combobox1.getSelectedItem();
    String cat=(String) combobox2.getSelectedItem();
    String income=(String) combobox3.getSelectedItem();
    String edu=(String) combobox4.getSelectedItem();
    String occ=(String) combobox5.getSelectedItem();

    String pan_no=pan.getText();
    String aadhar_no=aadhar.getText();

    String senior=null;
    if(r1.isSelected()){
        senior="Yes";
    }else if(r2.isSelected()){
        senior="No";
    }

    String existing=null;
    if(r1.isSelected()){
        existing="Yes";
    }else if(r2.isSelected()){
        existing="No";
    }
    try{
        //Here we will write code for thw situation when either pan no. or aadhar no. is not provided:
        if(pan.getText().equals("")||aadhar.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all details");
        }else{
           connection c1=new connection();
           String a="insert into signup_2 values ('"+formno+"','"+rel+"','"+cat+"','"+income+"','"+edu+"','"+occ+"','"+pan_no+"','"+aadhar_no+"','"+senior+"','"+existing+"')";
           c1.stmt.executeUpdate(a);
           new Signup3(formno);
           setVisible(false);
        }
    }catch(Exception ex){
        ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        //We need to put empty string to avoid the error we got from taking form no. as input from previous page;
        new SignUp2("");
}
}
