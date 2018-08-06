/**
 * 
 */
package judge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import constant.WindowConstant;
import content.Block;

/**
 * @author jiufung
 * @date 2018年8月3日
 *
 */
public class BlockMove {
	public static boolean moveLeft(Block[][] blocks){
		boolean isMove = false;
		for(int j = 0; j < blocks.length; j++){
			//空格计数
			int count = 0;
			boolean flag = true;
			for(int i = 0; i < blocks[j].length; i++){
				if(1 == blocks[i][j].getValue()){
					count ++;
				}else{
					if(0 != count){
						isMove = true;
						int temp = blocks[i-count][j].getValue();
						blocks[i-count][j].setValue(blocks[i][j].getValue());
						blocks[i][j].setValue(temp);
					}
					if(flag && 0 < i-count && blocks[i-count][j].getValue() == blocks[i-count-1][j].getValue()){
						blocks[i-count-1][j].setValue(blocks[i-count-1][j].getValue()*2);
						blocks[i-count][j].setValue(1);
						isMove = true;
						flag = false;
						count ++;
					}else{
						flag = true;
					}
				}
			}
		}
		return isMove;
	}
	
	public static boolean moveRight(Block[][] blocks){
		boolean isMove = false;
		for(int j = 0; j < blocks.length; j++){
			//空格计数
			int count = 0;
			boolean flag = true;
			for(int i = blocks[j].length-1; i >= 0; i--){
				if(1 == blocks[i][j].getValue()){
					count ++;
				}else{
					if(0 != count){
						isMove = true;
						int temp = blocks[i+count][j].getValue();
						blocks[i+count][j].setValue(blocks[i][j].getValue());
						blocks[i][j].setValue(temp);
					}
					if(flag && WindowConstant.NUMBER_OF_ROW-1 > i+count && blocks[i+count][j].getValue() == blocks[i+count+1][j].getValue()){
						blocks[i+count+1][j].setValue(blocks[i+count+1][j].getValue()*2);
						blocks[i+count][j].setValue(1);
						isMove = true;
						flag = false;
						count ++;
					}else{
						flag = true;
					}
				}
			}
		}
		return isMove;
	}
	
	public static boolean moveUp(Block[][] blocks){
		boolean isMove = false;
		for(int i = 0; i < blocks.length; i++){
			//空格计数
			int count = 0;
			boolean flag = true;
			for(int j = 0; j < blocks[i].length; j++){
				if(1 == blocks[i][j].getValue()){
					count ++;
				}else{
					if(0 != count){
						isMove = true;
						int temp = blocks[i][j-count].getValue();
						blocks[i][j-count].setValue(blocks[i][j].getValue());
						blocks[i][j].setValue(temp);
					}
					if(flag && 0 < j-count && blocks[i][j-count].getValue() == blocks[i][j-count-1].getValue()){
						blocks[i][j-count-1].setValue(blocks[i][j-count-1].getValue()*2);
						blocks[i][j-count].setValue(1);
						isMove = true;
						flag = false;
						count ++;
					}else{
						flag = true;
					}
				}
			}
		}
		return isMove;
	}
	
	public static boolean moveDown(Block[][] blocks){
		boolean isMove = false;
		for(int i = 0; i < blocks.length; i++){
			//空格计数
			int count = 0;
			boolean flag = true;
			for(int j = blocks[i].length-1; j >= 0; j--){
				if(1 == blocks[i][j].getValue()){
					count ++;
				}else{
					if(0 != count){
						isMove = true;
						int temp = blocks[i][j+count].getValue();
						blocks[i][j+count].setValue(blocks[i][j].getValue());
						blocks[i][j].setValue(temp);
					}
					if(flag && WindowConstant.NUMBER_OF_COL-1 > j+count && blocks[i][j+count].getValue() == blocks[i][j+count+1].getValue()){
						blocks[i][j+count+1].setValue(blocks[i][j+count+1].getValue()*2);
						blocks[i][j+count].setValue(1);
						isMove = true;
						flag = false;
						count ++;
					}else{
						flag = true;
					}
				}
			}
		}
		return isMove;
	}
	
	public static boolean randomInsert(Block[][] blocks){
		int insertValue = 0;
		Random rd = new Random();
		if(0 == rd.nextInt(2)){
			insertValue = 2;
		}else{
			insertValue = 4;
		}
		List<Block> blockOfNullValue = new ArrayList<Block>();
		for(int i = 0; i < blocks.length; i++){
			for(int j = 0; j < blocks[i].length; j++){
				if(1 == blocks[i][j].getValue()){
					blockOfNullValue.add(blocks[i][j]);
				}
			}
		}
		if(blockOfNullValue.size() > 0){
			blockOfNullValue.get(rd.nextInt(blockOfNullValue.size())).setValue(insertValue);
		}else{
			return true;
		}
		return false;
	}
	
	public static boolean isWin(Block[][] blocks){
		for(int i = 0; i < blocks.length; i++){
			for(int j = 0; j < blocks[i].length; j++){
				if(2048 == blocks[i][j].getValue()){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isEnd(Block[][] blocks){
		for(int i = 0; i < blocks.length; i++){
			for(int j = 0; j < blocks[i].length; j++){
				if(1 == blocks[i][j].getValue()){
					return false;
				}
				if(i < blocks.length-1 && blocks[i][j].getValue() == blocks[i+1][j].getValue()){
					return false;
				}
				if(j < blocks[i].length-1 && blocks[i][j].getValue() == blocks[i][j+1].getValue()){
					return false;
				}
			}
		}
		return true;
	}
}
