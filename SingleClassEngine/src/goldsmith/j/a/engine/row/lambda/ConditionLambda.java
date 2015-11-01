package goldsmith.j.a.engine.row.lambda;

import goldsmith.j.a.engine.input.Inputs;

public interface ConditionLambda {
    boolean passesCondition(Inputs inputs);
}
