package src.electronique;

import java.util.List;

abstract class Circuit extends Composant {
    protected List<Composant> composants;

    public Circuit(List<Composant> composants){
        this.composants = composants;
    }
}
