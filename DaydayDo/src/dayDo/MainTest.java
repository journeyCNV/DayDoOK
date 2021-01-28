package dayDo;
/**
 * 测试类
 * @author 24725
 *
 */

public class MainTest {

	public static void main(String[] args) {
		//MainView mainview = new MainView();
		
		//单例模式
		/**
		 * 原本想通过单利模式来实现界面实时刷新
		 * 但是没成功
		 * 我理解错了
		 */
		
		MainView mainview = MainView.getInstance();
		mainview.setVisible(true);
	}

}
