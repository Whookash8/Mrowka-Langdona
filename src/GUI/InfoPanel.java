package GUI;

import com.sun.javafx.fxml.builder.TriangleMeshBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by Łukasz on 2016-06-16.
 */
public class InfoPanel extends JPanel
{
    public JButton startButton = new JButton("Start");
    private SpringLayout infoLayout = new SpringLayout();

    InfoPanel()
    {
        setPreferredSize(new Dimension(300,600));
        setOpaque(true);
        setLayout(infoLayout);

        infoLayout.putConstraint(SpringLayout.WEST, startButton , 50, SpringLayout.WEST, this);
        infoLayout.putConstraint(SpringLayout.NORTH, startButton , 500, SpringLayout.NORTH, this);

        startButton.setPreferredSize(new Dimension(200,50));
        add(startButton);

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.RED);
        Rectangle2D rect1 = new Rectangle(100,100,100,100);
        g2d.fill(rect1);
        g2d.setColor(Color.BLUE);
        Rectangle2D rect2 = new Rectangle(100,300,100,100);
        g2d.fill(rect2);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(125,210,125,290);
        g2d.drawLine(175,210,175,290);
        g2d.fillPolygon(new Polygon(new int[]{115,125,135} , new int[]{215,205,215} , 3));
        g2d.fillPolygon(new Polygon(new int[]{165,175,185} , new int[]{285,295,285} , 3));
        g2d.drawString("R" , 200 , 250);
        g2d.drawString("L" , 100 , 250);

        setBackground(Color.CYAN);
    }
}
