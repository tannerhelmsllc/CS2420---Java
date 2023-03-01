public class WordInfo {
    private int hashCode;
    private final String word;

    public WordInfo(String word){
        this.hashCode = 0;
        this.word = word;
        for (int i = 0; i < word.length(); i++) {
            this.hashCode = word.hashCode();
        }
    }
    @Override
    public String toString(){
        return this.word;
    }

    @Override
    public int hashCode(){
        return this.hashCode;
    }
}
