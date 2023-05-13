
## Mini Game classes overview

** HintDictonary** - This class stores logic puzzles to ask to the user(And checks if the user has the correct answer to the logic puzzle

** WordDictonary**- Stores the word the user has to guess. It also stores the “hint” the user gets if they get it right. This class is able generate a random word and give you the hints associated WITH the word

** GuessWord**- Class that is the “backbone” of this GUI- holds all the buttons necessary for the GUI. It stores the random word generated in WordDictonary. That word s passed on to the hint class when the Hint1 and Hint2 buttons are pressed. Additionally, these hint buttons create an INSTANCE of the hint class(eg; open the frame). There is also a submit button that checks if the user has guessed the word correctly based on the randomly generated word stored in this class. If they have, they get a chance to play again! There is a scramble button that when clicked, scrambles the randomly generated word. There is also an instructions button when clicked displays instructions.

** Hint** - Hint Class that given a random word chosen from the Word Dictionary class from the GuessWord class, stores the corresponding hint to it. It also displays the logic puzzle from Hint Dictionary class. This class also checks if the user has got the logic puzzle right. If they have gotten it right, it shows them the corresponding hint from the chosen word of the WordDictionary
class
