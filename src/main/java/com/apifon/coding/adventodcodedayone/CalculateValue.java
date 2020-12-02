package com.apifon.coding.adventodcodedayone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateValue {

    private final InputData inputData;
    private List<Integer> dataToAnalise;

    @Autowired
    public CalculateValue(InputData inputData) {
        this.inputData = inputData;
        getDataToAnalise();
        calculateAndPrintMultiplyResult();
    }

    public void calculateAndPrintMultiplyResult() {
        int[] tab = findPairOfValues();
        int sum = tab[0] * tab[1];

        System.out.println("These are your values: " + tab[0] + " and " + tab[1] + "\nThis is your result: " + sum);
    }

    private int[] findPairOfValues() {
        int[] tab = new int[2];
        for (int i = 0; i < dataToAnalise.size(); i++) {
            for (int j = i+1; j < dataToAnalise.size(); j++) {
                if (dataToAnalise.get(i) + dataToAnalise.get(j) == 2020) {
                    tab[0] = dataToAnalise.get(i);
                    tab[1] = dataToAnalise.get(j);
                }
            }
        }
        return tab;
    }

    private void getDataToAnalise() {
        this.dataToAnalise = inputData.getInputData();
    }
}
