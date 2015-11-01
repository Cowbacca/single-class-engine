package goldsmith.j.a.engine;

import goldsmith.j.a.engine.input.VariableName;
import goldsmith.j.a.engine.row.Row;

public class Engine {
    private Row row;

    public void setup() {
        row = Row.newBuilder(
                conditionInputs -> {
                    if (conditionInputs.getInput(VariableName.AGE) > 10) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .scoreLambda(scoreInputs -> scoreInputs.getInput(VariableName.TIME_OFF) * 2)
                .addInput(VariableName.AGE, 11)
                .addInput(VariableName.TIME_OFF, 6)
                .build();
    }

    public void run() {
        row.run();
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.setup();
        engine.run();
    }
}
