package dayDo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * ���ļ����桢�ļ��򿪹��ܷ�װ
 * �ɳ�������������û���ֱ�Ӵ򿪽�������
 * ����򿪶��ɺ�̨����
 * ÿ���ļ����ж���ʱ���ʶ��
 * ͬһ����ļ���ͬһ��Ļ������޸�
 * ͨ��ʱ���ʶ�����������Բ�ѯ��Ӧ���ļ������ҵ���
 */
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class DayDoFile {

	Calendar calen = Calendar.getInstance();//calendar��
	private int inputY = calen.get(Calendar.YEAR);//��ȡ����ʱ��
	private int inputM = calen.get(Calendar.MONTH)+1;
	private int inputDay = calen.get(Calendar.DATE);
	
	public String isHaveNote() {
		String fn = setString();
		String fileName = "save/Note"+fn+".txt"; //��ȡ���յ��ļ���
		File file = new File(fileName);//�����ļ����Ͷ���
		if(file.exists()) {
			return "��";
		}else {
			return "��";
		}
	}
	
	
	public String setString() {
		String[] num={"0","1","2","3","4","5","6","7","8","9"};
		StringBuffer ans = new StringBuffer();
		while(inputDay>0) {
			ans.append(num[inputDay%10]);
			inputDay/=10;
		}
		ans.append("-");
		while(inputM>0) {
			ans.append(num[inputM%10]);
			inputM/=10;
		}
		ans.append("-");
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
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//�ӵ�һ���ֽ�д�����һ���ֽ�
			JOptionPane.showMessageDialog(JPMain, "�ճ̱���ɹ�", "��ܰ��ʾ", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public void saveF(JTextArea text,JPanel JPMain) {
		String fn = setString(inputY,inputM,inputDay);
		String fileName = "save/Note"+fn+".txt"; //��ȡ���յ��ļ���
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
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//�ӵ�һ���ֽ�д�����һ���ֽ�
			JOptionPane.showMessageDialog(JPMain, "�ճ̱���ɹ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	

}
