package 第二周作业.MyDoublyLinkedList;

/**
 * 基于链表结构存取元素的方法 API 定义
 * @param <E>
 */
public interface MyList<E> {
    void add(E element);
    E get(int index);
    int size();
    E remove(int index);
}