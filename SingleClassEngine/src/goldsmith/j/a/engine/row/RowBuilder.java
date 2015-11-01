package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.ActionLambda;
import goldsmith.j.a.engine.AlertLambda;
import goldsmith.j.a.engine.Condition;
import goldsmith.j.a.engine.ScoreLambda;
import goldsmith.j.a.engine.input.Inputs;
import goldsmith.j.a.engine.input.VariableName;

import java.util.HashMap;
import java.util.Map;

public class RowBuilder {

    private final Map<VariableName, Integer> inputMap;
    private Condition condition;
    private ScoreLambda scoreLambda;
    private ActionLambda actionLambda;
    private AlertLambda alertLambda;

    protected RowBuilder(Condition condition) {
        this.inputMap = new HashMap<>();
        this.condition = condition;
        this.scoreLambda = scoreInputs -> 0;
        this.actionLambda = actionInputs -> {
        };
        this.alertLambda = alertInputs -> {
        };
    }

    public RowBuilder scoreLambda(ScoreLambda scoreLambda) {
        this.scoreLambda = scoreLambda;
        return this;
    }

    public RowBuilder actionLambda(ActionLambda actionLambda) {
        this.actionLambda = actionLambda;
        return this;
    }

    public RowBuilder alertLambda(AlertLambda alertLambda) {
        this.alertLambda = alertLambda;
        return this;
    }

    public RowBuilder addInput(VariableName variableName, int value) {
        inputMap.put(variableName, value);
        return this;
    }

    public Row build() {
        Row row = new Row(new Inputs(inputMap), condition);
        row.setScoreLambda(scoreLambda);
        row.setActionLambda(actionLambda);
        row.setAlertLambda(alertLambda);
        return row;
    };
}