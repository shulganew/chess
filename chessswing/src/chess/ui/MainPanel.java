package chess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JPanel;

import ch.position.Position;

public class MainPanel extends JPanel {

	MainPanel() {
		// setBackground(new Color);

		setLayout(new BorderLayout());
		add(new MenuPanel(), BorderLayout.NORTH);
		add(new ChessBoard(), BorderLayout.WEST);

	}

}
