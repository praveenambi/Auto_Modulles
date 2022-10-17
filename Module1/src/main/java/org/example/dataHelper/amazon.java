package org.example.dataHelper;

public enum amazon {
    BESTSELLERS ("BestSellers"),
    MOBILES("Mobiles"),
    BOOKS("Books"),
    FASHION("Fashion");
private final String Categorytype;
    amazon(String Type) {
        this.Categorytype=Type;
    }

    public String getCategorytype() {
        return Categorytype;
    }
}
