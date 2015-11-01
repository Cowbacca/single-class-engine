package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.*;

public class RowBuilder {

    private Inputs inputs;
    private Condition condition;
    private ScoreLambda scoreLambda;
    private Action action;
    private Alert alert;

    protected RowBuilder(Inputs inputs, Condition condition) {
        this.inputs = inputs;
        this.condition = condition;
        this.scoreLambda = scoreInputs -> 0;
        this.action = actionInputs -> {
        };
        this.alert = alertInputs -> {
        };
    }

    public RowBuilder scoreLambda(ScoreLambda scoreLambda) {
        this.scoreLambda = scoreLambda;
        return this;
    }

    public RowBuilder action(Action action) {
        this.action = action;
        return this;
    }

    public RowBuilder alert(Alert alert) {
        this.alert = alert;
        return this;
    }

    public Row build() {
        Row row = new Row(inputs, condition);
        row.setScoreLambda(scoreLambda);
        row.setAction(action);
        row.setAlert(alert);
        return row;
    };
}