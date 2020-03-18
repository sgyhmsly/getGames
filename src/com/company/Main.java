package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String patha = "d:/game";
        //String patha = "D:/javaProject";
        String pathb = "h:/game";
        //String pathb = "D:\\javaProject\\selectGames";

        String pathc = "g:/";
        String txtFile = "H:/game/gamelists.txt";
        List list = new ArrayList();
        list.add("diablo3");
        getLists(patha,list);
        getLists(pathb,list);
        getTextLists(txtFile,list);
        int count = list.size();
        Random random = new Random();
        for (int j = 0; j < 5; j++)
        {
            int num = random.nextInt(count -1);
            System.out.println(list.toArray()[num]);

        }
        System.out.println(list.toArray().length);

    }
    private static void getLists(String pathx, List listx)
    {
        File file = new File(pathx);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        for (int i =0; i<directories.length;i++)
        {
            listx.add(directories[i]);
        }
    }

    private static void getTextLists(String pathx, List listx)
    {
        try {
            File myObj = new File(pathx);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listx.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
