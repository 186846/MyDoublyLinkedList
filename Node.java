package �ڶ�����ҵ.MyDoublyLinkedList;

class Node<E>{
    E item;//��¼Ԫ��
    Node prev;//��¼ǰһ���ڵ����
    Node next;//��¼��һ���ڵ����
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
