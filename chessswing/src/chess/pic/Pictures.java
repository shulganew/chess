package chess.pic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Pictures {
	public static ImageIcon iconChessNotebook;

	public static Image imageIconKingWhite;
	public static Image imageIconQueenWhite;
	public static Image imageIconBishopWhite;
	public static Image imageIconKnightWhite;
	public static Image imageIconRookWhite;
	public static Image imageIconPawnWhite;

	public static Image imageIconKingBlack;
	public static Image imageIconQueenBlack;
	public static Image imageIconBishopBlack;
	public static Image imageIconKnightBlack;
	public static Image imageIconRookBlack;
	public static Image imageIconPawnBlack;

	public static void LosdImageIcons() {
		// URL imgURL = Pictures.class.getResource("Chess.ico");
		// System.out.println(imgURL.toString());
		// System.out.println(Pictures.class.toString());
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));

		imageIconKingBlack = getPicImage("♚");

		imageIconQueenBlack = getPicImage("♛");
		imageIconBishopBlack = getPicImage("♝");
		imageIconKnightBlack = getPicImage("♞");
		imageIconRookBlack = getPicImage("♜");
		imageIconPawnBlack = getPicImage("♟");

		imageIconKingWhite = getPicImage("♔");
		imageIconQueenWhite = getPicImage("♕");
		imageIconBishopWhite = getPicImage("♗");
		imageIconKnightWhite = getPicImage("♘");
		imageIconRookWhite = getPicImage("♖");
		imageIconPawnWhite = getPicImage("♙");

	}

	private static Image getPicImage(String s) {
		String message = s;

		BufferedImage bImg = new BufferedImage(375, 375, BufferedImage.TRANSLUCENT);
		Graphics2D gr = bImg.createGraphics();
		Font f = new Font("Serif", Font.PLAIN, 410); // 410
		gr.setFont(f);
		gr.setPaint(Color.BLACK);
		FontRenderContext context = gr.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		System.out.println("Wind " + bounds.getWidth() + "Hig " + bounds.getWidth());
		double x = (375 - bounds.getWidth()) / 2; // 375
		double y = (375 - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		gr.drawString(message, (int) x, (int) baseY);
		return bImg;

	}

}
