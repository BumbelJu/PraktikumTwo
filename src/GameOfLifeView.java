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


    public void paint(Graphics gc) {
        super.paint(gc);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        double cellWidth = (double) panelWidth / columns;
        double cellHeight = (double) panelHeight / rows;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = (int) Math.round(col * cellWidth);
                int y = (int) Math.round(row * cellHeight);
                int nextX = (int) Math.round((col + 1) * cellWidth);
                int nextY = (int) Math.round((row + 1) * cellHeight);
                int width = nextX - x;
                int height = nextY - y;

                gc.setColor(Color.BLACK);
                gc.drawRect(x, y, width, height);

                if (gol.getGrid()[col][row]) {
                    gc.setColor(Color.RED);
                    gc.fillOval(x, y, width, height);
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

