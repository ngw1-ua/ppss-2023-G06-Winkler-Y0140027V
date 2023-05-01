package ppss;

import ppss.exceptions.IsbnInvalidoException;
import ppss.exceptions.JDBCException;
import ppss.exceptions.SocioInvalidoException;

public interface IOperacionBO {
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException;
}