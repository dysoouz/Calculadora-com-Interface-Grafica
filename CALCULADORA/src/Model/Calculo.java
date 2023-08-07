package Model;

public class Calculo {
    //attributes
    private double x, y;
    private int tipoCalculo;

    //methods


    public Calculo(double x, double y,int tipoCalculo) {
        this.x = x;
        this.y = y;
        this.tipoCalculo = tipoCalculo;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(int tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public double getCalculo() {
        switch (tipoCalculo) {
            case 1:
                return x + y;

            case 2:
                return x - y;

            case 3:
                return x * y;

            case 4:
                return x / y;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        if(tipoCalculo == 4){return String.format("%.2f",getCalculo());}
        return String.format("%.0f",getCalculo());
    }
}