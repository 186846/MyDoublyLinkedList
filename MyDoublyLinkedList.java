package �ڶ�����ҵ.MyDoublyLinkedList;

/**
 * ����˫������ʵ��Ԫ�ش�ȡ������
 */
public class MyDoublyLinkedList<E> implements MyList<E> {
    private Node head; //��¼ͷ�ڵ�
    private Node tail; //��¼β�ڵ�
    private int size; //��¼Ԫ�ظ���

     //����һ����˫�����������Ԫ�صķ���

    @Override
    public void add(E element) {
        this.linkLast(element);
    }
     // ���ڵ������ӵ�˫�������β��

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
    //���ܶ�������ָ��λ�û�ȡԪ��
    @Override
    public E get(int index) {
        //�� Index ���Ϸ���У��
        this.checkIndex(index);
        //����λ�ò��ҽڵ����
        Node<E> node = this.getNode(index);
        return node.item;
    }
     // У�� Index �ĺϷ���

    private void checkIndex(int index){
        if(!(index >= 0 && index < this.size)){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
    }
    //����λ�û�ȡָ���ڵ����
    private Node getNode(int index) {
     //�жϵ�ǰλ�þ���ͷ����β�ĸ��ڵ����
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


    //������������Ԫ�صĸ���
    @Override
    public int size() {
        return this.size;
    }


     // �����ġ�����ָ��λ��ɾ��Ԫ��
    @Override
    public E remove(int index) {
        //�� Index ���кϷ���У��
        this.checkIndex(index);
        //����ָ��λ�û�ȡ�ڵ����
        Node<E> node = this.getNode(index);
        //��ȡ�ڵ�����е�Ԫ��
        E item = node.item;
        //�жϵ�ǰ�ڵ��Ƿ�Ϊͷ�ڵ�
        if(node.prev ==null){
            this.head = node.next;
        }else{
        //��ɵ�ǰ�ڵ��ֱ��ǰ���ڵ��뵱ǰ�ڵ��ֱ�Ӻ�̽ڵ�Ĺҽ�
            node.prev.next = node.next;
        }
        //�жϵ�ǰ�ڵ��Ƿ�Ϊβ�ڵ�
        if(node.next == null){
            this.tail = node.prev;
        }else{
        //��ɵ�ǰ�ڵ��ֱ�Ӻ�̽ڵ��뵱ǰ�ڵ��ֱ��ǰ���ڵ�Ĺҽ�
            node.next.prev = node.prev;
        }
        //��ǰ�ڵ�ϵ�����ֱ��ǰ���ڵ������
        node.prev = null;
        //��ǰ�ڵ�ϵ�����ֱ�Ӻ�̽ڵ������
        node.next = null;
        node.item = null;
        //��¼Ԫ�ظ���
        this.size--;
        return item;
    }

    //�����塣��ָ����λ�ò���Ԫ��
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


    //����������������б���
    public void Look(MyDoublyLinkedList<E> e){
        if (e.head==null){
            System.out.println("������Ϊ��!");
        }
        else {
            System.out.println(e.head.getItem());
            for (Node t = e.head;t.next!=null;){
                t = t.next;
                System.out.println(t.getItem());
            }
        }
    }


    //�����ߡ���ת����
    public void reserve(){
        //�ж������Ƿ�Ϊ��
        if(this.size ==0){
            System.out.println("������Ϊ�գ�������Ԫ���ڽ��д˲�����");
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node node){
        if (node.next == null){
            head.next = node;
            return node;
        }
        //�ݹ�ķ�ת��ǰ�ڵ����һ���ڵ㣬����ֵ��������ת��ǰ�ڵ����һ���ڵ�
        Node pre = reverse(node.next);
        //�÷��صĽڵ����һ���ڵ���node
        pre.next = node;
        //�ѵ�ǰ�ڵ����һ���ڵ��Ϊnull
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