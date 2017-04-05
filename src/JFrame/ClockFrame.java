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
		JPanel overallTimePanel = new JPanel();
		overallTimePanel.add(overallTime);
		JLabel tossUpTime = new JLabel();
		tossUpTime.setText("00");
		JPanel tossUpTimePanel = new JPanel();
		tossUpTimePanel.add(tossUpTime);
		JLabel bonusTime = new JLabel();
		bonusTime.setText("00");
		JPanel bonusTimePanel = new JPanel();
		bonusTimePanel.add(bonusTime);
		//The grid that holds the times 
		GroupLayout buttonGrid = new GroupLayout(clockPanel);
		clockPanel.setLayout(buttonGrid);
		buttonGrid.setAutoCreateGaps(true);
		//Adds a group within the grid
		//Sets up the horizontal layout
		buttonGrid.setHorizontalGroup(buttonGrid.createSequentialGroup()
					.addComponent(overallTimePanel)
					.addGroup(buttonGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(tossUpTimePanel)
							.addComponent(bonusTimePanel) )
		);
		//Sets up the vertical layout
		buttonGrid.setVerticalGroup(buttonGrid.createSequentialGroup()
				.addGroup(buttonGrid.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(overallTimePanel)
						.addGroup(buttonGrid.createSequentialGroup()
								.addComponent(tossUpTimePanel)
								.addComponent(bonusTimePanel) ) 
				)	
		);
		//Add the panel
		add(clockPanel);
	}
}
