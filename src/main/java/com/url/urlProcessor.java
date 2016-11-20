package com.url;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by awi40 on 18/11/2016.
 */
public class urlProcessor {

    public File file;
    public ArrayList<URL> processedList;

    public urlProcessor(String validFilename) {
        file = new File(validFilename);
    }

    public String getFileName() {
        return file.getAbsolutePath();
    }

    public ArrayList<URL> getProcessedList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        processedList = new ArrayList<URL>();
        while(true){
            String nextLine = br.readLine();
            if(nextLine == null) break;
            URL nextURL = new URL(nextLine);
            processedList.add(nextURL);
        }
        return processedList;
    }
}
