package src.electronique;

import java.util.List;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {
 super(composants);
    }

    public double calculerResistance() {
        double resistance = 0;
        for (Composant c : composants) {
            valider(c);
            resistance += 1/c.calculerResistance();

        }
        return resistance;
    }

    private void valider(Composant c) {
        if (c.calculerResistance()==0){
            throw new IllegalArgumentException("il ne peut être 0 pour sa resistance");
        }
    }
}