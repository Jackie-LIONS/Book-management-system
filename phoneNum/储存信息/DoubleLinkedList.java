package com.pratice.通讯录管理系统.储存信息;
import java.io.Serializable;

public class DoubleLinkedList<E> implements ListInterface<E>, Serializable {
    private Node<E> headNode;       //记录头结点
    private Node<E> tailNode;       //记录尾结点
    private int size;               //记录结点数
    public int getSize() {
        return size;
    }

    /**
     * 定义结点类
     * @param <E>
     */
    class Node<E> implements Serializable{
         Node prevNode;             //前
         E element;                 //记录元素
         Node next;                 //后

        public Node(Node prevNode, E element, Node next) {
            this.prevNode = prevNode;
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this.element = element;
        }
    }

    private void addNode(E element){
        Node t = this.tailNode;
        Node node = new Node(t,element,null);
        this.tailNode = node;
        if(t == null){
            this.headNode = node;
        }else{
            t.next = node;
        }
        this.size++;
    }

    /**
     * 添加元素
     * @param element
     */
    @Override
    public void add(E element) {
        this.addNode(element);
    }
    private Node getNode(int index){
        if(index <= (this.size>>1)){
            Node node = this.headNode;
            for(int i = 0;i<index;i++){
                node = node.next;
            }
            return node;
        }
        else{
           Node node = this.tailNode;
            for(int i = this.size-1;i>index;i--){
                node = node.prevNode;
            }
            return node;
        }
    }

    /**
     * 在指定位置添加元素
     * @param index
     * @param element
     */
    @Override
    public  void add(int index,E element){
        if(index < 0||index >=this.size){
            throw new IndexOutOfBoundsException("下标不合法："+index);
        }
        Node<E> node = new Node(element);
        if(index == 0){
            node.next = this.headNode;
            this.headNode.prevNode = node;
            this.headNode = node;
        }else if(index+1 == this.size){
            this.tailNode.next = node;
            node.prevNode = tailNode;
            this.tailNode = node;
        }else{
            Node<E> temp = this.getNode(index-1);
            node.next = temp.next;
            temp.prevNode = node;
            temp.next = node;
            node.prevNode = temp;
        }
        this.size++;
    }

    /**
     * 根据下标添加元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if(index < 0||index >=this.size){
            throw new IndexOutOfBoundsException("下标不合法："+index);
        }
      Node<E> node = this.getNode(index);
        return node.element;
    }

    @Override               //删除元素
    public boolean remove(int index) {
        if(index <0||index >=this.size){
            throw new IndexOutOfBoundsException("下标不合法："+index);
        }
        Node<E> node = this.getNode(index);
        if(node.prevNode == null){
            this.headNode = node.next;
        }else{
            node.prevNode.next = node.next;
        }

        if(node.next == null){
            this.tailNode = node.prevNode;
        } else{
            node.next.prevNode = node.prevNode;

        }
        node.prevNode = null;
        this.size--;
        return true;
    }
    @Override               //清空所有元素
    public boolean removeAll(){
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
        return true;
    }

}
