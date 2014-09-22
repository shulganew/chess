/*
 * Copyright (C) Bernhard Seybold. All rights reserved.
 *
 * This software is published under the terms of the LGPL Software License,
 * a copy of which has been included with this distribution in the LICENSE.txt
 * file.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *
 * $Id: AbstractMoveablePosition.java,v 1.1 2002/12/08 13:27:34 BerniMan Exp $
 */

package ch.position;


import ch.*;
import ch.move.IllegalMoveException;
import ch.move.Move;
//import java.util.*;


/**
 *
 * @author  Bernhard Seybold
 * @version $Revision: 1.1 $
 */
public abstract class AbstractMoveablePosition extends AbstractMutablePosition
    implements MoveablePosition
{
    
    public void doMove(Move move) throws IllegalMoveException
    {
        doMove(move.getShortMoveDesc());
    }

    public short getMove(int from, int to, int promoPiece)
    {
        if (getColor(from) != getToPlay()) return Move.ILLEGAL_MOVE;  // =====>
        int piece = getPiece(from);
        if (piece == ChessBase.PAWN) {
            return Move.getPawnMove(from, to, ChessBase.sqiToCol(from) != ChessBase.sqiToCol(to), promoPiece);
        } else if (piece == ChessBase.KING && (to - from) ==  2) {
            return Move.getShortCastle(getToPlay());
        } else if (piece == ChessBase.KING && (to - from) == -2) {
            return Move.getLongCastle(getToPlay());
        } else {
            return Move.getRegularMove(from, to, !isSquareEmpty(to));
        }
    }

}