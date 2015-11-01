package goldsmith.j.a.engine;

import goldsmith.j.a.engine.row.Row;

public class Engine {
    private Row row;

    public void setup() {
        row = Row.newBuilder(
                new Inputs(11, 2),
                conditionInputs -> {
                    if (conditionInputs.getAge() > 10) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .scoreLambda(scoreInputs -> scoreInputs.getTimeOff() * 2)
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
