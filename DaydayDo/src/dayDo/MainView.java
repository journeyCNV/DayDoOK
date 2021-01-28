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
 * ���������
 */

public class MainView extends JFrame {
	
	//implements Runnable
	/**
	@Override
	public void run() {//����-----------------------------------
		while(true) {
			try {
				Thread.sleep(2000);
				call.repaint();
				call.setText("<html><br/><br/>����:<br/>"+new DayDoFile().setString()+"<br/>"+new DayDoFile().isHaveNote()+"�����ճ�<html>");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}*/

	
	//���Ե���ģʽ
	private static MainView mainview;
	
	public static synchronized MainView getInstance() {
		if(mainview==null) {
			mainview = new MainView();
		}
		return mainview;
	}

	/**������*/
	private static final long serialVersionUID = 1L;
	private static int setBackY = 60;//��ť��ʼY������
	private static final int high = 80;//��ť�ĸ߶�
	private static final String ver ="v1.1.1";//�汾��
	
	JPanel con;//�������
	JLabel name,version;
	static JLabel call = new JLabel();//;//�������,�汾,�ճ����Ѱ�ͷ
	JPanel topPanel,bottomPanel,mainPanel,leftPanel;//�����Ϲ̶����Ŀ����
	CardLayout card;//���忨Ƭ���ֶ���
	JButton userB,dateB,noteB,noticeB;//�ĸ���ť
    JPanel MP1,MP2,MP3,MP4;//�ĸ���ť��Ӧ���л����
    	
	private MainView() {
		//�����ܲ���
		setResizable(false);
		setType(Type.POPUP);
		setTitle("DayDo����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ���ʱ�˳�JVM
		setBounds(100,100,1000,800);
		setLocationRelativeTo(null);
		con = new JPanel();
		con.setBackground(new Color(160,220,240));
		con.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(con);
		con.setLayout(null);
		
		//��ť����
		userB = new JButton("��½");
		setViewB("��½",userB);
		setLisB("user",userB);
		dateB = new JButton("����");
		setViewB("����",dateB);	
		setLisB("date",dateB);
		noteB = new JButton("�ճ̼�¼");
		setViewB("�ճ̼�¼",noteB);	
		setLisB("note",noteB);
		noticeB = new JButton("ʹ��˵��");
		setViewB("ʹ��˵��",noticeB);
		setLisB("notice",noticeB);
		
		/**��ͷ*/
		//�ı���1
		name = new JLabel("DayDo����");
		name.setFont(new Font("����",Font.PLAIN,32));
		name.setForeground(Color.WHITE);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		//�ı���2
		version = new JLabel(ver);
		version.setFont(new Font("����",Font.PLAIN,18));
		version.setForeground(Color.WHITE);
		version.setVerticalAlignment(SwingConstants.TOP);
		version.setHorizontalAlignment(SwingConstants.CENTER);
		//�������ı�������ͷ�����
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1000, 60);
		topPanel.add(name);
		topPanel.add(version);
		topPanel.setBackground(new Color(120,190,255));
		//����ͷ�������������
		con.add(topPanel);
		
		/**װ�εױ�*/
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,730,1000,38);
		bottomPanel.setBackground(new Color(120,190,255));
		//���ױ߷����������
		con.add(bottomPanel);
		
		/**����ճ�����*/
		//�ı���	
		//call = new JLabel();
		//run();//����-------------------------------------
		call.setText("<html><br/><br/>����:<br/>"+new DayDoFile().setString()+"<br/>"+new DayDoFile().isHaveNote()+"�����ճ�<html>");
		call.setFont(new Font("����",Font.PLAIN,20));
		call.setForeground(Color.WHITE);
		
		//������
		leftPanel = new JPanel();
		leftPanel.setBounds(0, setBackY, 130, 350);
		leftPanel.setBackground(new Color(100,170,255));
		//���ı�����������
		leftPanel.add(call);
		//����������������
		con.add(leftPanel);
		
