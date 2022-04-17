import java.util.*;

public class DataHandler extends FileProcessor {

    protected ArrayList<String> header = new ArrayList<>();
    protected ArrayList<String> feature = new ArrayList<>();
    protected ArrayList<ArrayList<String>> data = new ArrayList<>();
    protected int x,y = 0;
    protected int alpha = 1;

    public DataHandler(String fileName) {
        super(fileName);
    }

    public void transformData(){
        for(String i : read()){ // Read returns lines[]
            // converting comma separate String to array of String
            String[] elements = i.strip().split(",");
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
        setX(data.get(0).size());
        System.out.println("X: " + x);
        setY(data.size());
        System.out.println("Y: " + y);
        System.out.println("Alpha: " + alpha);

        for (int i = 0; i < getX(); i++) {
            System.out.println("<-- " + feature.get(i) + "-->");
            for (int j = 0; j < getFeatureCategoryKey(i).size(); j++) {
                System.out.println(getFeatureCategoryKey(i).get(j));
                int counter = 0;
                for (int k = 0; k < getFeatureCategoryKey(getX()-1).size(); k++) {
                    System.out.print("Classifier: " + getFeatureCategoryKey(getX()-1).get(k) + " -> ");
                    System.out.println(getFrequency(i,
                            getFeatureCategoryKey(i).get(j),
                            getFeatureCategoryKey(getX()-1).get(k)
                    ));
                    counter += getFrequency(i,
                            getFeatureCategoryKey(i).get(j),
                            getFeatureCategoryKey(getX()-1).get(k));
                }
                System.out.println(counter + "\n");
            }
            System.out.println("<-- End -->\n");
        }
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
        return category;
    }

    public Integer getFrequency(int feature, String element, String classifier){
        int counter = alpha; // Alpha
        for(ArrayList<String> i : data){
            if(element.equals(i.get(feature)) && classifier.equals(i.get(i.size()-1))){
                counter++;
            }
        }
//        System.out.println("Value of: [Feature:" + feature + ", Element:"+ element + ", Classifier:" + classifier +"]\t" + counter);
        return counter;
    }

    public ArrayList<String> getFeatureCategoryKey(int feature){
        Set<String> keys = getFeatureCategory(feature).keySet();
        return new ArrayList<>(keys);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
