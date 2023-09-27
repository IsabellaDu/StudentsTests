package org.example.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public Object[][] dataForCreateAccountTest() {
        return new Object[][]{
                {"", "", "", "", ""},
                {"", "test-lastname", "iva@mail.ua", "12345678", "123"},
                {"test-firstname", "", "", "123Bn321", "123Bn321"},
                {"test-firstname", "test-lastname", "test@gmail.com", "344Mn655", "344Mn655"}
        };
    }

    @DataProvider
    public Object[][] dataForLoginTest() {
        return new Object[][]{
                {"", ""},
                {"iva@mail.ua", "roni_cost3@example.com"},
                {"roni_cost@example.com", "123Bn321"},
                {"roni_cost@example.com", "roni_cost3@example.com"}
        };
    }


    @DataProvider
    public Object[][] dataForRozetkaBrandTest() {
        return new Object[][]{
                {"процессор", 15},
                {"насос", 99},
                {"парацетамол", 6},
                {"электронная книга", 25},
        };
    }
}
