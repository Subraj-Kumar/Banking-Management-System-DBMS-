package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//Extend JFrame and import class;
public class SignUp extends JFrame implements ActionListener {
    JButton next;
    //radio buttons are basically tick options;
    JRadioButton r1,r2, r3,r4,r5,r6;
    //we need to declare this globally so that we can store the input into our database later;
    JTextField textname, textfathername, textemail,textphone, Address,State, City,Pin;
    // with help of random command we can generate application form number;
    Random ran= new Random();
    //with help of below command we will generate a random 4-digit number;
    long app1 = (ran.nextLong() % 90000L)+ 10000L;
    //string app will store the randomly generated number;
    String app = "" + Math.abs(app1);
    //we need to insert a class from library to take date as input;
    JDateChooser DateChooser;
    //Create constructor;
    SignUp() {
        //Super is used to give the tile of the page;
    super("Application Form");
    ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("icons/one_bank_logo1.png"));
    Image logo2= logo1.getImage().getScaledInstance(180,110, Image.SCALE_SMOOTH);
    ImageIcon logo3 = new ImageIcon(logo2);
    JLabel logo= new JLabel(logo3);
    logo.setBounds(10,0,180,110);
    add(logo);

    JLabel label1 = new JLabel("APPLICATION FORM NO. "+ app);
    label1.setFont(new Font("Aptos",Font.BOLD,24));
    label1.setBounds(225,14,500,40);
    label1.setForeground(new Color(0, 0, 0));
    add(label1);

    JLabel label2 = new JLabel("Page 1");
    label2.setBounds(30,730,100,25);
    label2.setFont(new Font("Aptos",Font.BOLD,14));
    label2.setForeground(new Color(0, 0, 0));
    add(label2);

    JLabel label3=new JLabel("Personal Information");
    label3.setBounds(300,50,250,25);
    label3.setForeground(new Color(0, 0, 0));
    label3.setFont(new Font("Aptos",Font.BOLD,22));
    add(label3);

    JLabel name= new JLabel("Name :");
    name.setBounds(100,125,100,25);
    name.setForeground(new Color(0, 0, 0));
    name.setFont(new Font("Aptos",Font.BOLD,22));
    add(name);
    textname= new JTextField();
    textname.setBounds(325,125,350,25);
    textname.setFont(new Font("Aptos",Font.BOLD,14));
    add(textname);

    JLabel fathername= new JLabel("Father's Name :");
    fathername.setBounds(100,175,200,25);
    fathername.setForeground(new Color(0, 0, 0));
    fathername.setFont(new Font("Aptos",Font.BOLD,22));
    add(fathername);
    textfathername= new JTextField();
    textfathername.setBounds(325,175,350,25);
    textfathername.setFont(new Font("Aptos",Font.BOLD,14));
    add(textfathername);

    JLabel dob = new JLabel("Date of Birth :");
    dob.setBounds(100,225,200,25);
    dob.setForeground(new Color(0, 0, 0));
    dob.setFont(new Font("Aptos",Font.BOLD,22));
    add(dob);
    DateChooser= new JDateChooser();
    DateChooser.setForeground(new Color(61, 61, 61));
    DateChooser.setBounds(325,225,350,25);
    add(DateChooser);

    JLabel gender = new JLabel("Gender :");
    gender.setBounds(100,275,200,25);
    gender.setForeground(new Color(0, 0, 0));
    gender.setFont(new Font("Aptos",Font.BOLD,22));
    add(gender);
    r1=new JRadioButton("Male");
    r1.setFont(new Font("Aptos",Font.BOLD,14));
    r1.setBounds(325,275,100,25);
    r1.setBackground(new Color(222,255,228));
    r1.setForeground(new Color(0,0,0));
    add(r1);
    r2=new JRadioButton("Female");
    r2.setFont(new Font("Aptos",Font.BOLD,14));
    r2.setBounds(465,275,100,25);
    r2.setBackground(new Color(222,255,228));
    r2.setForeground(new Color(0,0,0));
    add(r2);
    r5=new JRadioButton("Other");
    r5.setFont(new Font("Aptos",Font.BOLD,14));
    r5.setBounds(605,275,100,25);
    r5.setBackground(new Color(222,255,228));
    r5.setForeground(new Color(0,0,0));
    add(r5);
    //we need to combine both the buttons so that when we select one the other get unselected;
    ButtonGroup buttonGroup=new ButtonGroup();
    buttonGroup.add(r1);
    buttonGroup.add(r2);
    buttonGroup.add(r5);

    JLabel email = new JLabel("Email :");
    email.setBounds(100,325,200,25);
    email.setForeground(new Color(0, 0, 0));
    email.setFont(new Font("Aptos",Font.BOLD,22));
    add(email);
    textemail= new JTextField ();
    textemail.setBounds(325,325,350,25);
    textemail.setFont(new Font("Aptos",Font.BOLD,14));
    add(textemail);

    JLabel phone = new JLabel("Phone Number :");
    phone.setBounds(100,375,200,25);
    phone.setForeground(new Color(0, 0, 0));
    phone.setFont(new Font("Aptos",Font.BOLD,22));
    add(phone);
    textphone= new JTextField();
    textphone.setBounds(325,375,350,25);
    textphone.setFont(new Font("Aptos",Font.BOLD,14));
    add(textphone);

