public class PatternFactory {

   /**
     * Factory method for a glider pattern.
     * @return pattern
     */
   public static boolean[][] gliderPattern(int dimension) {
       boolean[][] pattern = new boolean[dimension][dimension];
       // Startet zentriert oben links
       int x = 1, y = 1;
       pattern[y][x + 1] = true;
       pattern[y + 1][x + 2] = true;
       pattern[y + 2][x] = true;
       pattern[y + 2][x + 1] = true;
       pattern[y + 2][x + 2] = true;
       return pattern;
   }

    public static boolean[][] standardPattern(int dimension){
        boolean[][] pattern = new boolean[dimension][dimension];

        pattern[1][2] = pattern[2][3] = pattern[3][1] = pattern[3][2] = pattern[3][3] = true;

        return pattern;
    }

    public static boolean[][] flyerPattern(int dimension) {
        boolean[][] pattern = new boolean[dimension][dimension];
        // Drei Blinker horizontal nebeneinander
        pattern[4][3] = pattern[4][4] = pattern[4][5] = true; // Mitte
        pattern[2][1] = pattern[3][1] = pattern[4][1] = true; // Links
        pattern[6][8] = pattern[7][8] = pattern[8][8] = true; // Rechts
        return pattern;
    }

    public static boolean[][] crossPattern(int dimension) {
        boolean[][] pattern = new boolean[dimension][dimension];
        // Toad zentriert (6 Zellen in 2 Reihen)
        int x = 3, y = 4;
        pattern[y][x + 1] = true;
        pattern[y][x + 2] = true;
        pattern[y][x + 3] = true;

        pattern[y + 1][x] = true;
        pattern[y + 1][x + 1] = true;
        pattern[y + 1][x + 2] = true;

        return pattern;
    }










}
