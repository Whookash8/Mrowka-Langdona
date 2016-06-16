package GUI;

import java.awt.*;

/**
 * Created by Łukasz on 2016-06-16.
 */
public class Square
{
    private Color color;
    private Point location;

    public Square(Point p)
    {
        this.location=p;
        this.color=Color.RED;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
    public Color getColor()
    {
        return this.color;
    }
    public int getxLocation()
    {
        return (int)this.location.getX();
    }
    public int getyLocation()
    {
        return (int)this.location.getY();
    }
}
