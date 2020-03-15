package view;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import control.GameDir;
import control.MyWindowAdapter;
import model.ImageDate;
/**
 * 
 * @ClassName: InputFrame 
 * @Description: TODO(点击 登录游戏后的窗口) 
 * @author 
 *
 */
public class InputFrame extends JFrame {
	private InputPanel inputpanel=new InputPanel();
	private GameinfoPanel gameinfo=new GameinfoPanel();
    private GameMenubar gameMenuBar;
	private MyWindowAdapter winListener=new MyWindowAdapter();
	public InputFrame(GameDir gd) {
		gameMenuBar=new GameMenubar(gd);	
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("坦克大战v1.0 ");
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setResizable(false);
	    this.setJMenuBar(gameMenuBar);
		this.add(inputpanel);
		this.add(gameinfo,BorderLayout.EAST);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(winListener);	
	}
	// ----------------------set和get方法区-----------------------------

	public InputPanel getInputpanel() {
		return inputpanel;
	}
	public void setInputpanel(InputPanel inputpanel) {
		this.inputpanel = inputpanel;
	}
	public GameinfoPanel getGameinfo() {
		return gameinfo;
	}
	public void setGameinfo(GameinfoPanel gameinfo) {
		this.gameinfo = gameinfo;
	}
	public GameMenubar getGameMenuBar() {
		return gameMenuBar;
	}
	public void setGameMenuBar(GameMenubar gameMenuBar) {
		this.gameMenuBar = gameMenuBar;
	}
	public MyWindowAdapter getWinListener() {
		return winListener;
	}
	public void setWinListener(MyWindowAdapter winListener) {
		this.winListener = winListener;
	}
	
	
	
}
