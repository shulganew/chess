package chess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JPanel;

import ch.position.Position;

public class MainPanel extends JPanel {
	ChessBoard board;
	MainPanel() {
		// setBackground(new Color);

		setLayout(new BorderLayout());
		board = new ChessBoard();
		add(new MenuPanel(board), BorderLayout.NORTH);		
		add(board, BorderLayout.WEST);

	}

}
