package chess.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ch.ChessBase;
import ch.move.IllegalMoveException;
import ch.move.Move;
import ch.position.Position;
import chess.pic.Pictures;

public class PieceMove extends JPanel implements MouseListener, MouseMotionListener {
	protected   Image[] pieces = new Image[64];
	public static Position position;
	protected static int[] squares = new int[64];
	private int selectedPieceX;
	private int selectedPieceY;
	private int cSelectedPieceX;
	private int cSelectedPieceY;
	private int fromSqi;
	private int toSqi;
	private Image piece;
	private List<Short> legalPiceMoves;

	/**
	 * lpiece - dragged mouse figure ()
	 */
	private Image lpiece;
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
		//System.out.println("Move:" + Integer.toBinaryString(Move.getPawnMove(ChessBase.A1, ChessBase.A2, false, ChessBase.NO_PIECE)));
		//System.out.println("Move:" + Integer.toBinaryString(Move.getRegularMove(ChessBase.A1, ChessBase.A2, false)));
		//System.out.println("Move string from move " + Move.getBinaryString(Move.getRegularMove(ChessBase.C1, ChessBase.C2, false)));
		//System.out.println("string" + Move.getString(Move.getRegularMove(ChessBase.A1, ChessBase.A2, false)));
		//System.out.println("Move" );

		cSelectedPieceX = arg0.getX();
		cSelectedPieceY = arg0.getY();
		selectedPieceX = arg0.getX() / ChessBoard.SQUARE;
		selectedPieceY = ChessBoard.CELL - arg0.getY() / ChessBoard.SQUARE - 1;
		fromSqi = ChessBase.coorToSqi(selectedPieceX, selectedPieceY);

