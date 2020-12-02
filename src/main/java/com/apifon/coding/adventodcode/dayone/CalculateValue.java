package com.apifon.coding.adventodcode.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class CalculateValue {

    private final HashSet<Integer> numbers;

    public CalculateValue() {
        this.numbers = prepareData();
    }

    public void calculateAndPrintMultiplyResult() {
        int[] tab = findValues();
        int sum = tab[0] * tab[1];

        System.out.println("These are your values: " + tab[0] + " and " + tab[1] + "\nThis is your result: " + sum);
    }

    private int[] findValues() {
        int[] tab = new int[2];
        for (int i : numbers) {
            int searchedNumber = 2020 - i;
            if (numbers.contains(searchedNumber)) {
                tab[0] = i;
                tab[1] = searchedNumber;
            }
        }
        return tab;
    }

    private HashSet<Integer> prepareData() {
        HashSet<Integer> numbers = new HashSet<>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/dayone.txt"))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return numbers;
    }

}