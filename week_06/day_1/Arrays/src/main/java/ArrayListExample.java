import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

    private ArrayList<String> words;
    private ArrayList<Integer> numbers;

    public ArrayListExample(ArrayList<Integer> numbers) {
        this.words = new ArrayList<>();
        this.numbers = numbers
    }

    public int getWordCount() {
        return this.words.size();
    }

    public void add(String word) {
        this.words.add(word);
    }

    public String getWordsAtIndex(int index) {
        return words.get(index);
    }

    public boolean arrayContainsWord(String word) {
        return words.contains(word);
    }

    public int getTotal() {
        int total = 0;
        for (int number : this.numbers) {
            total += number;
        }
        return total;
    }

    public int getRandomNumber() {
        Collections.shuffle(numbers);
        return numbers.get(0);
    }

    public ArrayList<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

}
