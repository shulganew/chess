package chess.ui;

import java.awt.Color;

import javax.swing.JFrame;

import chess.pic.Pictures;

public class BaseFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 600;

	public BaseFrame() {
		Pictures.LosdImageIcons();
		//setSize(DEFAULT_WIDTH + 18, DEFAULT_HEIGHT + 63);
		//setIconImage();
		setIconImage(Pictures.iconChessNotebook.getImage());
		setTitle("Шахматы");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MainPanel());
		//setBackground(Color.blue);
		pack();
		
		setVisible(true);
		
		
	}
}
