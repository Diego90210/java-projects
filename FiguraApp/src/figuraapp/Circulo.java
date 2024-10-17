package figuraapp;

public class Circulo extends Figura {
    private Punto centro;
    private float radio;

    public Circulo(){
        super();
        centro = new Punto();
        radio = 1;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public void setCentro (float x, float y){
        centro.setX(x);
        centro.setY(y);
    }

    @Override
    public double area() {
        return Math.PI*(radio*radio);
    }

    @Override
    public String toString() {
        return super.toString() + ", es un circulo." +
                " Y su area es = " + area();
    }

    @Override
    public void dibuja() {
        super.dibuja();
        System.out.println(" un circulo");
    }

    @Override
    public void borra() {
        super.borra();
        System.out.println(" un circulo");
    }


}
