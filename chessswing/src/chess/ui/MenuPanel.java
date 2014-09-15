package chess.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	public MenuPanel() {
		// TODO Auto-generated constructor stub
		
	JMenuBar menuBar = new JMenuBar();	
	JMenu file = new  JMenu("File");
	JMenuItem fileNew = new JMenuItem("New Game");
	JMenuItem fileExit = new JMenuItem("Exit");
	file.add(fileNew);
	file.add(fileExit);
	
	
	JMenu help = new  JMenu("Help");
	JMenuItem about = new JMenuItem("About");
	help.add(about);

	menuBar.add(file);
	menuBar.add(help);
	
	//setLayout(new GridLayout());
	
	setLayout(new BorderLayout());
	
	add(menuBar, BorderLayout.WEST);

	
	}

	
	

}
