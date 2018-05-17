import java.util.ArrayList;
import java.util.Collections;

public class MagicEightBall {

    //declarations
    private ArrayList<String> answers;

    //constructor
    public MagicEightBall(ArrayList<String> answers) {
        this.answers = answers;
    }

    //methods
    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public int getStringCount() {
        return this.answers.size();
    }

    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public String getRandomAnswer() {
        Collections.shuffle(answers);
        return this.answers.get(0);
    }

    public void removeAnswer(String answer) {
        this.answers.remove(answer);
    }
//    alternative to the above using a standard loop
//    public void removeAnswer(String answer) {
//        for (int i = 0; i < this.answers.size(); i++) {
//            if (answers.get(i) == answer) {
//                this.answers.remove(i);
//                break;
//            }
//        }
//    }
//    There is also another alternative that uses a copy instead of the original, see Steve's homework review

}
