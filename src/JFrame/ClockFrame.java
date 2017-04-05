package JFrame;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockFrame extends JFrame{
	public ClockFrame() {
		//Sets up the frame
		setTitle("Science Bowl Clock");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Creates the panel to hold the times
		JPanel clockPanel = new JPanel();
		//Creates the time labels
		JLabel overallTime = new JLabel();
		overallTime.setText("00:00");
		JLabel tossUpTime = new JLabel();
		tossUpTime.setText("00");
		JLabel bonusTime = new JLabel();
		bonusTime.setText("00");
		//The grid that holds the times 
		GroupLayout buttonGrid = new GroupLayout(clockPanel);
		clockPanel.setLayout(buttonGrid);
		buttonGrid.setAutoCreateGaps(true);
		//Adds a group within the grid
		//Sets up the horizontal layout
		buttonGrid.setHorizontalGroup(buttonGrid.createSequentialGroup()
					.addComponent(overallTime)
					.addGroup(buttonGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(tossUpTime)
							.addComponent(bonusTime) )
		);
		//Sets up the vertical layout
		buttonGrid.setVerticalGroup(buttonGrid.createSequentialGroup()
				.addGroup(buttonGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(overallTime)
						.addGroup(buttonGrid.createSequentialGroup()
								.addComponent(tossUpTime)
								.addComponent(bonusTime) ) 
				)	
		);
		//Add the panel
		add(clockPanel);
	}
}
