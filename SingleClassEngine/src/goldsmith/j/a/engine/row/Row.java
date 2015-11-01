package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.*;

public class Row {
    private Inputs inputs;

    private Condition condition;
    private ScoreLambda scoreLambda;
    private ActionLambda actionLambda;
    private AlertLambda alertLambda;

    protected Row(Inputs inputs, Condition condition) {
        this.inputs = inputs;
        this.condition = condition;
    }

    public void run() {
        if (condition.passesCondition(inputs)) {
            System.out.println(scoreLambda.run(inputs));
            actionLambda.run(inputs);
            alertLambda.run(inputs);

        }
    }

    protected void setScoreLambda(ScoreLambda scoreLambda) {
        this.scoreLambda = scoreLambda;
    }

    public void setActionLambda(ActionLambda actionLambda) {
        this.actionLambda = actionLambda;
    }

    public void setAlertLambda(AlertLambda alertLambda) {
        this.alertLambda = alertLambda;
    }

    public static RowBuilder newBuilder(Inputs inputs, Condition condition) {
        return new RowBuilder(inputs, condition);
    }
}
