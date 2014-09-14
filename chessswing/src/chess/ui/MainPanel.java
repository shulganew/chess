package chess.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	MainPanel() {
	//setBackground(new Color);	
	setLayout(new BorderLayout());
	add(new MenuPanel(), BorderLayout.NORTH);
	add(new ChessBoard(), BorderLayout.CENTER);
	}
}
