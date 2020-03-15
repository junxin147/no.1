package view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ImageDate;
/**
 * 
 * @ClassName: FinishPanel 
 * @Description: TODO(结算面板) 
 * @author 
 *
 */
public class FinishPanel extends JPanel {
	private JLabel whitetankinfo=new JLabel();
	private JLabel yellowtankinfo=new JLabel();
	private JLabel greentankinfo=new JLabel();
	private JLabel bluetankinfo=new JLabel();
	private JLabel redtankinfo=new JLabel();
	private JLabel whitetankinfo1=new JLabel("X");
	private JLabel yellowtankinfo1=new JLabel("X");
	private JLabel greentankinfo1=new JLabel("X");
	private JLabel bluetankinfo1=new JLabel("X");
	private JLabel redtankinfo1=new JLabel("X");
	private JLabel alldestroyinfo=new JLabel("总共击毁坦克：");
	private JLabel allscoreinfo=new JLabel("总共得分：");
	public FinishPanel() {
		// TODO Auto-generated constructor stub
		 this.setPreferredSize(new Dimension(400,400));
		   this.setLayout(null);
			ImageDate.white_up1.setImage(ImageDate.white_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageDate.yellow_up1.setImage(ImageDate.yellow_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageDate.blue_up1.setImage(ImageDate.blue_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageDate.green_up1.setImage(ImageDate.green_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageDate.red_up1.setImage(ImageDate.red_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			  //白色坦克图标设置
			   whitetankinfo.setIcon(ImageDate.white_up1);
			   whitetankinfo.setBounds(20, 40, 200, 50);
			   this.add(whitetankinfo);
			   whitetankinfo1.setBounds(80, 40, 200, 50);
			   this.add(whitetankinfo1);   
			   //黄坦克图标设置
			   yellowtankinfo.setIcon(ImageDate.yellow_up1);
			   yellowtankinfo.setBounds(20, 90, 200, 50);
			   this.add(yellowtankinfo);
			   yellowtankinfo1.setBounds(80, 90, 200, 50);
			   this.add(yellowtankinfo1);
			   //绿坦克图标设置
			   greentankinfo.setIcon(ImageDate.green_up1);
			   greentankinfo.setBounds(20, 140, 200, 50);
			   this.add(greentankinfo);
			   greentankinfo1.setBounds(80, 140, 200, 50);
			   this.add(greentankinfo1);
			   //蓝坦克图标设置
			   bluetankinfo.setIcon(ImageDate.blue_up1);
			   bluetankinfo.setBounds(20,190, 200, 50);
			   this.add(bluetankinfo);
			   bluetankinfo1.setBounds(80,190, 200, 50);
			   this.add(bluetankinfo1);
			   //红坦克设置
			   redtankinfo.setIcon(ImageDate.red_up1);
			   redtankinfo.setBounds(20, 240, 200, 50);
			   this.add(redtankinfo);
			   redtankinfo1.setBounds(80, 240, 200, 50);
			   this.add(redtankinfo1);
			   alldestroyinfo.setBounds(20, 300,200,50);
			   this.add(alldestroyinfo);
			   allscoreinfo.setBounds(20, 350,200,50);
			   this.add(allscoreinfo);
	}	
	// ----------------------set和get方法区-----------------------------

	public JLabel getAlldestroyinfo() {
		return alldestroyinfo;
	}



	public void setAlldestroyinfo(JLabel alldestroyinfo) {
		this.alldestroyinfo = alldestroyinfo;
	}



	public JLabel getWhitetankinfo() {
		return whitetankinfo;
	}
	public void setWhitetankinfo(JLabel whitetankinfo) {
		this.whitetankinfo = whitetankinfo;
	}
	public JLabel getYellowtankinfo() {
		return yellowtankinfo;
	}
	public void setYellowtankinfo(JLabel yellowtankinfo) {
		this.yellowtankinfo = yellowtankinfo;
	}
	public JLabel getGreentankinfo() {
		return greentankinfo;
	}
	public void setGreentankinfo(JLabel greentankinfo) {
		this.greentankinfo = greentankinfo;
	}
	public JLabel getBluetankinfo() {
		return bluetankinfo;
	}
	public void setBluetankinfo(JLabel bluetankinfo) {
		this.bluetankinfo = bluetankinfo;
	}
	public JLabel getRedtankinfo() {
		return redtankinfo;
	}
	public void setRedtankinfo(JLabel redtankinfo) {
		this.redtankinfo = redtankinfo;
	}
	public JLabel getWhitetankinfo1() {
		return whitetankinfo1;
	}
	public void setWhitetankinfo1(JLabel whitetankinfo1) {
		this.whitetankinfo1 = whitetankinfo1;
	}
	public JLabel getYellowtankinfo1() {
		return yellowtankinfo1;
	}
	public void setYellowtankinfo1(JLabel yellowtankinfo1) {
		this.yellowtankinfo1 = yellowtankinfo1;
	}
	public JLabel getGreentankinfo1() {
		return greentankinfo1;
	}
	public void setGreentankinfo1(JLabel greentankinfo1) {
		this.greentankinfo1 = greentankinfo1;
	}
	public JLabel getBluetankinfo1() {
		return bluetankinfo1;
	}
	public void setBluetankinfo1(JLabel bluetankinfo1) {
		this.bluetankinfo1 = bluetankinfo1;
	}
	public JLabel getRedtankinfo1() {
		return redtankinfo1;
	}
	public void setRedtankinfo1(JLabel redtankinfo1) {
		this.redtankinfo1 = redtankinfo1;
	}
	public JLabel getAllscoreinfo() {
		return allscoreinfo;
	}
	public void setAllscoreinfo(JLabel allscoreinfo) {
		this.allscoreinfo = allscoreinfo;
	}	
	
	
	
}
