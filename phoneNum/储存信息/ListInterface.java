package com.pratice.通讯录管理系统.储存信息;

public interface ListInterface<E>{
     void add(E element);
     void add(int index, E element);
     E get(int index);
     boolean remove(int index);
     boolean removeAll();

}
