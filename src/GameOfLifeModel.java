public class GameOfLifeModel {
    private boolean[][] grid;
    private int generation;


    GameOfLifeModel(int rows, int columns) {
        grid = new boolean[rows][columns];
        // Werte setzen, damit das Array gefüllt wird und die Länge abgefragt werden kann.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = false;
            }
        }
        setStartingGrid();
    }

    public int getGeneration(){
        return generation;
    }

    public void setStartingGrid(){
        grid[8][6] = true;
        grid[9][6] = true;
        grid[10][6] = true;
        grid[7][7] = true;
        grid[9][7] = true;
        grid[10][7] = true;
        grid[11][7] = true;
        grid[12][7] = true;
        grid[11][8] = true;
        grid[12][8] = true;
        grid[8][11] = true;
        grid[9][11] = true;
//        grid[10][11] = true;
//        grid[14][11] = true;
//        grid[15][11] = true;
//        grid[16][11] = true;
//        grid[16][11] = true;
//        grid[12][13] = true;
//        grid[12][14] = true;
//        grid[12][15] = true;
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
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < grid.length; j++) {
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
        boolean[][] nextState = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
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
                        if (horizontalerNachbarPos >= 0 && horizontalerNachbarPos < grid.length && vertikaleNachbarPos >= 0 && vertikaleNachbarPos < grid[0].length) {
                            if (grid[horizontalerNachbarPos][vertikaleNachbarPos]) {
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
        grid = nextState;
        generation++;

    }


}
