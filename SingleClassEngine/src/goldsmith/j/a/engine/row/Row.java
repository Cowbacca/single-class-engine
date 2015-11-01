package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.Action;
import goldsmith.j.a.engine.Alert;
import goldsmith.j.a.engine.Condition;
import goldsmith.j.a.engine.Inputs;
import goldsmith.j.a.engine.ScoreLambda;

public class Row {
    private Inputs inputs;

    private Condition condition;
    private ScoreLambda scoreLambda;
    private Action action;
    private Alert alert;

    protected Row(Inputs inputs, Condition condition) {
        this.inputs = inputs;
        this.condition = condition;
    }

    public void run() {
        if (condition.passesCondition(inputs)) {
            System.out.println(scoreLambda.run(inputs));
            action.run();
            alert.run();

        }
    }

    protected void setScoreLambda(ScoreLambda scoreLambda) {
        this.scoreLambda = scoreLambda;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public static RowBuilder newBuilder(Inputs inputs, Condition condition) {
        return new RowBuilder(inputs, condition);
    }
}
