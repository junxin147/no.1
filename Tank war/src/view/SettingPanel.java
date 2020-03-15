package view;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.GameDir;
import control.MyActionListener;
/**
 * 
 * @ClassName: SettingPanel 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author 
 *
 */
public class SettingPanel extends JPanel {
	private JRadioButton s1 = new JRadioButton("单人游戏");
	private JRadioButton s2 = new JRadioButton("双人游戏");
	private JRadioButton ss1 = new JRadioButton("正常游戏");
	private JRadioButton ss2 = new JRadioButton("自选难度");
	private JLabel level = new JLabel("请选择关卡数:");
	private JLabel tankSpeed = new JLabel("坦克速度:");
	private JLabel bulletSpeed = new JLabel("子弹速度:");
	private String[] choose1 = { "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox levelComboBox = new JComboBox(choose1);
	private JComboBox tankSpeedComboBox = new JComboBox(choose1);
	private JComboBox bulletSpeedComboBox = new JComboBox(choose1);
	private JLabel tankAmount = new JLabel("坦克数量：10~50");
	private JTextField input = new JTextField();
	private JCheckBox keep = new JCheckBox("继续游戏");
	private JCheckBox bottom = new JCheckBox("出现关底");
	private JButton sure = new JButton("确定");
	private JButton cancel = new JButton("取消");
	private ButtonGroup g = new ButtonGroup();
	private ButtonGroup gg = new ButtonGroup();
	private MyActionListener actLis;
	public SettingPanel(GameDir gd){
		actLis=new MyActionListener(gd);
		this.setPreferredSize(new Dimension(240, 380));
		this.setLayout(null);
		this.s1.setBounds(20, 40, 100, 30);// "单人游戏"
		this.s2.setBounds(120, 40, 100, 30);// "双人游戏"
		this.add(s1);
		this.g.add(s1);// 单人游戏添加到一个g数组里
		this.add(s2);
		this.g.add(s2);// 和双人游戏添加到一个g数组里
		this.ss1.setBounds(20, 80, 100, 30);// 正常游戏
		this.ss2.setBounds(120, 80, 100, 30);// 自选难度
		this.gg.add(ss1);// 正常游戏添加到gg数组里
		this.add(ss1);
		this.gg.add(ss2);// 自选难度添加到gg数组里
		this.add(ss2);
		level.setBounds(20, 120, 100, 30);// 设“关卡数”位置
		this.add(level);
		levelComboBox.setBounds(120, 120, 100, 30);// 关卡数下拉列表位置
		this.add(levelComboBox);
		tankSpeed.setBounds(20, 160, 100, 30);// 坦克速度设置位置
		this.add(tankSpeed);
		tankSpeedComboBox.setBounds(120, 160, 100, 30);// 坦克速度下拉列表设置位置
		this.add(tankSpeedComboBox);
		bulletSpeed.setBounds(20, 200, 100, 30);// 子弹速度设置位置
		this.add(bulletSpeed);
		bulletSpeedComboBox.setBounds(120, 200, 100, 30);// 子弹速度下拉列表位置
		this.add(bulletSpeedComboBox);
		tankAmount.setBounds(20, 240, 100, 30);// 坦克数量设置位置
		this.add(tankAmount);
		input.setBounds(120, 240, 100, 30);// 坦克数量输入框设置位置
		this.add(input);
		keep.setBounds(20, 280, 100, 30);// 继续游戏复选框设置位置
		this.add(keep);
		bottom.setBounds(120, 280, 100, 30);// 出现关底复选框设置位置
		this.add(bottom);
		sure.setBounds(30, 320, 70, 30);// 确定按钮位置
		this.add(sure);
		sure.setActionCommand("setSure");
		this.sure.addActionListener(actLis);
		cancel.setBounds(130, 320, 70, 30);// 取消按钮位置
		this.add(cancel);
		cancel.setActionCommand("cancel");
		this.cancel.addActionListener(actLis);
	}
	//----------------------set和get方法区-----------------------------

	public JRadioButton getS1() {
		return s1;
	}
	public void setS1(JRadioButton s1) {
		this.s1 = s1;
	}
	public JRadioButton getS2() {
		return s2;
	}
	public void setS2(JRadioButton s2) {
		this.s2 = s2;
	}
	public JRadioButton getSs1() {
		return ss1;
	}
	public void setSs1(JRadioButton ss1) {
		this.ss1 = ss1;
	}
	public JRadioButton getSs2() {
		return ss2;
	}
	public void setSs2(JRadioButton ss2) {
		this.ss2 = ss2;
	}
	public JLabel getLevel() {
		return level;
	}
	public void setLevel(JLabel level) {
		this.level = level;
	}
	public JLabel getTankSpeed() {
		return tankSpeed;
	}
	public void setTankSpeed(JLabel tankSpeed) {
		this.tankSpeed = tankSpeed;
	}
	public JLabel getBulletSpeed() {
		return bulletSpeed;
	}
	public void setBulletSpeed(JLabel bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}
	public String[] getChoose1() {
		return choose1;
	}
	public void setChoose1(String[] choose1) {
		this.choose1 = choose1;
	}
	public JComboBox getLevelComboBox() {
		return levelComboBox;
	}
	public void setLevelComboBox(JComboBox levelComboBox) {
		this.levelComboBox = levelComboBox;
	}
	public JComboBox getTankSpeedComboBox() {
		return tankSpeedComboBox;
	}
	public void setTankSpeedComboBox(JComboBox tankSpeedComboBox) {
		this.tankSpeedComboBox = tankSpeedComboBox;
	}
	public JComboBox getBulletSpeedComboBox() {
		return bulletSpeedComboBox;
	}
	public void setBulletSpeedComboBox(JComboBox bulletSpeedComboBox) {
		this.bulletSpeedComboBox = bulletSpeedComboBox;
	}
	public JLabel getTankAmount() {
		return tankAmount;
	}
	public void setTankAmount(JLabel tankAmount) {
		this.tankAmount = tankAmount;
	}
	public JTextField getInput() {
		return input;
	}
	public void setInput(JTextField input) {
		this.input = input;
	}
	public JCheckBox getKeep() {
		return keep;
	}
	public void setKeep(JCheckBox keep) {
		this.keep = keep;
	}
	public JCheckBox getBottom() {
		return bottom;
	}
	public void setBottom(JCheckBox bottom) {
		this.bottom = bottom;
	}
	public JButton getSure() {
		return sure;
	}
	public void setSure(JButton sure) {
		this.sure = sure;
	}
	public JButton getCancel() {
		return cancel;
	}
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	public ButtonGroup getG() {
		return g;
	}
	public void setG(ButtonGroup g) {
		this.g = g;
	}
	public ButtonGroup getGg() {
		return gg;
	}
	public void setGg(ButtonGroup gg) {
		this.gg = gg;
	}
	public MyActionListener getActLis() {
		return actLis;
	}
	public void setActLis(MyActionListener actLis) {
		this.actLis = actLis;
	}
	
	
	
}
