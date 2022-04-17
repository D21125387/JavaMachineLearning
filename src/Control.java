import java.util.ArrayList;
import java.util.Arrays;

public class Control {

    public static void main(String[] args){
        TestUtils dt = new TestUtils("MLTrain.csv");
        dt.open();
        dt.transformData();
        dt.observeData();
//        ArrayList<String> params = new ArrayList<String>(Arrays.asList("convex","scaly","white","yes","anise","free","close","narrow","black","enlarging","equal","smooth","smooth","white","white","partial","white","one","pendant","black","several","grasses"));
//        System.out.println(dt.applyEquation(params));
//        dt.testFromLine(200);
        dt.testFromPercentage(30);
        GUI gui = new GUI("Naive Bayes Prediction");
    }
}
