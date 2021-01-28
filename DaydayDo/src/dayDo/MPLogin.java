package dayDo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 用户子界面
 * @author 24725
 *
 */

public class MPLogin {
	
	JLabel JLa1,JLa2;//输入框前的标签
    JButton loginB,cancelB,NewUserB,returnB,sureB,cancelB2;//按钮
    JTextField userText;//文本框,用户名
    JPasswordField passwordF;//密码文本框
    CardLayout card;
    JPanel jp1,jp2,jp3,jp4;
    JPanel jp;
    
    public MPLogin(JPanel JP) {
    	JLa1 = new JLabel("用户名");
    	JLa1.setFont(new Font("宋体",Font.PLAIN,26));
    	JLa1.setForeground(Color.GRAY);
   		JLa2 = new JLabel("密码");
		JLa2.setFont(new Font("宋体",Font.PLAIN,26));
		JLa2.setForeground(Color.GRAY);
		
		loginB = new JButton("登陆");
		loginB.setFont(new Font("登陆",Font.PLAIN,24));
		loginB.setForeground(Color.GRAY);
		loginB.setBackground(new Color(255,220,220));
		setLisB(loginB);
		
		NewUserB = new JButton("注册");
		NewUserB.setFont(new Font("注册",Font.PLAIN,24));
		NewUserB.setForeground(Color.GRAY);
		NewUserB.setBackground(new Color(255,220,220));
		setLisB(NewUserB);
		
		cancelB = new JButton("取消");
		cancelB.setFont(new Font("取消",Font.PLAIN,24));
		cancelB.setForeground(Color.GRAY);
		cancelB.setBackground(new Color(255,220,220));
		setLisB(cancelB);
		
		cancelB2 = new JButton("取消");
		cancelB2.setFont(new Font("取消",Font.PLAIN,24));
		cancelB2.setForeground(Color.GRAY);
		cancelB2.setBackground(new Color(255,220,220));
		setLisB(cancelB2);
		
		returnB = new JButton("返回登陆");
		returnB.setFont(new Font("返回登陆",Font.PLAIN,24));
		returnB.setForeground(Color.GRAY);
		returnB.setBackground(new Color(255,220,220));
		setLisB(returnB);
		
		sureB = new JButton("确定");
		sureB.setFont(new Font("确定",Font.PLAIN,24));
		sureB.setForeground(Color.GRAY);
		sureB.setBackground(new Color(255,220,220));
		setLisB(sureB);

		
		userText = new JTextField();
		userText.setFont(new Font("宋体",Font.PLAIN,26));
		userText.setColumns(30);
		
		passwordF = new JPasswordField();
		passwordF.setFont(new Font("宋体",Font.PLAIN,26));
		passwordF.setColumns(32);
		
		//用户名模块
		jp1 = new JPanel();
		jp1.setBackground(new Color(255,220,220));
		jp1.add(JLa1);
		jp1.add(userText);
		
		//密码框模块
		jp2 = new JPanel();
		jp2.setBackground(new Color(255,220,220));
		jp2.add(JLa2);
		jp2.add(passwordF);
		
		//登陆按钮模块
		jp3 = new JPanel();
		jp3.setBackground(new Color(200,240,255));
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT,60,10));
		jp3.add(NewUserB);
		jp3.add(loginB);
		jp3.add(cancelB2);
		
		//注册按钮模块
		jp4 = new JPanel();
		jp4.setBackground(new Color(200,240,255));
		jp4.setLayout(new FlowLayout(FlowLayout.LEFT,50,10));
		jp4.add(sureB);
		jp4.add(returnB);
		jp4.add(cancelB);

		card = new CardLayout(0,0);
		jp = new JPanel();
		jp.setLayout(card);
		jp.setBackground(new Color(200,240,255));
		jp.add(jp4,"jp4");
		jp.add(jp3,"jp3");
		
		//登陆界面
		JP.setLayout(new FlowLayout(FlowLayout.LEFT,170,100));
		JP.add(jp1);
		JP.add(jp2);
		JP.add(jp);
		
    }
    
    
    public void setLisB(JButton b) {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b==returnB) {
					card.show(jp,"jp3");
					//b.setBackground(new Color(255,175,175));
				}else if(b==NewUserB) {
					card.show(jp, "jp4");
				}else if(b==loginB) {
					
				}else if(b==cancelB) {
					passwordF.setText("");
					userText.setText("");
				}else if(b==sureB) {
					
				}else if(b==cancelB2) {
					passwordF.setText("");
					userText.setText("");
				}
			}	
		});
	}
	
}
