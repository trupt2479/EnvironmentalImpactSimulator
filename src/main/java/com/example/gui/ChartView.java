package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * ChartView.java
 * Displays environmental impact data as a bar chart.
 */
public class ChartView extends JFrame {

    private List<Double> data;
    private List<String> labels;

    public ChartView(String title, List<Double> data, List<String> labels) {
        this.data = data;
        this.labels = labels;

        setTitle(title);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ChartPanel());
        setVisible(true);
    }

    private class ChartPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();

            int barWidth = width / (data.size() * 2);
            int xOffset = 50;

            double maxValue = data.stream().mapToDouble(Double::doubleValue).max().orElse(1);

            for (int i = 0; i < data.size(); i++) {
                int barHeight = (int) ((data.get(i) / maxValue) * (height - 100));
                int x = xOffset + i * 2 * barWidth;
                int y = height - barHeight - 50;

                g2d.setColor(new Color(100, 150, 255));
                g2d.fillRect(x, y, barWidth, barHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawString(labels.get(i), x + 5, height - 30);
            }
        }
    }
}
