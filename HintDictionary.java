import java.util.ArrayList;
import java.util.Random;

public class HintDictionary {

    private ArrayList<Hint> hints;
    private Random random;

    public HintDictionary() {
        hints = new ArrayList<Hint>();
        random = new Random();

        // Add hints with multiple possible answers
        
        addHint("There are 2 ducks in front of a duck, two ducks behind a duck and a duck in the middle. How many ducks are there?", "3", "THREE");
        addHint("The day before two days after the day before tomorrow is Saturday. What day is it today?", "FRIDAY");
        addHint("How many months have 28 days", "12", "TWELVE");
        addHint("Five people were eating apples, A finished before B, but behind C. D finished before E, but behind B. Who finished last", "E");
        addHint("Susan and Lisa decided to play tennis against each other. They bet $1 on each game they played. Susan won three bets and Lisa won $5. How many games did they play?","11", "ELEVEN");
        addHint("What has hands, but can’t clap", "CLOCK", "A CLOCK");
        addHint("What building has the most stories", "LIBRARY", "THE LIBRARY", "A LIBRARY");
        addHint("If there are three apples and you take away two, how many apples do you have", "2", "TWO");
        addHint("What loses its head in the morning and gets it back at night? ", "A PILLOW", "PILLOW");
        addHint("What is the capital city of Paraguay", "ASUNCION");
        addHint("What was the first movie to be ratxed PG-13", "RED DAWN");
        addHint("In what year did the Titanic sink","1912");
        addHint("What is the name of the famous prison island off the coast of San Francisco", "ALCATRAZ");
        addHint("Which planet in our solar system has the most moons?", "JUPITER");
        addHint("What is the biggest country in the world by land area?", "RUSSIA");
        addHint("In what year did the Korean War Start", "1950");
        addHint("What is the capital of Switzerland", "ZURICH");
        addHint("How many teeth do dogs have", "42");
        addHint("Where would you find the pinna on your body", "EAR");
        addHint("What scientist came up with the three laws of motion", "NEWTON", "ISSAC NEWTON");
        addHint("How many languages are written from right to left", "TWELVE", "12");
        addHint("Who was the first woman to win a Nobel Prize", "MARIE CURIE", "CURIE");
        addHint("What country is responsible for creating the Olympic Games", "GREECE");
        addHint("What is the hottest planet in the solar system", "VENUS");


    }

    // Given logic puzzles and answers, create an Instance of the "subclass" Hint and add this instance to an array
    public void addHint(String hint, String... answers) {
        Hint newHint = new Hint(hint, answers);
        hints.add(newHint);
    }

    // Get a random hint from this array
    public Hint getRandomHint() {
        int randomIndex = random.nextInt(hints.size());
        return hints.get(randomIndex);
    }

    // Each hint in the array is associated with an answer; check through the array to make sure the answer matches the hint
    public boolean checkAnswer(String answer, Hint hint) {
        for (String possibleAnswer : hint.getAnswers()) {
            if (answer.equalsIgnoreCase(possibleAnswer)) {
                return true;
            }
        }
        return false;
    }


    public class Hint {
        private String hint;
        private ArrayList<String> answers;

        // Given hint and answers; add the answers to the array 
        public Hint(String h, String... answers) {
            hint = h;   
            this.answers = new ArrayList<String>();
            for (String answer : answers) {
                this.answers.add(answer);
            }
        }

        public String getHint() {
            return hint;
        }

        public ArrayList<String> getAnswers() {
            return answers;
        }
    }

    public static void main(String[] args) {
        HintDictionary dictionary = new HintDictionary();
        // Test the checkAnswer method
    }
}