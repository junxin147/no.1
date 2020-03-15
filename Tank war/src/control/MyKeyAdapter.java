package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Bullet;
import model.Data;

public class MyKeyAdapter extends KeyAdapter {
	private GameDir gd;

	public MyKeyAdapter(GameDir gd) {
		this.gd = gd;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		super.keyPressed(e);
		switch (e.getKeyCode()) {
		case 80:// p��
			gd.getTimer().allStop();
			gd.getTimer().getMoveTime().stop();// �ӵ��ƶ���ʱ��
			System.out.println("��ͣ��Ϸ");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(false);
			// ������Ϸ��������ȫ�Ƴ�����ʱ������
			gd.getUi().getGameframe().getGamepanel()
					.removeKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());

			break;
		case 67:// c��
			gd.getTimer().partStart();
			System.out.println("������Ϸ");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			// ������Ϸ���ܰ�������
			gd.getUi().getGameframe().getGamepanel()
					.addKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());
			// �������ɾ۽�
			gd.getUi().getGameframe().getGamepanel().setFocusable(true);
			// ���󽹵�
			gd.getUi().getGameframe().getGamepanel().requestFocus();
			break;
		case 87:// w��
			gd.getTank().setDiretion(0);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 68:// D��
			gd.getTank().setDiretion(1);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 83:// S��
			gd.getTank().setDiretion(2);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 65:// A��
			gd.getTank().setDiretion(3);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 74:// J��
			gd.getTank().setState(true);
			gd.getTimer().getFireTime().start();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		case 87:// w��
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 68:// D��
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 83:// S��
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 65:// A��
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 74:// J��
			gd.getTank().fire();
			gd.getTank().setState(false);
			gd.getTimer().getFireTime().stop();

			break;
		}

	}
}
