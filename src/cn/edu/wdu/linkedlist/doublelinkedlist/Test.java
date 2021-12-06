package cn.edu.wdu.linkedlist.doublelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 测试非循环双向链表的增删改查功能
 * @date 2021/11/14 21:00
 * @since 1.8
 */
public class Test {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //在链表末尾添加节点
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);

        //在链表中间添加指定编号的节点添加节点
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);

        System.out.println("-------------修改前的双向链表：");
        //遍历打印单链表中所有节点
        doubleLinkedList.list();

        //修改指定节点
        HeroNode hero5 = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(hero4);
        HeroNode hero6 = new HeroNode(5, "武松", "行者");
        doubleLinkedList.update(hero5);
        System.out.println("-------------修改后的双向链表：");
        //遍历打印单链表中所有节点
        doubleLinkedList.list();

        // 删除指定编号的结点
        doubleLinkedList.del(3);
        doubleLinkedList.del(5);
        System.out.println("-------------删除后的双向链表：");
        doubleLinkedList.list();

        //查询指定编号的结点
        System.out.println("-------------查询到的结点如下（null表示编号不存在）：");
        System.out.println(doubleLinkedList.query(4));
        System.out.println(doubleLinkedList.query(3));

    }
}
