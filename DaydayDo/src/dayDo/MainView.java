package dayDo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 主界面大框架
 */

public class MainView extends JFrame {
	
	//implements Runnable
	/**
	@Override
	public void run() {//尝试-----------------------------------
		while(true) {
			try {
				Thread.sleep(2000);
				call.repaint();
				call.setText("<html><br/><br/>今天:<br/>"+new DayDoFile().setString()+"<br/>"+new DayDoFile().isHaveNote()+"待办日程<html>");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}*/

	
	//尝试单例模式
	private static MainView mainview;
	
	public static synchronized MainView getInstance() {
		if(mainview==null) {
			mainview = new MainView();
		}
		return mainview;
	}

	/**主界面*/
	private static final long serialVersionUID = 1L;
	private static int setBackY = 60;//大按钮初始Y轴坐标
	private static final int high = 80;//大按钮的高度
	private static final String ver ="v1.1.1";//版本号
	
	JPanel con;//面板容器
	JLabel name,version;
	static JLabel call = new JLabel();//;//软件名称,版本,日程提醒版头
	JPanel topPanel,bottomPanel,mainPanel,leftPanel;//界面上固定的四块面板
	CardLayout card;//定义卡片布局对象
	JButton userB,dateB,noteB,noticeB;//四个按钮
    JPanel MP1,MP2,MP3,MP4;//四个按钮对应的切换面板
    	
	private MainView() {
		//设置总参数
		setResizable(false);
		setType(Type.POPUP);
		setTitle("DayDo日历");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时退出JVM
		setBounds(100,100,1000,800);
		setLocationRelativeTo(null);
		con = new JPanel();
		con.setBackground(new Color(160,220,240));
		con.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(con);
		con.setLayout(null);
		
		//按钮部分
		userB = new JButton("登陆");
		setViewB("登陆",userB);
		setLisB("user",userB);
		dateB = new JButton("日历");
		setViewB("日历",dateB);	
		setLisB("date",dateB);
		noteB = new JButton("日程记录");
		setViewB("日程记录",noteB);	
		setLisB("note",noteB);
		noticeB = new JButton("使用说明");
		setViewB("使用说明",noticeB);
		setLisB("notice",noticeB);
		
		/**版头*/
		//文本框1
		name = new JLabel("DayDo日历");
		name.setFont(new Font("宋体",Font.PLAIN,32));
		name.setForeground(Color.WHITE);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		//文本框2
		version = new JLabel(ver);
		version.setFont(new Font("宋体",Font.PLAIN,18));
		version.setForeground(Color.WHITE);
		version.setVerticalAlignment(SwingConstants.TOP);
		version.setHorizontalAlignment(SwingConstants.CENTER);
		//将两个文本框放入版头面板中
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1000, 60);
		topPanel.add(name);
		topPanel.add(version);
		topPanel.setBackground(new Color(120,190,255));
		//将版头面板放入总面板中
		con.add(topPanel);
		
		/**装饰底边*/
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,730,1000,38);
		bottomPanel.setBackground(new Color(120,190,255));
		//将底边放入总面板中
		con.add(bottomPanel);
		
		/**侧边日程提醒*/
		//文本框	
		//call = new JLabel();
		//run();//尝试-------------------------------------
		call.setText("<html><br/><br/>今天:<br/>"+new DayDoFile().setString()+"<br/>"+new DayDoFile().isHaveNote()+"待办日程<html>");
		call.setFont(new Font("宋体",Font.PLAIN,20));
		call.setForeground(Color.WHITE);
		
		//侧边面板
		leftPanel = new JPanel();
		leftPanel.setBounds(0, setBackY, 130, 350);
		leftPanel.setBackground(new Color(100,170,255));
		//将文本框放入侧边面板
		leftPanel.add(call);
		//将侧边面板放入总面板
		con.add(leftPanel);
		
		/**主面板*/
		mainPanel = new JPanel();
		mainPanel.setBounds(130,60,870,670);
		mainPanel.setBackground(new Color(200,240,255));
		//将主面板放入总面板
		con.add(mainPanel);
		//给主面板设置卡片式布局
		card = new CardLayout(0,0);
		mainPanel.setLayout(card);
		//主面板的的四张卡片面板
		MP1 = new JPanel();
		setMP1(MP1);//子界面设置
		MP2 = new JPanel();
		setMP2(MP2);//子界面设置
		MP3 = new JPanel();
		setMP3(MP3);//子界面设置
		MP4 = new JPanel();
		setMP4(MP4);//子界面设置
		//把它们都加入主面板并命名
		mainPanel.add(MP1,"user");
		mainPanel.add(MP2,"date");
		mainPanel.add(MP3,"note");
		mainPanel.add(MP4,"notice");
		
	}
	

	public void setLisB(String s1,JButton b) {//四个主按钮的监听
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, s1);
				setColorB();
				b.setBackground(new Color(255,175,175));
				}	
		});
	}
	
	
	public void setMP1(JPanel JP) {//用户界面导入方法
		MP1.setBackground(new Color(200,240,255));
		MPLogin mplo = new MPLogin(JP);
	}
	
	public void setMP2(JPanel JP) {//日期界面导入方法
		MP2.setBackground(new Color(200,240,255));
		MPDate mpdate = new MPDate(JP);
	}
	
	public void setMP3(JPanel JP) {//日程界面导入方法
		MP3.setBackground(new Color(200,240,255));
		MPNote mpnote = new MPNote(JP);
	}
	
	
	public void setMP4(JPanel JP) {//简介界面导入方法
		MP4.setBackground(new Color(200,240,255));
		JLabel JL = new JLabel();
		JL.setText("<html><br/>DayDo日历是一个可以查看日期记录日程的应用程序<br/><br/>于2019年5-6月份开始开发"
				+ "<br/><br/>开发者是一个java小白<br/>开发过程中有很多问题<br/>swing做的界面也有些简陋<br/>"
				+ "目前可以查看日历,根据日期创建日程，根据日期查找日程<br/>也会提示用户今天有没有日程<br/><br/>"
				+ "还在继续施工中,部分功能暂时不能使用,新的功能还在酝酿<br/>多多谅解，敬请期待<html>");
		JL.setFont(new Font("宋体",Font.PLAIN,18));
		JL.setBounds(130,60,870,670);
		JL.setForeground(Color.GRAY);
		JL.setHorizontalAlignment(SwingConstants.CENTER);
		JL.setVerticalAlignment(SwingConstants.CENTER);
		JP.add(JL);
	}
	
	
	/**
	 * 按钮的基本设置
	 */
	
	public void setViewB(String s,JButton b) {
		b.setFont(new Font(s,Font.PLAIN,22));
		b.setForeground(Color.WHITE);
		int n1=110,n2=210,n3=255;//初始颜色设置
		b.setBackground(new Color(n1,n2,n3));
		b.setBounds(0, setBackY, 130, high);
		setBackY += high;
		con.add(b);
		b.setBackground(new Color(n1,n2,n3));
		}
	
	public void setColorB() {
		int n1=110,n2=210,n3=255;//初始颜色设置
		userB.setBackground(new Color(n1,n2,n3));
		dateB.setBackground(new Color(n1,n2,n3));
		noteB.setBackground(new Color(n1,n2,n3));
		noticeB.setBackground(new Color(n1,n2,n3));
	}
	
	
}
