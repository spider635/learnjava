package learningjavaproject;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("石头剪刀布游戏!");
        System.out.println("请输入你的选择: (1-石头, 2-剪刀, 3-布)");
        
        // 获取玩家输入
        int playerChoice = scanner.nextInt();
        
        // 验证输入
        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println("无效输入，请输入1、2或3");
            scanner.close();
            return;
        }
        
        // 计算机随机选择(1-3)
        int computerChoice = random.nextInt(3) + 1;
        
        // 显示选择
        System.out.println("你的选择: " + getChoiceName(playerChoice));
        System.out.println("计算机的选择: " + getChoiceName(computerChoice));
        
        // 使用switch判断胜负
        switch (playerChoice) {
            case 1: // 玩家选择石头
                switch (computerChoice) {
                    case 1:
                        System.out.println("平局!");
                        break;
                    case 2:
                        System.out.println("你赢了! 石头砸坏剪刀。");
                        break;
                    case 3:
                        System.out.println("你输了! 布包住石头。");
                        break;
                }
                break;
                
            case 2: // 玩家选择剪刀
                switch (computerChoice) {
                    case 1:
                        System.out.println("你输了! 石头砸坏剪刀。");
                        break;
                    case 2:
                        System.out.println("平局!");
                        break;
                    case 3:
                        System.out.println("你赢了! 剪刀剪开布。");
                        break;
                }
                break;
                
            case 3: // 玩家选择布
                switch (computerChoice) {
                    case 1:
                        System.out.println("你赢了! 布包住石头。");
                        break;
                    case 2:
                        System.out.println("你输了! 剪刀剪开布。");
                        break;
                    case 3:
                        System.out.println("平局!");
                        break;
                }
                break;
        }
        
        scanner.close();
    }
    
    // 辅助方法：将数字转换为选择名称
    private static String getChoiceName(int choice) {
        switch (choice) {
            case 1: return "石头";
            case 2: return "剪刀";
            case 3: return "布";
            default: return "未知";
        }
    }
}