package cn.edu.wdu.linkedlist.singlelinkedlist;

/**
 * @author gaojie  gao4433@qq.com
 * @version JDK11
 * @since 2021/10/10 11:16
 */
public class SingleLinkedList {

    /**先初始化一个头节点, 头节点不要动, 不存放具体的数据**/
    private HeroNode head = new HeroNode(0, "", "");

    /**返回头节点**/
    public HeroNode getHead() {
        return head;
    }

    /**
     *  在链表末尾添加节点
     *  1.找到当前链表的最后节点
     *  2.将最后这个节点的next指向新的节点
     * @param newheroNode
     */
    public void add(HeroNode newheroNode) {
        //【head】节点不能动，需要一个辅助遍历的节点【temp】
        HeroNode temp = head;
        //遍历链表，找到最后节点
        while(true) {
            //找到链表的最后节点
            if(temp.next == null) {
                break;
            }
            //如果没有找到, 将【temp】节点后移
            temp = temp.next;
        }
        //退出while循环时，【temp】就指向了链表的最后
        //将最后这个节点指向新的节点
        temp.next = newheroNode;
    }

    /**
     * 添加指定编号（排名）的英雄节点
     * 如果这个编号的节点已经存在，则添加失败，给出提示
     * @param newHeroNode
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
            //插入到链表中, 【temp】的后面
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        }
    }

    /**
     * 修改指定编号的节点的信息（数据域）
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        //判断链表是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //用来定位目标节点的辅助节点
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        //遍历链表，找到要修改的节点
        while(true) {
            //已经遍历完链表
            if (temp == null) {
                break;
            }
            if(temp.no == newHeroNode.no) {
                //要修改的目标节点找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            //没有找到
            System.out.printf("找不到编号为 %d 的英雄，无法修改！\n", newHeroNode.no);
        }
    }

    /**
     * 删除指定编号的节点
     * head不能动，因此我们需要一个【temp】辅助节点找到待删除节点的前一个节点
     * 在比较时，是 temp.next.no 和 需要删除的节点的no 比较
     * @param no
     */
    public void del(int no) {
        HeroNode temp = head;
        // 标志是否找到待删除节点的前一个节点
        boolean flag = false;
        while(true) {
            //已经遍历到链表最后
            if(temp.next == null) {
                break;
            }
            //找到了待删除节点的前一个节点【temp】
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            //temp后移，继续遍历
            temp = temp.next;
        }
        ////找到，可以删除
        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的编号为 %d 的英雄不存在!\n", no);
        }
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
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
