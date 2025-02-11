import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;







public class Budget {
    public static void main (String [] args){
    

       ImageIcon image2 = new ImageIcon("Logo.png");
        
    JLabel label = new JLabel();
     label.setText("BudgeTech");
     label.setHorizontalAlignment(0);
     label.setVerticalAlignment(SwingConstants.TOP);
     label.setFont(new Font("null", Font.PLAIN, 50));
     label.setForeground(new Color(137, 137,137 ));
     label.setIcon(image2);
    

    JFrame frame = new JFrame();
       frame.setTitle("Budget Tracker");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
       frame.setVisible(true);
       frame.add(label);
       

       ImageIcon image = new ImageIcon("CAT copy.png");
       frame.setIconImage(image.getImage());
       frame.getContentPane().setBackground(new Color(230,230,250));

     

    }
}
