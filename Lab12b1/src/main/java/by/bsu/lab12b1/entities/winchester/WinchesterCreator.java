package by.bsu.lab12b1.entities.winchester;

import com.github.javafaker.Faker;

public class WinchesterCreator {
    private String getAlphaNumericString() {
        int n = 10;
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public Winchester fillRandomizedWinchester(Winchester winchester){
        Faker fake = new Faker();
        winchester.setBrand(fake.company().name());
        winchester.setModelNumber(getAlphaNumericString());
        winchester.setSize((int)(Math.random()*10));
        return winchester;
    }
}