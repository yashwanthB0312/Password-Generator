package Password_Generator_Java_Swing;

import javax.swing.*;
import java.util.Random;

public class PasswordGenerator {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = "abcdefghijklmnopqrstuvwxyz";
    public static final String num = "0123456789";
    public static final String sym = "!@#$%^&*()_+-=[]{}|;':,.<>?";

    private final Random rand;
    public PasswordGenerator(){rand =new Random();}

    public String generatepassword(int len,boolean uc,boolean lc,boolean nc,boolean sc){
        StringBuilder pass=new StringBuilder();
        String valid="";
        if(uc) valid+=upper;
        if(lc) valid+=lower;
        if(nc) valid+=num;
        if(sc) valid+=sym;
        if(len==0){
            JOptionPane.showMessageDialog(null, "Enter a valid number");
        }
        if(len>25){
            JOptionPane.showMessageDialog(null, "Enter a number within limit of 25");
        }
        for(int i=0;i<len;i++){
            int rindex=rand.nextInt(valid.length());
            char rchar=valid.charAt(rindex);
            pass.append(rchar);
        }
        return pass.toString();
    }
}
