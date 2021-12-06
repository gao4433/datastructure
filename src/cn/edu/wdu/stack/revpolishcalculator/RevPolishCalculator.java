package cn.edu.wdu.stack.revpolishcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 逆波兰表达式计算器。
 * @date 2021/11/21 21:57
 * @since 1.8
 */
public class RevPolishCalculator {
    /**
     * 主方法：测试功能是否正确
     * @param args
     */
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";

        //将中缀表达式字符串入list
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList);

        //将【中缀表达式对应的List】转为【后缀表达式对应的List】
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List=" + parseSuffixExpressionList);

        //对后缀表达式进行计算
        System.out.println(expression + calculate(parseSuffixExpressionList));


    }


    /**
     * 依次将逆波兰表达式中的数据和运算符放入到 ArrayList 中
     *
     * @param suffixExpression [in] 表达式字符串
     * @return
     */
    /*public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }*/

    /**
     * 将中缀表达式转成对应的【List】
     *
     * @param s [in] 待转化的中缀表达式
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        //用于遍历【中缀表达式】字符串的指针
        int i = 0;
        // 用于多位数的拼接
        String str;
        // 每遍历到一个字符就放入到c
        char c;
        do {
            //如果c是一个非数字，我需要加入到 ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                //指针后移
                i++;
            } else {
                //如果是一个数，判断是否是多位数
                //先将 str 置成 ""
                str = "";
                // '0'是[48]-->'9'是[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    //拼接
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        //返回集合 ls
        return ls;
    }


    /**
     * 将【中缀表达式对应的List】转为【后缀表达式对应的List】
     *
     * @param ls [in] 中缀表达式对应的List
     * @return s2 [out] 后缀表达式对应的List
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义符号栈
        Stack<String> s1 = new Stack<String>();
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出

        //因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //用于存储中间结果的List s2
        List<String> s2 = new ArrayList<String>();

        //遍历集合ls中的中缀表达式
        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //遇到到右括号“)”，则依次弹出s1栈顶的运算符压入s2，直到遇到左括号为止
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //当s1栈顶是"("时, 将它弹出s1栈，将这一对小括号丢弃掉
                s1.pop();
            } else {
                //遍历到运算符，如果优先级小于等于s1栈顶运算符
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    //将s1栈顶的运算符弹出并加入到s2中，并再次与新的栈顶运算符相比较
                    s2.add(s1.pop());
                }
                //优先级大于s1栈顶运算符时压入s1栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        //因为是存放在List中,按顺序输出就是后缀表达式对应的List
        return s2;

    }

    /**
     * 对逆波兰表达式进行计算求值
     * 1.从左至右扫描，将3和4压入堆栈；
     * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3.将5入栈；
     * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5.将6入栈；
     * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     *
     * @param ls [in]
     * @return
     */
    public static int calculate(List<String> ls) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 ls
        for (String item : ls) {
            // 使用正则表达式取数,匹配到多位数
            if (item.matches("\\d+")) {
                // 入栈
                stack.push(item);
            } else {
                // 匹配到运算符，pop出两个数并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }

        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}



