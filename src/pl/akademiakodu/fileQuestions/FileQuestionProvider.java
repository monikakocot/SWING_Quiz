package pl.akademiakodu.fileQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileQuestionProvider implements QuestionProvider {

    private String fileName;

    public FileQuestionProvider(String fileName){
        this.fileName = fileName;
    }

    // I chose the method with using of Stream
    // another options with Scanner and Bufferreadreyou can find in /**/ below

    @Override
    public List<Question> getQuizQuestions() {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .collect(Collectors.toList()); // convert the stream to List

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);


        /**
         //Scanner
         @Override
         public List<Question> getQuizQuestions() {
         List<String> list = new ArrayList<>();

         try {
         FileReader fileReader = new FileReader(fileName);
         Scanner sc = new Scanner(fileReader);
         String textLine = sc.nextLine();
         while(sc.hasNextLine()){
         list.add(textLine);
         }
         sc.close();


         BUFFEREDREADER 1

         /**

         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String textLine = bufferedReader.readLine();

         while (textLine!=null) {
         list.add(textLine);
         }
         bufferedReader.close();

         }
         catch (FileNotFoundException e1) {
         e1.printStackTrace();
         }

         catch (IOException e) {
         e.printStackTrace();
         }
         System.out.println(list);

         // BufferedReader 2

         List<String> list = new ArrayList<>();

         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))  {

         String text=in.readLine();
         while (text !=null){

         System.out.println(list);
         text=in.readLine();
         }
         in.close();

         } catch (IOException e) {
         e.printStackTrace();
         }

         */
        
        List<Question> questions = new ArrayList<>();

        for (String word:list){
            String content = word.substring(0,word.length()-3).trim();
            String lastWord = word.substring(word.length()-3);
            if ( lastWord.equals("YES"))
                questions.add(new Question(content,true));
            else
                questions.add(new Question(content,false));
        }


        return questions;
    }

    public static void main(String[] args) {
        FileQuestionProvider fileQuestionProvider = new FileQuestionProvider("questions.txt");
        System.out.println(fileQuestionProvider.getQuizQuestions());

    }
}
