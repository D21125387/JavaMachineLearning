import java.util.ArrayList;
import java.util.Arrays;

public class Control {

    private static final String file = "MLTrain.csv";
    public static NaiveBayes ML = new NaiveBayes(file);
    public static TestUtils MLTest = new TestUtils(file);
    public static void main(String[] args){
        ML.open();
        ML.transformData();
        ML.observeData();
//        ArrayList<String> params = new ArrayList<String>(Arrays.asList("convex","scaly","white","yes","anise","free","close","narrow","black","enlarging","equal","smooth","smooth","white","white","partial","white","one","pendant","black","several","grasses"));
//        System.out.println(dt.applyEquation(params));
//        dt.testFromLine(200);
        MLTest.open();
        MLTest.transformData();
        MLTest.observeData();
        MLTest.testFromPercentage(30);
        GUI gui = new GUI("Naive Bayes Prediction");
    }
}
