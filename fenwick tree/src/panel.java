import java.awt.*;
import javax.swing.*;

public class panel extends JPanel{

 //Image image;
 
 panel(){
 
  this.setPreferredSize(new Dimension(1200,1200));
 }
 
 public void paint(Graphics g) {
  
  Graphics2D g2D = (Graphics2D) g;
  
  //g2D.drawImage(image, 0, 0, null);
  
  g2D.setPaint(Color.blue);
  g2D.setStroke(new BasicStroke(5));
  g2D.drawLine(100, 100, 900,900);
  
 }
}