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
		}
	}
}
