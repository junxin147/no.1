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
			gd.ok.play(1);//ȷ����ť����
			gd.getUi().getLoginframe().dispose();
			gd.getUi().getInputframe().setVisible(true);
			String inputValue = JOptionPane.showInputDialog("�������������");
			System.out.println(inputValue);
			while (inputValue == null) {
				if (inputValue == null) {// ��һ��û�е��ȷ������µ��Ի�����ȡ�������������Ե���˵�����
					JOptionPane.showMessageDialog(null, "���������֣����ܽ�����Ϸ");
				}
				inputValue = JOptionPane.showInputDialog("�������������");
			}

			while (inputValue.equals("")) {
				if (inputValue.equals("")) {
					JOptionPane.showMessageDialog(null, " ���ֲ���Ϊ��");
				}
				inputValue = JOptionPane.showInputDialog("�������������");
				while (inputValue == null) {
					if (inputValue == null) {// ��һ�ε���ȷ�ϲ����Ի�����ȡ�������������Ե���˵�����
						JOptionPane.showMessageDialog(null, "���������֣����ܽ�����Ϸ");
					}
					inputValue = JOptionPane.showInputDialog("�������������");
				}
			}

			User user = new User(inputValue);
			Data.alluser.add(user);
			// �����ʼ��������Ϣ

			gd.getUi().getInputframe().getGameinfo().getNameinfo().setText("������֣�" + inputValue);
			gd.getUi().getGameframe().getGameinfo().getNameinfo().setText("������֣�" + inputValue);
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			break;
		case "exit":
			gd.ok.play(1);//ȷ����ť����
			int a = JOptionPane.showConfirmDialog(null, "Ҫȷ���˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				int b = JOptionPane.showConfirmDialog(null, "�ٴ�ȷ�����Ҫ�˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
				if (b == 0) {
					System.exit(0);
				}
			}
			break;
		case "setSure":
			Object num = gd.getUi().getSettingJDialog().getSet().getLevelComboBox().getSelectedItem();
			// Obj����ת����int����
			int level = Integer.parseInt((String) num);
			gd.getScence().setLevel(level);// �ؿ� ���仯

			Object num1 = gd.getUi().getSettingJDialog().getSet().getTankSpeedComboBox().getSelectedItem();
			// Obj����ת����int����
			int speed = Integer.parseInt((String) num1);
			gd.getTank().setSpeed(speed);// �ҷ�̹���ٶȱ仯
			gd.getEnemyTank().setSpeed(speed);// �з�̹���ٶȱ仯

			Object num2 = gd.getUi().getSettingJDialog().getSet().getTankSpeedComboBox().getSelectedItem();
			// Obj����ת����int����
			int bulletspeed = Integer.parseInt((String) num2);
			gd.getTank().setBulletspeed(bulletspeed * 5);// �ҷ��ӵ��ٶȱ仯
			gd.getEnemyTank().setBulletspeed(bulletspeed * 5);// �з��ӵ��ٶȱ仯

			gd.getScence().getMap().backupMap(level);
			gd.getScence().getMap().backupTank(level);

			gd.getTimer().partStart();
			;

			// ��ʼ����Ϣ����̹����Ϣ
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			gd.getTank().setHitcount(0);// �ùػ���������ʼ��0
			gd.getUi().getGameframe().getGameinfo().getDestroyinfo().setText("�ùػ���̹�ˣ�" + gd.getTank().getHitcount());
			gd.getTank().setScore(0);
			gd.getUi().getGameframe().getGameinfo().getScoreinfo().setText("�ùص÷֣�" + gd.getTank().getScore());
			// ��ʼ����Ϣ���ͽ������
			gd.getEnemyTank().setScore(0);
			gd.getUi().getFinishDialog().getFinish().getAllscoreinfo()
					.setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
			gd.getEnemyTank().setHitcount(0);
			gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo()
					.setText("�ܹ�����̹�ˣ�" + gd.getEnemyTank().getHitcount());
			gd.getUi().getGameframe().getGameinfo().getAllscoreinfo().setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
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
			// ��ʼ��̹��
			gd.getTank().setPower(1);
			gd.getTank().setX(200);
			gd.getTank().setY(560);
			gd.getTank().setDiretion(0);
			gd.getTank().setImage(ImageDate.player1_up);
			gd.getTank().setBlood(3);
			gd.getTank().setHp(3);
			// ��ʼ������
			Scence.allbullet.clear();
			Scence.allEnemytank.clear();
			Scence.allitem.clear();
			gd.getUi().getSettingJDialog().setVisible(false);
			gd.getUi().getInputframe().setVisible(false);
			gd.getUi().getGameframe().setVisible(true);
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			gd.ok.play(1);//ȷ����ť����
			break;
		case "cancel":
			gd.ok.play(1);//ȷ����ť����

			gd.getTimer().partStart();
			gd.getUi().getSettingJDialog().dispose();
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			break;
		}
	}



}

