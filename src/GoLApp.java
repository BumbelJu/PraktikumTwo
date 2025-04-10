import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoLApp extends SwingApp{
    public static boolean showComponents = false;



    @Override
    protected JComponent createToolBar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);
        return tb;
    }

    @Override
    protected JComponent createContent() {
        return new GameOfLifeView();
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
        String msg = "Hey die GUI scheint zu laufen :-)";
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

    /**
     * @param args
     */
    public static void main(String[] args) {
        GoLApp.showComponents = true;
        SwingApp app = new GoLApp();
        app.startUp();
    }
}
