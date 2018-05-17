public class ArrayExample {

    private String[] words;

    public ArrayExample(){
        this.words = new String[5];
    }

    public int getWordCount(){
        return this.words.length;
    }

    //this is old school but since Java6 you don't need to do it anymore
    public void add(String word){
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                this.words[i] = word;
                break;
            }
        }
    }

}