		/**�����*/
		mainPanel = new JPanel();
		mainPanel.setBounds(130,60,870,670);
		mainPanel.setBackground(new Color(200,240,255));
		//���������������
		con.add(mainPanel);
		//����������ÿ�Ƭʽ����
		card = new CardLayout(0,0);
		mainPanel.setLayout(card);
		//�����ĵ����ſ�Ƭ���
		MP1 = new JPanel();
		setMP1(MP1);//�ӽ�������
		MP2 = new JPanel();
		setMP2(MP2);//�ӽ�������
		MP3 = new JPanel();
		setMP3(MP3);//�ӽ�������
		MP4 = new JPanel();
		setMP4(MP4);//�ӽ�������
		//�����Ƕ���������岢����
		mainPanel.add(MP1,"user");
		mainPanel.add(MP2,"date");
		mainPanel.add(MP3,"note");
		mainPanel.add(MP4,"notice");
		
	}
	

	public void setLisB(String s1,JButton b) {//�ĸ�����ť�ļ���
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel, s1);
				setColorB();
				b.setBackground(new Color(255,175,175));
				}	
		});
	}
	
	
	public void setMP1(JPanel JP) {//�û����浼�뷽��
		MP1.setBackground(new Color(200,240,255));
		MPLogin mplo = new MPLogin(JP);
	}
	
	public void setMP2(JPanel JP) {//���ڽ��浼�뷽��
		MP2.setBackground(new Color(200,240,255));
		MPDate mpdate = new MPDate(JP);
	}
	
	public void setMP3(JPanel JP) {//�ճ̽��浼�뷽��
		MP3.setBackground(new Color(200,240,255));
		MPNote mpnote = new MPNote(JP);
	}
	
	
	public void setMP4(JPanel JP) {//�����浼�뷽��
		MP4.setBackground(new Color(200,240,255));
		JLabel JL = new JLabel();
		JL.setText("<html><br/>DayDo������һ�����Բ鿴���ڼ�¼�ճ̵�Ӧ�ó���<br/><br/>��2019��5-6�·ݿ�ʼ����"
				+ "<br/><br/>��������һ��javaС��<br/>�����������кܶ�����<br/>swing���Ľ���Ҳ��Щ��ª<br/>"
				+ "Ŀǰ���Բ鿴����,�������ڴ����ճ̣��������ڲ����ճ�<br/>Ҳ����ʾ�û�������û���ճ�<br/><br/>"
				+ "���ڼ���ʩ����,���ֹ�����ʱ����ʹ��,�µĹ��ܻ�������<br/>����½⣬�����ڴ�<html>");
		JL.setFont(new Font("����",Font.PLAIN,18));
		JL.setBounds(130,60,870,670);
		JL.setForeground(Color.GRAY);
		JL.setHorizontalAlignment(SwingConstants.CENTER);
		JL.setVerticalAlignment(SwingConstants.CENTER);
		JP.add(JL);
	}
	
	
	/**
	 * ��ť�Ļ�������
	 */
	
	public void setViewB(String s,JButton b) {
		b.setFont(new Font(s,Font.PLAIN,22));
		b.setForeground(Color.WHITE);
		int n1=110,n2=210,n3=255;//��ʼ��ɫ����
		b.setBackground(new Color(n1,n2,n3));
		b.setBounds(0, setBackY, 130, high);
		setBackY += high;
		con.add(b);
		b.setBackground(new Color(n1,n2,n3));
		}
	
	public void setColorB() {
		int n1=110,n2=210,n3=255;//��ʼ��ɫ����
		userB.setBackground(new Color(n1,n2,n3));
		dateB.setBackground(new Color(n1,n2,n3));
		noteB.setBackground(new Color(n1,n2,n3));
		noticeB.setBackground(new Color(n1,n2,n3));
	}
	
	
}
