public class PatternFactory {

   /**
     * Factory method for a glider pattern.
     * @return pattern
     */
    public static boolean[][] gliderPattern(int dimension) {
        boolean[][] pattern = new boolean[dimension][dimension];
        //{{false,true,false},{false,false,true},{true,true,true}};
        pattern[0][1] = true;
        pattern[1][2] = true;
        pattern[2][0] = true;
        pattern[2][1] = true;
        pattern[2][2] = true;
        return pattern;
    }

    public static boolean[][] standardPattern(int dimension){
        boolean[][] pattern = new boolean[dimension][dimension];

        pattern[1][2] = pattern[2][3] = pattern[3][1] = pattern[3][2] = pattern[3][3] = true;

        return pattern;
    }

    public static boolean[][] flyerPattern(int dimension) {
        boolean[][] pattern = new boolean[dimension][dimension];

        pattern[0][1] = true;
        pattern[1][1] = true;
        pattern[2][1] = true;
        pattern[2][0] = true;
        pattern[0][2] = true;
        pattern[1][2] = true;

        return pattern;
    }

    /**
     * Factory method for two crossed blinker.
     * @return pattern
     */
    public static boolean[][] crossPattern(int dimension) {
        boolean[][] pattern = new boolean[dimension][dimension];
        pattern[0][1] = true;
        pattern[1][0] = true;
        pattern[1][1] = true;
        pattern[1][2] = true;
        pattern[2][1] = true;
        return pattern;
    }










}
