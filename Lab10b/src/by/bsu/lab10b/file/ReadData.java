package by.bsu.lab10b.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadData {

    private final String DIR_NAME;

    private final String FILE_NAME;

    public ReadData(String DIR_NAME, String FILE_NAME) {
        this.DIR_NAME = DIR_NAME;
        this.FILE_NAME = FILE_NAME;
    }

    private <T> ArrayList<T> getArrayListFromStream(Stream<T> stream) {
        return stream.collect(Collectors.toCollection(ArrayList::new));
    }

    private String getFullPathToFile() {
        String FILE_EXTENSION = ".txt";
        return DIR_NAME + File.separator + FILE_NAME + FILE_EXTENSION;
    }

    public List<Integer> readFromFile(){
        List<Integer> list = new ArrayList<>();
        List<String> listStrings = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(getFullPathToFile()))) {
            listStrings = getArrayListFromStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str : listStrings) {
            if(!str.isEmpty()) {
                String []s = str.split(" ");
                for (String sub : s) {
                    if(Integer.parseInt(sub) != 0) {
                        list.add(Integer.parseInt(sub));
                    }
                }
            }
        }
        return list;
    }
}
