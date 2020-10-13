package com.gaga.designPatterns.decorator;

import java.io.*;

/**
 * @author liujia
 */
public class InputStreamTest {
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("23.txt")
                    )
            );
            byte[] bytes = new byte[dis.available()];
            dis.read(bytes);
            String content = new String(bytes);
            System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}