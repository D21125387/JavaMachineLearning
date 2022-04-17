import java.util.ArrayList;

public class TestUtils extends NaiveBayes {

    public TestUtils(String fileName) {
        super(fileName);
    }

    public void testFromLine(int num){
        int success = 0,fail = 0;
        for (int i = num; i < data.size(); i++) {
            ArrayList<String> tester = new ArrayList<>(data.get(i));
            tester.remove(getX()-1);
            System.out.println(tester);
            if(applyEquation(tester).equals(data.get(i).get(getX()-1))){
                success++;
            } else {
                fail++;
            }
        }

        double accuracy = ((double) success/((double) success+fail))*100;
        System.out.println(accuracy);
        System.out.println(success + " | " + fail);
    }

    public void testFromPercentage(int percentage){
        int testSize = Math.round(getY()*percentage/100);
        System.out.println(testSize);
        int testPerClassifier = testSize/getFeatureCategoryKey(getX()-1).size();
        System.out.println(testPerClassifier);
        ArrayList<ArrayList<String>> testSet = new ArrayList<>();
        for(String key : getFeatureCategoryKey(getX()-1)){
            int counter = 0;
            for (int i = 0; i < data.size(); i++) {
                if(counter == testPerClassifier){
                    break;
                }

                if(data.get(i).get(getX()-1).equals(key)){
                    testSet.add(data.get(i));
                    counter++;
                }
            }
        }
        int success = 0,fail = 0;
        for (ArrayList<String> strings : testSet) {
            ArrayList<String> tester = new ArrayList<>(strings);
            tester.remove(getX() - 1);
            System.out.println(tester);
            String result = applyEquation(tester);
            System.out.println("Result: " + result);
            if (result.equals(strings.get(getX() - 1))) {
                success++;
            } else {
                fail++;
            }
        }

        double accuracy = ((double) success/((double) success+fail))*100;
        System.out.println(accuracy);
        System.out.println(success + " | " + fail);
        System.out.println(testSet.size());
    }
}
