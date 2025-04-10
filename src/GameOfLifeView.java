import javax.swing.*;
import java.awt.*;

public class GameOfLifeView extends JComponent {
   static final GameOfLifeModel gol = new GameOfLifeModel();

   private double columnsCount = (double) getWidth() / gol.getColumns();

   private double rowsCount = (double) getHeight() / gol.getRows();

    public void paint(Graphics gc){

        super.paintComponent(gc);
        gc.setColor(Color.BLACK);
        for (int x = 0; x < getWidth(); x+=columnsCount) {
            for(int y = 0; y <= getHeight(); y+=rowsCount){
                gc.drawRect(x,y,30,30);
            }
        }
    }













}
