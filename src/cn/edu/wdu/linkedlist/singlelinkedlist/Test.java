package cn.edu.wdu.linkedlist.singlelinkedlist;

import java.util.Stack;

/**
 * @author gaojie  gao4433@qq.com
 * @version JDK11
 * @since 2021/11/11 21:06
 */
public class Test {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个空的单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //在链表末尾添加节点
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);

        //添加指定编号（排名）的节点
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);

        System.out.println("-------------修改前的单链表：");
        //遍历打印单链表中所有节点
        singleLinkedList.list();

        //修改指定编号的结点的信息
        HeroNode hero5 = new HeroNode(2, "鲁智深", "花和尚");
        singleLinkedList.update(hero5);
        HeroNode hero6 = new HeroNode(5, "武松", "行者");
        singleLinkedList.update(hero6);

        System.out.println("-------------修改后的单链表：");
        //遍历打印单链表中所有节点
        singleLinkedList.list();

        //删除指定编号的结点
        singleLinkedList.del(1);
        singleLinkedList.del(6);
        System.out.println("-------------删除后的单链表：");
        //遍历打印单链表中所有节点
        singleLinkedList.list();

        //查询指定编号的节点
        System.out.println("-------------查询到的英雄如下：");
        System.out.println(singleLinkedList.query(3));
        System.out.println(singleLinkedList.query(1));

        //返回有效节点个数
        System.out.println("-------------有效节点个数为：" + getLength(singleLinkedList.getHead()));

        //查找倒数第 k 个结点
        System.out.println("-------------倒数第 2 个节点为：");
        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 2));

        //反转单链表
        reverseList(singleLinkedList.getHead());
        System.out.println("-------------反转后的单链表：");
        singleLinkedList.list();

        //利用栈逆序打印单链表
        System.out.println("-------------利用栈逆序打印单链表:");
        reversePrint(singleLinkedList.getHead());

    }

    /**
     * 获取单链表中有效节点的个数
     *
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        //空链表
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个用遍历的辅助接点
        //从第一个节点开始，不计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找倒数第 k 个结点
     *
     * @param head
     * @param k
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int k) {
        //如果链表为空返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表长度
        int size = getLength(head);
        //先检查 k 是否合法
        if (k <= 0 || k > size) {
            return null;
        }
        //再次遍历到 size-k 位置，得到倒数第k个节点
        //用来遍历的辅助节点
        HeroNode temp = head.next;
        //从正数第一个有效节点开始,循环定位到倒数第k个节点
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 将单链表反转
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空或者只有一个节点，就无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助遍历链表的指针（变量）
        HeroNode cur = head.next;
        //指向当前节点【cur】的下一个节点，临时保存链表的后半部分
        HeroNode nextNode = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，，依次将每个节点取出，放在新的链表 reversHead 的最前端；
        while (cur != null) {
            //临时保存当前节点的下一个节点
            nextNode = cur.next;
            //让cur的下一个节点指向新链表的最前端
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            //让cur后移
            cur = nextNode;
        }
        //将head.next指向reverseNode.next;
        head.next = reverseHead.next;
    }

    /**
     * 利用栈逆序打印单链表
     */
    public static void reversePrint(HeroNode head) {
        //空链表，不能打印
        if (head.next == null) {
            return;
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        //用于辅助遍历的节点
        HeroNode cur = head.next;
        //将单链表所有的有效节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //弹栈并打印节点
        while (stack.size() > 0) {
            //stack 栈的特点是先进后出
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个单链表，合并后的链表仍然有序
     * @param head1
     * @param head2
     * @return
     */
    public static  SingleLinkedList mergeList(HeroNode head1, HeroNode head2){
        return null;
            }

}