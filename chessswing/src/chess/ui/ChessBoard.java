package chess.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.pic.Pictures;

public class ChessBoard extends JPanel {
	public static int BAORD = 600;
	public static int CELL = 8;
	public static int SQUARE = BAORD / CELL;
	ImageIcon[][] pieces;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, 0, 600, 600);
		paintBoard();
		for (int x = 0; x < CELL; x++) {
			for (int y = 0; y < CELL; y++) {
				paintSquare(g2, x, y);
				if (pieces[x][y] != null)
					g2.drawImage(pieces[x][y].getImage(), SQUARE * x, SQUARE
							* y, SQUARE, SQUARE, this);
			}
		}

		g2.setColor(new Color(0, 0, 0));
		g2.drawLine(0, BAORD / 2, BAORD, BAORD / 2);
		g2.drawRect(0, 0, BAORD, BAORD);
	}

	public void paintSquare(Graphics2D g2, int x, int y) {

		boolean isWhiteSquare = ((x + y) % 2 == 0);
		Color squareColor = isWhiteSquare ? new Color(58, 165, 212)
				: new Color(239, 240, 240);
		g2.setColor(squareColor);
		g2.fillRect(x * SQUARE, y * SQUARE, SQUARE, SQUARE);
	}

	public void paintBoard() {

		pieces = new ImageIcon[CELL][CELL];

		for (int k = 0; k < CELL; k++) {
			pieces[k][1] = Pictures.imageIconPawnBlack;
			pieces[k][6] = Pictures.imageIconPawnWhite;
		}

		pieces[0][0] = Pictures.imageIconRookBlack;
		pieces[7][0] = Pictures.imageIconRookBlack;
		pieces[0][7] = Pictures.imageIconRookWhite;
		pieces[7][7] = Pictures.imageIconRookWhite;

		pieces[1][0] = Pictures.imageIconKnightBlack;
		pieces[6][0] = Pictures.imageIconKnightBlack;
		pieces[1][7] = Pictures.imageIconKnightWhite;
		pieces[6][7] = Pictures.imageIconKnightWhite;

		pieces[2][0] = Pictures.imageIconBishopBlack;
		pieces[5][0] = Pictures.imageIconBishopBlack;
		pieces[2][7] = Pictures.imageIconBishopWhite;
		pieces[5][7] = Pictures.imageIconBishopWhite;

		pieces[3][0] = Pictures.imageIconQueenBlack;
		pieces[4][0] = Pictures.imageIconKingBlack;

		pieces[3][7] = Pictures.imageIconQueenWhite;
		pieces[4][7] = Pictures.imageIconKingWhite;

	}
}
