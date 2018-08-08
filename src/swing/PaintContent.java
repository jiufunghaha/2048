/**
 * 
 */
package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import constant.WindowConstant;
import content.Block;

/**
 * 用于画出内容类
 * @author jiufung
 * @date 2018年7月25日
 *
 */
public class PaintContent {
	
	/**
	 * 画出静态效果图
	 * @param g 画笔
	 */
	public static void paintBackground(Graphics g){
		//title
		g.setColor(new Color(101011));
		g.fillRect(WindowConstant.MARGIN_LEFT, WindowConstant.MARGIN_TOP, WindowConstant.WIDTH_OF_TITLE, WindowConstant.HEIGHT_OF_TITLE);
		g.setColor(Color.white);
		g.setFont(new Font("宋体", Font.BOLD, 17));
		g.drawString("2048", WindowConstant.X_OF_TITLE, WindowConstant.Y_OF_TITLE);
		//background
		g.setColor(new Color(187, 173, 160));
		g.fillRect(WindowConstant.X_OF_GAMEAREA, WindowConstant.Y_OF_GAMEAREA, WindowConstant.SIZE_OF_GAMEAREA, WindowConstant.SIZE_OF_GAMEAREA);
		g.setColor(Color.gray);
		g.setFont(new Font("宋体", Font.BOLD, 17));
		g.drawString("2048 by JiuFung", 155, 480);
	}
	
	public static void paintWinEndInfo(Graphics g, boolean isWin, boolean isEnd){
		g.setColor(new Color(101011));
		g.setFont(new Font("黑体", Font.BOLD, 30));
		if(isWin){
			g.drawString("Succeed!", 175, 200);
			g.drawString("Press space to restart.", 40, 240);
			g.drawString("Press enter to continue.", 40, 280);
		}
		if(isEnd){
			g.drawString("Failed!", 175, 200);
			g.drawString("Press space to restart.", 40, 240);
		}
	}
	
	public static void paintBlock(Graphics g, Block[][] b){
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[i].length; j++){
				if(b[i][j] != null){
					b[i][j].paint(g);
				}
			}
		}
	}

}
