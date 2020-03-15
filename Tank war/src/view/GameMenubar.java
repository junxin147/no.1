package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.GameDir;
import control.MyMenuListener;
import control.GameActionListener;
/**
 * 
 * @ClassName: GameMenubar 
 * @Description: TODO(菜单栏设置) 
 * @author 
 *
 */
public class GameMenubar extends JMenuBar {
	private JMenu gameMenu=new JMenu("游戏");
	private JMenu helpMenu=new JMenu("帮助");
	private JMenu stopMenu=new JMenu("暂停游戏");
	private JMenu keepMenu=new JMenu("继续游戏");
    private JMenuItem starGame=new JMenuItem("开始游戏");
    private JMenuItem restarGame=new JMenuItem("重新游戏");
    private JMenuItem rangking=new JMenuItem("排行榜"); 
    private JMenuItem custom=new JMenuItem("自定义");
     private JMenuItem exit=new JMenuItem("退出");
     private JMenuItem helpItem=new JMenuItem("游戏说明");
     private GameActionListener actionlist;
    private MyMenuListener menuListener;
     
     public GameMenubar(GameDir gd) {
    	 menuListener=new MyMenuListener(gd);
    	 actionlist=new GameActionListener(gd);
    	 this.add(gameMenu);
	    this.add(helpMenu);
	    this.add(stopMenu);
	    this.add(keepMenu);
	    gameMenu.add(starGame);
	    gameMenu.add(restarGame);
	    gameMenu.add(rangking);
	    gameMenu.add(custom);
	    gameMenu.add(exit);
	    helpMenu.add(helpItem);
	    
	    keepMenu.addMenuListener(menuListener);
	   stopMenu.addMenuListener(menuListener); 
	    //设置动作指令，添加到监听
	    helpItem.setActionCommand("help");
	    this.  helpItem.addActionListener(actionlist);
	    starGame.setActionCommand("star");
	    this. starGame.addActionListener(actionlist);
	    exit.setActionCommand("exit");
	    this. exit.addActionListener(actionlist);
	    custom.setActionCommand("set");
	    this.custom.addActionListener(actionlist);
	    restarGame.setActionCommand("restarGame");
	    this.restarGame.addActionListener(actionlist);
	    this.restarGame.setEnabled(false);
	    this.stopMenu.setEnabled(false);
	    this.keepMenu.setEnabled(false);
     }
	// ----------------------set和get方法区-----------------------------

	public JMenu getStopMenu() {
		return stopMenu;
	}


	public void setStopMenu(JMenu stopMenu) {
		this.stopMenu = stopMenu;
	}


	public JMenu getKeepMenu() {
		return keepMenu;
	}


	public void setKeepMenu(JMenu keepMenu) {
		this.keepMenu = keepMenu;
	}


	public JMenu getGameMenu() {
		return gameMenu;
	}

	public void setGameMenu(JMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	public JMenuItem getStarGame() {
		return starGame;
	}

	public void setStarGame(JMenuItem starGame) {
		this.starGame = starGame;
	}

	public JMenuItem getRestarGame() {
		return restarGame;
	}

	public void setRestarGame(JMenuItem restarGame) {
		this.restarGame = restarGame;
	}

	public JMenuItem getRangking() {
		return rangking;
	}

	public void setRangking(JMenuItem rangking) {
		this.rangking = rangking;
	}

	public JMenuItem getCustom() {
		return custom;
	}

	public void setCustom(JMenuItem custom) {
		this.custom = custom;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JMenuItem getHelpItem() {
		return helpItem;
	}

	public void setHelpItem(JMenuItem helpItem) {
		this.helpItem = helpItem;
	}

	public GameActionListener getActionlist() {
		return actionlist;
	}

	public void setActionlist(GameActionListener actionlist) {
		this.actionlist = actionlist;
	}

     
     
}
