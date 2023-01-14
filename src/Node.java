import java.awt.*;

public class Node implements Drawable{
    int x;
    int y;
    int height = 10;
    int width = 10;
    int xChange;
    int yChange;
    Grid grid;

    public Node(int x, int y,Grid grid){
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public void update(){
        int xAdjust;
        int yAdjust;
        if (x>0){
            xAdjust = -1;
        } else {
            xAdjust = 1;
        }
        if (y>0){
            yAdjust = -1;
        } else {
            yAdjust = 1;
        }
        boolean xCross = grid.translate(x)!=grid.translate(x+xChange);
        boolean yCross = grid.translate(y)!=grid.translate(y+yChange);
        if(yCross&&!xCross){
            if (grid.getCell(grid.translate(x),grid.translate(y+yChange)).ceiling){
                setPosition(x+xChange+xAdjust, grid.getEdge(grid.translate(y+yChange)+yAdjust));
                yChange = 0;
            }
        } else if (xCross&&!yCross){
            if (grid.getCell(grid.translate(x),grid.translate(y+yChange)).ceiling){
                setPosition(grid.getEdge(grid.translate(x+xChange))+xAdjust,y+yChange+yAdjust);
                xChange = 0;
            }

        } else if (xCross&&yCross){
            System.out.println("AHHHHH!!!");
        }
        this.x += xChange;
        this.y += yChange;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2){
        g2.fillRect(x,y,width,height);
    }
}
