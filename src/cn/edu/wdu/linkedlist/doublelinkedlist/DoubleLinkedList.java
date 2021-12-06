package cn.edu.wdu.linkedlist.doublelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 模拟循环双向链表，实现增删改查的功能
 * @date 2021/11/13 19:37
 * @since 1.8
 */
public class DoubleLinkedList {
    /**
     * 初始化一个头节点, 头节点不能动不要, 不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 返回头节点
     */
    public HeroNode getHead() {
        return head;
    }

    /**
     * 遍历打印双向链表
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移，一定小心
            temp = temp.next;
        }
    }

    /**
     * 添加节点到双向链表的最后
     * 这里我们的链表是非循环双向链表
     * @param heroNode [in] 传入链表的头节点
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后, 继续将temp后移
            temp = temp.next;
        } //当退出while循环时，temp就指向了链表的最后
        // 让新添加节点成为最后一个结点的后继
        temp.next = heroNode;
        // 让最后一个结点成为新添加节点的前驱
        heroNode.pre = temp;
    }

    /**
     * 添加英雄节点到链表中间的指定位置（编号）
     * 如果这个编号的节点已经存在，则添加失败，给出提示
     * @param newHeroNode [in] 要添加的结点
     */
    public void addByOrder(HeroNode newHeroNode) {
        //头节点不能动，通过一个辅助指针(变量)来帮助找到添加的位置
        //【temp】是添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        // flag 标志要添加编号的节点是否存在，默认为false
        boolean flag = false;
        while(true) {
            //说明【temp】已经在链表的最后
            if(temp.next == null) {
                break;
            }
            //位置找到，就在【temp】的后面插入
            if(temp.next.no > newHeroNode.no) {
                break;
            } else if (temp.next.no == newHeroNode.no) {
                //说明希望添加的编号的【heroNode】已然存在
                flag = true;
                break;
            }
            //后移，遍历当前链表，逐个比较【heroNode】的编号
            temp = temp.next;
        }
        //该编号的节点已经存在，不能添加
        if(flag) {
            System.out.printf("准备插入的编号为 %d 的英雄已经存在, 无法再加入!\n", newHeroNode.no);
        } else {
            //让前一个节点成为新节点的前驱
            newHeroNode.pre = temp;
            //让后面一个结点成为新节点的后继
            newHeroNode.next = temp.next;
            //让新节点成为后面一个节点的前驱
            temp.next.pre = newHeroNode;
            //让新结点成为前面一个节点的后继
            temp.next = newHeroNode;
        }
    }


    /**
     * 修改特定节点的内容
     * 双向链表的节点内容修改和单向链表一样
     * @param newHeroNode [in] 要修改成的节点
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 定义一个辅助遍历的变量
        HeroNode temp = head.next;
        // 标识是否找到该节点
        boolean flag = false;
        // 遍历链表，根据no找到需要修改的节点
        while (true) {
            if (temp == null) {
                break;
            } // 已经遍历完链表
            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag的值，判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 从双向链表中删除指定编号的节点
     * 对于双向链表，找到要删除的节点后，可以直接自我删除
     * 不必像单链表那样，需要利用前一个节点来删除
     * 注意我们这里的双向链表是非循环的
     * @param no [in] 要删除的节点的编号（no）
     */
    public void del(int no) {
        // 判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        // 辅助变量(指针)
        HeroNode temp = head.next;
        // 标志是否找到待删除节点的
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            } // 已经到链表的最后节点的next
            if (temp.no == no) {
                // 找到了的待删除节点（就是当前节点temp）
                flag = true;
                break;
            }
            // 没有找到，temp后移继续遍历
            temp = temp.next;
        } //遍历查找结束

        // 根据flag的值，判断是否存在要删除的节点
        if (flag) {
            // 可以删除
            temp.pre.next = temp.next;
            // 由于我们的链表是非循环的
            // 如果删除的是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * 查询指定编号的节点
     * @param no
     * @return
     */
    public HeroNode query(int no){
        //用来辅助遍历的节点
        HeroNode temp = head;
        while (true){
            //遍历完链表，没有找到该编号的节点
            if (temp.next == null){
                return null;
            }
            //找到目标编号的节点，就返回该节点
            if (temp.next.no == no){
                return temp.next;
            }
            temp = temp.next;
        }
    }
}

