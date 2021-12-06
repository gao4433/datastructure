package cn.edu.wdu.stack.arraystack;

import java.nio.file.OpenOption;
import java.util.Arrays;

/**
 * @author 高杰
 * @Description: 用数组模拟栈
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxStack;

    /**
     * 用来模拟栈的数组
     */
    private int[] stack;

    /**
     * 表示栈顶所在的位置，没有数据时默认为-1
     */
    private int top = -1;

    /**
     * 构造器
     *
     * @param maxStack [in] 栈的最大容量
     */
    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }

    /**
     * 判断栈是否已满
     */
    public boolean isFull() {
        return this.top == this.maxStack - 1;
    }

    /**
     * 判断是否为空栈
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 压栈
     */
    public void push(int val) {
        //先判断是否已经栈满
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = val;
        System.out.println(val + "入栈！");
    }

    /**
     * 弹栈
     */
    public int pop() {
        //如果栈为空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈，查看栈中所有元素
     * 从栈顶开始打印数据
     */
    public void list() {
        //是否是空栈
        if (isEmpty()) {
            throw new RuntimeException("空栈，未找到数据");
        }
        for (int i = maxStack - 1; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }

    }

}
