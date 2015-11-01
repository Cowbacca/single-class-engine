package goldsmith.j.a.engine;

import goldsmith.j.a.engine.row.Row;

public class Engine {
    private Row row;

    public void setup() {
        Inputs inputs = new Inputs(11, 2);

        Condition condition = new Condition() {

            public boolean passesCondition(Inputs inputs) {
                if (inputs.getAge() > 10) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        ScoreLambda scoreLambda = new ScoreLambda() {

            public int run(Inputs inputs) {
                return inputs.getTimeOff() * 2;
            }

        };

        row = Row.newBuilder(inputs, condition).scoreLambda(scoreLambda).build();
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
