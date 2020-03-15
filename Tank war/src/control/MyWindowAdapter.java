package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		int a = JOptionPane.showConfirmDialog(null, "要确认退出吗", "来自大哥哥的关爱", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			int b = JOptionPane.showConfirmDialog(null, "再次确认真的要退出吗", "来自大哥哥的关爱", JOptionPane.YES_NO_OPTION);
			if (b == 0) {
				System.exit(0);
			}
		}
	}
}
