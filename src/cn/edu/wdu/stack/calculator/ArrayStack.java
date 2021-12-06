package cn.edu.wdu.stack.calculator;

/**
 * @Description: 用数组模拟栈,并添加了判断运算符和计算表达式的方法。
 * @author 高杰
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxStack;

    /**
     * 数组用来模拟栈
     */
    private int[] stack;

    /**
     * 表示栈顶所在的位置，默认情况下如果没有数据时，使用-1
     */
    private int top = -1;

    /**
     * 构造器
     * @param maxStack [in] 栈的最大容量
     */
    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        stack = new int[maxStack];
    }


    /**
     * 判断是否已经满栈
     */
    public boolean isFull() {
        return this.top == this.maxStack - 1;
    }

    /**
     * 判断栈是否是空栈
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


    /**
     * 返回运算符的优先级
     * 优先级使用数字来表示：数字越大，优先级越高
     * @param oper [in] 用户输入的运算符
     * @return
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '1'){
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     * @param val [in] 用户输入的字符
     * @return
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 返回栈顶的元素，不是弹栈
     * @return
     */
    public int peek(){
        return stack[top];
    }

    /**
     * 计算表达式的结果
     * @param num1 [in] 接收的第一个数字
     * @param num2 [in] 接收的第二个数字
     * @param oper [in] 接收的符号
     * @param oper [out] 返回的计算结果
     * @return
     */
    public int cal(int num1,int num2,int oper){
        //存放计算结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // 减法要注意顺序，一定是后出栈的数字减先出栈的数字
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                // 除法要注意顺序，一定是后出栈的数字除以先出栈的数字
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}
