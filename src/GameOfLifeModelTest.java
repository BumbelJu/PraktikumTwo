import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeModelTest {

    @org.junit.jupiter.api.Test
    void nextGeneration() {
        GameOfLifeModel gameofLifeModel = new GameOfLifeModel(4,4);
        gameofLifeModel.set(0,0, true);
        gameofLifeModel.set(0,3, true);
        gameofLifeModel.set(3,0, true);
        gameofLifeModel.set(3,3, true);
        gameofLifeModel.nextGeneration();
        assertFalse(gameofLifeModel.isAlive());
        // Prüfen ob nach einer Generation die Zelle in 2, 3 noch lebt.
        assertFalse(gameofLifeModel.getGrid()[2][3]);

        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(4,4);
        gameofLifeModel.set(0,0, true);
        gameofLifeModel.set(0,1, true);
        gameofLifeModel.set(1,2, true);
        gameofLifeModel.set(2,2, true);

        gameofLifeModel.nextGeneration();
        assertTrue(gameofLifeModel.isAlive());
    }
}