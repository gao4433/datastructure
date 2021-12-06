package cn.edu.wdu.linkedlist.doublelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 链表的节点，每个HeroNode对象就是一个节点
 * @version JDK11
 * @since 2021/11/13 19:04
 */
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点，默认null
     */
    public HeroNode next;
    /**
     * 指向前一个节点，默认null
     */
    public HeroNode pre;

    /**
     * 构造器
     **/
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为方便打印，我们重写toString
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}