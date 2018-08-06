package swing;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import constant.WindowConstant;
import content.Block;
import judge.BlockMove;

/**
 * 游戏panel类
 * @author jiufung
 * @date 2018年7月25日
 *
 */
public class GamePanel extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Block[][] blocks = new Block[WindowConstant.NUMBER_OF_ROW][WindowConstant.NUMBER_OF_COL];
	
	boolean isEnd;
	boolean isWin;
	boolean isContinue;
	
	public GamePanel(){
		this.setFocusable(true);
		this.addKeyListener(this);
		init();
	}
	/**
	 * 
	 */
	public void init(){
		for(int j = 0; j < blocks.length; j++){
			for(int i = 0; i < blocks[j].length; i++){
				blocks[i][j] = new Block(i, j);
			}
		}
		BlockMove.randomInsert(blocks);
		BlockMove.randomInsert(blocks);
		
		isEnd = false;
		isWin = false;
		isContinue = false;
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		PaintContent.paintBackground(g);
		PaintContent.paintBlock(g, blocks);
		PaintContent.paintWinEndInfo(g, isWin, isEnd);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			if(!isWin && BlockMove.moveLeft(blocks))BlockMove.randomInsert(blocks);
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			if(!isWin && BlockMove.moveRight(blocks))BlockMove.randomInsert(blocks);
			repaint();
			break;
		case KeyEvent.VK_UP:
			if(!isWin && BlockMove.moveUp(blocks))BlockMove.randomInsert(blocks);
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			if(!isWin && BlockMove.moveDown(blocks))BlockMove.randomInsert(blocks);
			repaint();
			break;
		case KeyEvent.VK_SPACE:
			System.out.println(isWin);
			if(isEnd || isWin)init();
			repaint();
			break;
		case KeyEvent.VK_ENTER:
			if(isWin){
				isContinue = true;
				isWin = false;
			}
			repaint();
			break;

		default:
			break;
		}
		
		if(!isContinue)isWin = BlockMove.isWin(blocks);
		isEnd = BlockMove.isEnd(blocks);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e.getKeyChar());
	}
}
