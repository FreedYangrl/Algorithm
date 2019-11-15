package November_2019;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 K 个排序链表
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    /**
     * 时间复杂度：O(Nlog⁡k)，这里 N 是这 𝑘 个链表的结点总数，每一次从一个优先队列中选出一个最小结点的时间复杂度是 O(log⁡k)，
     * 故时间复杂度为O(Nlog⁡k)。
     *
     * 空间复杂度：O(k)，使用优先队列需要 k 个空间，“穿针引线”需要常数个空间，因此空间复杂度为 O(k)。
     * @param lists
     * @return
     */
    public static ListNode method1(ListNode[] lists ){
        int len =lists.length;
        if(len==0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(len, Comparator.comparingInt(a ->a.value));
        ListNode dummyNode =new ListNode(-1);
        ListNode curNode =dummyNode;
        for(ListNode list : lists){
            if (list != null){
                priorityQueue.add(list);
            }
        }
        while(! priorityQueue.isEmpty()){
            ListNode node =priorityQueue.poll();
            curNode.next=node;
            curNode=curNode.next;
            if(curNode.next !=null){
                priorityQueue.add(curNode.next);
            }

        }
        return dummyNode.next;
    }

    /**
     * 如果我们不想“穿针引线”，那么“递归”、“分治”是一个不错的选择。
     *
     * 代码结构和“归并排序”可以说是同出一辙：
     *
     * 1、先一分为二，分别“递归地”解决了与原问题同结构，但规模更小的两个子问题；
     *
     * 2、再考虑如何合并，这个合并的过程也是一个递归方法。
     * @param lists
     * @return
     *
     *
     * 时间复杂度：O(Nlog⁡k)，这里 N 是这 k 个链表的结点总数，k 个链表二分是对数级别的。
     *
     * 空间复杂度：O(n)，合并两个排序链表需要“穿针引线”的指针数是常数个的。
     */

    public static ListNode mergeKLists(ListNode[] lists){
        int len =lists.length;
        if(len==0){
            return null;
        }
        return mergeKLists(lists,0,len-1);
    }
    public static ListNode mergeKLists(ListNode[] lists,int l,int r){
        //  思考这里为什么取等于？这是因为根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (l==r){
            return lists[1];
        }
        int mid =l+((r-l)>>1);
        ListNode l1=mergeKLists(lists,l,mid);
        ListNode l2=mergeKLists(lists,mid+1,r);
        return mergeTwoSortedListNode(l1,l2);
    }

    public static  ListNode mergeTwoSortedListNode(ListNode l1,ListNode l2){
        if(l1==null){
            return  l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.value<l2.value){
            l1.next=mergeTwoSortedListNode(l1.next,l2);
            return l1;
        }
        l2.next=mergeTwoSortedListNode(l1,l2.next);
        return l2;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        ListNode l3=new ListNode(2);
        l3.next=new ListNode(6);
        ListNode[] lists=new ListNode[3];
        lists[0]=l1;
        lists[1]=l2;
        lists[2]=l3;
        ListNode cur=method1(lists);
        while (cur !=null){
            System.out.print(cur.value+" ");
            cur=cur.next;
        }
    }
}
