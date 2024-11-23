package assets;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.io.Serializable;

public class HeartButton extends JButton implements Serializable {

    public HeartButton() {
        super("+"); // Set default text
        setContentAreaFilled(false); // Disable default background
        setFocusPainted(false); // Disable focus border
        setBorderPainted(false); // Disable default border
        setForeground(Color.WHITE); // Set text color to white
        setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20)); // Set font
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a heart shape
        Path2D.Double heart = new Path2D.Double();
        int width = getWidth();
        int height = getHeight();

        // Define the heart shape path
        heart.moveTo(width / 2.0, height / 4.0); // Top center
        heart.curveTo(width * 0.75, height * -0.2, width * 1.4, height * 0.6, width / 2.0, height); // Right curve
        heart.curveTo(width * -0.4, height * 0.6, width * 0.25, height * -0.2, width / 2.0, height / 4.0); // Left curve
        heart.closePath();

        // Draw the heart shape outline
        g2.setColor(Color.WHITE);
        g2.setStroke(new java.awt.BasicStroke(2)); // Set line thickness
        g2.draw(heart);

        // Draw the text
        super.paintComponent(g); // Draw "+" symbol
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border painting needed
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50); // Default size of the heart button
    }
}