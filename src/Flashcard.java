public class Flashcard { 
    private String word; 
    private String definition; 
    private boolean studied; // track if flashcard has been studied 

public Flashcard(String word, String definition) { 
    this.word = word; 
    this.definition = definition;
    studied = false;
}

public String getWord() { 
    return word;
}

public String getDefinition() { 
    return definition; 
}

public boolean isStudied() { 
    return studied;
}
public void markAsStudied() { 
    studied = true;
}
}