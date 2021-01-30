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
	 * *��ȡ����ʵ��
	 * @return
	 */
	public static synchronized MainView getInstance() {
		if(mainview==null) {
			mainview = new MainView();
		}
		return mainview;
	}
	
	// ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϵ�λ��
	static Point origin = new Point();
	JPanel con;//�������
	static JLabel call = new JLabel();//;//�������,�汾,�ճ�����
	JPanel leftPanel;
	JButton B1,B2,B3,B4,B5,B6,B7;
	JButton flDay; //ˢ������
	JButton inn; //���뱾���ļ�����
	
	private static int setBackY = 18;//ť��ʼY������
	private static final int high = 32;//��ť�ĸ߶�
	
	private static int setBackY1 = 20;//�ı���ʼY������
	private static final int high1 = 32;//�߶�
	
	//�ı���
	JTextField t1,t2,t3,t4,t5,t6,t7;//�����ı���
	
	//��ȡ��ǰĿ¼����·��
	String rootPath = System.getProperty("user.dir");
	//��б�ܻ�˫б��
	Image icon = Toolkit.getDefaultToolkit().getImage(rootPath.replace("\\", "\\\\")+"\\src\\logic\\tubiao.png");
	ImageIcon iconBOFF = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BOFF.png");
	ImageIcon iconBON = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BON.png");
	ImageIcon iconBBB = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\BBB.png");
	ImageIcon iconINN = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\INN.png");
	ImageIcon iconINNS = new ImageIcon(rootPath.replace("\\", "\\\\")+"\\src\\logic\\INNS.png");
	
	
	int setOnB[] = {1,1,1,1,1,1,1}; //�л���ťͼ��
	int saveF = 1; //1��������0��д  ��ʼ����1�����涼��0����ʼ����ʱ��ӱ��ض�ȡ�ϴε��ճ̣�Ȼ���ʱһֱ����
	
	private MainView() {
		
    /**-------------��������------------*/
		
		setResizable(false);
		setType(Type.POPUP);
		setTitle("DayDoOK");
	
		this.setIconImage(icon);   //���ô��ڵ�logo

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ���ʱ�˳�JVM
		setBounds(100,100,460,260);//���ڴ�С
		setLocationRelativeTo(null);
		
		
		this.setUndecorated(true);//���岻��ʾ,����ᵼ�´����޷��϶�
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
		//this.setOpacity(0.1f);
		
		/**--------------�����϶�--------------*/
		this.addMouseListener(new MouseAdapter() {
			// ���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {
			// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
			origin.x = e.getX();
			origin.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
				// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
				public void mouseDragged(MouseEvent e) {
				// ������϶�ʱ��ȡ���ڵ�ǰλ��
				Point p = getLocation();
				// ���ô��ڵ�λ��
				// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}
		});
		
		
		/**-----��JPanel--------*/
		con = new JPanel();
		con.setBackground(new Color(80,100,225,138));//���һ����������͸����
		con.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(con);
		con.setLayout(null);
		
		
		/**----���ʱ������----*/
		/**����ճ�����*/
		//�ı���	
		/**����ʹ��html��û��͸��*/
		call.setText("<html>...........<br/>DAYDO,OK!: <br/>"+new TimeFile().setString()+"<br/><br/>"+"�����ҳ�<br/>������"+"<br/>...........<html>");
		call.setFont(new Font("����",Font.PLAIN,16));
		call.setForeground(Color.WHITE);
		
		//������
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 100, 350);
		leftPanel.setBackground(new Color(80,130,255,158));
		//���ı�����������
		leftPanel.add(call);
		//����������������
		con.add(leftPanel);
		
		
		/**----------�ճ̰�ť------------------*/
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
		
		flDay = new JButton(); //ˢ������
		setViewflT(flDay);
		setLisflT(flDay);
		
		inn = new JButton();
		setViewInn(inn);
		setLisInn(inn);
		
		
		
		/**----------�ճ��ı���---------*/
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
		t.setFont(new Font("����",Font.PLAIN,16));
		t.setForeground(new Color(30,40,220));
		setBackY1 += high1;
		con.add(t);
	}
	
	public void setViewB(JButton b) {
		b.setIcon(iconBON);
		b.setSize(28,28);
		//ȥ����ť������Χ�Ľ����
		b.setFocusPainted(false);
		b.setBorderPainted(false);//���ð�ť�߽粻��ʾ
		b.setBounds(136, setBackY, 28, 28);
		setBackY += high;
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisB(JButton b,int n) {//��ť�ļ���
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(setOnB[n]==1) { 
					b.setIcon(iconBBB);
					setOnB[n]=0; //0���Ѿ����
				}else {
					b.setIcon(iconBON);
					setOnB[n]=1;  //1��δ���
				}
			}	
		});
	}
	
	public void setViewflT(JButton b) {
		b.setIcon(iconBOFF);
		b.setSize(28,28);
		//ȥ����ť������Χ�Ľ����
		b.setFocusPainted(false);
		b.setBorderPainted(false);//���ð�ť�߽粻��ʾ
		b.setBounds(34, 200, 28, 28);
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisflT(JButton b) {//ˢ�����ں�������
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				call.setText("<html>...........<br/>DAYDO,OK!: <br/>"+new TimeFile().setString()+"<br/><br/>"+"�����ҳ�<br/>������"+"<br/>...........<html>");
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
		//ȥ����ť������Χ�Ľ����
		b.setFocusPainted(false);
		b.setBorderPainted(false);//���ð�ť�߽粻��ʾ
		b.setBounds(34, 160, 28, 28);
		b.setBackground(new Color(0,0,0,0));
		con.add(b);
	}
	
	public void setLisInn(JButton b) {//��ť�ļ���
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeFile tf = new TimeFile();
				ArrayList<String> List = new ArrayList<String>();
				/**����ǿ�ʼ�򿪣���ȡ�ϴεļ�¼*/
				if(saveF==1) {  //1
					//�ѱ��ص����ݶ�����
					List = tf.readF();
					String sLine1 = List.get(0);  //��һ���ַ���
					if(sLine1.charAt(0)=='0') {//��Ӧ�������Ѿ����
						B1.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B1.setIcon(iconBON);
					}
					
					if(sLine1.charAt(1)=='0') {//��Ӧ�������Ѿ����
						B2.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B2.setIcon(iconBON);
					}
					
					if(sLine1.charAt(2)=='0') {//��Ӧ�������Ѿ����
						B3.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B3.setIcon(iconBON);
					}
					
					if(sLine1.charAt(3)=='0') {//��Ӧ�������Ѿ����
						B4.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B4.setIcon(iconBON);
					}
					
					if(sLine1.charAt(4)=='0') {//��Ӧ�������Ѿ����
						B5.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B5.setIcon(iconBON);
					}
					
					if(sLine1.charAt(5)=='0') {//��Ӧ�������Ѿ����
						B6.setIcon(iconBBB);
					}else { //��Ӧ������δ���
						B6.setIcon(iconBON);
					}
					
					if(sLine1.charAt(6)=='0') {//��Ӧ�������Ѿ����
						B7.setIcon(iconBBB);
					}else { //��Ӧ������δ���
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
					saveF = 0;//д
					
				}else {
					/**���һֱ�ڴ�״̬��һֱ��ȡ�������*/
					//���ı��������д���ļ���
					//String context = t1.getText();
					StringBuffer SB = new StringBuffer();
					//context = context.concat("����������");
					for(int i=0;i<7;i++) {
						if(setOnB[i]==0) {
							//�ַ���ƴ��0, �������Ŀ
							SB.append('0');
						}else {
							//�ַ���ƴ��1
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
