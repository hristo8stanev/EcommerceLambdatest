package enums;

import lombok.Getter;

@Getter
public enum ShopCategory {
    COMPONENTS("Components"),
    CAMERAS("Cameras"),
    PHONE_TABLES_IPOD(" Phone, Tablets & Ipod"),
    SOFTWARE("Software"),
    MP3_PLAYERS("MP3 Players"),
    LAPTOP_AND_NOTEBOOKS(" Laptops & Notebooks"),
    DESKTOP_AND_MONITORS(" Desktops and Monitors"),
    PRINTERS_AND_SCANNERS(" Printers & Scanners"),
    MICE_AND_TRACKBALLS(" Mice and Trackballs"),
    FASHION_AND_ACCESSORIES(" Fashion and Accessories"),
    BEAUTY_AND_SALOON(" Beauty and Saloon"),
    AUTOPARTS_AND_ACCESSORIES(" Autoparts and Accessories"),
    WASHING_MACHINE("Washing machine"),
    GAMING_CONSOLES(" Gaming consoles"),
    AIR_CONDITIONER(" Air conditioner"),
    WEB_CAMERAS(" Web Cameras");

    private final String category;

    ShopCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
