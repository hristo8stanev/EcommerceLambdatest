package enums;

import lombok.Getter;

@Getter
public enum Manufacturer {
    APPLE("Apple"),
    CANON("Canon"),
    HEWLETT_PACKARD("Hewlett-Packard"),
    HTC("Htc"),
    NIKON("Nikon"),
    PALM("Palm"),
    SONY("Sony");

    public final String manufacturerName;

    Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

}
