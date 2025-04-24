import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GoLApp extends SwingApp{
    public static boolean showComponents = false;

    int maxGeneration = 50;

    private GameOfLifeView view;
    public static GameOfLifeModel gameofLifeModel;



    @Override
    protected JComponent createToolBar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);
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
        int width = 8 * msg.length();
        status.setText(msg);
        Dimension dim = new Dimension(width, height);
        status.setMaximumSize(dim);
        status.setMinimumSize(dim);
        status.setPreferredSize(dim);
        statusBar.add(new JLabel("Status: "));
        statusBar.add(status);
        return statusBar;
    }

    @Override
    protected JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
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
            gameofLifeModel.nextGeneration();
            view.repaint();
        } while(gameofLifeModel.isAlive() && gameofLifeModel.getGeneration() < maxGeneration);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        GoLApp.gameofLifeModel = new GameOfLifeModel(19,19);
        gameofLifeModel.setStartingGrid();
        SwingApp app = new GoLApp();
        app.startUp();
    }
}
