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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 日程界面
 * @author 24725
 *
 */

public class MPNote {
	JPanel JPMain,JPHead,JPsearch,jpser,jpse1,jpse2;//文本主框框，头框，查找框,默认空,保存框
	JTextArea text;//多行文本框
	JButton newFile,open,save;//三个按钮
	JFileChooser openFile,saveFile;//打开和保存文件窗口
	CardLayout card,card1;
	JLabel hello;//欢迎
	
	JLabel JLaY,JLaM,JLaD,JLaY1,JLaM1,JLaD1;//三个文本框输入提示标签
	JTextField year,month,day,year1,month1,day1;//两个输入文本框
	JButton choB,choB1;//选择按钮
	
	 DayDoFile FileO = new DayDoFile();//外援
	
	public MPNote(JPanel JP) {
		
		card = new CardLayout(0,0);
		card1 = new CardLayout(0,0);
				
		JPMain = new JPanel();
		JPMain.setBackground(new Color(255,220,220));
		JPMain.setLayout(card);
		
		JPHead = new JPanel();
    	JPHead.setBackground(new Color(200,240,255));
				
		
		text = new JTextArea();
		text.setFont(new Font("宋体",Font.PLAIN,24));
		
		
		hello = new JLabel();
    	hello.setText("快创建今天的日程吧！");
    	hello.setFont(new Font("宋体",Font.PLAIN,24));
    	hello.setForeground(Color.GRAY);//new Color(250,130,130)


		newFile = new JButton("新建");
		newFile.setFont(new Font("文件",Font.PLAIN,24));
		newFile.setForeground(Color.GRAY);
		newFile.setBackground(new Color(255,220,220)); 
		open = new JButton("打开");
		open.setFont(new Font("文件",Font.PLAIN,24));
		open.setForeground(Color.GRAY);
		open.setBackground(new Color(255,220,220)); 
		save = new JButton("保存");
		save.setFont(new Font("文件",Font.PLAIN,24));
		save.setForeground(Color.GRAY);
		save.setBackground(new Color(255,220,220)); 
		
		JScrollPane jsP = new JScrollPane(JPMain);
		jsP.setPreferredSize(new Dimension(718,360));
		
		JPHead.add(hello);
		JPHead.add(newFile);
		JPHead.add(open);
		JPHead.add(save);
		JPHead.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
				
		JPMain.add(text,"text");
		
		
		//打开
		year = new JTextField(8);
    	year.setFont(new Font("宋体",Font.PLAIN,26));
    	month = new JTextField(8);
    	month.setFont(new Font("宋体",Font.PLAIN,26));
    	day = new JTextField(8);
    	day.setFont(new Font("宋体",Font.PLAIN,26));
    	
    	JLaY = new JLabel("年");
    	JLaY.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaY.setForeground(Color.GRAY);
    	JLaM = new JLabel("月");
    	JLaM.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaM.setForeground(Color.GRAY);
    	JLaD = new JLabel("日");
    	JLaD.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaD.setForeground(Color.GRAY);
    	  	
    	choB = new JButton("打开");
    	choB.setFont(new Font("打开",Font.PLAIN,24));
		choB.setForeground(Color.GRAY);
		choB.setBackground(new Color(255,220,220));   
			
	    year1 = new JTextField(8);
    	year1.setFont(new Font("宋体",Font.PLAIN,26));
    	month1 = new JTextField(8);
    	month1.setFont(new Font("宋体",Font.PLAIN,26));
    	day1 = new JTextField(8);
    	day1.setFont(new Font("宋体",Font.PLAIN,26));
    	
    	JLaY1 = new JLabel("年");
    	JLaY1.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaY1.setForeground(Color.GRAY);
    	JLaM1 = new JLabel("月");
    	JLaM1.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaM1.setForeground(Color.GRAY);
    	JLaD1 = new JLabel("日");
    	JLaD1.setFont(new Font("宋体",Font.PLAIN,26));
    	JLaD1.setForeground(Color.GRAY);
		
		choB1 = new JButton("确定");
    	choB1.setFont(new Font("确定",Font.PLAIN,24));
		choB1.setForeground(Color.GRAY);
		choB1.setBackground(new Color(200,240,255));   
		
		jpser = new JPanel();
		jpser.setBackground(new Color(200,240,255));
		jpse1 = new JPanel();
		jpse1.setBackground(new Color(200,240,255));
		jpse2 = new JPanel();
		jpse2.setBackground(new Color(255,220,220));
		
		jpser.add(year);
    	jpser.add(JLaY);
    	jpser.add(month);
    	jpser.add(JLaM);
    	jpser.add(day);
    	jpser.add(JLaD);
    	jpser.add(choB);
    	jpser.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
    	
    	jpse2.add(year1);
    	jpse2.add(JLaY1);
    	jpse2.add(month1);
    	jpse2.add(JLaM1);
    	jpse2.add(day1);
    	jpse2.add(JLaD1);
    	jpse2.add(choB1);
    	jpse2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		JPsearch = new JPanel();
    	JPsearch.setBackground(new Color(200,240,255));
    	JPsearch.setLayout(card1);
    	JPsearch.add(jpser,"search");
       	JPsearch.add(jpse1,"default");
       	JPsearch.add(jpse2, "save");
       	
    	//card1.show(JPsearch,"search");
    	card1.show(JPsearch,"default");
		
		JP.add(JPHead);
		JP.add(jsP);
		JP.add(JPsearch);
		
		//响应
		MyEvent();
		
	}
	
	public void MyEvent() {
		
		
		//新建
		newFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card1.show(JPsearch, "default");
				card.show(JPMain, "text");
				text.setText("我的日程: \n1.\n2.\n3.\n4.\n5.\n6.\n7.\n8.\n9.");
				
			}		
		});
		
		//打开
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jpser.setBackground(new Color(200,240,255));
				card1.show(JPsearch,"search");
				setchoB();
			}
			
		});
		
		//保存
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card1.show(JPsearch, "save");
				JOptionPane.showMessageDialog(JPMain, "请输入日期", "温馨提示", JOptionPane.WARNING_MESSAGE);
				setchoB(1);
				}
			
		});
	}
	
	public void setchoB(int a) {
		
				choB1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String Y = year1.getText();
					String M = month1.getText();
					String D = day1.getText();
					String fileName = "save/Note"+Y+"-"+M+"-"+D+".txt";
			    	 FileO.saveF(text,fileName,JPMain);
			    	 
				}
			});
		}
	
	public void setchoB() {
		choB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ye = year.getText();
				String mo = month.getText();
				String da = day.getText();
				String filename = "save/Note"+ye+"-"+mo+"-"+da+".txt";
				File file = new File(filename);	
				if(file.exists()) {				
					try {
						//从文件读取数据
						text.setText("");
						BufferedReader read = new BufferedReader(new FileReader(file));
						String str = null;
						card.show(JPMain, "text");
						//将读取到的数据存放在文本框内区域内
						while((str = read.readLine())!= null) {
							text.append(str+"\n");
						}
					}catch(FileNotFoundException e1) {
						e1.printStackTrace();
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				}else if(!file.exists()){
					JOptionPane.showMessageDialog(JPMain, "当日无日程", "警告", JOptionPane.WARNING_MESSAGE);
				}

			}		
		});
	}
}
