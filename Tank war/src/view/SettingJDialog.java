package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import control.GameDir;
import model.ImageDate;
/**
 * 
 * @ClassName: SettingJDialog 
 * @Description: TODO(�Զ�����崰��) 
 * @author 
 *
 */
public class SettingJDialog extends JDialog {
  

	private SettingPanel set;

	public SettingJDialog(GameDir gd) {
		// TODO Auto-generated constructor stub
		set = new SettingPanel(gd);
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("�Զ�������");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		;
		this.add(set);
		this.pack();
		this.setLocationRelativeTo(null);
		this.set.setVisible(true);

		// this.addWindowListener(winListener);
	}
	//----------------------set��get������-----------------------------

	public SettingPanel getSet() {
		return set;
	}
	public void setSet(SettingPanel set) {
		this.set = set;
	}
	
	
	
}
