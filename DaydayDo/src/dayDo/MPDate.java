package dayDo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ��������
 * @author 24725
 *
 */

public class MPDate {
	
	JTable table;//������
	JPanel JPHead,JPBody,JPMain;
	JLabel JLaY,JLaM,JLaD;//�����ı���������ʾ��ǩ
    JButton choB;//ѡ��ť
    JTextField year,month,day;//���������ı���
    CardLayout card,card1,card2;
    JTextArea text;//�����ı���
    
    Object[] name = {"������","����һ","���ڶ�","������","������","������","������"};
    Object[][] date;
    
    public MPDate(JPanel JP) {
    	card = new CardLayout(0,0);
    	card1 = new CardLayout(0,0);	
        card2 = new CardLayout(0,0);
		
        //�ճ̴�ӡ��
		JPMain = new JPanel();
		JPMain.setBackground(new Color(255,220,220));
		JPMain.setLayout(card2);
		JScrollPane jsP = new JScrollPane(JPMain);
		jsP.setPreferredSize(new Dimension(718,160));
		text = new JTextArea();
		text.setFont(new Font("����",Font.PLAIN,20));
		JPMain.add(text,"text");
		
    	
    	JPHead = new JPanel();
    	JPHead.setBackground(new Color(200,240,255));
    	JPBody = new JPanel();
    	JPBody.setBackground(new Color(200,240,255));
    	JPBody.setLayout(card);
    	
    	year = new JTextField(8);
    	year.setFont(new Font("����",Font.PLAIN,26));
    	month = new JTextField(8);
    	month.setFont(new Font("����",Font.PLAIN,26));
    	day = new JTextField(8);
    	day.setFont(new Font("����",Font.PLAIN,26));
   	
       	JLaY = new JLabel("��");
    	JLaY.setFont(new Font("����",Font.PLAIN,26));
    	JLaY.setForeground(Color.GRAY);
    	JLaM = new JLabel("��");
    	JLaM.setFont(new Font("����",Font.PLAIN,26));
    	JLaM.setForeground(Color.GRAY);
    	JLaD = new JLabel("��");
    	JLaD.setFont(new Font("����",Font.PLAIN,26));
    	JLaD.setForeground(Color.GRAY);
    	
    	
    	choB = new JButton("��ѯ");
    	choB.setFont(new Font("��ѯ",Font.PLAIN,24));
		choB.setForeground(Color.GRAY);
		choB.setBackground(new Color(255,220,220));    	
		setLisB(choB,JPBody);
    	
		JPHead.add(year);
    	JPHead.add(JLaY);
    	JPHead.add(month);
    	JPHead.add(JLaM);
    	JPHead.add(day);
    	JPHead.add(JLaD);
    	JPHead.add(choB);
    	JPHead.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
    	
    	JP.setLayout(new FlowLayout(FlowLayout.LEFT,60,20));
    	JP.add(JPHead);
    	JP.add(JPBody);
    	defaultView(JPBody);
    	JP.add(jsP);
    	
    	}
    
    public void setLisB(JButton b,JPanel JP) {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DayDoDate cal = new DayDoDate();
				Integer inputY = 0;
				int inputM = 0;
				
				try {
					inputY = Integer.parseInt(year.getText().trim());
					inputM = Integer.parseInt(month.getText().trim());
					
					if(inputM>=1&&inputM<=12) {
						cal.setYear(inputY);
						cal.setMonth(inputM);
						date = cal.getCalendar();
						table = new JTable(date,name);//���������ݺͱ�ͷ��Ϣ�ı��
						table.getTableHeader().setFont(new Font("����",Font.PLAIN,22));
						table.setFont(new Font("����",Font.PLAIN,26));
						table.setRowHeight(60);//�и�
	       				for(int i=0;i<7;i++) {
							table.getColumnModel().getColumn(i).setPreferredWidth(100);
						}
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ�����ģʽ
						table.setForeground(Color.GRAY);
						table.setBackground(new Color(255,220,220));
						JScrollPane jsP = new JScrollPane(table);
						jsP.setPreferredSize(new Dimension(718,360));
						JP.add(jsP,"jsp");//�������������������
						//JP.validate();
						card.show(JP, "jsp");
						setchoB();
					}else {
						JOptionPane.showMessageDialog(JP, "���������������������", "����", JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(JP, "���������������������", "����", JOptionPane.WARNING_MESSAGE);
				}
			}	
		});
	}
    
    
    /**
     * �������������������ȡ������ı�����
     * ������֤��΢��һ��
     * Ȼ���������������е���
     */
    
    //Ĭ�Ͻ���
    public void defaultView(JPanel JP) {
    	Calendar calen = Calendar.getInstance();//calendar��
    	DayDoDate cal = new DayDoDate();		
		int inputY = calen.get(Calendar.YEAR);//��ȡ����ʱ��
		int inputM = calen.get(Calendar.MONTH)+1;
		cal.setYear(inputY);
		cal.setMonth(inputM);
		date = cal.getCalendar();
		table = new JTable(date,name);//���������ݺͱ�ͷ��Ϣ�ı��
			//���ñ�ͷ��С
		table.getTableHeader().setFont(new Font("����",Font.PLAIN,22));
		table.setFont(new Font("����",Font.PLAIN,30));
		table.setRowHeight(60);//�и�
		for(int i=0;i<7;i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ�����ģʽ
		table.setForeground(Color.GRAY);
		table.setBackground(new Color(255,220,220));
		JScrollPane jsP = new JScrollPane(table);
		jsP.setPreferredSize(new Dimension(718,360));
		JP.add(jsP,"jsp");//�������������������
		card.show(JP, "jsp");
		//JP.validate();
    }
    
    public void setchoB() {
				String ye = year.getText();
				String mo = month.getText();
				String da = day.getText();
				String filename = "save/Note"+ye+"-"+mo+"-"+da+".txt";
				File file = new File(filename);	
				if(file.exists()) {				
					try {
						//���ļ���ȡ����
						text.setText("");
						BufferedReader read = new BufferedReader(new FileReader(file));
						String str = null;
						card2.show(JPMain, "text");
						//����ȡ�������ݴ�����ı�����������
						while((str = read.readLine())!= null) {
							text.append(str+"\n");
						}
					}catch(FileNotFoundException e1) {
						e1.printStackTrace();
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				}else if(!file.exists()){
					JOptionPane.showMessageDialog(JPMain, "�������ճ�", "����", JOptionPane.WARNING_MESSAGE);
					text.setText("");
				}

	}

}
