package view;

import javax.swing.JFrame;

import control.GameDir;
import control.MyWindowAdapter;
import model.ImageDate;

/**
 * 
 * @ClassName: LoginFrame
 * @Description: TODO(登录窗口)
 * @author
 *
 */


public class LoginFrame extends JFrame {
	private LoginPanel loginpanel;
	private MyWindowAdapter winListener=new MyWindowAdapter();
	public LoginFrame(GameDir gd) {
		loginpanel=new LoginPanel(gd);
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("坦克大战v1.0 ");
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setResizable(false);
		this.add(loginpanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(winListener);
		


	}
}
