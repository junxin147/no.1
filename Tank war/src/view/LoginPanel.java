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
 * @Description: TODO(登录面板)
 * @author
 *
 */
public class LoginPanel extends JPanel {
	private JButton entercheck=new JButton("进入游戏");
	private JButton exitcheck=new JButton("退出游戏");
	private MyActionListener actionlist;
	
	
	public LoginPanel(GameDir gd) {
		actionlist=new MyActionListener(gd);
		// TODO Auto-generated constructor stub
	this.setPreferredSize(new Dimension(800,600));
	this.setLayout(null);
	entercheck.setBounds(300,400, 200, 50);
	this.add(entercheck);
    //设置动作指令，添加到监听
    entercheck.setActionCommand("enter");
    entercheck.addActionListener(actionlist);
	
	exitcheck.setBounds(300, 480, 200, 50);
	this.add(exitcheck);
    //设置动作指令，添加到监听
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
