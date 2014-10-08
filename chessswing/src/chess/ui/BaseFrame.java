package chess.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import chess.pic.Pictures;

public class BaseFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 600;

	public BaseFrame() {
		try {
			Pictures.LosdImageIconsImg();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width-DEFAULT_WIDTH -250)/2, (dim.height-DEFAULT_HEIGHT-200)/2);
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
