import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JComponent {
    List<Drawable> components = new ArrayList<>();

    public void add(Drawable draw){
        components.add(draw);
    }

    public void update(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Drawable drawing:components){
            drawing.draw(g2);
        }
    }
}
