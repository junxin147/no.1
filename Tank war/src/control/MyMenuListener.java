package control;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MyMenuListener implements MenuListener {
	private GameDir gd;
	public MyMenuListener(GameDir gd) {
		this.gd = gd;
	}
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==gd.getUi().getGameframe().getGameMenuBar().getKeepMenu()){
            gd.getTimer().partStart();
            System.out.println("������Ϸ");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			//������Ϸ��������ȫ�Ƴ�����ʱ������
			gd.getUi().getGameframe().getGamepanel().removeKeyListener(	gd.getUi().getGameframe().getGamepanel().getKeylis());
		}
        if (e.getSource()==gd.getUi().getGameframe().getGameMenuBar().getStopMenu()){
            gd.getTimer().allStop();
            System.out.println("��ͣ��Ϸ");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(false);
			//������Ϸ���ܰ�������
			gd.getUi().getGameframe().getGamepanel().addKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());
			// �������ɾ۽�
			gd.getUi().getGameframe().getGamepanel().setFocusable(true);
			// ���󽹵�
			gd.getUi().getGameframe().getGamepanel().requestFocus();
        }
    
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

}
