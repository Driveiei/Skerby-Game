<<<<<<< HEAD
package Skerby;

public class Camera {

    private double x;
    private double y;

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(Player p) {
        x = -p.getX() + Game.WIDTH / 5;
        if (x <= -17100) {
            x = -17100;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
=======
package Skerby;

public class Camera {

    private double x;
    private double y;

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(Player p) {
        x = -p.getX() + Game.WIDTH / 5;
        if (x <= -17100) {
            x = -17100;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
>>>>>>> 06492be59156b5c4a5572cd433435caf1274aceb
