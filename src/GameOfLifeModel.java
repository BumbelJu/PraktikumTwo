public class GameOfLifeModel {
    private boolean[][] grid = new boolean[8][8];

    public int getColumns(){
        return grid.length;
    }

    public int getRows(){
        return grid[0].length;
    }




}
