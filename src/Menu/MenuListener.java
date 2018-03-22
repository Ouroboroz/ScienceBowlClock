package Menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Clock.Clock;
import Clock.ClockCase;
import Executable.ScienceBowlClock;
import FileWriter.CSVWriter;
import JFrame.AddTimeFrame;
import JFrame.ExportFrame;
import JFrame.SubtractTimeFrame;
public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String source = e.getActionCommand();
		if(source.equals("Start Overall Time"))
			Clock.startCountdown();
		else if(source.equals("Stop Overall Time"))
				Clock.stopCountdown();
		else if(source.equals("Start Toss Up Time"))
				Clock.setMode(ClockCase.TOSSUP);
		else if(source.equals("Stop Toss Up Time")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetTossUp();}
		else if(source.equals("Start Bonus Time"))
				Clock.setMode(ClockCase.BONUS);
		else if(source.equals("Stop Bonus Time")){
				Clock.setMode(ClockCase.OVERALL);
				Clock.resetBonus();}
		else if(source.equals("Reset Overall Time")){
				Clock.resetClock();
				Clock.updateGUI();
		}
		else if(source.equals("Reset Toss Up Time")){
			Clock.resetTossUp();
			Clock.updateGUI();
		}
		else if(source.equals("Reset Bonus Time")){
			Clock.resetBonus();
			Clock.updateGUI();
		}
		else if(source.equals("Show Scoreboard")){
			ScienceBowlClock.ScoreGUI.setVisible(true);
			ScienceBowlClock.GUI.isShowScoreButton(false);
		}
		else if(source.equals("Hide Scoreboard")){
			ScienceBowlClock.ScoreGUI.setVisible(false);
			ScienceBowlClock.GUI.isShowScoreButton(true);
		}
		else if(source.equals("Add Time"))
				new AddTimeFrame().setVisible(true);
		else if(source.equals("Subtract Time"))
				new SubtractTimeFrame().setVisible(true);
		else if(source.equals("Export to CSV")){
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(Calendar.getInstance().getTime());
			ExportFrame exportFrame = new ExportFrame("_"+timeStamp);
			exportFrame.setAlwaysOnTop(true);
			exportFrame.setLocationRelativeTo(ScienceBowlClock.ScoreGUI);
			exportFrame.setVisible(true);
		}
		else if(source.equals("Reset Scoreboard"))
			ScienceBowlClock.ScoreGUI.reset();
		else if(source.equals("About")){
			JFrame aboutFrame = new JFrame();
			aboutFrame.setTitle("About");
			aboutFrame.setSize(500, 300);
			aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aboutFrame.setAlwaysOnTop(true);
			aboutFrame.setLocationRelativeTo(ScienceBowlClock.GUI);
			aboutFrame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridy = 0;
			aboutFrame.add(new JLabel("Made by Ouroboroz, Kevin Yang, to aid Science Bowl Practices."),c);
			c.gridy = 1;
			aboutFrame.add(new JLabel("Based off of the GUI used at competition."), c);
			c.gridy = 2;
			aboutFrame.add(new JLabel("Includes a countdown and scoreboard system."),c);
			c.gridy = 3;
			aboutFrame.add(new JLabel("Be sure to export to save data and credit when sharing this program!"), c);
			aboutFrame.setVisible(true);
		}
	}

}
