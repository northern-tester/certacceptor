package com.url;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by awi40 on 18/11/2016.
 */
public class urlProcessor {

    public File file;

    public urlProcessor(String validFilename) {
        file = new File(validFilename);
    }

    public String getFileName() {
        return file.getAbsolutePath();
    }

    public ArrayList<String> getProcessedList() {
        return processedList;
    }
}
