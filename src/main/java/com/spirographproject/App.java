// package com.spirographproject;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.geom.Point2D;
// import java.util.Random;

// public class SpirographApp extends JPanel {
//     private double R;
//     private double r;
//     private double d;
//     private double angle = 0;
//     private Point2D previousPoint; // Store the previous point

//     public SpirographApp() {
//         // Generate random values for R, r, and d within the specified ranges
//         Random random = new Random();
//         R = random.nextDouble() * (150 - 75) + 75;
//         r = random.nextDouble() * (50 - 10) + 10;
//         d = random.nextDouble() * (100 - 50) + 50;
//         previousPoint = calculatePoint();
//     }

//     public void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         Graphics2D g2d = (Graphics2D) g;
//         int centerX = getWidth() / 2;
//         int centerY = getHeight() / 2;

//         // Calculate the current point
//         Point2D currentPoint = calculatePoint();

//         // Draw a line from the previous point to the current point
//         g2d.setColor(Color.RED);
//         g2d.drawLine((int) previousPoint.getX(), (int) previousPoint.getY(), (int) currentPoint.getX(), (int) currentPoint.getY());

//         // Update the previous point
//         previousPoint = currentPoint;

//         // Update the angle for the next frame
//         angle += 0.01;

//         // Schedule a repaint to create animation (if desired)
//         repaint();
//     }

//     private Point2D calculatePoint() {
//         int centerX = getWidth() / 2;
//         int centerY = getHeight() / 2;

//         // Calculate the coordinates of the drawing point
//         double x = (R - r) * Math.cos(angle) + d * Math.cos((R - r) * angle / r) + centerX;
//         double y = (R - r) * Math.sin(angle) - d * Math.sin((R - r) * angle / r) + centerY;

//         return new Point2D.Double(x, y);
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Spirograph");
//         SpirographApp spirograph = new SpirographApp();
//         frame.add(spirograph);
//         frame.setSize(400, 400);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }

