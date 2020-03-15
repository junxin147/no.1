package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameDir;
import control.MyActionListener;


import model.ImageDate;

/**
 * 
 * @ClassName: LoginPanel
 * @Description: TODO(��¼���)
 * @author
 *
 */
public class LoginPanel extends JPanel {
	private JButton entercheck=new JButton("������Ϸ");
	private JButton exitcheck=new JButton("�˳���Ϸ");
	private MyActionListener actionlist;
	
	
	public LoginPanel(GameDir gd) {
		actionlist=new MyActionListener(gd);
		// TODO Auto-generated constructor stub
	this.setPreferredSize(new Dimension(800,600));
	this.setLayout(null);
	entercheck.setBounds(300,400, 200, 50);
	this.add(entercheck);
    //���ö���ָ���ӵ�����
    entercheck.setActionCommand("enter");
    entercheck.addActionListener(actionlist);
	
	exitcheck.setBounds(300, 480, 200, 50);
	this.add(exitcheck);
    //���ö���ָ���ӵ�����
	exitcheck.setActionCommand("exit");
	exitcheck.addActionListener(actionlist);
  
	}
	
	
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
		g.drawImage(ImageDate.BJ, 0, 0, 800, 600, null);
		this.repaint();
		}
	

}
