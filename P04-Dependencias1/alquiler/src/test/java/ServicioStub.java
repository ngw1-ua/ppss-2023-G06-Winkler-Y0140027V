public class ServicioStub implements IService{
    private float precio;

    public void setPrecio(float precio){
        this.precio = precio;
    }
    @Override
    public float consultaPrecio(TipoCoche tipo) {
        return precio;
    }
}
