public class Control {

    public static void main(String[] args){
        DataHandler dt = new DataHandler("MLTrain.csv");
        dt.open();
        dt.transformData();
        dt.observeData();
    }
}
