package cn.edu.wdu.stack.calculator;

/**
 * @Description 完成表达式的运算
 * @author gaojie  gao4433@qq.com
 * @date 2021/11/17 18:57
 * @since 1.8
 */
public class Calculator {
    public static void main(String[] args) {
        //用户输入的运算式
        String expression = "7*2*2-5+1-5+3-4";
        //数栈
        ArrayStack numStack = new ArrayStack(10);
        //符号栈
        ArrayStack operStack = new ArrayStack(10);
        //用于扫描时，定位当前所在表达式的位置
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        //用于存放运算结果
        int res = 0;
        //保存每次扫描表达式得到的符号
        char ch = ' ';
        //用于拼接 多位数
        String keepNum = "";

        //扫描表达式,逐个的处理表达式中的字符
        while(true) {
            //获取一个字符并存放在ch中
            ch = expression.substring(index, index+1).charAt(0);
            //如果是运算符
            if(operStack.isOper(ch)) {
                //如果当前符号栈不为空
                if(!operStack.isEmpty()) {
                    /** 当前的操作符的优先级小于或者等于栈中的操作符
                     * 就需要从数栈中pop出两个数,再从符号栈中pop出一个符号，进行运算
                     * 将结果压入数栈，然后将当前操作符压入符号栈 **/
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果压人数栈
                        numStack.push(res);
                        //将当前的操作符压入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈.
                        operStack.push(ch);
                    }
                //如果符号栈为空，直接入符号栈
                }else {
                    operStack.push(ch);
                }
            //如果是数，则压入数栈
            } else {
                //numStack.push(ch - 48);
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向表达式当前的index后再看一位,如果是数就继续扫描，如果是符号才入栈
                //3. 因此我们定义了变量 keepNum，用于拼接

                //处理多位数
                keepNum += ch;

                //如果ch已经是表达式的最后一位了，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{

                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意只是看index后面一位，不是index++
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        //如果后一位是运算符，则入栈 ，如keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";

                    }
                }
            }
            //让index + 1，定位到下一个数
            index++;
            //判断是否扫描到表达式的最后，扫描结束
            if (index == expression.length()) {
                break;
            }
        } //整个表达式扫描完毕，数字和符号已经全部作处理后入栈

        //顺序的从数栈和符号栈中弹出相应的数和符号并进行计算.
        while(true) {
            //如果符号栈为空，停止弹栈运算
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        } //此时符号栈为空，数栈只有一个数字就是表达式的运算结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}
