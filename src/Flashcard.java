public class Flashcard { 
    private String word; 
    private String definition; 
    private boolean studied; // track if flashcard has been studied 
/** constructor for flashcard */
public Flashcard(String word, String definition) { 
    this.word = word; // use this. since parameter and instance variable have the same name. chatGPT helped me with this https://docs.google.com/document/d/1ONCWdZvLwDbZJ-81M9bXXRUlULQJ165AYNjuXBuc1uc/edit?tab=t.0
    this.definition = definition; // looking back could have just changed the names
    studied = false;
}
/** getter to access the word of the flash card  */
public String getWord() { 
    return word;
}
/** getter for the definition on the flashcard  */
public String getDefinition() { 
    return definition; 
}
/** checks if the flashcard has been studied, returns true or false */
public boolean isStudied() { 
    return studied;
}
/** marks the flashcard as studied, change studied boolean to true */
public void markAsStudied() { 
    studied = true;
}
}