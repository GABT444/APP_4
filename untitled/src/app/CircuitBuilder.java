package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.electronique.CircuitParallele;
import src.electronique.CircuitSerie;
import src.electronique.Composant;
import src.electronique.Resistance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircuitBuilder {

    public  Composant construireCircuit(String node) {
        List<Composant> Circuits = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode donneescircuits = mapper.readTree(new File(node));
            JsonNode e = donneescircuits.get("circuit");
            Composant composant = lireCircuitBuilder(e);
            return composant;
        } catch (IOException e) {
            System.err.println("erreur de lecture : " + e.getMessage());
            ;
        }
        throw new IllegalArgumentException("le fichier ne peut pas être lu");
    }

    private Composant lireCircuitBuilder(JsonNode node) {
        String type = node.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        } else if ("serie".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireCircuitBuilder(composantNode));
            }
            return new CircuitSerie(composants);
        } else if ("parallele".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireCircuitBuilder(composantNode));
            }
            return new CircuitParallele(composants);
        }
        throw new IllegalArgumentException("type de circuits : " + type);
    }
}
