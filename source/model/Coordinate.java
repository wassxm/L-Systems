package model;

public class Coordinate {

    private double x;
    private double y;
    private double z;

    /**
     * Constructeur de la classe Coordinate.
     *
     * @param x La valeur de la coordonnée x.
     * @param y La valeur de la coordonnée y.
     * @param z La valeur de la coordonnée z.
     */
    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Getter pour la coordonnée x.
     *
     * @return La valeur de la coordonnée x.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter pour la coordonnée y.
     *
     * @return La valeur de la coordonnée y.
     */
    public double getY() {
        return y;
    }

    /**
     * Getter pour la coordonnée z.
     *
     * @return La valeur de la coordonnée z.
     */
    public double getZ() {
        return z;
    }

    /**
     * Setter pour la coordonnée z.
     *
     * @param z La nouvelle valeur de la coordonnée z.
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Setter pour la coordonnée x.
     *
     * @param x La nouvelle valeur de la coordonnée x.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter pour la coordonnée y.
     *
     * @param y La nouvelle valeur de la coordonnée y.
     */
    public void setY(double y) {
        this.y = y;
    }

}