package Password_Generator_Java_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("PASSWORD GENERATOR");
        setSize(400,450);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator=new PasswordGenerator();
        addGuicomponents();
    }
    public void addGuicomponents(){
        //label
        JLabel a=new JLabel("Password Generator");
        a.setFont(new Font("Dialog",Font.BOLD,25));
        a.setHorizontalAlignment(SwingConstants.CENTER);
        a.setBounds(0,15,380,20);
        add(a);

        //textarea
        JTextArea b=new JTextArea();
        b.setEditable(false);
        b.setFont(new Font("Dialog",Font.PLAIN,20));
        b.setBounds(20,60,345,30);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(b);

        //password length
        JLabel c=new JLabel("Password Length : ");
        c.setFont(new Font("Dialog",Font.PLAIN,20));
        c.setHorizontalAlignment(SwingConstants.CENTER);
        c.setBounds(0,110,260,30);
        add(c);

        //password length textarea
        JTextArea d=new JTextArea();
        d.setFont(new Font("Dialog",Font.PLAIN,20));
        d.setBounds(220,110,120,30);
        d.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(d);

        //toggle buttons
        JToggleButton upper=new JToggleButton("UPPERCASE");
        upper.setFocusable(false);
        upper.setFont(new Font("Dialog",Font.PLAIN,20));
        upper.setBounds(20,200,165,30);
        add(upper);

        JToggleButton lower=new JToggleButton("LOWERCASE");
        lower.setFocusable(false);
        lower.setFont(new Font("Dialog",Font.PLAIN,20));
        lower.setBounds(200,200,165,30);
        add(lower);

        JToggleButton sym=new JToggleButton("SYMBOLS");
        sym.setFocusable(false);
        sym.setFont(new Font("Dialog",Font.PLAIN,20));
        sym.setBounds(20,250,165,30);
        add(sym);

        JToggleButton num=new JToggleButton("NUMBERS");
        num.setFocusable(false);
        num.setFont(new Font("Dialog",Font.PLAIN,20));
        num.setBounds(200,250,165,30);
        add(num);

        JButton e=new JButton(" GENERATE ");
        e.setFont(new Font("Dialog",Font.PLAIN,22));
        e.setHorizontalAlignment(SwingConstants.CENTER);
        e.setFocusable(false);
        e.setBounds(100,320,180,30);
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(d.getText().length()<=0 && d.getText().length()>=25) return;
                boolean tb=upper.isSelected() || lower.isSelected() || sym.isSelected() || num.isSelected();
                int s=Integer.parseInt(d.getText());
                if(tb){
                    String newpass=passwordGenerator.generatepassword(s,upper.isSelected() ,lower.isSelected() ,num.isSelected(),sym.isSelected());
                    b.setText(newpass);
                }
            }
        });
        add(e);

    }
}
