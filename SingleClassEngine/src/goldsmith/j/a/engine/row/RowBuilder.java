package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.*;

public class RowBuilder {

    private Inputs inputs;
    private Condition condition;
    private ScoreLambda scoreLambda;
    private ActionLambda actionLambda;
    private AlertLambda alertLambda;

    protected RowBuilder(Inputs inputs, Condition condition) {
        this.inputs = inputs;
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

    public Row build() {
        Row row = new Row(inputs, condition);
        row.setScoreLambda(scoreLambda);
        row.setActionLambda(actionLambda);
        row.setAlertLambda(alertLambda);
        return row;
    };
}