package data;

public class Const {
    static StringBuilder builder = new StringBuilder();
    static public String energoProBaseLink = "https://my.energo-pro.ge";
    static public String energoPro;
    static public String energoProPersonalLink;

    static {
        builder.append(energoProBaseLink).append("/en/");
        energoPro = builder.toString();
        builder.setLength(0);
        builder.append(energoProBaseLink).append("/ow/#/");
        energoProPersonalLink = builder.toString();
    }

}
