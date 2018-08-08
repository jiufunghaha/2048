package main;

import javax.swing.JFrame;

import constant.WindowConstant;
import swing.GamePanel;

/**
 * 主函数类：主函数所在位置
 * @author jiufung
 * @date 2018年7月25日
 *
 */
public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("2048");
		frame.setSize(WindowConstant.WIDTH, WindowConstant.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel panel = new GamePanel();
		frame.add(panel);
		frame.setVisible(true);
	}
}
