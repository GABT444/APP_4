package app;

import com.fasterxml.jackson.databind.JsonNode;
import src.electronique.Resistance;

public class CircuitBuilder {
    private CircuitBuilder lireCircuitBuilder(JsonNode node){
        String type = node.get("type").asText();

        if ("resistance".equals(type)){
            return new Resistance(node.get("valeur").asDouble());

        }
    }
}
