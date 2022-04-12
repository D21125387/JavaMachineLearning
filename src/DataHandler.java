import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataHandler extends FileProcessor {

    protected ArrayList<String> header = new ArrayList<>();
    protected ArrayList<String> feature = new ArrayList<>();
    protected ArrayList<ArrayList<String>> data = new ArrayList<>();

    public DataHandler(String fileName) {
        super(fileName);
    }

    public void transformData(){
        for(String i : read()){ // Read returns lines[]
            // converting comma separate String to array of String
            String[] elements = i.split(",");
            // convert String array to list of String
            List<String> elementsAsListObj = Arrays.asList(elements);
            // copy list to an ArrayList
            data.add(new ArrayList<String>(elementsAsListObj));
//            System.out.println(elementsAsListObj);
        }

        header = data.get(0);
        data.remove(0);
        feature = data.get(0);
        data.remove(0);
    }

    public void observeData(){
        int x = data.get(0).size();
//        System.out.println("X: " + x);
        int y = data.size();
//        System.out.println("Y: " + y);

        for (int i = 0; i < header.size(); i++) {
            System.out.println(feature.get(i));
            getFeatureCategory(i);
        }

        getFrequency(0, "Female", "Yes");
        getFrequency(0, "Female", "No");
    }

    public HashMap<String, Integer> getFeatureCategory(int feature){
        HashMap<String, Integer> category = new HashMap<>();
        for(ArrayList<String> i : data){
            if(!category.containsKey(i.get(feature))){
                category.put(i.get(feature),1);
            } else {
                category.put(i.get(feature), category.get(i.get(feature))+1);
            }
        }
        System.out.println(category);
        return category;
    }

    public Integer getFrequency(int feature, String element, String classifier){
        int counter = 0;
        for(ArrayList<String> i : data){
            if(element.equals(i.get(feature)) && classifier.equals(i.get(i.size()-1))){
                counter++;
            }
        }
        System.out.println("Value of: [" + feature + ", "+ element + ", " + classifier +"]\t" + counter);
        return counter;
    }
}
