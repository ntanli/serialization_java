import java.util.ArrayList;

public class Questions {
    private int id;
    private String title;
    private ArrayList<Answers> answers = new ArrayList<>();

    public ArrayList<Answers> getAnswers () {
        return this.answers;
    }

    public int getId() {
        return this.id;
    }


    public String getTitle() {
       return title;
    }
}
