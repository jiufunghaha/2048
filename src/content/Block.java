package content;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import constant.WindowConstant;

/*
 * 2:(238,228,218)
 * 4:(237,224,200)
 * 8:(242,177,121)
 * 16:(245,149,99)
 * 32:(246,124,95)
 * 64:(246,94,59)
 * 128:(237,207,114)
 * 256:(237,204,97)
 * 512:(237,200,80)
 * 1024:
 * 2048:
 * 4096:
 */

/**
 * 
 * 单元方块类
 * @author jiufung
 * @date 2018年7月25日
 *
 */
public class Block {
	
	//坐标位置
	private int i;
	private int j;
	//像素位置
	private int x;
	private int y;
	//字体像素位置
	private int xOfText;
	private int yOfText;
	//单元的值
	private int value;
	
	//单元方块的颜色
	private Color color;
	//字体的颜色
	private Color colorOfText;
	
	public Block(int i, int j){
		this.i = i;
		this.j = j;
		this.value = 1;
		setXY();
		setText();
	}
	
	private void setXY(){
		x = WindowConstant.X_OF_GAMEAREA + WindowConstant.INTERVAL_BETWEEN_BLOCK + (WindowConstant.SIZE_OF_BLOCK+WindowConstant.INTERVAL_BETWEEN_BLOCK)*i;
		y = WindowConstant.Y_OF_GAMEAREA + WindowConstant.INTERVAL_BETWEEN_BLOCK + (WindowConstant.SIZE_OF_BLOCK+WindowConstant.INTERVAL_BETWEEN_BLOCK)*j;
	}
	
	public void setIJ(int i, int j){
		this.i = i;
		this.j = j;
		setXY();
	}
	
	public void setValue(int value){
		this.value = value;
		setText();
	}
	
	private void setText(){
		//计算value的位数
		int num = 0;
		int valueCopy = value;
		do{
			num++;
		}while((valueCopy /= 10) != 0);
		//设置xy
		xOfText = x + WindowConstant.SIZE_OF_BLOCK/2 - 6*num;
		yOfText = y + 55;
		switch(value){
		case 1:
			color = new Color(205, 193, 180);
			break;
		case 2:
			color = new Color(238, 228, 218);
			colorOfText = new Color(119, 110, 101);
			break;
		case 4:
			color = new Color(237, 224, 200);
			colorOfText = new Color(119, 110, 101);
			break;
		case 8:
			color = new Color(242, 177, 121);
			colorOfText = Color.white;
			break;
		case 16:
			color = new Color(245, 149, 99);
			colorOfText = Color.white;
			break;
		case 32:
			color = new Color(246, 124, 95);
			colorOfText = Color.white;
			break;
		case 64:
			color = new Color(246, 94, 59);
			colorOfText = Color.white;
			break;
		case 128:
			color = new Color(237, 207, 114);
			colorOfText = Color.white;
			break;
		case 256:
			color = new Color(237, 204, 97);
			colorOfText = Color.white;
			break;
		case 512:
			color = new Color(237, 200, 80);
			colorOfText = Color.white;
			break;
		case 1024:
			color = new Color(237, 197, 63);
			colorOfText = Color.white;
			break;
		case 2048:
			color = new Color(237, 194, 46);
			colorOfText = Color.white;
			break;
		default:
			color = new Color(0, 0, 0);
			colorOfText = Color.white;
			break;
		}
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getValue(){
		return value;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, WindowConstant.SIZE_OF_BLOCK, WindowConstant.SIZE_OF_BLOCK);
		g.setColor(colorOfText);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		if(value != 1)g.drawString(value+"", xOfText, yOfText);
	}
	
}
