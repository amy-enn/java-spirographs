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
    private List<Point2D> points;

    public SpirographPanel(double R, double r, double d) {
        this.R = R;
        this.r = r;
        this.d = d;
        points = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Calculate the current point
        Point2D currentPoint = calculatePoint();

        points.add(currentPoint);

        g2d.setStroke(new BasicStroke(1.0f)); 

       
        g2d.setColor(Color.BLACK);
        for (int i = 1; i < points.size(); i++) {
            Point2D previousPoint = points.get(i - 1);
            Point2D nextPoint = points.get(i);
            g2d.drawLine((int) previousPoint.getX(), (int) previousPoint.getY(), (int) nextPoint.getX(), (int) nextPoint.getY());
        }

        angle += 0.005;

        repaint();
    }

    private Point2D calculatePoint() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Calculate the coordinates of the point being drawn
        double x = (R - r) * Math.cos(angle) + d * Math.cos((R - r) * angle / r) + centerX;
        double y = (R - r) * Math.sin(angle) - d * Math.sin((R - r) * angle / r) + centerY;

        return new Point2D.Double(x, y);
    }
}
