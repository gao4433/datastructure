package cn.edu.wdu.stack.revpolishcalculator;

/**
 * @author 高杰
 */
public class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    /**
     * 返回插入的运算符的优先级数字
     *
     * @param operation [in] 传入的运算符
     * @return
     */
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                //System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}