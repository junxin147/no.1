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
 * @Description: TODO(������һ�仰��������������) 
 * @author 
 *
 */
public class SettingPanel extends JPanel {
	private JRadioButton s1 = new JRadioButton("������Ϸ");
	private JRadioButton s2 = new JRadioButton("˫����Ϸ");
	private JRadioButton ss1 = new JRadioButton("������Ϸ");
	private JRadioButton ss2 = new JRadioButton("��ѡ�Ѷ�");
	private JLabel level = new JLabel("��ѡ��ؿ���:");
	private JLabel tankSpeed = new JLabel("̹���ٶ�:");
	private JLabel bulletSpeed = new JLabel("�ӵ��ٶ�:");
	private String[] choose1 = { "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox levelComboBox = new JComboBox(choose1);
	private JComboBox tankSpeedComboBox = new JComboBox(choose1);
	private JComboBox bulletSpeedComboBox = new JComboBox(choose1);
	private JLabel tankAmount = new JLabel("̹��������10~50");
	private JTextField input = new JTextField();
	private JCheckBox keep = new JCheckBox("������Ϸ");
	private JCheckBox bottom = new JCheckBox("���ֹص�");
	private JButton sure = new JButton("ȷ��");
	private JButton cancel = new JButton("ȡ��");
	private ButtonGroup g = new ButtonGroup();
	private ButtonGroup gg = new ButtonGroup();
	private MyActionListener actLis;
	public SettingPanel(GameDir gd){
		actLis=new MyActionListener(gd);
		this.setPreferredSize(new Dimension(240, 380));
		this.setLayout(null);
		this.s1.setBounds(20, 40, 100, 30);// "������Ϸ"
		this.s2.setBounds(120, 40, 100, 30);// "˫����Ϸ"
		this.add(s1);
		this.g.add(s1);// ������Ϸ��ӵ�һ��g������
		this.add(s2);
		this.g.add(s2);// ��˫����Ϸ��ӵ�һ��g������
		this.ss1.setBounds(20, 80, 100, 30);// ������Ϸ
		this.ss2.setBounds(120, 80, 100, 30);// ��ѡ�Ѷ�
		this.gg.add(ss1);// ������Ϸ��ӵ�gg������
		this.add(ss1);
		this.gg.add(ss2);// ��ѡ�Ѷ���ӵ�gg������
		this.add(ss2);
		level.setBounds(20, 120, 100, 30);// �衰�ؿ�����λ��
		this.add(level);
		levelComboBox.setBounds(120, 120, 100, 30);// �ؿ��������б�λ��
		this.add(levelComboBox);
		tankSpeed.setBounds(20, 160, 100, 30);// ̹���ٶ�����λ��
		this.add(tankSpeed);
		tankSpeedComboBox.setBounds(120, 160, 100, 30);// ̹���ٶ������б�����λ��
		this.add(tankSpeedComboBox);
		bulletSpeed.setBounds(20, 200, 100, 30);// �ӵ��ٶ�����λ��
		this.add(bulletSpeed);
		bulletSpeedComboBox.setBounds(120, 200, 100, 30);// �ӵ��ٶ������б�λ��
		this.add(bulletSpeedComboBox);
		tankAmount.setBounds(20, 240, 100, 30);// ̹����������λ��
		this.add(tankAmount);
		input.setBounds(120, 240, 100, 30);// ̹���������������λ��
		this.add(input);
		keep.setBounds(20, 280, 100, 30);// ������Ϸ��ѡ������λ��
		this.add(keep);
		bottom.setBounds(120, 280, 100, 30);// ���ֹص׸�ѡ������λ��
		this.add(bottom);
		sure.setBounds(30, 320, 70, 30);// ȷ����ťλ��
		this.add(sure);
		sure.setActionCommand("setSure");
		this.sure.addActionListener(actLis);
		cancel.setBounds(130, 320, 70, 30);// ȡ����ťλ��
		this.add(cancel);
		cancel.setActionCommand("cancel");
		this.cancel.addActionListener(actLis);
	}
	//----------------------set��get������-----------------------------

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
