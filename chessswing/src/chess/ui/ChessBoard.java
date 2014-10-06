package chess.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import ch.ChessBase;
import ch.move.IllegalMoveException;
import ch.move.Move;
import ch.position.Position;
import chess.pic.Pictures;

public class ChessBoard extends PieceMove {
	public static int BAORD = 800;
	public static int CELL = 8;
	public static int SQUARE = BAORD / CELL;
	 
	

	ChessBoard() {
		position = Position.createInitialPosition();
		
		setPictureStones(position);
		

		//System.out.println("game " + Arrays.toString(game));

	}

	public void paintComponent(Graphics g) {
		// System.out.println("draw!");
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		for (int x = 0; x < CELL; x++) {
			for (int y = 0; y < CELL; y++) {
				paintSquare(g2, x, y);
				if (pieces[ChessBase.coorToSqi(x, (CELL - y - 1))] != null)
					g2.drawImage(pieces[ChessBase.coorToSqi(x, (CELL - y - 1))], SQUARE *x, SQUARE * y, SQUARE, SQUARE, this);
			}
		}
		
		//g2.drawImage(pieces[0], SQUARE * 0, SQUARE * 0, SQUARE, SQUARE, this);
		//g2.drawImage(Pictures.imageIconRookBlack, SQUARE * 1, SQUARE * 0, SQUARE, SQUARE, this);
		g2.setColor(new Color(255, 0, 255));
		mousePiece(g2);
		g2.setColor(new Color(0, 0, 0));
		// g2.drawLine(0, BAORD / 2, BAORD, BAORD / 2);
		g2.drawRect(0, 0, BAORD, BAORD);
		g2.setColor(new Color(255, 255, 255));

	}

	public Dimension getPreferredSize() {
		return new Dimension(BAORD + 18, BAORD + 63);
	}

	public void paintSquare(Graphics2D g2, int x, int y) {
		
		boolean isWhiteSquare = ((x + y) % 2 == 0);
		Color squareColor = isWhiteSquare ? new Color(58, 165, 212) : new Color(239, 240, 240);
		g2.setColor(squareColor);
		g2.fillRect(SQUARE * x, SQUARE * y, SQUARE, SQUARE);
		g2.setColor(Color.BLACK);
		g2.drawRect(SQUARE * x, SQUARE * y, SQUARE, SQUARE);

	}
	
	
	/**
	 * 
	 * set and update array of pieces[i] Images
	 * 
	 * @param pos
	 */


}
