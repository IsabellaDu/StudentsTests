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
}
