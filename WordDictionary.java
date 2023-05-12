import java.util.ArrayList;
import java.util.Random;

public class WordDictionary {

    private ArrayList<Word> words;
    private Random random;

    public WordDictionary() {
        words = new ArrayList<Word>();
        random = new Random();

        
        // Add words with their 2 hints

        addWord("APPLE", "Red", "Juicy");
        addWord("NOVEL", "Literature", "Fictional");
        addWord("RUMOR", "Spreads", "Unconfirmed");
        addWord("CROWD", "Big", "Close");
        addWord("SKATE", "Hockey", "Ice");
        addWord("DRY", "Beach", "Humor");
        addWord("POINT", "Line", "Tip");
        addWord("MASK", "Protection", "Covering");
        addWord("BREAD", "Loaf", "Baked");
        addWord("EYE", "Face", "See");
        addWord("SMILE", "Mouth", "Teeth");
        addWord("TRICK", "Prank", "Deceive");
        addWord("BLADE", "Sharp", "Knife");
        addWord("DANCE", "Choreographed", "Stage");
        addWord("WARM", "Weather", "Sunny");
        addWord("LEMON", "Acidic", "Sour");
        addWord("CHAIR", "Seat", "Furniture");
        addWord("PIANO", "Keys", "Instrument");
        addWord("GLASS", "Fragile", "Brittle");
        addWord("TALK", "Discourse", "Speech");
        addWord("NARROW", "Slim", "Limited");
        addWord("TOOTHBRUSH", "Teeth", "Clean");
        addWord("BOOK", "Pages", "Words");
        addWord("PILLOW", "Bed", "Sleep");
        addWord("PENCIL", "Eraser", "Write");
        addWord("BALL", "Bounce", "Throw");
        addWord("CATERPILLAR", "Cocoon", "Leaf");
        addWord("LAMB", "Farm", "Animal");
        addWord("LOBSTER", "Ocean", "Shell");
        addWord("YOGHURT", "White", "Dairy");
        addWord("SUGAR", "Sweet", "Baking");
        addWord("PINEAPPLE", "Yellow", "Fruit");
        addWord("WATER", "Clear", "Hydrogen");
        addWord("VOLCANO", "Mountain", "Ash");
        addWord("GAME", "Fun", "Play");
        addWord("HAND", "Hour", "Minute");
        addWord("PLANE", "Airport", "Travel");
        addWord("KEY", "Door", "Lock");
        addWord("RAINBOW", "Colors", "Rain");
        addWord("MOON", "Earth", "Satellite");
        addWord("BIOLOGY", "Living", "School");
        addWord("VACCINE", "COVID", "Antibodies");
        addWord("SLEEP", "Tired", "Night");
        addWord("POPULATION", "Number", "Humans");
        addWord("RICE", "White", "Chopsticks");

    }

    // This method adds a new word with two hints to the list of words
public void addWord(String word, String hint1, String hint2) {
    Word newWord = new Word(word, hint1, hint2);
    words.add(newWord);
    }
    
    // This method returns a random word from the list of words
    public Word getRandomWord() {
    int randomIndex = random.nextInt(words.size());
    return words.get(randomIndex);
    }
    
    // This method returns a string representation of a random word from the list of words
    public String getRandomWordAsString() {
    Word randomWord = getRandomWord();
    return randomWord.toString();
    }
    
    // This method returns the first hint of a specific word from the list of words
    public String getHint1(String word) {
    for (Word w : words) {
    if (w.getWord().equalsIgnoreCase(word)) {
    return w.getHint1();
    }
    }
    return ""; // return empty string if word is not found
    }
    
    // This method returns the second hint of a specific word from the list of words
    public String getHint2(String word) {
    for (Word w : words) {
    if (w.getWord().equalsIgnoreCase(word)) {
    return w.getHint2();
    }
    }
    return ""; // return empty string if word is not found
    }
    
/**

*/
private class Word {

    private String word;
    
    private String hint1;
    
    private String hint2;
    
    // Constructor that takes in a word and 2 hints

    public Word(String word, String hint1, String hint2) {
    this.word = word;
    this.hint1 = hint1;
    this.hint2 = hint2;
    }
    
    // Returns the word represented by this instance.

    public String getWord() {
    return word;
    }

    // Returns the first hint of this word.

    public String getHint1() {
    return hint1;
    }

    // Returns the second hint of this word.

    public String getHint2() {
    return hint2;
    }

    // Converts the Word Object into a string
    @Override
    public String toString(){
        return word;
    }
    }
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
    }
}



