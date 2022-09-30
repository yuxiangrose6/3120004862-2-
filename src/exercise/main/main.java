package exercise.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import exercise.utils.AnswerCheckUtil;
import exercise.utils.ExerciseFractionUtil;
import exercise.utils.ExerciseIntegerUtil;

public class main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//n表示输入题目数量，x表示输入数字的范围
		int choose,n,x,over;
		System.out.println("自动生成小学四则运算题目");
		while(true) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("请选择你需要出的题目的类型，1是整数类型，2是分数类型");
			//判断是否输入为数字
			if(!scanner.hasNextInt())
				continue;
			choose=scanner.nextInt();
			if(choose==1) {
				System.out.println("请输入出题的数量以及数字的范围");
				n=new Scanner(System.in).nextInt();
				x=new Scanner(System.in).nextInt();
				ExerciseIntegerUtil.getExerise(n, x);
				File file=new File("1.txt");
					try {
						if(!file.exists())
							file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("请在1.txt中作答,答题完毕请输入1");
				over=scanner.nextInt();
				//判断是否输入正确
				while(over!=1) {
					System.out.println("输入有误，请重新输入");
					over=new Scanner(System.in).nextInt();
				}
				AnswerCheckUtil.checkAnswer();
			}
			else if(choose==2) {
				System.out.println("请输入出题的数量以及数字的范围");
				n=new Scanner(System.in).nextInt();
				x=new Scanner(System.in).nextInt();
				ExerciseFractionUtil.getExercise(n, x);
				File file=new File("1.txt");
				try {
					if(!file.exists())
						file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("请在1.txt中作答,答题完毕请输入1");
				over=scanner.nextInt();
				while(over!=1) {
					System.out.println("输入有误，请重新输入");
					over=new Scanner(System.in).nextInt();
				}
				AnswerCheckUtil.checkAnswer();
			}
			else {
				System.out.println("你输入有误");
			}
		}
	}

}
