import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameOfLifeView extends JComponent implements GameOfLifeListener {
    private GameOfLifeModel gol;
    private int columns;
    private int rows;

    public GameOfLifeView(GameOfLifeModel gol) {
        this.gol = gol;
        // Observer hinzufügen
       // this.gol.addObserver(this);
        columns = gol.getColumns();
        rows = gol.getRows();
    }

    public void setGameOfLifeModel(GameOfLifeModel gol){
        this.gol = gol;
        this.gol.addObserver(this);
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
                    gc.setColor(Color.RED);
                    gc.fillOval(x,y,(int) columnsSize, (int) rowSize);
                    gc.setColor(Color.BLACK);
                }
            }
        }
    }

    @Override
    public void generationChanged(int generation) {
        this.repaint();
    }

    @Override
    public void dimensionChanged(int dimension) {
        GoLApp.setStatusAndDimensionLabel("                            Open  ",dimension + "x" + dimension);
        this.repaint();
    }
}

