package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ROI {

    private static ObservableList<CalculateROI> allROI = FXCollections.observableArrayList();

    public static void addCalculation(CalculateROI newROI) {
        allROI.add(newROI);
    }

    public static ObservableList<CalculateROI> getAllROI(){
        return allROI;
    }
}
