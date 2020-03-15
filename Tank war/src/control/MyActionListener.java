package control;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Scence;
import model.Data;
import model.ImageDate;
import model.Map;
import model.User;

public class MyActionListener implements ActionListener {


	private GameDir gd;
	public MyActionListener(GameDir gd) {
		this.gd = gd;
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "enter":
			gd.ok.play(1);//确定按钮声音
			gd.getUi().getLoginframe().dispose();
			gd.getUi().getInputframe().setVisible(true);
			String inputValue = JOptionPane.showInputDialog("请输入你的名字");
			System.out.println(inputValue);
			while (inputValue == null) {
				if (inputValue == null) {// 第一次没有点击确认情况下当对话框点击取消不允许进入可以点击菜单窗口
					JOptionPane.showMessageDialog(null, "请输入名字，才能进入游戏");
				}
				inputValue = JOptionPane.showInputDialog("请输入你的名字");
			}

			while (inputValue.equals("")) {
				if (inputValue.equals("")) {
					JOptionPane.showMessageDialog(null, " 名字不能为空");
				}
				inputValue = JOptionPane.showInputDialog("请输入你的名字");
				while (inputValue == null) {
					if (inputValue == null) {// 第一次点了确认并当对话框点击取消不允许进入可以点击菜单窗口
						JOptionPane.showMessageDialog(null, "请输入名字，才能进入游戏");
					}
					inputValue = JOptionPane.showInputDialog("请输入你的名字");
				}
			}

			User user = new User(inputValue);
			Data.alluser.add(user);
			// 载入初始化所有信息

			gd.getUi().getInputframe().getGameinfo().getNameinfo().setText("玩家名字：" + inputValue);
			gd.getUi().getGameframe().getGameinfo().getNameinfo().setText("玩家名字：" + inputValue);
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			break;
		case "exit":
			gd.ok.play(1);//确定按钮声音
			int a = JOptionPane.showConfirmDialog(null, "要确认退出吗", "来自大哥哥的关爱", JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				int b = JOptionPane.showConfirmDialog(null, "再次确认真的要退出吗", "来自大哥哥的关爱", JOptionPane.YES_NO_OPTION);
				if (b == 0) {
					System.exit(0);
				}
			}
			break;
		case "setSure":
			Object num = gd.getUi().getSettingJDialog().getSet().getLevelComboBox().getSelectedItem();
			// Obj类型转换成int类型
			int level = Integer.parseInt((String) num);
			gd.getScence().setLevel(level);// 关卡 数变化

			Object num1 = gd.getUi().getSettingJDialog().getSet().getTankSpeedComboBox().getSelectedItem();
			// Obj类型转换成int类型
			int speed = Integer.parseInt((String) num1);
			gd.getTank().setSpeed(speed);// 我方坦克速度变化
			gd.getEnemyTank().setSpeed(speed);// 敌方坦克速度变化

			Object num2 = gd.getUi().getSettingJDialog().getSet().getTankSpeedComboBox().getSelectedItem();
			// Obj类型转换成int类型
			int bulletspeed = Integer.parseInt((String) num2);
			gd.getTank().setBulletspeed(bulletspeed * 5);// 我方子弹速度变化
			gd.getEnemyTank().setBulletspeed(bulletspeed * 5);// 敌方子弹速度变化

			gd.getScence().getMap().backupMap(level);
			gd.getScence().getMap().backupTank(level);

			gd.getTimer().partStart();
			;

			// 初始化信息面板的坦克信息
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			gd.getTank().setHitcount(0);// 该关击毁数量初始化0
			gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("该关击毁坦克：" + gd.getTank().getHitcount());
			gd.getTank().setScore(0);
			gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("该关得分：" + gd.getTank().getScore());
			// 初始化信息面板和结算面板
			gd.getEnemyTank().setScore(0);
			gd.getUi().getFinishDialog().getFinish().getAllscoreinfo()
					.setText("总共得分：" + (gd.getEnemyTank().getScore()));
			gd.getEnemyTank().setHitcount(0);
			gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo()
					.setText("总共击毁坦克：" + gd.getEnemyTank().getHitcount());
			gd.getUi().getGameframe().getGameinfo().getAllscoreinfo().setText("总共得分：" + (gd.getEnemyTank().getScore()));
			gd.getTank().setHitwhite(0);
			gd.getTank().setHitwhite(0);
			gd.getUi().getFinishDialog().getFinish().getWhitetankinfo1()
					.setText("X" + gd.getTank().getHitwhite() + "     X100=" + gd.getTank().getHitwhite() * 100);
			gd.getTank().setHityellow(0);
			gd.getUi().getFinishDialog().getFinish().getYellowtankinfo1()
					.setText("X" + gd.getTank().getHityellow() + "     X100=" + gd.getTank().getHityellow() * 200);
			gd.getTank().setHitgreen(0);
			gd.getUi().getFinishDialog().getFinish().getGreentankinfo1()
					.setText("X" + gd.getTank().getHitgreen() + "     X100=" + gd.getTank().getHitgreen() * 200);
			gd.getTank().setHitblue(0);
			gd.getUi().getFinishDialog().getFinish().getBluetankinfo1()
					.setText("X" + gd.getTank().getHitblue() + "     X100=" + gd.getTank().getHitblue() * 300);
			gd.getTank().setHitred(0);
			gd.getUi().getFinishDialog().getFinish().getRedtankinfo1()
					.setText("X" + gd.getTank().getHitred() + "     X100=" + gd.getTank().getHitred() * 500);
			// 初始化坦克
			gd.getTank().setPower(1);
			gd.getTank().setX(200);
			gd.getTank().setY(560);
			gd.getTank().setDiretion(0);
			gd.getTank().setImage(ImageDate.player1_up);
			gd.getTank().setBlood(3);
			gd.getTank().setHp(3);
			// 初始化集合
			Scence.allbullet.clear();
			Scence.allEnemytank.clear();
			Scence.allitem.clear();
			gd.getUi().getSettingJDialog().setVisible(false);
			gd.getUi().getInputframe().setVisible(false);
			gd.getUi().getGameframe().setVisible(true);
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			gd.ok.play(1);//确定按钮声音
			break;
		case "cancel":
			gd.ok.play(1);//确定按钮声音

			gd.getTimer().partStart();
			gd.getUi().getSettingJDialog().dispose();
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			break;
		}
	}



}

