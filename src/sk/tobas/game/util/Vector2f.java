package sk.tobas.game.util;

public class Vector2f {

    public float x;
    public float y;

    public static float worldX;
    public static float worldY;

    public Vector2f() {
        x = 0;
        y = 0;
    }

    public Vector2f(Vector2f vector) {
        new Vector2f(vector.x, vector.y);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addX(float f) { x += f; }
    public void addY(float f) { y += f; }

    public void setX(float f) { x = f; }
    public void setY(float f) { y = f; }

    public void setVector(Vector2f vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldVar(float x, float y) {
        worldX = x;
        worldY = y;
    }

    public Vector2f getWorldVar() {
        return new Vector2f(x - worldX, y - worldY);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
