import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Template template = mapper.readValue(new File("C:\\Users\\79631\\Documents\\notata.txt"), Template.class);
        Result result = new Result();
        Scanner console = new Scanner(System.in);
        //создаем список для добавления в result
        ArrayList<AnswersR> arr = new ArrayList<AnswersR>();

        for (Questions questions : template.getQuestions()) {
            System.out.println(questions.getTitle());


            for (Answers answers : questions.getAnswers()) {
                System.out.print(answers.getId());
                System.out.println(answers.getValue());
            }
            System.out.println("Введите номер ответа: ");
            int number= console.nextInt();
            //записываем id в temp
            AnswersR temp = new AnswersR();
            temp.setAnswer_id(number);
            temp.setQuestion_id(questions.getId());
            //добавляем в список
            arr.add(temp);

        }
        //записываем список в файл
        result.setAnswers(arr);
        mapper.writeValue(new File("C:\\Users\\79631\\Documents\\result.txt"), result);

    }
}
