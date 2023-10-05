package com.spirographproject;

// import com.spirographproject.SpirographPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpirographGUI {

    // three distinct app frames
    private static JFrame welcomeFrame;
    private static JFrame inputFrame;
    private static JFrame spirographFrame;

    // three user input fields on input panel
    private static JTextField fcRadius;
    private static JTextField mcRadius;
    private static JTextField distance;

    public static void main(String[] args) {

        // Welcome frame with "Begin!" button
        welcomeFrame = new JFrame("Spirograph App");
        JButton beginButton = new JButton("Begin!");

        beginButton.setBackground(Color.BLUE);
        beginButton.setForeground(Color.GREEN);
        Font buttonFont = new Font(beginButton.getFont().getName(), Font.PLAIN, 25);
        beginButton.setFont(buttonFont);
        welcomeFrame.setLayout(new BorderLayout());

        welcomeFrame.add(beginButton, BorderLayout.CENTER);

        // handle button click and open the input window
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInputWindow();
                welcomeFrame.dispose();
            }
        });

        welcomeFrame.setSize(700, 300);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);
    }

    // input window where user inputs R, r, and d values
    public static void openInputWindow() {

        // Frame for user input window
        inputFrame = new JFrame("Custom Spirograph");
        inputFrame.setLayout(new BorderLayout());

        // actual input panel - where the JTextFields attach
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        int padding = 50;
        inputPanel.setBorder(new EmptyBorder(15, 200, padding, padding));
        inputPanel.setBackground(Color.MAGENTA);

        // R value input - radius of the fixed circle
        inputPanel.add(new JLabel("R:"));
        fcRadius = new JTextField();
        inputPanel.add(fcRadius);

        // r value input - radius of the moving circle
        inputPanel.add(new JLabel("r:"));
        mcRadius = new JTextField();
        inputPanel.add(mcRadius);

        // d value input - distance of the drawing point from the center of the mc
        inputPanel.add(new JLabel("d:"));
        distance = new JTextField();
        inputPanel.add(distance);

        inputFrame.add(inputPanel, BorderLayout.CENTER);

        JButton makeSpirographButton = new JButton("Make Spirograph");
        makeSpirographButton.setBackground(Color.ORANGE);

        // makeSpirographButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // displaySpirograph();

        // inputFrame.dispose();
        // }
        // });

        makeSpirographButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Parse user input and pass the values to displaySpirograph
                double RValue = Double.parseDouble(fcRadius.getText());
                double rValue = Double.parseDouble(mcRadius.getText());
                double dValue = Double.parseDouble(distance.getText());


                displaySpirograph(RValue, rValue, dValue);

                inputFrame.dispose();
            }
        });

        inputFrame.add(makeSpirographButton, BorderLayout.SOUTH);

        inputFrame.setSize(700, 300);
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputFrame.setVisible(true);
    }

    // add spirograph visuals from my App.java to this JFrame
    public static void displaySpirograph(double R, double r, double d) {
        spirographFrame = new JFrame("Spirograph Display");
        spirographFrame.setSize(700, 700);
        spirographFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpirographPanel spirographPanel = new SpirographPanel(R, r, d);
        spirographFrame.add(spirographPanel);
        spirographFrame.setVisible(true);
    }
}
