package JFrame;
import java.awt.Container;

import javax.swing.JFrame;

public class ClockFrame extends JFrame{
	public ClockFrame() {
		setTitle("Science Bowl Clock");
		setSize(300,200);
		setLocation(10,200);
		addWindowListener(new Terminator());
		Container contentPane = getContentPane();
		contentPane.add(new ClockDisplay());
	}
}
