public class TestableAlquilaCoches extends AlquilaCoches{
    private IService servicio;

    public void setServicio(IService serv){
        this.servicio = serv;
    }
    @Override
    public IService getInstance(){
        return servicio;
    }
}
