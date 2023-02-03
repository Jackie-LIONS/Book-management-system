package com.pratice.通讯录管理系统.存储;

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
