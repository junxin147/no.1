package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter1 extends KeyAdapter {
	private GameDir gd;
	public MyKeyAdapter1(GameDir gd) {
		this.gd = gd;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
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
		}
	}
}
