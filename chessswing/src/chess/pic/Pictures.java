package chess.pic;

import java.net.URL;

import javax.swing.ImageIcon;

public class Pictures {
	public static ImageIcon iconChessNotebook;

	public static ImageIcon imageIconKingWhite;
	public static ImageIcon imageIconQueenWhite;
	public static ImageIcon imageIconBishopWhite;
	public static ImageIcon imageIconKnightWhite;
	public static ImageIcon imageIconRookWhite;
	public static ImageIcon imageIconPawnWhite;

	public static ImageIcon imageIconKingBlack;
	public static ImageIcon imageIconQueenBlack;
	public static ImageIcon imageIconBishopBlack;
	public static ImageIcon imageIconKnightBlack;
	public static ImageIcon imageIconRookBlack;
	public static ImageIcon imageIconPawnBlack;



	public static void LosdImageIcons() {
		// URL imgURL = Pictures.class.getResource("Chess.ico");
		// System.out.println(imgURL.toString());
		// System.out.println(Pictures.class.toString());
		iconChessNotebook = new ImageIcon(
				Pictures.class.getResource("Chess.png"));
		imageIconKingBlack = new ImageIcon(
				Pictures.class.getResource("bKingZurich.gif"));
		imageIconQueenBlack = new ImageIcon(
				Pictures.class.getResource("bQueenZurich.gif"));
		imageIconBishopBlack = new ImageIcon(
				Pictures.class.getResource("bBishopZurich.gif"));
		imageIconKnightBlack = new ImageIcon(
				Pictures.class.getResource("bKnightZurich.gif"));
		imageIconRookBlack = new ImageIcon(
				Pictures.class.getResource("bRookZurich.gif"));
		imageIconPawnBlack = new ImageIcon(
				Pictures.class.getResource("bPawnZurich.gif"));

		imageIconKingWhite = new ImageIcon(
				Pictures.class.getResource("wKingZurich.gif"));
		imageIconQueenWhite = new ImageIcon(
				Pictures.class.getResource("wQueenZurich.gif"));
		imageIconBishopWhite = new ImageIcon(
				Pictures.class.getResource("wBishopZurich.gif"));
		imageIconKnightWhite = new ImageIcon(
				Pictures.class.getResource("wKnightZurich.gif"));
		imageIconRookWhite = new ImageIcon(
				Pictures.class.getResource("wRookZurich.gif"));
		imageIconPawnWhite = new ImageIcon(
				Pictures.class.getResource("wPawnZurich.gif"));
	}
}
