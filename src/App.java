import java.util.ArrayList; // array list instead of array because you dont know how many flashcards will be in the text file

public class App {
    private InputOutput io = new InputOutput();;
    private ArrayList<Flashcard> flashcards;

    public App() { 
        this.flashcards = new ArrayList<>();
        this.io = new InputOutput();
    }

    public void start() { 
        loadFlashcards("flashcard.txt");  
        
        for(int i=0; i<flashcards.size(); i++) { 
            Flashcard card = flashcards.get(i); 
            io.output("Word: " + card.getWord());
            io.output("press enter to see definition");
            io.input();
            io.output("definition: " + card.getDefinition());
            io.output("press enter to continue");
            io.input(); 
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



