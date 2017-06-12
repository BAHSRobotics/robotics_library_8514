package com.ba.robolib.math.vector;

public class Vector4 {

    public static final Vector4 FORWARD = new Vector4(1, 1, 1, 1);
    public static final Vector4 RIGHT = new Vector4(1, 1, -1, -1);
    public static final Vector4 ROTATION = new Vector4(-1, 1, -1, 1);
    public static final Vector4 ZERO = new Vector4();

    private int w, x, y, z;

    public Vector4() {

    }

    public Vector4(int w, int x, int y, int z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getW() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void resetValues() {
        w = 0;
        x = 0;
        y = 0;
        z = 0;
    }

    public void add(Vector4 other) {
        w += other.w;
        x += other.x;
        y += other.y;
        z += other.z;
    }

    public void subtract(Vector4 other) {
        w -= other.w;
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }

    public boolean equals(Object o) {
        Vector4 other = (Vector4) o;
        return w == other.w &&
                x == other.x &&
                y == other.y &&
                z == other.z;
    }
}
