import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeModelTest {
    // Zu Praktikum 4
    public ArrayList<GameOfLifeListener> testobservers = new ArrayList<>();

    @Test
    public void setDimension(){
        GameOfLifeModel gol = new GameOfLifeModel(20,10);
        assertEquals(20, gol.getRows());
        assertEquals(10, gol.getColumns());

        gol.setDimensions(3,4);
        assertEquals(3, gol.getRows());
        assertEquals(4, gol.getColumns());
    }

    @Test
    public void setDimensionSmallerTest(){
        GameOfLifeModel gol = new GameOfLifeModel(3,4);
        assertEquals(3, gol.getRows());
        assertEquals(4, gol.getColumns());

        gol.setDimensions(1,2);
        assertEquals(1, gol.getRows());
        assertEquals(2, gol.getColumns());
    }

    @Test
    public void setStartingGrid() {
        GameOfLifeModel gol = new GameOfLifeModel(30, 30);
        boolean[][] pattern = PatternFactory.gliderPattern(30);
        gol.setStartingGrid("Glider");
        for(int i = 0; i < pattern.length; i++){
            for(int j = 0; j < pattern[i].length; j++){
                assertEquals(pattern[i][j], gol.getGrid()[i][j]);
            }
        }
    }

    // ZU Praktikum 4
    @Test
    public void addAndRemoveObserverTest(){
        GameOfLifeModel gol = new GameOfLifeModel(10,10);
        GoLApp.gameofLifeModel = gol;
        SwingApp testApp = new GoLApp();
        gol.addObserver((GameOfLifeListener) testApp);
        assertEquals(gol.observers.size(), 1);

        gol.removeObserver((GameOfLifeListener) testApp);
        assertEquals(gol.observers.size(), 0);
    }
    // Zu Praktikum 4
    @Test
    public void notifyObservers(){
        GameOfLifeModel gol = new GameOfLifeModel(10,10);
        GoLApp.gameofLifeModel = gol;
        SwingApp testApp = new GoLApp();
        SwingApp test2App = new GoLApp();
        gol.addObserver((GameOfLifeListener) testApp);
        gol.addObserver((GameOfLifeListener) test2App);
        assertEquals(gol.observers.size(), 2);

        // Prüfung ob die Generation und Start Dimension stimmte
        gol.notifyDimensionChanged();
        gol.notifyGenerationChanged();
        assertEquals(gol.getRows(), 10);
        assertEquals(gol.getGeneration(), 0);


        // Prüfung ob nach durchführung von nextGeneration und setDimensions, es immernoch im Model gleich ist.
        gol.nextGeneration();
        gol.setDimensions(20,20);
        gol.notifyDimensionChanged();
        gol.notifyGenerationChanged();
        assertEquals(gol.getRows(), 20);
        assertEquals(gol.getGeneration(), 1);
    }















































}