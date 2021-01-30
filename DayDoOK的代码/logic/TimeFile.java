package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TimeFile {
	Calendar calen = Calendar.getInstance();//calendar��
	private int inputY = calen.get(Calendar.YEAR);//��ȡ����ʱ��
	private int inputM = calen.get(Calendar.MONTH)+1;
	private int inputDay = calen.get(Calendar.DATE);
	
	public String isHaveNote() {
		String fn = setString();
		String fileName = "save/Note"+fn+".txt"; //��ȡ���յ��ļ���
		File file = new File(fileName);//�����ļ����Ͷ���
		if(file.exists()) {
			return "���������";
		}else {
			return "���������";
		}
	}
	
	
	public String setString() {
		String[] num={"0","1","2","3","4","5","6","7","8","9"};
		StringBuffer ans = new StringBuffer();
		while(inputDay>0) {
			ans.append(num[inputDay%10]);
			inputDay/=10;
		}
		ans.append(".");
		while(inputM>0) {
			ans.append(num[inputM%10]);
			inputM/=10;
		}
		ans.append(".");
		while(inputY>0) {
			ans.append(num[inputY%10]);
			inputY/=10;
		}
		ans.reverse();//ת��
		return ans.toString();//ת����String�ͱ���
	}
		
	public String setString(int Y,int M,int D) {
		String[] num={"0","1","2","3","4","5","6","7","8","9"};
		StringBuffer ans = new StringBuffer();
		while(D>0) {
			ans.append(num[D%10]);
			D/=10;
		}
		ans.append("-");
		while(M>0) {
			ans.append(num[M%10]);
			M/=10;
		}
		ans.append("-");
		while(Y>0) {
			ans.append(num[Y%10]);
			Y/=10;
		}
		ans.reverse();//ת��
		return ans.toString();//ת����String�ͱ���
	}
	
	//���� saveF ���嶨�����ļ�
	public void saveF(JTextArea text,String fileName,JPanel JPMain) {
		File file = new File(fileName);//�����ļ����Ͷ���
		//���ļ����������½�������ɾ�����½�
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}else {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//��ȡ�ı������������
		String content = text.getText();
		
		//���ı���������ݱ��浽�ļ���
		try {
			@SuppressWarnings("resource")
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//�ӵ�һ���ֽ�д�����һ���ֽ�
			JOptionPane.showMessageDialog(JPMain, "�ճ̱���ɹ�", "��ܰ��ʾ", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public void saveF(JTextArea text) {
		//String fn = setString(inputY,inputM,inputDay);
		String fileName = "Note.txt"; 
		File file = new File(fileName);//�����ļ����Ͷ���
		//���ļ����������½�������ɾ�����½�
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}else {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//��ȡ�ı������������
		String content = text.getText();
		
		//���ı���������ݱ��浽�ļ���
		try {
			@SuppressWarnings("resource")
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//�ӵ�һ���ֽ�д�����һ���ֽ�
			//JOptionPane.showMessageDialog(JPMain, "�ճ̱���ɹ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void saveF(StringBuffer s) {
		String fileName = "Note.txt"; 
		File file = new File(fileName);//�����ļ����Ͷ���
		//���ļ����������½�������ɾ�����½�
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}else {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//���ı���������ݱ��浽�ļ���
		try {
			//@SuppressWarnings("resource")
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = s.toString().getBytes();
			out.write(contentByte,0,contentByte.length);//�ӵ�һ���ֽ�д�����һ���ֽ�
			//JOptionPane.showMessageDialog(JPMain, "�ճ̱���ɹ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
			out.close();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public ArrayList<String> readF() {
		String fileName = "Note.txt"; 
		File file = new File(fileName);	
		ArrayList<String> List = new ArrayList<String>();
		if(file.exists()) {				
			try {
				BufferedReader read = new BufferedReader(new FileReader(file));
				String str = null;
				List.add(read.readLine());
				//����ȡ�������ݴ�����ı�����������
				while((str = read.readLine())!= null) {
					List.add(str);
				}
				read.close();
			}catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}else if(!file.exists()){
			//JOptionPane.showMessageDialog(JPMain, "�������ճ�", "����", JOptionPane.WARNING_MESSAGE);
		}
		return List;
	}
	
}
