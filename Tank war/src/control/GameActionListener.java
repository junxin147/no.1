package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Map;
import view.GameMenubar;

public class GameActionListener implements ActionListener {
	private GameDir gd;
	
	public GameActionListener(GameDir gd) {
		// TODO Auto-generated constructor stub
	this.gd=gd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "help":// �˵�����Ϸ˵��
			JOptionPane.showMessageDialog(null, "<html>��Ϸ�淨<br>���ϣ�W<br>���£�S<br>����A<br>���ң�D<br>����:J<br>��ͣ��P<br>������C");
			break;
		case "star":// �˵��ʼ��Ϸ
			gd.gamebutton.play(1);//��ʼ��Ϸ��ť��Ч
			gd.bk2.play(0);//������Ч
			gd.getTimer().partStart();
			gd.getTimer().getFireTime().stop();
			gd.getTimer().getMovingTime().stop();
			gd.getScence().getMap().backupMap(1);
			gd.getScence().getMap().backupTank(1);
			gd.getUi().getInputframe().dispose();
			gd.getUi().getGameframe().setVisible(true);
			gd.getUi().getGameframe().getGameMenuBar().getRestarGame().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStarGame().setEnabled(false);
			// ��ʼ����Ϣ���ͽ������
			gd.getUi().getGameframe().getGameinfo().getWhitetankinfo1().setText("X" + Map.tankcopy1[0]);
			gd.getUi().getGameframe().getGameinfo().getYellowtankinfo1().setText("X" + Map.tankcopy1[1]);
			gd.getUi().getGameframe().getGameinfo().getGreentankinfo1().setText("X" + Map.tankcopy1[2]);
			gd.getUi().getGameframe().getGameinfo().getBluetankinfo1().setText("X" + Map.tankcopy1[3]);
			gd.getUi().getGameframe().getGameinfo().getRedtankinfo1().setText("X" + Map.tankcopy1[4]);
			gd.getEnemyTank().setScore(0);
			gd.getUi().getFinishDialog().getFinish().getAllscoreinfo()
					.setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
			gd.getEnemyTank().setHitcount(0);
			gd.getUi().getFinishDialog().getFinish().getAlldestroyinfo()
					.setText("�ܹ�����̹�ˣ�" + gd.getEnemyTank().getHitcount());
			gd.getUi().getGameframe().getGameinfo().getAllscoreinfo().setText("�ܹ��÷֣�" + (gd.getEnemyTank().getScore()));
			gd.getTank().setHitwhite(0);
			gd.getUi().getFinishDialog().getFinish().getWhitetankinfo1()
					.setText("X" + gd.getTank().getHitwhite() + "     X100=" + gd.getTank().getHitwhite() * 100);
			gd.getTank().setHityellow(0);
			gd.getUi().getFinishDialog().getFinish().getYellowtankinfo1()
					.setText("X" + gd.getTank().getHityellow() + "     X200=" + gd.getTank().getHityellow() * 200);
			gd.getTank().setHitgreen(0);
			gd.getUi().getFinishDialog().getFinish().getGreentankinfo1()
					.setText("X" + gd.getTank().getHitgreen() + "     X200=" + gd.getTank().getHitgreen() * 200);
			gd.getTank().setHitblue(0);
			gd.getUi().getFinishDialog().getFinish().getBluetankinfo1()
					.setText("X" + gd.getTank().getHitblue() + "     X300=" + gd.getTank().getHitblue() * 300);
			gd.getTank().setHitred(0);
			gd.getUi().getFinishDialog().getFinish().getRedtankinfo1()
					.setText("X" + gd.getTank().getHitred() + "     X500=" + gd.getTank().getHitred() * 500);
			break;
		case "exit":// �˵����˳�����
			int a = JOptionPane.showConfirmDialog(null, "Ҫȷ���˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				int b = JOptionPane.showConfirmDialog(null, "�ٴ�ȷ�����Ҫ�˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
				if (b == 0) {
					System.exit(0);
				}
			}
			break;
		case "restarGame":		
			gd.gamebutton.play(1);//��ʼ��Ϸ��ť��Ч
			gd.getTimer().partStart();
			gd.getUi().getGameframe().getGamepanel().reset();
			break;
		case "set":
			gd.getUi().getSettingJDialog().setVisible(true);
			gd.getTimer().allStop();
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(false);
			break;
		}

	}

}
