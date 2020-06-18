package by.bsu.lab11b1.entity.winchester;

import com.github.javafaker.Faker;

public class WinchesterCreator {
    private String getAlphaNumericString() {
        int n = 10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public Winchester fillRandomizedWinchester(Winchester winchester) {
        Faker fake = new Faker();
        winchester.setBrand(fake.company().name());
        winchester.setModelNumber(getAlphaNumericString());
        winchester.setSize((int)(Math.random() * 10));
        return winchester;
    }
}
