package ppss.ejercicio2;

public class TestableGestorLlamadas extends GestorLlamadas{
    public int hora;
    public void setHora(int hora){
        this.hora = hora;
    }
    @Override
    public Calendario getCalendario() {
        CalendarioStub cs = new CalendarioStub();
        cs.setHora(hora);
        return cs;
    }
}
