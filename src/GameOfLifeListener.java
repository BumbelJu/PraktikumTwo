public interface GameOfLifeListener {
    void generationChanged(int generation);

    void dimensionChanged(int dimension);
}
