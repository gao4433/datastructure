package cn.edu.wdu.linkedlist.circlesinglelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 模拟结点的类，每个 boy 对象就是一个结点
 * @date 2021/11/15 10:39
 * @since 1.8
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
