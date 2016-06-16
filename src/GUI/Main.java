package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Łukasz on 2016-06-16.
 */
public class Main extends JFrame
{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension resolution = toolkit.getScreenSize();
    private final double SCREEN_WIDTH = resolution.getWidth();
    private final double SCREEN_HEIGHT = resolution.getHeight();
    private GridBagLayout mainLayout = new GridBagLayout();
    private GridBagConstraints GBC = new GridBagConstraints();
    private InfoPanel info = new InfoPanel();
    private AntPanel antP = new AntPanel();

    public Main()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        setLocation(((int)SCREEN_WIDTH-WINDOW_WIDTH)/2,((int)SCREEN_HEIGHT-WINDOW_HEIGHT)/2);
        Timer timer = new Timer(1000,antP);

        info.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        setLayout(mainLayout);
        GBC.ipadx=0;
        GBC.ipady=0;
        GBC.anchor=GridBagConstraints.LINE_START;
        GBC.weightx=0.4;
        add(info , GBC);
        GBC.gridx=1;
        GBC.weightx=0.6;
        add(antP , GBC);

        setVisible(true);
        pack();
    }

    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
