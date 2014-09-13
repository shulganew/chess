package chess.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	MainPanel() {
	setLayout(new BorderLayout());
	add(new MenuPanel(), BorderLayout.NORTH);
	add(new ChessBoard(), BorderLayout.CENTER);
	}
}
