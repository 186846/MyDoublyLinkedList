package �ڶ�����ҵ.MyDoublyLinkedList;

/**
 * ��������ṹ��ȡԪ�صķ��� API ����
 * @param <E>
 */
public interface MyList<E> {
    void add(E element);
    E get(int index);
    int size();
    E remove(int index);
}