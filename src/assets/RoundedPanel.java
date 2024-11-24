package assets;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class RoundedPanel extends JPanel implements Serializable {
    private int cornerRadius = 15; // Default corner radius

    // Default constructor (needed for GUI builder tools like NetBeans)
    public RoundedPanel() {
        super();
        setOpaque(false); // Make it transparent
    }

    // Constructor with corner radius
    public RoundedPanel(int radius) {
        this();
        this.cornerRadius = radius;
    }

    // Getter and Setter for cornerRadius (for customization in NetBeans)
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Redraw the component when the corner radius changes
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background Color and Transparency
        g2.setColor(new Color(255, 255, 255, 180)); // White with transparency
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}