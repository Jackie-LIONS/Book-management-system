# 通讯录管理系统

# 一.  🦁 项目描述 
该项目是用于日常生活中记录联系人信息的一款智能小工具。实现了对联系人的姓名、年龄、性别、电话号码、住址的添加及修改、查找、删除、排序等功能。该项目是以 Windows 控制台为运行平台，所有的操作都应在控制台上进行。
# 二. 🦁编写目的
通过该项目将平时所学的内容综合到一起并运用到实际的项目中。并且通过实现自己实现的数据结构来实现存储和持久化处理（老师不给用集合，自己实现一个数据结构来存储）
该项目能够充分的体现出一些简单的业务流程处理，能够使同学们掌握基本的业务流程处理。进一步理解什么是`面相对象设计(OOD：Object Oriented Design)`。充分理解面向对象设计的精髓。
`总的来说，就是要完成作业。`
# 三. 🦁技术说明
## 3.1 业务流程结构图
![输入图片说明](https://foruda.gitee.com/images/1702801051024080208/fcac913b_10961261.png "屏幕截图")


## 3.2 数据存储结构
|id|序号  |
|--|--|
| name |姓名  |
|age|年龄|
|sex|性别  |
|telNum|电话号码|
| address|地址 |

## 3.3 技术要求及开发环境
 - JDK 版本为 11
- 键盘输入 Scanner 类
- 正则表达式 Pattern 类
- 自编写数据结构LinkedList
- Windows 10 & idea 2020

# 四. 🦁项目开发
## 4.1 创建菜单类
>进入每个功能模块，用户都有清晰的功能选择。还有返回上一层，降低了代码的耦合性。
```java
public class Menus {
        //主界面
        public void mainMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 添加记录        **");
            System.out.println("**         2 查找记录        **");
            System.out.println("**         3 修改记录        **");
            System.out.println("**         4 删除记录        **");
            System.out.println("**         5 排序记录        **");
            System.out.println("**         6 退出系统        **");
            System.out.println("--------------⭐------------");
        }
        //添加界面
        public void addMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 添加新记录     **");
            System.out.println("**         2 查看全记录     **");
            System.out.println("**         3 返回上一级     **");
            System.out.println("--------------⭐------------");
        }
        //查找界面
        public void searchMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 按姓名查找    **");
            System.out.println("**         2 按年龄查找    **");
            System.out.println("**         3 按性别查找    **");
            System.out.println("**         4 按号码查找    **");
            System.out.println("**         5 按住址查找    **");
            System.out.println("**         6 查看全记录    **");
            System.out.println("**         7 返回上一级    **");
            System.out.println("--------------⭐------------");
        }
        //修改界面
        public void modifyMenu(){
            System.out.println("---------------⭐------------");
            System.out.println("**         1 查看全记录    **");
            System.out.println("**         2 修改指定记    **");
            System.out.println("**         3 返回上一级    **");
            System.out.println("--------------⭐------------");
        }
        //修改子界面
        public void subModifyMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 修改姓名    **");
            System.out.println("**         2 修改年龄    **");
            System.out.println("**         3 修改性别    **");
            System.out.println("**         4 修改号码    **");
            System.out.println("**         5 修改住址    **");
            System.out.println("**         6 返回上一级   **");
            System.out.println("--------------⭐------------");
        }
        //删除界面
        public void deleteMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 查看全部记录  **");
            System.out.println("**         2 删除指定记录  **");
            System.out.println("**         3 删除全部记录  **");
            System.out.println("**         4 返回上一级    **");
            System.out.println("--------------⭐------------");
        }
        //排序界面
        public void orderMenu(){
            System.out.println("--------------⭐------------");
            System.out.println("**         1 按姓名排序  **");
            System.out.println("**         2 按年龄排序  **");
            System.out.println("**         3 按性别排序  **");
            System.out.println("**         4 查看全部记录 **");
            System.out.println("**         5 返回上一级  **");
            System.out.println("--------------⭐------------");
        }
}

```
![输入图片说明](https://foruda.gitee.com/images/1702801015743980193/adb3927f_10961261.png "屏幕截图")
## 4.2 创建实体类
```java
import java.io.Serializable;
public class Users implements Serializable {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String telNum;
    private String address;

    public Users() {
    }
    public Users(String name, int age, String sex, String telNum, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\tname: " + name  +
                " age:  " + age  +
                " sex:  " + sex  +
                " telNum:   " + telNum  +
                " address:  " + address  +"\t\t";
    }
}

```
## 4.3 创建数据校验类
>数据校验类是为了避免在使用过程，用户输入错误的数据又跳转了，导致系统出错。

```java
import java.util.Scanner;
public class Varify {
    Scanner S = new Scanner(System.in);
    /**
     * 校验主菜单
     * @param min
     * @param max
     * @return int
     */
    public int menuVarify(int min,int max){         //菜单选项验证
        String str1 = "\\d";
        while(true){
            System.out.println("最小为"+min+","+"最大为"+max+";"+"请输入您的选择：");
            String input = S.nextLine();
            if(input.matches(str1)){
                int num = Integer.parseInt(input);
                if(num >=min&&num<=max){
                    return num;
                }else{
                    System.out.println("请输入有效数字！！！");
                }
            }else{
                System.out.println("您的输入有误，请重新输入！！！");
            }
        }
    }

    /**
     * 校验名字
     * 汉字或者字母
     * @return name
     */
    public String nameVarity(){
        String str = "[A-Za-z\\u4e00-\\u9fa5]{1,10}";
        while (true){
            System.out.println("请输入您的名字（中文/英文）：");
            String name = S.nextLine();
            if(name.matches(str)){
                return name;
            }else{
                System.out.println("您的输入有误，请重新输入!");
            }
        }
    }

    /**
     *
     * @return
     */
    public int ageVarity(){
        String str = "\\d{0,125}";
        while(true){
            System.out.println("请输入您的年龄：(0-125)");
            String age = S.nextLine();
            if(age.matches(str)){
                return Integer.parseInt(age);
            }else{
                System.out.println("输入有误，请重新输入!");
            }
        }
    }
    public String sexVarity(){
        String str = "[男|女]{1}";
        while(true){
            System.out.println("请输入您的性别：（男/女）");
            String sex = S.nextLine();
            if(sex.matches(str)){
                return sex;
            }else{
                System.out.println("输入有误，请重新输入！");
            }
        }
    }
    public String tellNumVarity(){
        String str = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        while(true){
            System.out.println("请输入电话号码或者座机号码：");
            String inputNum = S.nextLine();
            if(inputNum .matches(str)){
                return inputNum;
            }else{
                System.out.println("您输入的电话号码有误，请重新输入：");
            }
        }
    }
    public String addressVarity(){
        String str = "[a-zA-Z\\u4e00-\\u9fa5]{1,50}";
        while(true){
            System.out.println("请输入地址：字母或者汉字");
            String inputName = S.nextLine();
            if(inputName.matches(str)){
                return inputName;
            }else{
                System.out.println("您输入的地址有误，请重新输入：");
            }
        }
    }
}

```
## 4.4 创建双向链表
>这个是模仿LinkedList的双向链表，里面有基本添加，删除，清空链表功能。
```java
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
```
## 4.5 创建持久层文件处理
>创建一个IoUtil包，封装好了读取文件方法，和将数据写入文件的方法，专门进行文件的读取和写入，简化了在使用过程中，创建输入输出流的繁琐步骤，加快了生产效率。
```java
import java.io.*;

/**
 * 文件读取
 */
public class IoUtil {
    /**
     * 读取文件
     * @param fileName
     * @return
     * @throws IOException
     */
  	public static  Object readFile(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
  	public static void writeFile(Object obj,String fileName) throws IOException {
      		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
      		objectOutputStream.writeObject(obj);
  }
}

```
## 4.6 创建正则表达式
>`tips`:
>正则表达式是对字符串操作的一种逻辑公式，就是用事先定义好的一些特定字符、及这些特定字符的组合，组成一个“规则字符串”，这个“规则字符串”用来表达对字符串的一种过滤逻辑。使用特殊语法来表示字符类、数量限定符和位置关系,然后用这些特殊语法和普通字符一起表示一个模式。

这里的校验类有很多种，分别有主菜单的校验，名字的校验，年龄输入的校验，电话号码是否输入正确的校验，还有地址的校验。实现详情请看以下代码：
```java
import java.util.Scanner;
public class Varify {
    Scanner S = new Scanner(System.in);
    /**
     * 校验主菜单
     * @param min
     * @param max
     * @return int
     */
    public int menuVarify(int min,int max){         //菜单选项验证
        String str1 = "\\d";
        while(true){
            System.out.println("最小为"+min+","+"最大为"+max+";"+"请输入您的选择：");
            String input = S.nextLine();
            if(input.matches(str1)){
                int num = Integer.parseInt(input);
                if(num >=min&&num<=max){
                    return num;
                }else{
                    System.out.println("请输入有效数字！！！");
                }
            }else{
                System.out.println("您的输入有误，请重新输入！！！");
            }
        }
    }

    /**
     * 校验名字
     * 汉字或者字母
     * @return name
     */
    public String nameVarity(){
        String str = "[A-Za-z\\u4e00-\\u9fa5]{1,10}";
        while (true){
            System.out.println("请输入您的名字（中文/英文）：");
            String name = S.nextLine();
            if(name.matches(str)){
                return name;
            }else{
                System.out.println("您的输入有误，请重新输入!");
            }
        }
    }

    /**
     *
     * @return
     */
    public int ageVarity(){
        String str = "\\d{0,125}";
        while(true){
            System.out.println("请输入您的年龄：(0-125)");
            String age = S.nextLine();
            if(age.matches(str)){
                return Integer.parseInt(age);
            }else{
                System.out.println("输入有误，请重新输入!");
            }
        }
    }
    public String sexVarity(){
        String str = "[男|女]{1}";
        while(true){
            System.out.println("请输入您的性别：（男/女）");
            String sex = S.nextLine();
            if(sex.matches(str)){
                return sex;
            }else{
                System.out.println("输入有误，请重新输入！");
            }
        }
    }
    public String tellNumVarity(){
        String str = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        while(true){
            System.out.println("请输入电话号码或者座机号码：");
            String inputNum = S.nextLine();
            if(inputNum .matches(str)){
                return inputNum;
            }else{
                System.out.println("您输入的电话号码有误，请重新输入：");
            }
        }
    }
    public String addressVarity(){
        String str = "[a-zA-Z\\u4e00-\\u9fa5]{1,50}";
        while(true){
            System.out.println("请输入地址：字母或者汉字");
            String inputName = S.nextLine();
            if(inputName.matches(str)){
                return inputName;
            }else{
                System.out.println("您输入的地址有误，请重新输入：");
            }
        }
    }
}

```

## 4.7 创建用户业务层
功能太多，但是较为简单，就不一一阐述。
# 五. 🦁总结 
一个跟数据结构挂钩的期末实验，功能实现并不复杂，接近crud，但是构造整体框架很复杂，花费了很多精力去打磨。唯一一个难点就是双向链表的编写；还有就是正则表达式的使用不够熟练，查询了很多资料，才知道如何去使用。`给大家介绍了一个很简单的Java小项目入门，希望大家喜欢。`
项目已经开源到git，感兴趣的小伙伴点击：[下载](https://gitee.com/jackie_Ye/address-book-management-system.git)
