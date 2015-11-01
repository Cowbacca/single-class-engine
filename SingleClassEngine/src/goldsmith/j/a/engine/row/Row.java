package goldsmith.j.a.engine.row;

import goldsmith.j.a.engine.input.Inputs;
import goldsmith.j.a.engine.row.lambda.ActionLambda;
import goldsmith.j.a.engine.row.lambda.AlertLambda;
import goldsmith.j.a.engine.row.lambda.ConditionLambda;
import goldsmith.j.a.engine.row.lambda.ScoreLambda;

public class Row {
    private Inputs inputs;
    private ConditionLambda conditionLambda;
    private ScoreLambda scoreLambda;
    private ActionLambda actionLambda;
    private AlertLambda alertLambda;

    protected Row(Inputs inputs, ConditionLambda conditionLambda) {
        this.inputs = inputs;
        this.conditionLambda = conditionLambda;
    }

    public void run() {
        if (conditionLambda.passesCondition(inputs)) {
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

    public static RowBuilder newBuilder(ConditionLambda conditionLambda) {
        return new RowBuilder(conditionLambda);
    }
}
