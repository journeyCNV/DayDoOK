package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * 工具类
 * 按钮事件监听
 * @author 24725
 *
 */

public class HandleAction implements ActionListener{
	
	
    /**
     * 事件监听处理方法
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg;
		//如果按下确认按钮，显示用户名和密码
		if(e.getSource()==LoginView.loginB) {
			/**
			 * 先判断用户是否存在
			 * 如果存在登陆
			 * 如果不存在，提示先注册
			 */
			msg = "正在登陆";
			JOptionPane.showMessageDialog(LoginView.mainJ,msg);
		}else if(e.getSource()==LoginView.cancelB) {
			//如果取消，清空文本框、密码框
			LoginView.passwordF.setText("");
			LoginView.userText.setText("");
		}else if(e.getSource()==LoginView.NewUserB) {
			/**
			 * 进入注册界面
			 * 注册成功后直接登陆
			 */
		}else if(e.getSource()==LoginView.exitB) {
			/**
			 * 产品简介
			 */
		}
	}
	
}
