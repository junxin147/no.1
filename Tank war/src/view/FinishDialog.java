package view;

import javax.swing.JDialog;

import model.ImageDate;
/**
 * 
 * @ClassName: FinishDialog 
 * @Description: TODO(���㴰��) 
 * @author 
 *
 */
public class FinishDialog extends JDialog {
	private FinishPanel finish=new FinishPanel();
	public FinishDialog() {
		this.setIconImage(ImageDate.ICON.getImage());
		this.setTitle("ͳ�Ƶ÷�");
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    this.setResizable(false);;
		this.add(finish);
		this.pack();
		this.setLocationRelativeTo(null);
		this.finish.setVisible(true);		
	}
	// ----------------------set��get������-----------------------------

	public FinishPanel getFinish() {
		return finish;
	}
	public void setFinish(FinishPanel finish) {
		this.finish = finish;
	}
	
	
	
}