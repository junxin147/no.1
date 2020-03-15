package view;

import javax.swing.JDialog;

import model.ImageDate;
/**
 * 
 * @ClassName: FinishDialog 
 * @Description: TODO(结算窗口) 
 * @author 
 *
 */
public class FinishDialog extends JDialog {
	private FinishPanel finish=new FinishPanel();
	public FinishDialog() {
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("统计得分");
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setResizable(false);;
		this.add(finish);
		this.pack();
		this.setLocationRelativeTo(null);
		this.finish.setVisible(true);		
	}
	// ----------------------set和get方法区-----------------------------

	public FinishPanel getFinish() {
		return finish;
	}
	public void setFinish(FinishPanel finish) {
		this.finish = finish;
	}
	
	
	
}