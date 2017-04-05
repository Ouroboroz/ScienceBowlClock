package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ClockDisplay extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Font f = new Font("SansSerif", Font.PLAIN, 12);
	    FontMetrics fm = g.getFontMetrics(f);
	    int cx = 150; int cy = 50;
	    g.setFont(f);
	    g.drawString("Hello World! ", cx, cy);
	    cx += fm.stringWidth("Hello World");
	    setBackground(new Color(100,200,200));
	    setSize(300,100);
	}
}
