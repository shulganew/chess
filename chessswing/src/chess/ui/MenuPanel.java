package chess.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ch.position.Position;
import chess.pic.Pictures;

public class MenuPanel extends JPanel {
	ChessBoard mBoard;
	public MenuPanel(ChessBoard board) {
		// TODO Auto-generated constructor stub
		mBoard = board;
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("Меню");
		JMenuItem fileNew = new JMenuItem("Новая игра");
		fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				PieceMove.position = Position.createInitialPosition();
				mBoard.setPictureStones(PieceMove.position);
				mBoard.repaint();
			}
		});
		JMenuItem fileExit = new JMenuItem("Выход");
		fileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		file.add(fileNew);
		file.add(fileExit);

		JMenu help = new JMenu("Помощь");

		JMenuItem about = new JMenuItem("О игре");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null, "Chess Gamse, Bugs and support: shulganew@gmail.com");

			}
		});
		help.add(about);

		JMenu option = new JMenu("Настройки");
		JMenu chessType = new JMenu("Тип фигур");
		
		
		JMenuItem op1 = new JMenuItem( new ImageIcon(Pictures.class.getResource("iconKingBlack.png")));
		JMenuItem op2 = new JMenuItem( new ImageIcon(Pictures.class.getResource("iconKingBlack1.png")));
		JMenuItem op3 = new JMenuItem( new ImageIcon(Pictures.class.getResource("iconKingBlack2.png")));
		JMenuItem op4 = new JMenuItem( new ImageIcon(Pictures.class.getResource("iconKingBlack3.png")));
		op1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Pictures.LosdImageIconsImg();
					mBoard.setPictureStones(PieceMove.position);
					mBoard.repaint();
					System.out.println("change chess 1");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		op2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Pictures.LosdImageIconsImgA();
					mBoard.setPictureStones(PieceMove.position);
					mBoard.repaint();
					System.out.println("change chess 1");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		op3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Pictures.LosdImageIconsImgB();
					mBoard.setPictureStones(PieceMove.position);
					mBoard.repaint();
					System.out.println("change chess 1");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		op4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Pictures.LosdImageIconsImgC();
					mBoard.setPictureStones(PieceMove.position);
					mBoard.repaint();
					System.out.println("change chess 1");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		
		chessType.add(op1);
		chessType.add(op2);
		chessType.add(op3);
		chessType.add(op4);
		option.add(chessType);
		menuBar.add(file);
		menuBar.add(option);
		menuBar.add(help);
		
		setLayout(new GridLayout());

		//setLayout(new BorderLayout());

		add(menuBar);
	
	}

	private void restart() {
		StringBuilder cmd = new StringBuilder();
		cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
		for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
			cmd.append(jvmArg + " ");
		}
		cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
		cmd.append(Window.class.getName()).append(" ");

		try {
			Runtime.getRuntime().exec(cmd.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
}
