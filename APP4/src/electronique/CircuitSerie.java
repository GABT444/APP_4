package electronique;

import java.util.List;

public class CircuitSerie extends Circuit {

    public CircuitSerie(List<Composant> composants){
        super(composants);

    }
    public double calculerResistance(){
        double resistance = 0;
        for(Composant c :composants){
            resistance += c.calculerResistance();

        }
        return resistance;
    }

}
