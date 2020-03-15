package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import control.GameDir;
import control.MyWindowAdapter;

import model.ImageDate;

/**
 * 
 * @ClassName: GameFrame 
 * @Description: TODO(游戏窗口) 
 * @author 
 *
 */
public class GameFrame extends JFrame {
	private GamePanel gamepanel;
	private GameinfoPanel gameinfo=new GameinfoPanel();
    private GameMenubar gameMenuBar;
	private MyWindowAdapter winListener=new MyWindowAdapter();
	public GameFrame(GameDir gd) {
		gameMenuBar=new GameMenubar(gd);
		gamepanel=new GamePanel(gd);
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("坦克大战v1.0 ");
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setResizable(false);
	    this.setJMenuBar(gameMenuBar);
		this.add(gamepanel);
		this.add(gameinfo,BorderLayout.EAST);		
		this.pack();		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(winListener);

	
	}
	// ----------------------set和get方法区-----------------------------

	public GameMenubar getGameMenuBar() {
		return gameMenuBar;
	}


	public void setGameMenuBar(GameMenubar gameMenuBar) {
		this.gameMenuBar = gameMenuBar;
	}





	public GamePanel getGamepanel() {
		return gamepanel;
	}
	public void setGamepanel(GamePanel gamepanel) {
		this.gamepanel = gamepanel;
	}
	public GameinfoPanel getGameinfo() {
		return gameinfo;
	}
	public void setGameinfo(GameinfoPanel gameinfo) {
		this.gameinfo = gameinfo;
	}
	public MyWindowAdapter getWinListener() {
		return winListener;
	}
	public void setWinListener(MyWindowAdapter winListener) {
		this.winListener = winListener;
	}
	

	
}
