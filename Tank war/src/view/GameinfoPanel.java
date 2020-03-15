package view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GameDir;
import control.MyActionListener;
import model.ImageDate;
/**
 * 
 * @ClassName: GameinfoPanel 
 * @Description: TODO(��Ϸ��Ϣ���) 
 * @author 
 *
 */
public class GameinfoPanel extends JPanel {
	private JLabel tankinfo=new JLabel("�з�̹�˻���:");
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

	private JLabel helpinfo=new JLabel("<html>��Ϸ�淨<br>���ϣ�W<br>���£�S<br>����A<br>���ң�D<br>����:J<br>��ͣ��P<br>������C");
	private JLabel nameinfo=new JLabel("������֣�");
	private JLabel destroyinfo=new JLabel("�ùػ���̹�ˣ�");
	private JLabel scoreinfo=new JLabel("�ùص÷֣�");
	private JLabel alldestroyinfo=new JLabel("�ܹ�����̹�ˣ�");
	private JLabel allscoreinfo=new JLabel("�ܹ��÷֣�");
	
	
	public GameinfoPanel() {
	   this.setPreferredSize(new Dimension(200,600));
	   this.setLayout(null);
		ImageDate.white_up1.setImage(ImageDate.white_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageDate.yellow_up1.setImage(ImageDate.yellow_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageDate.blue_up1.setImage(ImageDate.blue_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageDate.green_up1.setImage(ImageDate.green_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageDate.red_up1.setImage(ImageDate.red_up1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

	   tankinfo.setBounds(20, 10, 200, 50);
	   this.add(tankinfo);
	   //��ɫ̹��ͼ������
	   whitetankinfo.setIcon(ImageDate.white_up1);
	   whitetankinfo.setBounds(20, 40, 200, 50);
	   this.add(whitetankinfo);
	   whitetankinfo1.setBounds(80, 40, 200, 50);
	   this.add(whitetankinfo1);
	   
	   //��̹��ͼ������
	   yellowtankinfo.setIcon(ImageDate.yellow_up1);
	   yellowtankinfo.setBounds(20, 90, 200, 50);
	   this.add(yellowtankinfo);
	   yellowtankinfo1.setBounds(80, 90, 200, 50);
	   this.add(yellowtankinfo1);
	   //��̹��ͼ������
	   greentankinfo.setIcon(ImageDate.green_up1);
	   greentankinfo.setBounds(20, 140, 200, 50);
	   this.add(greentankinfo);
	   greentankinfo1.setBounds(80, 140, 200, 50);
	   this.add(greentankinfo1);
	   //��̹��ͼ������
	   bluetankinfo.setIcon(ImageDate.blue_up1);
	   bluetankinfo.setBounds(20,190, 200, 50);
	   this.add(bluetankinfo);
	   bluetankinfo1.setBounds(80,190, 200, 50);
	   this.add(bluetankinfo1);
	   //��̹������
	   redtankinfo.setIcon(ImageDate.red_up1);
	   redtankinfo.setBounds(20, 240, 200, 50);
	   this.add(redtankinfo);
	   redtankinfo1.setBounds(80, 240, 200, 50);
	   this.add(redtankinfo1);
	   
	   helpinfo.setBounds(20, 280,200,150);
	   this.add(helpinfo);
	   nameinfo.setBounds(20, 420,200,50);
	   this.add(nameinfo);
	   destroyinfo.setBounds(20, 440,200,50);
	   this.add(destroyinfo);
	   scoreinfo.setBounds(20, 460,200,50);
	   this.add(scoreinfo);
	   alldestroyinfo.setBounds(20, 480,200,50);
	   this.add(alldestroyinfo);
	   allscoreinfo.setBounds(20, 500,200,50);
	   this.add(allscoreinfo);
	  
	}
	
	// ----------------------set��get������-----------------------------

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



	public JLabel getTankinfo() {
		return tankinfo;
	}
	public void setTankinfo(JLabel tankinfo) {
		this.tankinfo = tankinfo;
	}
	public JLabel getHelpinfo() {
		return helpinfo;
	}
	public void setHelpinfo(JLabel helpinfo) {
		this.helpinfo = helpinfo;
	}
	public JLabel getNameinfo() {
		return nameinfo;
	}
	public void setNameinfo(JLabel nameinfo) {
		this.nameinfo = nameinfo;
	}
	public JLabel getDestroyinfo() {
		return destroyinfo;
	}
	public void setDestroyinfo(JLabel destroyinfo) {
		this.destroyinfo = destroyinfo;
	}
	public JLabel getScoreinfo() {
		return scoreinfo;
	}
	public void setScoreinfo(JLabel scoreinfo) {
		this.scoreinfo = scoreinfo;
	}
	public JLabel getAlldestroyinfo() {
		return alldestroyinfo;
	}
	public void setAlldestroyinfo(JLabel alldestroyinfo) {
		this.alldestroyinfo = alldestroyinfo;
	}
	public JLabel getAllscoreinfo() {
		return allscoreinfo;
	}
	public void setAllscoreinfo(JLabel allscoreinfo) {
		this.allscoreinfo = allscoreinfo;
	}

	
	
}
