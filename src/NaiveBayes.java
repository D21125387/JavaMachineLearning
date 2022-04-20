import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class NaiveBayes extends DataHandler {

    public NaiveBayes(String fileName) {
        super(fileName);
    }

    public Double getProbability(int feature, String element, String classifier){
        double counter = 0;
        for (int i = 0; i < getFeatureCategoryKey(feature).size(); i++) {
            counter += (getFrequency(feature,getFeatureCategoryKey(feature).get(i),classifier));
        }
        double probability = 1*(getFrequency(feature, element, classifier))/counter;
        System.out.println("Probability of Feature:" + feature + ", Element:"+ element + ", Classifier:" + classifier +"");
        System.out.println(getFrequency(feature, element, classifier) + "/" + counter);
        return probability;
    }

    public Double getClassifierProbability(String classifier){
        double probability;
        int counter = 0;
        for(String key : getFeatureCategory(getX()-1).keySet()){
            counter += getFeatureCategory(getX()-1).get(key);
        }

        probability = getFeatureCategory(getX()-1).get(classifier)/(double) counter;

        return probability;
    }

    public String applyEquation(ArrayList<String> params){
        /*
        params = (Gender, ...)
        params x classifier / params
         */
        HashMap<String, Double> result = new HashMap<>();
        for(String i : getFeatureCategoryKey(getX()-1)){
            result.put(i, 0.00);
        }


        for (int j = 0; j < getFeatureCategoryKey(getX()-1).size(); j++) {
            double calcResult = 1.00;
            ArrayList<String> calcStr = new ArrayList<>();
            for (int i = 0; i < params.size(); i++) {
                double getProb = getProbability(i,params.get(i),getFeatureCategoryKey(getX()-1).get(j));
                calcResult *= getProb;
                calcStr.add(String.valueOf(getProb));
            }
            calcResult *= getClassifierProbability(getFeatureCategoryKey(getX()-1).get(j));
            calcStr.add(getClassifierProbability(getFeatureCategoryKey(getX()-1).get(j)).toString());
//            System.out.println(calcResult);
            result.put(getFeatureCategoryKey(getX()-1).get(j),calcResult/getClassifierProbability(getFeatureCategoryKey(getX()-1).get(j)));
            System.out.println(calcStr);
        }
        System.out.println("Raw Result: " + result);

        HashMap<String, Double> normalisation = result;

        double bottom = 0.00;
        for(String key : result.keySet()){
            bottom += result.get(key);
        }
//        System.out.println(bottom);
        for(String key : result.keySet()){
            normalisation.put(key, result.get(key)/bottom);
        }
        System.out.println("Normalisation Result: " + normalisation);

        Double maxVal = Collections.max(normalisation.values());
        String maxKey = "";
        for(String key : result.keySet()){
            if(Objects.equals(maxVal, normalisation.get(key))){
                maxKey = key;
            }
        }
//        System.out.println(maxKey);
        return maxKey;
    }

    public String applyEquationOpt(ArrayList<String> params){
        HashMap<String, Double> result = new HashMap<>();
        HashMap<String, Double> normalisation = new HashMap<>();
        for (int i = 0; i < getFeatureCategoryKey(getX()-1).size(); i++) {
            ArrayList<Double> probArray = new ArrayList<>();
            String classifier = getFeatureCategoryKey(getX()-1).get(i);

            for (int j = 0; j < params.size(); j++) {
                String tableKey = j + "|" + params.get(j) + "|" + classifier;
//                System.out.println(tableKey);
//                System.out.println(observedData.get(tableKey));
                double calcVal = (double) observedData.get(tableKey)/observedData.get(j + "|Total|" + classifier);
                probArray.add(calcVal);
//                System.out.println(calcVal);
            }
            probArray.add((double) observedData.get(getX()-1 + "|" + classifier + "|" + classifier)/(getY()+getFeatureCategoryKey(getX()-1).size()));
//            System.out.println(probArray);
            double rawProbability = 1;
            for(double x : probArray){
                rawProbability *= x;
            }
//            System.out.println(observedData.get(getX()-1 + "|" + classifier + "|" + classifier));
            result.put(classifier, rawProbability);
        }
//        System.out.println(result);
        double bottom = 0.00;
        for(String key : result.keySet()){
            bottom += result.get(key);
        }
//        System.out.println(bottom);
        for(String key : result.keySet()){
            normalisation.put(key, result.get(key)/bottom);
        }
        System.out.println("Normalisation Result: " + normalisation);

        Double maxVal = Collections.max(normalisation.values());
        String maxKey = "";
        for(String key : result.keySet()){
            if(Objects.equals(maxVal, normalisation.get(key))){
                maxKey = key;
            }
        }
//        System.out.println(maxKey);
        return maxKey;
    }
}