		//System.out.println("fromSqi " + fromSqi);
		if (arg0.getX() > 0 && arg0.getX() < ChessBoard.BAORD && arg0.getY() > 0 && arg0.getY() < ChessBoard.BAORD) {

			if (pieces[fromSqi] != null) {

				piece = pieces[fromSqi];
				lastX = selectedPieceX;
				lastY = selectedPieceY;
				lpiece = pieces[fromSqi];
				pieces[fromSqi] = null;
				setP = true;
				
				short[] legalMoves = position.getAllMoves();
				System.out.println("Start");
				legalPiceMoves = new ArrayList<Short>();
				for (short legalMove : legalMoves){
					if (Move.getFromSqi(legalMove) == fromSqi) {
						legalPiceMoves.add(legalMove);
						System.out.println(legalMove);
						  
					}
				}
				for (short legalPieceMove : legalPiceMoves){
					pieces[Move.getToSqi(legalPieceMove)] =  Pictures.imageGoodMove;
				}
				System.out.println("!!!!!!!!" + legalPiceMoves);

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
		selectedPieceY = ChessBoard.CELL - arg0.getY() / ChessBoard.SQUARE - 1;
		toSqi = ChessBase.coorToSqi(selectedPieceX, selectedPieceY);
		short move = 0;
		if (arg0.getX() > 0 && arg0.getX() < ChessBoard.BAORD && arg0.getY() > 0 && arg0.getY() < ChessBoard.BAORD) {

			if (piece != null && toSqi != fromSqi) {

				for (short legalPieceMove : legalPiceMoves){
					if (toSqi == Move.getToSqi(legalPieceMove))
						move = legalPieceMove;
						
				}
				try {
							position.doMove(move);
						} catch (IllegalMoveException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				
				System.out.println(position.getPieceMove(position.getStone(fromSqi), ChessBase.sqiToCol(fromSqi), ChessBase.sqiToRow(fromSqi), toSqi));
				//position.isLegal();

				piece = null;
			}
		} else if (lpiece != null)

			pieces[ChessBase.coorToSqi(lastX, lastY)] = lpiece;

		//setCursor(Cursor.getDefaultCursor());
		//short[] legalMoves = position.getAllMoves();
		/*
		try {
			//position = Position.createInitialPosition();

			position.doMove(legalMoves[12]);

		} catch (IllegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		setPictureStones(position);
		repaint();
		if (position.isMate()) JOptionPane.showMessageDialog(this, "Мат!");
		else if (position.isCheck()) JOptionPane.showMessageDialog(this, "Шах!");
		

	}

	protected void mousePiece(Graphics2D g) {
		if (setP)
			g.drawImage(piece, cSelectedPieceX - ChessBoard.SQUARE / 2, cSelectedPieceY - ChessBoard.SQUARE / 2, ChessBoard.SQUARE, ChessBoard.SQUARE, this);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		cSelectedPieceX = e.getX();
		cSelectedPieceY = e.getY();
		if (cSelectedPieceX < 0 || cSelectedPieceX > ChessBoard.BAORD || cSelectedPieceY < 0 || cSelectedPieceY > ChessBoard.BAORD) {
			setP = false;
			if (lpiece != null)
				pieces[ChessBase.coorToSqi(lastX, lastY)] = lpiece;
			piece = null;
		}
		// System.out.println(cSelectedPieceX + " " + cSelectedPieceY + " ");

		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setPictureStones(Position pos) {
		Arrays.fill(pieces, null);
		Arrays.fill(squares, 0);
		for (int i = 0; i < 64; i++) {
			squares[i] = pos.getStone(i);

		}

		for (int i = 0; i < 64; i++) {
			//System.out.println("iiii" + );
			if (squares[i] != 0)
				switch (squares[i]) {
				case ChessBase.WHITE_KING:
					pieces[i] = Pictures.iKingWhite;
					break;
				case ChessBase.WHITE_PAWN:
					pieces[i] = Pictures.iPawnWhite;
					break;
				case ChessBase.WHITE_QUEEN:
					pieces[i] = Pictures.iQueenWhite;
					break;
				case ChessBase.WHITE_ROOK:
					pieces[i] = Pictures.iRookWhite;
					break;
				case ChessBase.WHITE_BISHOP:
					pieces[i] = Pictures.iBishopWhite;
					break;
				case ChessBase.WHITE_KNIGHT:
					pieces[i] = Pictures.iKnightWhite;
					break;
				case ChessBase.BLACK_KING:
					pieces[i] = Pictures.iKingBlack;
					break;
				case ChessBase.BLACK_PAWN:
					pieces[i] = Pictures.iPawnBlack;
					break;
				case ChessBase.BLACK_QUEEN:
					pieces[i] = Pictures.iQueenBlack;
					break;
				case ChessBase.BLACK_ROOK:
					pieces[i] = Pictures.iRookBlack;
					break;
				case ChessBase.BLACK_BISHOP:
					pieces[i] = Pictures.iBishopBlack;
					break;
				case ChessBase.BLACK_KNIGHT:
					pieces[i] = Pictures.iKnightBlack;
					break;
				default:
					pieces[i] = null;
					break;

				}
			repaint();
		}
		/*
		* WHITE_KING = -6, <br>
		 * WHITE_PAWN = -5, <br>
		 * WHITE_QUEEN = -4, <br>
		 * WHITE_ROOK = -3, <br>
		 * WHITE_BISHOP = -2, <br>
		 * WHITE_KNIGHT = -1,<br>
		 * BLACK_KING = 6, <br>
		 * BLACK_PAWN = 5, <br>
		 * BLACK_QUEEN = 4, <br>
		 * BLACK_ROOK = 3, <br>
		 * BLACK_BISHOP = 2, <br>
		 * BLACK_KNIGHT = 1, <br>
		*/

	}

	public void printPosStones(Position pos) {
		int[] st = new int[64];
		for (int i = 0; i < 64; i++) {
			st[i] = pos.getStone(i);
			System.out.println(i + ":(" + st[i] + ");");
		}

	}

}