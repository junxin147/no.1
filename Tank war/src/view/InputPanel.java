package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ImageDate;

/**
 * 
 * @ClassName: InputPanel
 * @Description: TODO(登录游戏后的面板)
 * @author
 *
 */
public class InputPanel extends JPanel {
	public InputPanel() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(600,600));
	
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	g.drawImage(ImageDate.BJ, 0, 0, 600, 600, null);
	this.repaint();
	}


}
