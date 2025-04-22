import javax.swing.*;
import java.awt.*;

public class GameOfLifeView extends JComponent {
    private final GameOfLifeModel gol = new GameOfLifeModel(19,19);

    private int columns = gol.getColumns();
    private int rows = gol.getRows();

    public GameOfLifeModel getGameOfLifeModel(){
        return gol;
    }

    public void paint(Graphics gc){
        JComponent component = this;
        Dimension d = new Dimension(200, 400);
        component.setMinimumSize(d);

        // Rechteck Größe berechnen
        double columnsSize = (double) getWidth() / columns;
        double rowSize = (double) getHeight() / rows;

        super.paintComponent(gc);
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
