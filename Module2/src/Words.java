public class Words{ //created this to get around set and map limitations

     private String word;
     private int freq;

    public Words(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return this.word + ": " + this.freq;
    }

    public int compareTo(Words w) {
        if(freq==w.getFreq())
            return 0;
        else if (freq<w.getFreq())
            return 1;
        else
            return -1;
    }

}
