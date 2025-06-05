import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoLApp extends SwingApp implements GameOfLifeListener{
    public static boolean showComponents = false;

    int maxGeneration = 30;

    public GameOfLifeView view;
    public static GameOfLifeModel gameofLifeModel;
    public static boolean shouldRun = false;

    public static int dimension = 10;
    public static String pattern = "Standard";
    public static JLabel actualDimension;
    public static JLabel statusLabel;
    JButton startStopButton;
    JMenuItem startStop;

    @Override
    protected JComponent createToolBar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);
        startStopButton = new JButton("Start");
        // Button Funktion für Start und Stop implementierung
        startStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
               toggleStartStop();
            }
        });

        tb.add(startStopButton);
        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameofLifeModel.nextGeneration();
            }
        });
        tb.add(stepButton);

        return tb;
    }

    @Override
    protected JComponent createContent() {
        this.view = new GameOfLifeView(gameofLifeModel);
        return view;
    }

    @Override
    protected JComponent createStatusBar(JTextField status) {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        JPanel statusBar = new JPanel(layout);
        if(showComponents) {
            Border bo = new LineBorder(Color.red,2);
            statusBar.setBorder(bo);
        }
        statusBar.setToolTipText("Status");
        String msg = "Generation: ";
        Font font = status.getFont();
        int height = font.getSize() + 8;
        int width = 25 * msg.length();
        status.setText(msg);
        Dimension dim = new Dimension(width, height);
        status.setMaximumSize(dim);
        status.setMinimumSize(dim);
        status.setPreferredSize(dim);
        status.setEnabled(false);
        status.setDisabledTextColor(Color.blue);
        statusBar.add(new JLabel("Status: "));
        statusBar.add(status);
        statusBar.setSize(width * 3, height *2 );
        // Neues Label für die Dimensionsanzeigen erstellen (Praktikum 4)
        if(shouldRun){
            statusLabel = new JLabel("                            Open  ");
            actualDimension = new JLabel(dimension+"x"+dimension);
        } else {
            statusLabel = new JLabel("                            Closed  ");
            actualDimension = new JLabel(dimension+"x"+dimension);
        }
        statusLabel.setForeground(Color.blue);
        actualDimension.setForeground(Color.lightGray);
        statusBar.add(statusLabel);
        statusBar.add(actualDimension);
        return statusBar;
    }

    @Override
    protected JMenuBar createMenuBar() {
        JToolBar tb = (JToolBar) createToolBar();
        JMenuBar mb = new JMenuBar();
        mb.setToolTipText("Umgesetzte Funktionen in der MenuBar");
        JMenu menu = new JMenu();
        // Deklaraetion des Start - Stop Buttons und des Exit Buttons
        startStop = new JMenuItem("Start");
        JMenuItem exit;

        if(showComponents) {
            Border bo = new LineBorder(Color.blue, 3);
            mb.setBorder(bo);
        }
        menu.setText("File");
        menu.setToolTipText("Start und Exit");
        mb.add(menu);
        startStop = new JMenuItem("Start");
        menu.add(startStop);
        exit = new JMenuItem ("Exit");
        menu.add(exit);

        // Button Funktion für Start und Stop implementierung
        startStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                toggleStartStop();
            }
        });
        // Button Funktion die das Projekt schließt.
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                shutDown();
            }
        });

        menu = new JMenu();
        mb.add(menu);
        menu.setText("Settings");
        JMenuItem tenXTen;
        tenXTen = new JMenuItem("10x10");
        menu.add(tenXTen);
        tenXTen.setToolTipText("set dimension to 10x10");
        tenXTen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dimension = 10;
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                gameofLifeModel.notifyDimensionChanged();
            }
        });

        JMenuItem twentyXTwenty;
        twentyXTwenty = new JMenuItem("20x20");
        menu.add(twentyXTwenty);
        twentyXTwenty.setToolTipText("set dimension to 20x20");
        twentyXTwenty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dimension = 20;
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                gameofLifeModel.notifyDimensionChanged();
            }
        });

        JMenuItem thirtyXThirty;
        thirtyXThirty = new JMenuItem("30x30");
        menu.add(thirtyXThirty);
        thirtyXThirty.setToolTipText("set dimension to 30x30");
        thirtyXThirty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dimension = 30;
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                gameofLifeModel.notifyDimensionChanged();
            }
        });

        JMenuItem fortyXForty;
        fortyXForty = new JMenuItem("40x40");
        menu.add(fortyXForty);
        fortyXForty.setToolTipText("set dimension to 40x40");
        fortyXForty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dimension = 40;
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                gameofLifeModel.notifyDimensionChanged();
            }
        });

        JMenuItem fiftyXFifty;
        fiftyXFifty = new JMenuItem("50x50");
        menu.add(fiftyXFifty);
        fiftyXFifty.setToolTipText("set dimension to 50x50");
        fiftyXFifty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dimension = 50;
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                gameofLifeModel.notifyDimensionChanged();

            }
        });

        menu = new JMenu();
        mb.add(menu);
        menu.setText("Pattern");
        JMenuItem item = new JMenuItem("Glider");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                pattern = "Glider";
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                view.revalidate();
                view.repaint();
            }
        });

        item = new JMenuItem("Standard");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                pattern = "Standard";
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                view.revalidate();
                view.repaint();
            }
        });

        item = new JMenuItem("Flyer");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                pattern = "Flyer";
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                view.revalidate();
                view.repaint();
            }
        });

        item = new JMenuItem("Cross");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                gameofLifeModel = new GameOfLifeModel(dimension,dimension);
                pattern = "Cross";
                gameofLifeModel.setStartingGrid(pattern);
                view.setGameOfLifeModel(gameofLifeModel);
                view.revalidate();
                view.repaint();
            }
        });

        return mb;
    }

    @Override
    public void startUp(){
        super.startUp();
        do{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // ignore
            }
            if(shouldRun){
                gameofLifeModel.nextGeneration();
            }
        } while(gameofLifeModel.isAlive() && gameofLifeModel.getGeneration() < maxGeneration);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        GoLApp.gameofLifeModel = new GameOfLifeModel(dimension,dimension);
        gameofLifeModel.setStartingGrid(pattern);
        SwingApp app = new GoLApp();
        gameofLifeModel.addObserver((GameOfLifeListener) app);
        app.startUp();
    }


    public static void setStatusAndDimensionLabel(String status, String dimension){
        if(!shouldRun){
            statusLabel.setText("                            Closed  ");
        } else {
            statusLabel.setText(status);
        }
        actualDimension.setText(dimension);
    }

    public void generationChanged(int generation) {
        setStatusMsg("run generation " + generation);
        view.repaint();
    }

    public void dimensionChanged(int dimension) {
        if(!shouldRun){
            statusLabel.setText("                            Closed  ");
        } else {
            statusLabel.setText("                            Open  ");
        }
        actualDimension.setText(dimension + "x" + dimension);
        view.repaint();
    }

    private void toggleStartStop() {
        shouldRun = !shouldRun;
        String text = shouldRun ? "Stop" : "Start";
        if (startStopButton != null) {
            startStopButton.setText(text);
        }
        if (startStop != null) {
            startStop.setText(text);
        }
        gameofLifeModel.notifyDimensionChanged();
    }
}
