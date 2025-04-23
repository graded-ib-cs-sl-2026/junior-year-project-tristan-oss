import java.util.ArrayList; // array list instead of array because you dont know how many flashcards will be in the text file
import java.util.Collections; // imported for shufling 

public class App {
    private InputOutput io = new InputOutput(); 
    private ArrayList<Flashcard> flashcards; //flashcard name of array list that stores objects of the type Flashcard 

    public App() { 
        flashcards = new ArrayList<>(); // initializing flashcards 
        
    }

    public void start() { 
        loadFlashcards("flashcard.txt");  

        Collections.shuffle(flashcards); // shufles the array list https://www.digitalocean.com/community/tutorials/shuffle-array-java
        
        ArrayList<Flashcard> incorrectCards = new ArrayList<>();

        for(int i=0; i<flashcards.size(); i++) { 
            Flashcard card = flashcards.get(i); // gets the i-th object of the array and stores it into card 
            io.output("Word: " + card.getWord()); // output this to the terminal 
            io.output("press enter to see definition");
            io.input();  // waits for the user to type enter before moving on 
            io.output("definition: " + card.getDefinition());
            io.output("did you get this definiton? (yes/no)");
            String answer = io.input();
            if(answer.equals("yes")) { // if statement to determine if the card is marked as studdied 
                card.markAsStudied();
            } else { 
                incorrectCards.add(card); // if the user did not get the definition, that flashcard is added to the "pile"/ arrayList of incorrect ones
            }

            saveStudiedFlashcards("studied.txt"); // saves the flashcards that have been mastered up until this point 
        

        }
        //this is the review section for the flashcards 
        while(incorrectCards.size() > 0){ // while loop runs as long as their are unmastered flashcards 
            io.output("Press enter to review the ones you missed");
            io.input(); 
            ArrayList<Flashcard> stillIncorrect = new ArrayList<>(); // new array list for the flachards still not mastered
           // have to make new array list or else it creates a infinite loop ( further explanation on line 54)

        for(int i = 0; i < incorrectCards.size(); i++){ 
            Flashcard card = incorrectCards.get(i);
            io.output("word: " + card.getWord());
            io.output("press enter to see definition"); 
            io.input();
            io.output("definition: " + card.getDefinition());
            io.output("did you get this definiton this time? (yes/no)");
            String answer = io.input(); 
            if(answer.equals("yes")){ 
                card.markAsStudied();
            } else{ 
                stillIncorrect.add(card); // if I were to add the ones that still arent mastered back to the original incorrect pile, 
                // it would duplicate since that card is already their. 

            }

        }
        incorrectCards = stillIncorrect; // replace the old list with the new pile of unmastered
        
        saveStudiedFlashcards("studied.txt"); // save the mastered flashcards after reviewing the incorrect ones


        }

        System.out.println("your done studying!"); 
       
    } 
    


    /** reads the text file with the flashcards. Text file Must have word on one line, then definition on the line below. Then another word below the definiton and so on. No spaced between lines*/
    public void loadFlashcards(String filename) {
        try{ // used Mr Griswolds code along with this link to understand this. https://www.w3schools.com/java/java_try_catch.asp
            io.openFile(filename);
        } catch (Exception e) { 
            io.output("Error reading File");
            return; 
        }
            while(io.fileHasNextLine()) { 
                String word =io.getNextLine();
                if (io.fileHasNextLine()) { 
                    String definition = io.getNextLine();
                    flashcards.add(new Flashcard(word, definition)); // this line adds the flashcard with word and definition to the array list. Learned from https://stackoverflow.com/questions/19616972/how-to-add-an-object-to-an-arraylist-in-java
                }
            }
            
        }
        /** saves the flashcards that have been studdied into a separate text file */
public void saveStudiedFlashcards(String filename) { 
    io.openWriteFile(filename);
    for(int i = 0; i < flashcards.size(); i++) {
        Flashcard card = flashcards.get(i);
        if(card.isStudied()) { 
            io.writeToFile(card.getWord());; // if card is studied it will write the word onto the studied file 
            io.writeToFile(card.getDefinition()); // then it will write the definition of that word to the studied file 
        } 
    }
io.closeWriteFile(); 
}

    
        public static void main(String[] args) {
            new App().start();
    

    }
}



