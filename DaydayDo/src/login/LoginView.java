package login;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 登陆界面
 * @author 24725
 *
 */

public class LoginView {
	
	
	/**
	 * 界面控件
	 */
	JLabel JLa1,JLa2;//标签
	static JFrame mainJ;//窗口
	Container con;
	static JButton loginB,cancelB,NewUserB,exitB;//按钮
	static JTextField userText;//文本框
	static JPasswordField passwordF;
	HandleAction handle;//按钮事件监听器
	
	/**
	 * 界面初始化方法
	 */
	public void JtextDemo() {
		handle = new HandleAction();//初始化自设监听类
		
		JLa1 = new JLabel("用户名");
		JLa2 = new JLabel("密码");
		
		mainJ = new JFrame("DayDo登陆");//界面上面的标题
		
		/**
		 * 三个需要监听的按钮
		 */
		loginB = new JButton("登陆");
		loginB.addActionListener(handle);//添加事件监听
		NewUserB = new JButton("注册");
		NewUserB.addActionListener(handle);
		cancelB = new JButton("取消");
		cancelB.addActionListener(handle);
		exitB = new JButton("DayDo简介");
		exitB.addActionListener(handle);
		
		/**
		 * 两个输入框 用户名+密码
		 */
		userText = new JTextField();
		userText.setColumns(20);//设置文本框的宽度
		passwordF = new JPasswordField();
		passwordF.setColumns(20);
		
		/**
		 * 放置已经设置好的控件
		 */
		con = mainJ.getContentPane();//初始化一个容器/返回此窗体的contentPane对象
		con.setLayout(new FlowLayout(FlowLayout.CENTER));//设置流布局管理
		con.add(JLa1);
		con.add(userText);
		con.add(JLa2);
		con.add(passwordF);
		con.add(loginB);
		con.add(NewUserB);
		con.add(cancelB);
		con.add(exitB);
		
		mainJ.setSize(1500, 800);//设置窗体大小
		mainJ.setVisible(true);//设置窗口可见
		
		mainJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置关闭窗口时退出JVM
		
	}

}
