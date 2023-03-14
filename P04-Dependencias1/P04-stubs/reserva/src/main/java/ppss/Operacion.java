package ppss;

import ppss.exceptions.IsbnInvalidoException;
import ppss.exceptions.JDBCException;
import ppss.exceptions.SocioInvalidoException;

public class Operacion implements IOperacionBO {
    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        throw new UnsupportedOperationException ("Not yet implemented");
    }
}
