public enum Size {
    SMALL("s"), MEDIUM("m"), LARGE("l"), EXTRA_LARGE("xl"), UNSPECIFIED(" ");

    private String code;

    public String getCode() {
        return code;
    }
    Size(String code) {
        this.code = code;
    }


}
