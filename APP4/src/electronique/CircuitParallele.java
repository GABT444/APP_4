package electronique;

import java.util.List;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {
 super(composants);
    }

    public double calculerResistance() {
        double resistance = 0;
        for (Composant c : composants) {
            resistance += 1/c.calculerResistance();

        }
        return resistance;
    }
}