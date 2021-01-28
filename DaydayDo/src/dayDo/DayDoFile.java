package dayDo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 将文件保存、文件打开功能封装
 * 由程序决定操作，用户不直接打开交互界面
 * 保存打开都由后台操作
 * 每个文件都有独立时间标识符
 * 同一天的文件在同一天的基础上修改
 * 通过时间标识符，日历可以查询对应的文件，并且导入
 */
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class DayDoFile {

	Calendar calen = Calendar.getInstance();//calendar类
	private int inputY = calen.get(Calendar.YEAR);//获取当下时间
	private int inputM = calen.get(Calendar.MONTH)+1;
	private int inputDay = calen.get(Calendar.DATE);
	
	public String isHaveNote() {
		String fn = setString();
		String fileName = "save/Note"+fn+".txt"; //获取当日的文件名
		File file = new File(fileName);//创建文件类型对象
		if(file.exists()) {
			return "有";
		}else {
			return "无";
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
		ans.reverse();//转置
		return ans.toString();//转换成String型变量
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
		ans.reverse();//转置
		return ans.toString();//转换成String型变量
	}
	
	//重载 saveF 自义定保存文件
	public void saveF(JTextArea text,String fileName,JPanel JPMain) {
		File file = new File(fileName);//创建文件类型对象
		//若文件不存在则新建，存在删除再新建
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
		
		//获取文本框区域的内容
		String content = text.getText();
		
		//将文本区域的内容保存到文件中
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//从第一个字节写到最后一个字节
			JOptionPane.showMessageDialog(JPMain, "日程保存成功", "温馨提示", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public void saveF(JTextArea text,JPanel JPMain) {
		String fn = setString(inputY,inputM,inputDay);
		String fileName = "save/Note"+fn+".txt"; //获取当日的文件名
		File file = new File(fileName);//创建文件类型对象
		//若文件不存在则新建，存在删除再新建
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
		
		//获取文本框区域的内容
		String content = text.getText();
		
		//将文本区域的内容保存到文件中
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] contentByte = content.getBytes();
			out.write(contentByte,0,contentByte.length);//从第一个字节写到最后一个字节
			JOptionPane.showMessageDialog(JPMain, "日程保存成功", "提示", JOptionPane.WARNING_MESSAGE);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	

}
