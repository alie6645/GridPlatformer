import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    public int height;
    public int width;
    public int size = 100;
    GridCell[][] cells = new GridCell[10][10];
    public void add(int x, int y, boolean wall, boolean ceiling){
        cells[x][y] = new GridCell(wall,ceiling);
    }

    public int translate(int value){
        return value/10;
    }

    public getCell()
}
