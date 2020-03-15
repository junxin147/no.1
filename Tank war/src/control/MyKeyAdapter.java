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
		case 80:// p键
			gd.getTimer().allStop();
			gd.getTimer().getMoveTime().stop();// 子弹移动定时器
			System.out.println("暂停游戏");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(false);
			// 关于游戏按键监听全移除，暂时不能用
			gd.getUi().getGameframe().getGamepanel()
					.removeKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());

			break;
		case 67:// c键
			gd.getTimer().partStart();
			System.out.println("继续游戏");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			// 开启游戏功能按键监听
			gd.getUi().getGameframe().getGamepanel()
					.addKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());
			// 设置面板可聚焦
			gd.getUi().getGameframe().getGamepanel().setFocusable(true);
			// 请求焦点
			gd.getUi().getGameframe().getGamepanel().requestFocus();
			break;
		case 87:// w键
			gd.getTank().setDiretion(0);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 68:// D键
			gd.getTank().setDiretion(1);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 83:// S键
			gd.getTank().setDiretion(2);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 65:// A键
			gd.getTank().setDiretion(3);
			gd.getTank().setMoveState(true);
			gd.getTimer().getMovingTime().start();
			break;
		case 74:// J键
			gd.getTank().setState(true);
			gd.getTimer().getFireTime().start();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		case 87:// w键
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 68:// D键
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 83:// S键
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 65:// A键
			gd.getTank().move();
			gd.getTank().setMoveState(false);
			gd.getTimer().getMovingTime().stop();
			break;
		case 74:// J键
			gd.getTank().fire();
			gd.getTank().setState(false);
			gd.getTimer().getFireTime().stop();

			break;
		}

	}
}
