package Interface.com.dao;

import Interface.com.contrl.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadPakegeJson {

    /**
     * 读取json文件
     */
    public static String readJsonFile(String path) throws Exception {
        String laststrJson = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(path)));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                laststrJson = laststrJson + tempString;
                line++;
            }
            reader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return laststrJson;
    }

}
