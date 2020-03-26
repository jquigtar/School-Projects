import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyWindow extends JFrame implements MouseListener {
    // this is an array of locations where the mouse has been clicked:
    private ArrayList<Point> clicks = new ArrayList<Point>();
    
    public MyWindow() {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
        
        
    }
    public void mouseClicked(MouseEvent e){
        // the MouseEvent e stores info about the mouse, like 
        // where it has just been clicked:
        int x = e.getX();
        int y = e.getY();
        Point mostRecentMouseClick = new Point(x,y);
        clicks.add(mostRecentMouseClick); // add this click to "clicks"
        System.out.println("MouseClicked at " + x + ", " + y);

    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
        repaint(); // this make a blank canvas and call paint() again.
    }
    
    public void paint(Graphics g){
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
     
        // draw lines from each point to the next:
        // (we start with index 1, because we don't want to start
        // doing this unless we've got at least 2 clicks in there. )
        for(int i=1; i<clicks.size(); i++){
            // get the point before this one, and this one:
            Point p1 = clicks.get(i-1);
            Point p2 = clicks.get(i);
            // get their x and y coordinates:
            int p1_x = (int)p1.getX();
            int p1_y = (int)p1.getY();
            int p2_x = (int)p2.getX();
            int p2_y = (int)p2.getY();
            // use those coordinates to draw the line:
            g2.drawLine( p1_x, p1_y, p2_x, p2_y );
            
        }
        
        // what would happen if instead we drew a line from every 
        // point to every other point in clicks?
        // (use a nested for loop)
        
        
    }
    
}
