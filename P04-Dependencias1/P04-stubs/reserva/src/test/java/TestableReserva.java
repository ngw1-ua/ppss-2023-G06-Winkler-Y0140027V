import ppss.IOperacionBO;
import ppss.Operacion;
import ppss.Reserva;
import ppss.Usuario;

import java.util.ArrayList;

public class TestableReserva extends Reserva {
    public boolean bool;
    public ArrayList<String> Operation;
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return bool;
    }

    @Override
    public IOperacionBO operacionFactory(){
        OperacionStub op = new OperacionStub();
        op.thingToThrow = Operation;
        return op;
    }
}
