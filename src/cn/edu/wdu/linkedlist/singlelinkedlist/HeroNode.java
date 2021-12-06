package cn.edu.wdu.linkedlist.singlelinkedlist;

/**
 * @author 高杰
 */
public class HeroNode {
	public int no;
	public String name;
	public String nickname;
	/**指向下一个节点**/
	public HeroNode next;
	/**构造器**/
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	/**
	 * 为了显示方便，我们重写toString
	 */
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}
