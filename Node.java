package secod.MyDoublyLinkedList;

class Node<E>{
    E item;//记录元素
    Node prev;//记录前一个节点对象
    Node next;//记录下一个节点对象
    public Node(Node<E> prev,E item,Node<E> next){
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
    public Node() {
    }
    public E getItem(){
        return this.item;
    }
}
