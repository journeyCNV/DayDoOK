package login;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * ��½����
 * @author 24725
 *
 */

public class LoginView {
	
	
	/**
	 * ����ؼ�
	 */
	JLabel JLa1,JLa2;//��ǩ
	static JFrame mainJ;//����
	Container con;
	static JButton loginB,cancelB,NewUserB,exitB;//��ť
	static JTextField userText;//�ı���
	static JPasswordField passwordF;
	HandleAction handle;//��ť�¼�������
	
	/**
	 * �����ʼ������
	 */
	public void JtextDemo() {
		handle = new HandleAction();//��ʼ�����������
		
		JLa1 = new JLabel("�û���");
		JLa2 = new JLabel("����");
		
		mainJ = new JFrame("DayDo��½");//��������ı���
		
		/**
		 * ������Ҫ�����İ�ť
		 */
		loginB = new JButton("��½");
		loginB.addActionListener(handle);//����¼�����
		NewUserB = new JButton("ע��");
		NewUserB.addActionListener(handle);
		cancelB = new JButton("ȡ��");
		cancelB.addActionListener(handle);
		exitB = new JButton("DayDo���");
		exitB.addActionListener(handle);
		
		/**
		 * ��������� �û���+����
		 */
		userText = new JTextField();
		userText.setColumns(20);//�����ı���Ŀ��
		passwordF = new JPasswordField();
		passwordF.setColumns(20);
		
		/**
		 * �����Ѿ����úõĿؼ�
		 */
		con = mainJ.getContentPane();//��ʼ��һ������/���ش˴����contentPane����
		con.setLayout(new FlowLayout(FlowLayout.CENTER));//���������ֹ���
		con.add(JLa1);
		con.add(userText);
		con.add(JLa2);
		con.add(passwordF);
		con.add(loginB);
		con.add(NewUserB);
		con.add(cancelB);
		con.add(exitB);
		
		mainJ.setSize(1500, 800);//���ô����С
		mainJ.setVisible(true);//���ô��ڿɼ�
		
		mainJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ùرմ���ʱ�˳�JVM
		
	}

}
