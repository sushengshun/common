package com.sss.io;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class IOUtilsTest {


    public static void  a(){
        File file = new File("d:/a.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
            System.out.println(IOUtils.toString(stream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  b(){
        try {
            URL url = new URL("file:/d:/a.txt");
            System.out.println(IOUtils.toString(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //IOUtilsTest.a();
        IOUtilsTest.b();
    }

}
