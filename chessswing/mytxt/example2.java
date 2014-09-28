package com.gmail.bernabe.laurent.j2se.chesspresso_test;

import javax.swing.JFrame;

import chesspresso.Chess;
import chesspresso.game.Game;
import chesspresso.game.view.GameBrowser;
import chesspresso.move.IllegalMoveException;
import chesspresso.move.Move;

public class ChessFrame extends JFrame {

    public ChessFrame(){
        setTitle("Chesspresso gamebrowser test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gameBrowser);
        pack();

        addMove(Chess.E2, Chess.E4, false, "Debut pour une partie ouverte");
        addMove(Chess.E7, Chess.E5, false, "Reponse symetrique forte");
        addMove(Chess.G1, Chess.F3, false, null);
        addMove(Chess.B8, Chess.C6, false, null);
        addMove(Chess.F1, Chess.B5, false, null);
    }

    private void addMove(int fromSquareIndex, int toSquareIndex,
            boolean isCapturingMove, String comment){
        try {
            short move = Move.getRegularMove(fromSquareIndex, toSquareIndex,
                    isCapturingMove);
            if (Move.isValid(move)) {
                chessGame.getPosition().doMove(move);
                if (comment != null && comment.length() > 0)
                    chessGame.addComment(comment);
            }
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
    }


    private Game chessGame = new Game();
    private GameBrowser gameBrowser = new GameBrowser(chessGame);
    private static final long serialVersionUID = -6856238414376776882L;

}
And here is my main class :

package com.gmail.bernabe.laurent.j2se.chesspresso_test;


public class ChesspressoGraphicalTest {

    public static void main(String[] args) {
        ChessFrame chessFrame = new ChessFrame();
        chessFrame.setVisible(true);
    }

}