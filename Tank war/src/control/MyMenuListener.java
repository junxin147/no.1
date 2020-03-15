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
            System.out.println("继续游戏");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(false);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(true);
			//关于游戏按键监听全移除，暂时不能用
			gd.getUi().getGameframe().getGamepanel().removeKeyListener(	gd.getUi().getGameframe().getGamepanel().getKeylis());
		}
        if (e.getSource()==gd.getUi().getGameframe().getGameMenuBar().getStopMenu()){
            gd.getTimer().allStop();
            System.out.println("暂停游戏");
			gd.getUi().getGameframe().getGameMenuBar().getKeepMenu().setEnabled(true);
			gd.getUi().getGameframe().getGameMenuBar().getStopMenu().setEnabled(false);
			//开启游戏功能按键监听
			gd.getUi().getGameframe().getGamepanel().addKeyListener(gd.getUi().getGameframe().getGamepanel().getKeylis());
			// 设置面板可聚焦
			gd.getUi().getGameframe().getGamepanel().setFocusable(true);
			// 请求焦点
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
