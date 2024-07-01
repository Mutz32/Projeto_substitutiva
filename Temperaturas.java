public class Temperaturas {
    private double temperaturaMedia;
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public Temperaturas(double temperaturaMedia, double temperaturaMinima, double temperaturaMaxima) {
        this.temperaturaMedia = temperaturaMedia;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    @Override
    public String toString() {
        return "Temperaturas{" +
                "temperaturaMedia=" + temperaturaMedia +
                ", temperaturaMinima=" + temperaturaMinima +
                ", temperaturaMaxima=" + temperaturaMaxima +
                '}';
    }
}
