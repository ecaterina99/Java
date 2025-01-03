public class Wine extends Product {
    protected int bottleVolume;
    private static final float EXTRA = 1.1F;

    public Wine(String name, int barcode, float basePrice, int bottleVolume) {
        super(name, barcode, basePrice);
        this.bottleVolume = bottleVolume;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
                "Volume of the bottle: " + bottleVolume + " ml";
    }

    @Override
    public float calculatePrice() {
        return super.calculatePrice() * EXTRA;
    }
}
