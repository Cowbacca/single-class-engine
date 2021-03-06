package goldsmith.j.a.engine.input;

import java.util.Map;

public class Inputs {

    private Map<VariableName, Integer> inputMap;

    public Inputs(Map<VariableName, Integer> inputMap) {
        this.inputMap = inputMap;
    }

    public int getInput(VariableName variableName) {
        return inputMap.get(variableName);
    }
}
