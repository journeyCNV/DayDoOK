package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ������
 * ��ť�¼�����
 * @author 24725
 *
 */

public class HandleAction implements ActionListener{
	
	
    /**
     * �¼�����������
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg;
		//�������ȷ�ϰ�ť����ʾ�û���������
		if(e.getSource()==LoginView.loginB) {
			/**
			 * ���ж��û��Ƿ����
			 * ������ڵ�½
			 * ��������ڣ���ʾ��ע��
			 */
			msg = "���ڵ�½";
			JOptionPane.showMessageDialog(LoginView.mainJ,msg);
		}else if(e.getSource()==LoginView.cancelB) {
			//���ȡ��������ı��������
			LoginView.passwordF.setText("");
			LoginView.userText.setText("");
		}else if(e.getSource()==LoginView.NewUserB) {
			/**
			 * ����ע�����
			 * ע��ɹ���ֱ�ӵ�½
			 */
		}else if(e.getSource()==LoginView.exitB) {
			/**
			 * ��Ʒ���
			 */
		}
	}
	
}
