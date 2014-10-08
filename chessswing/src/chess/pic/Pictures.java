package chess.pic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import chess.ui.PieceMove;


public class Pictures {
	public static ImageIcon iconChessNotebook;

	public static Image iKingWhite;
	public static Image iQueenWhite;
	public static Image iBishopWhite;
	public static Image iKnightWhite;
	public static Image iRookWhite;
	public static Image iPawnWhite;

	public static Image iKingBlack;
	public static Image iQueenBlack;
	public static Image iBishopBlack;
	public static Image iKnightBlack;
	public static Image iRookBlack;
	public static Image iPawnBlack;
	
	public static Image imageGoodMove;
	public static String fontName;
	public static int iterFont = 485;

	public static void LosdImageIconsUtf() {
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));

		iKingBlack = getPicImage("♚", "KingBlack");
		iQueenBlack = getPicImage("♛", "QueenBlack");
		iBishopBlack = getPicImage("♝", "BishopBlack");
		iKnightBlack = getPicImage("♞", "KnightBlack");
		iRookBlack = getPicImage("♜", "RookBlack");
		iPawnBlack = getPicImage("♟", "PawnBlack");

		iKingWhite = getPicImage("♔", "KingWhite");
		iQueenWhite = getPicImage("♕", "QueenWhite");
		iBishopWhite = getPicImage("♗", "BishopWhite");
		iKnightWhite = getPicImage("♘", "KnightWhite");
		iRookWhite = getPicImage("♖", "RookWhite");
		iPawnWhite = getPicImage("♙", "PawnWhite");
		imageGoodMove = getPicImage("*", "ast");
		
	}
	
	public static void LosdImageIconsImg() throws IOException {
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));


		iKingBlack = ImageIO.read(Pictures.class.getResourceAsStream("KingBlack.png"));
		iQueenBlack = ImageIO.read(Pictures.class.getResourceAsStream("QueenBlack.png"));
		iBishopBlack = ImageIO.read(Pictures.class.getResourceAsStream("BishopBlack.png"));
		iKnightBlack = ImageIO.read(Pictures.class.getResourceAsStream("KnightBlack.png"));
		iRookBlack = ImageIO.read(Pictures.class.getResourceAsStream("RookBlack.png"));
		iPawnBlack = ImageIO.read(Pictures.class.getResourceAsStream("PawnBlack.png"));
		
		iKingWhite = ImageIO.read(Pictures.class.getResourceAsStream("KingWhite.png"));
		iQueenWhite = ImageIO.read(Pictures.class.getResourceAsStream("QueenWhite.png"));
		iBishopWhite = ImageIO.read(Pictures.class.getResourceAsStream("BishopWhite.png"));
		iKnightWhite = ImageIO.read(Pictures.class.getResourceAsStream("KnightWhite.png"));
		iRookWhite = ImageIO.read(Pictures.class.getResourceAsStream("RookWhite.png"));
		iPawnWhite = ImageIO.read(Pictures.class.getResourceAsStream("PawnWhite.png"));		
		
		imageGoodMove = ImageIO.read(Pictures.class.getResourceAsStream("ast.png"));
		
	}
	
	public static void LosdImageIconsImgA() throws IOException {
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));


		iKingBlack = ImageIO.read(Pictures.class.getResourceAsStream("KingBlack1.png"));
		iQueenBlack = ImageIO.read(Pictures.class.getResourceAsStream("QueenBlack1.png"));
		iBishopBlack = ImageIO.read(Pictures.class.getResourceAsStream("BishopBlack1.png"));
		iKnightBlack = ImageIO.read(Pictures.class.getResourceAsStream("KnightBlack1.png"));
		iRookBlack = ImageIO.read(Pictures.class.getResourceAsStream("RookBlack1.png"));
		iPawnBlack = ImageIO.read(Pictures.class.getResourceAsStream("PawnBlack1.png"));
		
		iKingWhite = ImageIO.read(Pictures.class.getResourceAsStream("KingWhite1.png"));
		iQueenWhite = ImageIO.read(Pictures.class.getResourceAsStream("QueenWhite1.png"));
		iBishopWhite = ImageIO.read(Pictures.class.getResourceAsStream("BishopWhite1.png"));
		iKnightWhite = ImageIO.read(Pictures.class.getResourceAsStream("KnightWhite1.png"));
		iRookWhite = ImageIO.read(Pictures.class.getResourceAsStream("RookWhite1.png"));
		iPawnWhite = ImageIO.read(Pictures.class.getResourceAsStream("PawnWhite1.png"));		
		
		imageGoodMove = ImageIO.read(Pictures.class.getResourceAsStream("ast.png"));
		
	}
	public static void LosdImageIconsImgB() throws IOException {
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));


		iKingBlack = ImageIO.read(Pictures.class.getResourceAsStream("KingBlack2.png"));
		iQueenBlack = ImageIO.read(Pictures.class.getResourceAsStream("QueenBlack2.png"));
		iBishopBlack = ImageIO.read(Pictures.class.getResourceAsStream("BishopBlack2.png"));
		iKnightBlack = ImageIO.read(Pictures.class.getResourceAsStream("KnightBlack2.png"));
		iRookBlack = ImageIO.read(Pictures.class.getResourceAsStream("RookBlack2.png"));
		iPawnBlack = ImageIO.read(Pictures.class.getResourceAsStream("PawnBlack2.png"));
		
		iKingWhite = ImageIO.read(Pictures.class.getResourceAsStream("KingWhite2.png"));
		iQueenWhite = ImageIO.read(Pictures.class.getResourceAsStream("QueenWhite2.png"));
		iBishopWhite = ImageIO.read(Pictures.class.getResourceAsStream("BishopWhite2.png"));
		iKnightWhite = ImageIO.read(Pictures.class.getResourceAsStream("KnightWhite2.png"));
		iRookWhite = ImageIO.read(Pictures.class.getResourceAsStream("RookWhite2.png"));
		iPawnWhite = ImageIO.read(Pictures.class.getResourceAsStream("PawnWhite2.png"));		
		
		imageGoodMove = ImageIO.read(Pictures.class.getResourceAsStream("ast.png"));
		
	}
	
	public static void LosdImageIconsImgC() throws IOException {
		iconChessNotebook = new ImageIcon(Pictures.class.getResource("Chess.png"));


		iKingBlack = ImageIO.read(Pictures.class.getResourceAsStream("KingBlack3.png"));
		iQueenBlack = ImageIO.read(Pictures.class.getResourceAsStream("QueenBlack3.png"));
		iBishopBlack = ImageIO.read(Pictures.class.getResourceAsStream("BishopBlack3.png"));
		iKnightBlack = ImageIO.read(Pictures.class.getResourceAsStream("KnightBlack3.png"));
		iRookBlack = ImageIO.read(Pictures.class.getResourceAsStream("RookBlack3.png"));
		iPawnBlack = ImageIO.read(Pictures.class.getResourceAsStream("PawnBlack3.png"));
		
		iKingWhite = ImageIO.read(Pictures.class.getResourceAsStream("KingWhite3.png"));
		iQueenWhite = ImageIO.read(Pictures.class.getResourceAsStream("QueenWhite3.png"));
		iBishopWhite = ImageIO.read(Pictures.class.getResourceAsStream("BishopWhite3.png"));
		iKnightWhite = ImageIO.read(Pictures.class.getResourceAsStream("KnightWhite3.png"));
		iRookWhite = ImageIO.read(Pictures.class.getResourceAsStream("RookWhite3.png"));
		iPawnWhite = ImageIO.read(Pictures.class.getResourceAsStream("PawnWhite3.png"));		
		
		imageGoodMove = ImageIO.read(Pictures.class.getResourceAsStream("ast.png"));
		
	}
	
	private static String getFonts(){
		BufferedImage bImg = new BufferedImage(375, 375, BufferedImage.TRANSLUCENT);
		Graphics2D gr2 = bImg.createGraphics();
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] allfonts = env.getAllFonts();
		//for (int i = 0; i < allfonts.length; i++) {
		//	System.out.println("Fonts: " + allfonts[i].getFontName());
		//}
		fontName = allfonts[iterFont].getFontName();
		
		System.out.println("iterFont " + iterFont + " iter " + allfonts[iterFont] + "lenght " +allfonts.length);
		iterFont++;
		return fontName;
		
	}
	private static Image getPicImage(String s, String name) {
		String message = s;

		BufferedImage bImg = new BufferedImage(375, 375, BufferedImage.TRANSLUCENT);
		Graphics2D gr = bImg.createGraphics();

		//if (name == "PawnBlack") System.out.println(">>>>>>>>>>>>>!!!!!!!!!!!!!!!" + l_fontName);
		Font f = new Font("", Font.PLAIN, 410); // 410
		
		//Font f = new Font("Palatino Linotype Курсив", Font.PLAIN, 410); // 410
		gr.setFont(f);
		gr.setPaint(Color.BLACK);
		FontRenderContext context = gr.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		//System.out.println("Wind " + bounds.getWidth() + "Hig " + bounds.getWidth());
		double x = (375 - bounds.getWidth()) / 2; // 375
		double y = (375 - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		gr.drawString(message, (int) x, (int) baseY);
		/*
		File outputfile = new File("C:\\Users\\shulga\\Desktop\\ast\\"+ name +".png");
		try {
			ImageIO.write(bImg, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return bImg;
	}
}
