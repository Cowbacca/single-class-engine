package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.Action;
import goldsmith.j.a.engine.Alert;
import goldsmith.j.a.engine.Condition;
import goldsmith.j.a.engine.Inputs;
import goldsmith.j.a.engine.ScoreLambda;

public class RowBuilder {

    private Inputs inputs;
    private Condition condition;
    private ScoreLambda scoreLambda;
    private Action action;
    private Alert alert;

    protected RowBuilder(Inputs inputs, Condition condition) {
        this.inputs = inputs;
        this.condition = condition;
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