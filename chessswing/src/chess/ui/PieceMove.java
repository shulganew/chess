package chess.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PieceMove extends JPanel implements MouseListener,
		MouseMotionListener {
	protected ImageIcon[][] pieces;
	private int selectedPieceX;
	private int selectedPieceY;
	private int cSelectedPieceX;
	private int cSelectedPieceY;

	private ImageIcon piece;
	private ImageIcon lpiece;
	private int lastX;
	private int lastY;
	private boolean setP = false;

	public PieceMove() {
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("out!");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		// TODO Auto-generated method stub
		cSelectedPieceX = arg0.getX();
		cSelectedPieceY = arg0.getY();
		selectedPieceX = arg0.getX() / ChessBoard.SQUARE;
		selectedPieceY = arg0.getY() / ChessBoard.SQUARE;
		if (arg0.getX() > 0 && arg0.getX() < ChessBoard.BAORD
				&& arg0.getY() > 0 && arg0.getY() < ChessBoard.BAORD) {
			if (pieces[selectedPieceX][selectedPieceY] != null) {
				piece = pieces[selectedPieceX][selectedPieceY];
				lastX = selectedPieceX;
				lastY = selectedPieceY;
				lpiece = pieces[selectedPieceX][selectedPieceY];
				pieces[selectedPieceX][selectedPieceY] = null;
				setP = true;
				
			}
		}

		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setP = false;
		cSelectedPieceX = arg0.getX();
		cSelectedPieceY = arg0.getY();
		selectedPieceX = arg0.getX() / ChessBoard.SQUARE;
		selectedPieceY = arg0.getY() / ChessBoard.SQUARE;

		if (arg0.getX() > 0 && arg0.getX() < ChessBoard.BAORD
				&& arg0.getY() > 0 && arg0.getY() < ChessBoard.BAORD) {
			if (piece != null) {
				pieces[selectedPieceX][selectedPieceY] = piece;
				piece = null;
			}
		} else if (lpiece != null)
			pieces[lastX][lastY] = lpiece;

		setCursor(Cursor.getDefaultCursor());
		repaint();

	}

	protected void mousePiece(Graphics2D g) {
		if (setP)
			g.drawImage(piece.getImage(), cSelectedPieceX - ChessBoard.SQUARE
					/ 2, cSelectedPieceY - ChessBoard.SQUARE / 2,
					ChessBoard.SQUARE, ChessBoard.SQUARE, this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		cSelectedPieceX = e.getX();
		cSelectedPieceY = e.getY();
		if (cSelectedPieceX < 0 || cSelectedPieceX > ChessBoard.BAORD
				|| cSelectedPieceY < 0 || cSelectedPieceY > ChessBoard.BAORD) {
			setP = false;
			if (lpiece != null)
				pieces[lastX][lastY] = lpiece;
			piece = null;
		}
		// System.out.println(cSelectedPieceX + " " + cSelectedPieceY + " ");

		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}