package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static MainView mainview;
	
	/**
	 * *获取单个实例
	 * @return
	 */
	public static synchronized MainView getInstance() {
		if(mainview==null) {
			mainview = new MainView();
		}
		return mainview;
	}
	
	// 全局的位置变量，用于表示鼠标在窗口上的位置
	static Point origin = new Point();
	JPanel con;//面板容器
	static JLabel call = new JLabel();//;//软件名称,版本,日程提醒
	JPanel leftPanel;
	JButton B1,B2,B3,B4,B5,B6,B7;
	JButton flDay; //刷新日期
	JButton inn; //导入本地文件数据
	
	private static int setBackY = 18;//钮初始Y轴坐标
	private static final int high = 32;//按钮的高度
	
	private static int setBackY1 = 20;//文本框始Y轴坐标
	private static final int high1 = 32;//高度
	
	//文本框
	JTextField t1,t2,t3,t4,t5,t6,t7;//多行文本框
	
	//获取当前目录绝对路径
	String rootPath = System.getProperty("user.dir");
	//单斜杠换双斜杠
	Image icon = Toolkit.getDefaultToolkit().getImage(rootPath.replace("\\", "\\\\")+"\\src\\logic\\tubiao.png");
	ImageIcon iconBOFF = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BOFF.png");
	ImageIcon iconBON = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BON.png");
	ImageIcon iconBBB = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BBB.png");
	ImageIcon iconINN = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\INN.png");
	ImageIcon iconINNS = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\INNS.png");
	
	
	int setOnB[] = {1,1,1,1,1,1,1}; //切换按钮图标
	int saveF = 1; //1：读，，0：写  初始都是1，后面都是0，初始化的时候从本地读取上次的日程，然后打开时一直保存
	
	private MainView() {
		
    /**-------------整体设置------------*/
		
		setResizable(false);
		setType(Type.POPUP);
		setTitle("DayDoOK");
	
		this.setIconImage(icon);   //设置窗口的logo

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时退出JVM
		setBounds(100,100,460,260);//窗口大小
		setLocationRelativeTo(null);
		
		
		this.setUndecorated(true);//窗体不显示,这个会导致窗口无法拖动
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
		//this.setOpacity(0.1f);
		
		/**--------------窗口拖动--------------*/
		this.addMouseListener(new MouseAdapter() {
			// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {
			// 当鼠标按下的时候获得窗口当前的位置
			origin.x = e.getX();
			origin.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
				// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
				public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}
		});
		
		
		/**-----总JPanel--------*/
		con = new JPanel();
		con.setBackground(new Color(80,100,225,138));//最后一个参数设置透明度
		con.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(con);
		con.setLayout(null);
		
		
		/**----侧边时间提醒----*/
		/**侧边日程提醒*/
		//文本框	
		/**这里使用html，没法透明*/
		call.setText("<html>...........<br/>DAYDO,OK!: <br/>"+new TimeFile().setString()+"<br/><br/>"+"道阻且长<br/>行则将至"+"<br/>...........<html>");
		call.setFont(new Font("黑体",Font.PLAIN,16));
		call.setForeground(Color.WHITE);
		
		//侧边面板
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 100, 350);
		leftPanel.setBackground(new Color(80,130,255,158));
		//将文本框放入侧边面板
		leftPanel.add(call);
		//将侧边面板放入总面板
		con.add(leftPanel);
		
		
		/**----------日程按钮------------------*/
		B1 = new JButton();
		setViewB(B1);
		setLisB(B1,0);
		
		B2 = new JButton();
		setViewB(B2);
		setLisB(B2,1);
		
		B3 = new JButton();
		setViewB(B3);
		setLisB(B3,2);
		
		B4 = new JButton();
		setViewB(B4);
		setLisB(B4,3);
		
		B5 = new JButton();
		setViewB(B5);
		setLisB(B5,4);
		
		B6 = new JButton();
		setViewB(B6);
		setLisB(B6,5);
		
		B7 = new JButton();
		setViewB(B7);
		setLisB(B7,6);
		
		flDay = new JButton(); //刷新日期
		setViewflT(flDay);
		setLisflT(flDay);
		
		inn = new JButton();
		setViewInn(inn);
		setLisInn(inn);
		
		
		
		/**----------日程文本框---------*/
		t1 = new JTextField(28);
		setViewT(t1);
		
		t2 = new JTextField(28);
		setViewT(t2);
		
		t3 = new JTextField(28);
		setViewT(t3);
		
		t4 = new JTextField(28);
		setViewT(t4);
		
		t5 = new JTextField(28);
		setViewT(t5);
		
		t6 = new JTextField(28);
		setViewT(t6);
		
		t7 = new JTextField(28);
		setViewT(t7);

	
	}
	
	public void setViewT(JTextField t) {
		t.setBorder(new EmptyBorder(0,0,0,0));
		t.setBackground(new Color(255,255,255));
		t.setBounds(172, setBackY1, 240, 24);
		t.setFont(new Font("黑体",Font.PLAIN,16));
		t.setForeground(new Color(30,40,220));
		setBackY1 += high1;
		con.add(t);
	}
	
	public void setViewB(JButton b) {
		b.setIcon(iconBON);
		b.setSize(28,28);
		//去掉按钮文字周围的焦点框
		b.setFocusPainted(false);
		b.setBorderPainted(false);//设置按钮边界不显示
		b.setBounds(136, setBackY, 28, 28);
		setBackY += high;
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisB(JButton b,int n) {//按钮的监听
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(setOnB[n]==1) { 
					b.setIcon(iconBBB);
					setOnB[n]=0; //0：已经完成
				}else {
					b.setIcon(iconBON);
					setOnB[n]=1;  //1：未完成
				}
			}	
		});
	}
	
	public void setViewflT(JButton b) {
		b.setIcon(iconBOFF);
		b.setSize(28,28);
		//去掉按钮文字周围的焦点框
		b.setFocusPainted(false);
		b.setBorderPainted(false);//设置按钮边界不显示
		b.setBounds(34, 200, 28, 28);
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisflT(JButton b) {//刷新日期和任务栏
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				call.setText("<html>...........<br/>DAYDO,OK!: <br/>"+new TimeFile().setString()+"<br/><br/>"+"道阻且长<br/>行则将至"+"<br/>...........<html>");
				B1.setIcon(iconBON);
				B2.setIcon(iconBON);
				B3.setIcon(iconBON);
				B4.setIcon(iconBON);
				B5.setIcon(iconBON);
				B6.setIcon(iconBON);
				B7.setIcon(iconBON);
				for(int i=0;i<7;i++) {
					setOnB[i]=1;
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
			}	
		});
	}
	
	public void setViewInn(JButton b) {
		b.setIcon(iconINN);
		b.setSize(28,28);
		//去掉按钮文字周围的焦点框
		b.setFocusPainted(false);
		b.setBorderPainted(false);//设置按钮边界不显示
		b.setBounds(34, 160, 28, 28);
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisInn(JButton b) {//按钮的监听
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeFile tf = new TimeFile();
				ArrayList<String> List = new ArrayList<String>();
				/**如果是开始打开，读取上次的记录*/
				if(saveF==1) {  //1
					//把本地的内容读进来
					List = tf.readF();
					String sLine1 = List.get(0);  //第一行字符串
					if(sLine1.charAt(0)=='0') {//对应项任务已经完成
						B1.setIcon(iconBBB);
					}else { //对应项任务未完成
						B1.setIcon(iconBON);
					}
					
					if(sLine1.charAt(1)=='0') {//对应项任务已经完成
						B2.setIcon(iconBBB);
					}else { //对应项任务未完成
						B2.setIcon(iconBON);
					}
					
					if(sLine1.charAt(2)=='0') {//对应项任务已经完成
						B3.setIcon(iconBBB);
					}else { //对应项任务未完成
						B3.setIcon(iconBON);
					}
					
					if(sLine1.charAt(3)=='0') {//对应项任务已经完成
						B4.setIcon(iconBBB);
					}else { //对应项任务未完成
						B4.setIcon(iconBON);
					}
					
					if(sLine1.charAt(4)=='0') {//对应项任务已经完成
						B5.setIcon(iconBBB);
					}else { //对应项任务未完成
						B5.setIcon(iconBON);
					}
					
					if(sLine1.charAt(5)=='0') {//对应项任务已经完成
						B6.setIcon(iconBBB);
					}else { //对应项任务未完成
						B6.setIcon(iconBON);
					}
					
					if(sLine1.charAt(6)=='0') {//对应项任务已经完成
						B7.setIcon(iconBBB);
					}else { //对应项任务未完成
						B7.setIcon(iconBON);
					}
					
					t1.setText(List.get(1));
					t2.setText(List.get(2));
					t3.setText(List.get(3));
					t4.setText(List.get(4));
					t5.setText(List.get(5));
					t6.setText(List.get(6));
					t7.setText(List.get(7));
					
					b.setIcon(iconINNS);
					saveF = 0;//写
					
				}else {
					/**如果一直在打开状态，一直采取保存操作*/
					//把文本框的内容写到文件里
					//String context = t1.getText();
					StringBuffer SB = new StringBuffer();
					//context = context.concat("哈哈哈哈哈");
					for(int i=0;i<7;i++) {
						if(setOnB[i]==0) {
							//字符串拼接0, 已完成项目
							SB.append('0');
						}else {
							//字符串拼接1
							SB.append('1');
						}
					}
					SB.append("\n");
					SB.append(t1.getText()+"\n");
					SB.append(t2.getText()+"\n");
					SB.append(t3.getText()+"\n");
					SB.append(t4.getText()+"\n");
					SB.append(t5.getText()+"\n");
					SB.append(t6.getText()+"\n");
					SB.append(t7.getText()+"\n");
					//System.out.println(SB);
					tf.saveF(SB);
				}
			}	
		});
	}

}
