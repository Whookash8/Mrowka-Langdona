package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Łukasz on 2016-06-16.
 */
public class AntPanel extends JPanel implements MouseListener, ActionListener
{
    private Square[][] antField = new Square[50][60];
    private Point antLocation = new Point(25,30);

    @Override
    public void actionPerformed(ActionEvent e) {
        moveAnt();
        repaint();
    }

    private enum antDirection {UP , DOWN , LEFT , RIGHT};
    antDirection currentAntDirection;

    public AntPanel()
    {
        setPreferredSize(new Dimension(500,600));
        currentAntDirection = antDirection.UP;

        for(int i=0 ; i<50 ; i++)
        {
            for(int j=0 ; j<60 ; j++)
            {
                antField[i][j] = new Square(new Point(i,j));
            }
        }

        setOpaque(true);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        for(int i=0 ; i<50 ; i++)
        {
            for(int j=0 ; j<60 ; j++)
            {
                g2d.setColor(antField[i][j].getColor());

                if(new Point(antField[i][j].getxLocation(),antField[i][j].getyLocation()).equals(antLocation))
                {
                    g2d.setColor(Color.BLACK);
                }
                g2d.fillRect(antField[i][j].getxLocation()*10 , antField[i][j].getyLocation()*10 , 10 ,10);

                g2d.setColor(Color.BLACK);
                g2d.drawLine(0,j*10,500,j*10);
            }

            g2d.setColor(Color.BLACK);
            g2d.drawLine(i*10,0,i*10,600);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xPosition = e.getX()/10;
        int yPosition = e.getY()/10;
        antField[xPosition][yPosition].setColor(Color.RED);
        System.out.println("Kliknięto w punkt (" + xPosition + " ; " + yPosition + " ).");
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void moveAnt()
    {
        switch (currentAntDirection)
        {
            case UP:
                antLocation.setLocation(antLocation.getX() , antLocation.getY()-1);
                break;
            case DOWN:
                antLocation.setLocation(antLocation.getX() , antLocation.getY()+1);
                break;
            case LEFT:
                antLocation.setLocation(antLocation.getX()-1 , antLocation.getY());
                break;
            case RIGHT:
                antLocation.setLocation(antLocation.getX()+1 , antLocation.getY());
                break;
            default:
                break;
        }
        if(antField[(int)antLocation.getX()][(int)antLocation.getY()].getColor().equals(Color.RED))
        {
            switch (currentAntDirection)
            {
                case UP:
                    currentAntDirection=antDirection.RIGHT;
                    break;
                case DOWN:
                    currentAntDirection=antDirection.LEFT;
                    break;
                case LEFT:
                    currentAntDirection=antDirection.UP;
                    break;
                case RIGHT:
                    currentAntDirection=antDirection.DOWN;
                    break;
                default:
                    break;
            }
            antField[(int)antLocation.getX()][(int)antLocation.getY()].setColor(Color.BLUE);
        }
        else
        {
            switch (currentAntDirection)
            {
                case UP:
                    currentAntDirection=antDirection.LEFT;
                    break;
                case DOWN:
                    currentAntDirection=antDirection.RIGHT;
                    break;
                case LEFT:
                    currentAntDirection=antDirection.DOWN;
                    break;
                case RIGHT:
                    currentAntDirection=antDirection.UP;
                    break;
                default:
                    break;
            }
            antField[(int)antLocation.getX()][(int)antLocation.getY()].setColor(Color.RED);
        }

        this.repaint();
    }
}
