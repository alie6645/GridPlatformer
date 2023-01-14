import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        Grid grid = new Grid();
        Node player = new Node(100,10,grid);
        for (int i=0; i<10; i++){
            grid.add(i,5,true,true);
        }
        panel.add(grid);
        panel.add(player);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(415,400));
        frame.setVisible(true);

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.yChange += 1;
                player.update();
                panel.update();
            }
        });

        timer.start();
    }
}
