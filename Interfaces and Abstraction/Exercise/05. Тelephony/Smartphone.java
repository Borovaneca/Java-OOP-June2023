package Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        boolean isNumber = false;
        for (int i = 0; i < urls.size(); i++) {
            String current = urls.get(i);
            isNumber = false;
            for (int j = 0; j < current.length(); j++) {
                if (Character.isDigit(current.charAt(j))) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isNumber = true;
                    break;
                }
            }
            if (!isNumber) {
                sb.append(String.format("Browsing: %s!", urls.get(i))).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        boolean isNumber = false;
        for (String number : numbers) {
            String current = number;
            for (int j = 0; j < current.length(); j++) {
                if (!Character.isDigit(current.charAt(j))) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isNumber = true;
                    break;
                }
            }
            if (!isNumber) {
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
