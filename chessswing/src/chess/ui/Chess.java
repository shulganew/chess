package chess.ui;

import java.awt.EventQueue;

public class Chess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BaseFrame();

			}
		});

	}
}
