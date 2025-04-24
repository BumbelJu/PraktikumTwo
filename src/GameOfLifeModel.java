import java.util.Arrays;

public class GameOfLifeModel extends PatternFactory {
    private boolean[][] grid;
    private int generation;


    GameOfLifeModel(int rows, int columns) {
        grid = new boolean[rows][columns];
    }

    public int getGeneration(){
        return generation;
    }

    public void setStartingGrid(String startingPattern){
        if(startingPattern.equals("Glider")){
            grid = gliderPattern(grid.length);
        }
        if(startingPattern.equals("Standard")){
            grid = standardPattern(grid.length);
        }
        if(startingPattern.equals("Flyer")){
            grid = flyerPattern(grid.length);
        }
        if(startingPattern.equals("Cross")){
            grid = crossPattern(grid.length);
        }
    }

    public int getColumns(){
        return grid[0].length;
    }

    public int getRows(){
        return grid.length;
    }

    public boolean[][] getGrid(){
        return grid;
    }


    /**
     * Prüfe ob es noch lebende Zellen auf dem Spielfeld gibt.
     * */
    public boolean isAlive() {
        // TODO implement the isAlive method
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Berechne die nächste Generation des Game of Life Models
     */
    public void nextGeneration() {
        boolean[][] nextState = new boolean[this.grid.length][this.grid[0].length];

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                int counter = 0;

                // Nachbarn zählen (8 Richtungen)
                // dx steht für die Richtung Horizontal
                // dy steht für die Richtung Vertikal
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx == 0 && dy == 0) continue; // sich selbst überspringen

                        // Berechnung zur Berechnung des jeweiligen Nachbarn
                        int horizontalerNachbarPos = i + dx;
                        int vertikaleNachbarPos = j + dy;
                        if (horizontalerNachbarPos >= 0 && horizontalerNachbarPos < this.grid.length && vertikaleNachbarPos >= 0 && vertikaleNachbarPos < this.grid[0].length) {
                            if (this.grid[horizontalerNachbarPos][vertikaleNachbarPos]) {
                                counter++;
                            }
                        }
                    }
                }
                // Regeln anwenden
                if (grid[i][j]) {
                    nextState[i][j] = (counter == 2 || counter == 3);
                } else {
                    nextState[i][j] = (counter == 3);
                }
            }
        }
        // Neue Generation übernehmen
        this.grid = nextState;
        generation++;
    }


}
