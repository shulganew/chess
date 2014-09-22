package chess.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JPanel;

import ch.game.Game;
import ch.game.view.GameBrowser;
import ch.game.Game;
import ch.game.view.GameBrowser;
import ch.move.IllegalMoveException;
import ch.move.Move;
import ch.position.Position;
import ch.position.view.*;
public class MainPanel extends JPanel {
	static Position position;
	static String[] game;

	MainPanel() {
		// setBackground(new Color);

		setLayout(new BorderLayout());
		add(new MenuPanel(), BorderLayout.NORTH);
		// add(new ChessBoard(), BorderLayout.WEST);
		Game chessGame = new Game();
		GameBrowser gameBrowser = new GameBrowser(chessGame);
		add(gameBrowser, BorderLayout.WEST);
		

		position = Position.createInitialPosition();
		short[] all = position.getAllMoves();
		System.out.println("All pos" + Arrays.toString(all));
		game = new String[9 + 1];
		short firstmove = Move.getRegularMove(ch.ChessBase.E2, ch.ChessBase.E8, false);
		short firstmove2 = Move.getRegularMove(ch.ChessBase.F2, ch.ChessBase.E6, false);
		try {
			chessGame.getPosition().doMove(firstmove);
			chessGame.getPosition().doMove(firstmove2);
			
		} catch (IllegalMoveException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//chessGame.getPosition().
		
		try {
			position.doMove(firstmove);
		} catch (IllegalMoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		System.out.println("game " + Arrays.toString(game));

	}

	static void recurse() throws IllegalMoveException {
		int ply = position.getPlyNumber();
		Move lastMove = position.getLastMove();

		// Record move.
		game[ply - 1] = lastMove.getSAN();

		if (ply > 2) {

			// Check if we've found a position where a black knight captures
			// a white rook with checkmate on the fifth move.
			if (position.isMate() && lastMove.isCapturing() && lastMove.getMovingPiece() == ch.ChessBase.KNIGHT && position.getPiece(lastMove.getToSqi()) == ch.ChessBase.ROOK) {

				// We found it, now print the sequence of moves.
				for (int i = 0; i < ply; i++)
					System.out.println(game[i]);
				System.out.println();
			}
			return;
		}

		// Recurse all the possible next positions.
		short[] nextMoves = position.getAllMoves();

		for (short thisMove : nextMoves) {
			// Make the move, recurse, and undo the move.
			position.doMove(thisMove);
			recurse();
			position.undoMove();
		}
	}

}
