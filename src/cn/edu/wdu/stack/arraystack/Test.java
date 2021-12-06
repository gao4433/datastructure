package cn.edu.wdu.stack.arraystack;

import cn.edu.wdu.stack.arraystack.ArrayStack;

import java.util.Scanner;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 测试我们用数组模拟的栈的功能
 * @date 2021/11/16 22:17
 * @since 1.8
 */
public class Test {
    public static void main(String[] args) {
        //先创建一个ArrayStack对象，用来表示表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

       /* while(loop) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 添加数据到栈(入栈)");
            System.out.println("pop: 从栈取出数据(出栈)");
            System.out.print("---请输入您的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");*/
        System.out.println("--------压栈：");
        stack.push(30);
        stack.push(20);
        stack.push(20);
        stack.push(40);
        stack.push(50);

        System.out.println("--------打印栈中元素：");
        stack.list();
        System.out.println("--------弹栈");
        for (int i = 0; i < 5; i++) {
            try {
                int res = stack.pop();
                System.out.printf("出栈的数据是 %d\n", res);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }


    }
}
