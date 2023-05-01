import ppss.IOperacionBO;
import ppss.exceptions.IsbnInvalidoException;
import ppss.exceptions.JDBCException;
import ppss.exceptions.ReservaException;
import ppss.exceptions.SocioInvalidoException;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class OperacionStub implements IOperacionBO {
    public ArrayList<String> thingToThrow;
    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        switch (thingToThrow.remove(0))
        {
            case "IsbnInvalidoException":
                throw new IsbnInvalidoException();
                //break;
            case "JDBCException":
                throw new JDBCException();
                //break;
            case "SocioInvalidoException":
                throw new SocioInvalidoException();
                //break;
            default:
                break;
        }
    }
}
