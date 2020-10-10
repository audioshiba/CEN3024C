import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestClass {

    public static void main(String[] args) throws Exception {

        //Setting filepath and creating string of file
        Path fileName = Path.of("theRaven.html");
        String htmlIncluded = Files.readString(fileName);
        htmlIncluded = htmlIncluded.replace("\n", "").replace("\r", "");


        String noHTML = htmlIncluded.replaceAll("\\<.*?>", " "); //removes HTML tags
        String noDash = noHTML.replaceAll("&mdash", " "); //removes mdash
        String noHyphen = noDash.replaceAll("--", " "); //removes dashes
        String noFluff = noHyphen.replaceAll("\\p{Punct}", " "); //removes all punctuation

        List<String> poemList = new ArrayList<>(List.of(noFluff.split(" "))); //creating mutable list from array

        poemList.removeIf(String::isBlank);
        poemList.replaceAll(String::trim);
        poemList.replaceAll(String::toLowerCase);

        int start = 0;
        int end = 0;

        //using for-loop to find the start and end points of the poem
        for(int i = 0; i < poemList.size(); i++){
            if((poemList.get(i).equals("the")) && (poemList.get(i+7).equals("upon"))){
                start = i; //getting start point for poem
            }//end if
            if((poemList.get(i).equals("floor")) && (poemList.get(i+4).equals("nevermore"))){
                end = i+3; //getting end point for poem
            }//end if
        }//end for

        List<String> freqList = poemList.subList(start, (end+2));//creating a sublist of only the actual poem

        Set<String> wordSet = new TreeSet<String>(freqList); //creates a set of all words in the poem, no duplicates
        ArrayList<Words> wordObjList = new ArrayList<Words>(); //list of Words objects

        for(String key : wordSet) {
            wordObjList.add(new Words(key, Collections.frequency(freqList, key))); //creating word objects
        }//end for

        wordObjList.sort(Words::compareTo);//sorting Words objects by their compareTo values

        for(Words word : wordObjList){
            System.out.println(word.toString());
        }//end for


    }//end main


}//end TestClass
