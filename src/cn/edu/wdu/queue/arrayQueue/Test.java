package cn.edu.wdu.queue.arrayQueue;

import java.util.Scanner;

/**
 * @author gaojie  gao8847@qq.com
 * @version JDK11
 * @since 2021/10/8 22:18
 */
public class Test {
    public static void main(String[] args) {

        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户接受
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("l(length): 查看队列中的元素个数");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l':
                    //查看元素个数
                    System.out.println(queue.queueLength());
                    break;
                case 'e':
                    //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}
