package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		int a = JOptionPane.showConfirmDialog(null, "Ҫȷ���˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			int b = JOptionPane.showConfirmDialog(null, "�ٴ�ȷ�����Ҫ�˳���", "���Դ���Ĺذ�", JOptionPane.YES_NO_OPTION);
			if (b == 0) {
				System.exit(0);
			}
		}
	}
}
