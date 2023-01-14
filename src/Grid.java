import java.awt.*;

public class Grid implements Drawable{
    public int height;
    public int width;
    public int size = 400;
    public int squares = 10;
    GridCell[][] cells = new GridCell[squares][squares];

    //Constructs an empty grid
    public Grid(){
        for (int x=0; x<squares; x++) {
            for (int y = 0; y < squares; y++) {
                cells[x][y] = new GridCell(false,false);
            }
        }
    }

    public void add(int x, int y, boolean wall, boolean ceiling){
        cells[x][y] = new GridCell(wall,ceiling);
    }

    public int translate(int value){
        return value/(size/squares);
    }

    public int getEdge(int value){
        return value * (size/squares);
    }

    public GridCell getCell(int x, int y){
        return cells[x][y];

    }

    @Override
    public void draw(Graphics2D g2) {
        int length = size/squares;
        for (int x=0; x<squares; x++){
            for (int y=0; y<squares; y++){
                GridCell active = getCell(x,y);
                int startX = x * length;
                int startY = y * length;
                if (active.ceiling){
                    g2.drawLine(startX,startY,startX + length,startY);
                }
                if (active.wall){
                    g2.drawLine(startX,startY,startX,startY + length);
                }
            }
        }
    }
}