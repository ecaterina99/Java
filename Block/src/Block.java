/*
The constructor should take an array as an argument, this will contain 3 integers of the form
[width, length, height] from which the Block should be created.
`getWidth()` return the width of the `Block`
`getLength()` return the length of the `Block`
`getHeight()` return the height of the `Block`
`getVolume()` return the volume of the `Block`
`getSurfaceArea()` return the surface area of the `Block`
 */

public class Block {
    int width;
    int length;
    int height;

    public Block(int[] dimensions) {
        width = dimensions[0];
        length = dimensions[1];
        height = dimensions[2];
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getVolume() {
        return length * width * height;
    }

    public int getSurfaceArea() {
        return 2 * length * width + 2 * width * height + 2 * length * height;
    }
}