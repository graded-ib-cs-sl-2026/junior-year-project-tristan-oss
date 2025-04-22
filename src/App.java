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
        
        for(int i=0; i<flashcards.size(); i++) { 
            Flashcard card = flashcards.get(i); // gets the i-th object of the array and stores it into card 
            io.output("Word: " + card.getWord()); // output this to the terminal 
            io.output("press enter to see definition");
            io.input();  // waits for the user to type enter before moving on 
            io.output("definition: " + card.getDefinition());
            io.output("press enter to continue");
            io.input(); 

            card.markAsStudied();
        }
        System.out.println("your done studying!");
    } 
    


    
    public void loadFlashcards(String filename) {
        try{ 
            io.openFile(filename);
        } catch (Exception e) { 
            io.output("Error reading File");
            return; 
        }
            while(io.fileHasNextLine()) { 
                String word =io.getNextLine();
                if (io.fileHasNextLine()) { 
                    String definition = io.getNextLine();
                    flashcards.add(new Flashcard(word, definition));
                }
            }
            
        }


    
        public static void main(String[] args) {
            new App().start();
    

    }
}



