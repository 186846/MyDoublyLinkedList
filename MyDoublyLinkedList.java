package 第二周作业.MyDoublyLinkedList;

/**
 * 基于双向链表实现元素存取的容器
 */
public class MyDoublyLinkedList<E> implements MyList<E> {
    private Node head; //记录头节点
    private Node tail; //记录尾节点
    private int size; //记录元素个数

     //功能一。向双向链表中添加元素的方法

    @Override
    public void add(E element) {
        this.linkLast(element);
    }
     // 将节点对象添加到双向链表的尾部

    private void linkLast(E element){
        final Node l = tail;
        final Node<E> newNode = new Node<>(l,element,null);
        tail = newNode;
        if(l ==null){
            head = newNode;
        }
         else
             l.next = newNode;
         this.size++;
    }
    //功能二。根据指定位置获取元素
    @Override
    public E get(int index) {
        //对 Index 做合法性校验
        this.checkIndex(index);
        //根据位置查找节点对象
        Node<E> node = this.getNode(index);
        return node.item;
    }
     // 校验 Index 的合法性

    private void checkIndex(int index){
        if(!(index >= 0 && index < this.size)){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
    }
    //根据位置获取指定节点对象
    private Node getNode(int index) {
     //判断当前位置距离头或者尾哪个节点更近
        if (index < (this.size >> 1))
        {
            Node node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
     Node node = this.tail;
     for (int i = this.size - 1; i > index; i--) {
            node = node.prev;}
     return node;
        }
    }


    //功能三。返回元素的个数
    @Override
    public int size() {
        return this.size;
    }


     // 功能四。根据指定位置删除元素
    @Override
    public E remove(int index) {
        //对 Index 进行合法性校验
        this.checkIndex(index);
        //根据指定位置获取节点对象
        Node<E> node = this.getNode(index);
        //获取节点对象中的元素
        E item = node.item;
        //判断当前节点是否为头节点
        if(node.prev ==null){
            this.head = node.next;
        }else{
        //完成当前节点的直接前驱节点与当前节点的直接后继节点的挂接
            node.prev.next = node.next;
        }
        //判断当前节点是否为尾节点
        if(node.next == null){
            this.tail = node.prev;
        }else{
        //完成当前节点的直接后继节点与当前节点的直接前驱节点的挂接
            node.next.prev = node.prev;
        }
        //当前节点断掉与它直接前驱节点的连接
        node.prev = null;
        //当前节点断掉与它直接后继节点的连接
        node.next = null;
        node.item = null;
        //记录元素个数
        this.size--;
        return item;
    }

    //功能五。在指定的位置插入元素
    public void insert(int index,E e){
        if(index==0){
            Node<E> E = new Node<>(null,e,null);
            E.prev = head.next;
            head.next.prev = E;
            head.next = E;
            E.prev = head;
            this.size++;
        }else if (index>0&&index<=this.size){
            Node<E> E = new Node<E>(null,e,null);
            Node t = head.next;
            for (int i=0;i<index;i++){
                t = t.next;
            }
            E.prev = t.prev;
            t.prev.next = E;
            t.prev = E;
            E.next = t;
            this.size++;
        }
        else {
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
    }


    //功能六。对链表进行遍历
    public void Look(MyDoublyLinkedList<E> e){
        if (e.head==null){
            System.out.println("该链表为空!");
        }
        else {
            System.out.println(e.head.getItem());
            for (Node t = e.head;t.next!=null;){
                t = t.next;
                System.out.println(t.getItem());
            }
        }
    }


    //功能七。翻转链表
    public void reserve(){
        //判断链表是否为空
        if(this.size ==0){
            System.out.println("该链表为空，请填入元素在进行此操作！");
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node node){
        if (node.next == null){
            head.next = node;
            return node;
        }
        //递归的反转当前节点的下一个节点，返回值就是链表反转后当前节点的上一个节点
        Node pre = reverse(node.next);
        //让返回的节点的下一个节点变成node
        pre.next = node;
        //把当前节点的下一个节点变为null
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.Look(list);
        System.out.println("---------------------------------");
        list.reserve();
        list.Look(list);
        System.out.println("-----------------------");
        list.remove(2);
        list.size();
        list.insert(1,8);
        list.get(1);
    }
}