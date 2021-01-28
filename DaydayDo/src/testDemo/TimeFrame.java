package testDemo;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class is a simple JFrame implementation(ʵ��) to explain how to display time
 * dynamically(��̬��) on the JSwing-based interface.
 */
public class TimeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Variables
	 */
	private JPanel timePanel;
	private JLabel timeLabel;
	private JLabel displayArea;
	private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";
	private String time;
	private int ONE_SECOND = 1000;
 
	public TimeFrame() {
		timePanel = new JPanel();
		timeLabel = new JLabel("CurrentTime: ");
		displayArea = new JLabel();
 
		configTimeArea();
 
		timePanel.add(timeLabel);
		timePanel.add(displayArea);
		this.add(timePanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(200, 80));
		this.setLocationRelativeTo(null);
	}
 
	/**
	 * ����������� a timer task ÿ�����һ�� the time
	 */
	private void configTimeArea() {
		Timer tmr = new Timer();
		tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);
	}
 
	/**
	 * Timer task ����ʱ����ʾ��
	 * 
	 */
	protected class JLabelTimerTask extends TimerTask {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				DEFAULT_TIME_FORMAT);
 
		@Override
		public void run() {
			time = dateFormatter.format(Calendar.getInstance().getTime());
			displayArea.setText(time);
		}
	}
 
	public static void main(String arg[]) {
		TimeFrame timeFrame = new TimeFrame();
		timeFrame.setVisible(true);
	}
}

