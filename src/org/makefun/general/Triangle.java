package org.makefun.general;

public final class Triangle {

    // (x,y ) - define the top point
    // h - defines the height of the triangle
    // for this case, x = 3, y = 3, h = 3
    //
    //           3,3
    //      2,2  3,2  4,2
    // 1,1  2,1  3,1  4,1  5,1
    // Draw triangle.

    private static final int STEP = 2;

    public static void main(final String[] args) {
        Triangle triangle = new Triangle();
        triangle.drawTriangle(3, 3, 3);
    }

    private void drawTriangle(final int x, final int y, final int h) {
        int tempX = x;
        int tempY = y;
        int numOfPoints = 1;
        for (int i = 0; i < h; i++) {
            drawLevel(tempX--, tempY--, numOfPoints);
            numOfPoints += STEP;
        }
    }

    private void drawLevel(final int x, final int y, final int numOfPoints) {
        for (int i = x; i < x + numOfPoints; i++) {
            drawPoint(i, y);
        }
    }

    private void drawPoint(final int x, final int y) {
        System.out.println(" x = [" + x + "]" + " y = [" + y + "]");
    }
}
