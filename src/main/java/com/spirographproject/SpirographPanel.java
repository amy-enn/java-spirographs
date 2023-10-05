package com.spirographproject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class SpirographPanel extends JPanel {

    private double R;
    private double r;
    private double d;
    private double angle = 0;
    // this list will hold every single 2d point on the spirograph path
    private List<Point2D> points;

    // * ˚ ✦ constructooooor
    public SpirographPanel(double R, double r, double d) {

        this.R = R;
        this.r = r;
        this.d = d;
        
        points = new ArrayList<>();
    }

    // * ˚ ✦ paint the damn thing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // * ˚ ✦ calculate the current point of the brush
        Point2D currentPoint = calculatePoint();

        // * ˚ ✦ add the point to the points array
        points.add(currentPoint);

        // * ˚ ✦ creating the pen stroke - increase the number for a thicker line
        g2d.setStroke(new BasicStroke(2.0f)); 

       // * ˚ ✦ setting the pen color (this will be the spirograph's color!)
        g2d.setColor(Color.ORANGE);
        for (int i = 1; i < points.size(); i++) {
            Point2D previousPoint = points.get(i - 1);
            Point2D nextPoint = points.get(i);
            g2d.drawLine((int) previousPoint.getX(), (int) previousPoint.getY(), (int) nextPoint.getX(), (int) nextPoint.getY());
        }

        // * ˚ ✦ the 'angle' variable controls the position of the drawing point on the spirograph.
        // it creates the pattern as it increments this angle with each point in the array.
        // the angle and repaint method together over and over essentially 3d-print the spirograph onto the frame
        angle += 0.005;
        repaint();
    }

    // * ˚ ✦ where the brush figures out where it is on the canvas so it can draw its point
    private Point2D calculatePoint() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // * ˚ ✦ calculate the coordinates of the point being drawn
        double x = (R - r) * Math.cos(angle) + d * Math.cos((R - r) * angle / r) + centerX;
        double y = (R - r) * Math.sin(angle) - d * Math.sin((R - r) * angle / r) + centerY;

        return new Point2D.Double(x, y);
    }
}
