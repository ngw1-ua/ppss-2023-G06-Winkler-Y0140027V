public class MensajeException extends Throwable{
    String obsv;
    public MensajeException(String observaciones) {
        this.obsv = observaciones;
    }
}
