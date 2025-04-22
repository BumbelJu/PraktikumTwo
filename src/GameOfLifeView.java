import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameOfLifeView extends JComponent {
    private GameOfLifeModel gol;
    private int columns;
    private int rows;
    public GameOfLifeView(GameOfLifeModel gol) {
        this.gol = gol;
        columns = gol.getColumns();
        rows = gol.getRows();
    }


    public void paint(Graphics gc){
        super.paint(gc);

        // Rechteck Größe berechnen
        double columnsSize = (double) getWidth() / columns;
        double rowSize = (double) getHeight() / rows;

        gc.setColor(Color.BLACK);
        for (int x = 0; x < getWidth(); x+= (int) columnsSize) {
            for(int y = 0; y < getHeight(); y+= (int) rowSize) {
                gc.drawRect(x,y, (int) columnsSize, (int) rowSize);
                if(gol.getGrid()[(int) (x / columnsSize)][(int) (y / rowSize)]){
                    gc.setColor(Color.BLUE);
                    gc.fillOval(x,y,(int) columnsSize, (int) rowSize);
                    gc.setColor(Color.BLACK);
                }
            }
        }
    }













}
