package JSONopgave;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws IOException
    {

        File filePath =  new File("/Users/patrickmeitemogensen/IdeaProjects/JSONopg/src/main/java/JSONopgave/unece.json");
        Scanner scan = new Scanner(filePath);
        String str = "";
        while (scan.hasNextLine()){
            str = str + scan.nextLine();
        }
        System.out.println(str);
        JSONArray arr = new JSONArray(str);

        String str2 = "[";
        for (int i = 0; i < arr.length() ; i++) {
            JSONObject obj = arr.getJSONObject(i);


            System.out.println(obj.get("Country") + " " + obj.getString("Year") + " " + obj.get("Total population")  );
            str2 = str2 + "{\"Country\":\"" + obj.get("Country") + "\"," + "\"Year\":" +  obj.get("Year") + "," + "\"Total population\":" + obj.get("Total population") + "},";

        }
        str2 = str2.substring(0, str2.length() - 1) + "]";
        System.out.println(str2);

        File file = new File("/Users/patrickmeitemogensen/IdeaProjects/JSONopg/src/main/java/JSONopgave/new.json");


        FileWriter myWriter = new FileWriter(file);
        myWriter.write(str2);
        myWriter.close();
       // { "name":"John", "age":30},  { "name":"John", "age":30}



    }
}
