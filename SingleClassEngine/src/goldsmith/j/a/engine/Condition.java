package goldsmith.j.a.engine;

import goldsmith.j.a.engine.input.Inputs;

public interface Condition {
    boolean passesCondition(Inputs inputs);
}
