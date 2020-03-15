package view;

import control.GameDir;

public class Ui {
	private FinishDialog finishDialog=new FinishDialog();
	private GameFrame gameframe;
	private LoginFrame loginframe;
	private InputFrame inputframe;
	private SettingJDialog settingJDialog;
	public Ui(GameDir gd) {
		settingJDialog=new SettingJDialog(gd);
		loginframe=new LoginFrame(gd);
		gameframe=new GameFrame(gd);
		inputframe=new InputFrame(gd);
		// TODO Auto-generated constructor stub

	}
	public void showlogin() {
		// TODO Auto-generated method stub
		 loginframe.setVisible(true);
		    inputframe.setVisible(false);
		    gameframe.setVisible(false);
	}
	public void showinput() {
		// TODO Auto-generated method stub
		 loginframe.setVisible(false);
		    inputframe.setVisible(true);
		    gameframe.setVisible(false);
	}
	public void showgame() {
		// TODO Auto-generated method stub
		 loginframe.setVisible(false);
		    inputframe.setVisible(false);
		    gameframe.setVisible(true);
	}
	
//-------------------SET和get方法区-------------------
	public SettingJDialog getSettingJDialog() {
		return settingJDialog;
	}
	public void setSettingJDialog(SettingJDialog settingJDialog) {
		this.settingJDialog = settingJDialog;
	}
	public GameFrame getGameframe() {
		return gameframe;
	}
	public void setGameframe(GameFrame gameframe) {
		this.gameframe = gameframe;
	}
	public LoginFrame getLoginframe() {
		return loginframe;
	}
	public void setLoginframe(LoginFrame loginframe) {
		this.loginframe = loginframe;
	}
	public InputFrame getInputframe() {
		return inputframe;
	}
	public void setInputframe(InputFrame inputframe) {
		this.inputframe = inputframe;
	}
	public FinishDialog getFinishDialog() {
		return finishDialog;
	}
	public void setFinishDialog(FinishDialog finishDialog) {
		this.finishDialog = finishDialog;
	}

	
	
}
