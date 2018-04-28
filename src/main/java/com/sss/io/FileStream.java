package com.sss.io;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileStream {

    public static void a(){

        try {
            FileInputStream is = new FileInputStream(new File("d:/a.txt"));
            FileOutputStream os = new FileOutputStream(new File("d:/b.txt"));

            FileInputStream is2 = new FileInputStream(new File("d:/a.txt"));
            FileOutputStream os2 = new FileOutputStream(new File("d:/c.txt"));

            byte[] length = new byte[1024];

            try {
                while (is.read(length) != -1){
                    os.write(length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                is.close();
                os.flush();
                os.close();
            }


            IOUtils.copy(is2,os2);
            IOUtils.closeQuietly(is2);
            IOUtils.closeQuietly(os2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        a();
    }
}
