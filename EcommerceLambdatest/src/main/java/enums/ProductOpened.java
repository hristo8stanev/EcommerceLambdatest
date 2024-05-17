package enums;

public enum ProductOpened {
    YES(0),
    NO(1);

    private final int numberDisplayed;

    ProductOpened(int numberDisplayed) {
        this.numberDisplayed = numberDisplayed;
    }

    public int getNumberDisplayed() {
        return numberDisplayed;
    }
}