    JLabel marrigeStatus = new JLabel("Marriage Status :");
    marrigeStatus.setBounds(100,425,200,25);
    marrigeStatus.setForeground(new Color(0, 0, 0));
    marrigeStatus.setFont(new Font("Aptos",Font.BOLD,22));
    add(marrigeStatus);
    r3=new JRadioButton("Married");
    r3.setFont(new Font("Aptos",Font.BOLD,14));
    r3.setBounds(325,425,100,25);
    r3.setBackground(new Color(222,255,228));
    r3.setForeground(new Color(0,0,0));
    add(r3);
    r4=new JRadioButton("Unmarried");
    r4.setFont(new Font("Aptos",Font.BOLD,14));
    r4.setBounds(465,425,100,25);
    r4.setBackground(new Color(222,255,228));
    r4.setForeground(new Color(0,0,0));
    add(r4);
    r6=new JRadioButton("Other");
    r6.setFont(new Font("Aptos",Font.BOLD,14));
    r6.setBounds(605,425,100,25);
    r6.setBackground(new Color(222,255,228));
    r6.setForeground(new Color(0,0,0));
    add(r6);
    ButtonGroup buttonGroup1=new ButtonGroup();
    buttonGroup1.add(r3);
    buttonGroup1.add(r4);
    buttonGroup1.add(r6);


    JLabel address = new JLabel("Address :");
    address.setBounds(100,475,200,25);
    address.setForeground(new Color(0, 0, 0));
    address.setFont(new Font("Aptos",Font.BOLD,22));
    add(address);
    Address = new JTextField();
    Address.setBounds(325,475,350,25);
    Address.setFont(new Font("Aptos",Font.BOLD,14));
    add(Address);

    JLabel state =  new JLabel("State :");
    state.setBounds(100,525,200,25);
    state.setForeground(new Color(0, 0, 0));
    state.setFont(new Font("Aptos",Font.BOLD,22));
    add(state);
    State= new JTextField();
    State.setBounds(325,525,350,25);
    State.setFont(new Font("Aptos",Font.BOLD,14));
    add(State);

    JLabel city = new JLabel("City :");
    city.setBounds(100,575,200,25);
    city.setForeground(new Color(0, 0, 0));
    city.setFont(new Font("Aptos",Font.BOLD,22));
    add(city);
    City= new JTextField();
    City.setBounds(325,575,350,25);
    City.setFont(new Font("Aptos",Font.BOLD,14));
    add(City);

    JLabel pin = new JLabel("Pin Code :");
    pin.setBounds(100,625,200,25);
    pin.setForeground(new Color(0, 0, 0));
    pin.setFont(new Font("Aptos",Font.BOLD,22));
    add(pin);
    Pin= new JTextField();
    Pin.setBounds(325,625,350,25);
    Pin.setFont(new Font("Aptos",Font.BOLD,14));
    add(Pin);

    next = new JButton("Next");
    next.setFont(new Font("Aptos",Font.BOLD,28));
    next.setForeground(new Color(222, 255, 228));
    next.setBackground(new Color(0,0,0));
    next.setBounds(625,720,100,35);
    next.addActionListener(this);
    add(next);


    setSize(800,800);
    setLocation(400,40);
    getContentPane().setBackground(new Color(222,255,228));
    setLayout(null);
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String formno= app;
    String nam= textname.getText();
    String fname= textfathername.getText();
    //we cannot get date of birth that easily because we are taking date from calendar ;
    String DOB = ((JTextField) DateChooser.getDateEditor().getUiComponent()).getText();
    //as gender is a radio button so taking input from it is also different;
    String Gender = null;
    if(r1.isSelected()){
        Gender="Male";
    }else if(r2.isSelected()){
        Gender="Female";
    }else if(r5.isSelected()){
        Gender="Other";
    }

    String mail= textemail.getText();
    String Phone= textphone.getText();

    //just like gender marital status is also a radio button;
    String marital= null;
    if(r3.isSelected()){
        marital="Married";
    }else if(r4.isSelected()){
        marital="Unmarried";
    }else if(r6.isSelected()){
        marital="Other";
    }
    String add= Address.getText();
    String sta= State.getText();
    String ci= City.getText();
    String pi= Pin.getText();
    //as there are high chances of error so we use try and catch;
    try{
    //as all the important information can not be empty so we will use if else statements:
        if(textname.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter your First Name");
        }else{
            connection con1 = new connection();
            //the below statement is a format to insert values into the database:
            String q = "insert into signup values('"+formno+"','"+nam+"','"+fname+"','"+DOB+"','"+Gender+"','"+mail+"','"+Phone+"','"+marital+"','"+add+"','"+sta+"','"+ci+"','"+pi+"')";
            //now the below statement is used to execute the values stored in the string q:
            con1.stmt.executeUpdate(q);
            //As we have to send the form number to the next form so we give app input to the next file;
            new SignUp2(formno);
            setVisible(false);
        }
    }catch(Exception E){
        E.printStackTrace();
    }
    }

    public static void main(String[] args) {
    new SignUp();

    }
}
