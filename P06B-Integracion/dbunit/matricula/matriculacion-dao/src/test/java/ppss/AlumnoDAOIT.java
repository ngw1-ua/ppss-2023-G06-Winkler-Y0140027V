package ppss;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;

import org.junit.jupiter.api.*;
import ppss.matriculacion.dao.*;
import ppss.matriculacion.to.AlumnoTO;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlumnoDAOIT {

    private AlumnoTO alumno; //SUT
    private IDatabaseTester databaseTester;
    private IDatabaseConnection connection;
    @BeforeEach
    public void setUp() throws Exception {

        String cadena_conexionDB = "jdbc:mysql://localhost:3306/DBUNIT";
        databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/DBUNIT", "root", "toortoor");
        connection = databaseTester.getConnection();

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/dataset.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
        //clienteDAO = new ClienteDAO();
        alumno = new AlumnoTO();
    }
    @Test
    public void testA1() throws DAOException, SQLException, DatabaseUnitException {
        //AlumnoTO alumno = new AlumnoTO();
        alumno.setNif("33333333C");
        alumno.setFechaNacimiento(LocalDate.of(1985, 02, 22));
        alumno.setNombre("Elena Aguirre Juarez");
        Assertions.assertDoesNotThrow(()->new FactoriaDAO().getAlumnoDAO().addAlumno(alumno));


        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testA2() throws DAOException {
        alumno.setNif("11111111A");
        alumno.setFechaNacimiento(LocalDate.of(1982, 02, 22));
        alumno.setNombre("Alfonso Ramirez Ruiz");
        Exception e = assertThrows(DAOException.class, ()->{new FactoriaDAO().getAlumnoDAO().addAlumno(alumno);});

        String expectedMessage = "Error al conectar con BD";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testA3() throws DAOException {
        alumno.setNif("44444444D");
        alumno.setFechaNacimiento(LocalDate.of(1982, 02, 22));
        alumno.setNombre(null);
        Exception e = assertThrows(DAOException.class, ()->{new FactoriaDAO().getAlumnoDAO().addAlumno(alumno);});

        String expectedMessage = "Error al conectar con BD";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testA4() throws DAOException {
        alumno = null;
        Exception e = assertThrows(DAOException.class, ()->{new FactoriaDAO().getAlumnoDAO().addAlumno(alumno);});

        String expectedMessage = "Alumno nulo";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testA5() throws DAOException {
        alumno.setNif("null");
        alumno.setFechaNacimiento(LocalDate.of(1982, 02, 22));
        alumno.setNombre("Pedro Garcia Lopez");
        Exception e = assertThrows(DAOException.class, ()->{new FactoriaDAO().getAlumnoDAO().addAlumno(alumno);});

        String expectedMessage = "Error al conectar con BD";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testB1() throws DAOException, SQLException, DatabaseUnitException {
        Assertions.assertDoesNotThrow(()->new FactoriaDAO().getAlumnoDAO().delAlumno("11111111A"));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla4.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testB2() throws DAOException {
        Exception e = assertThrows(DAOException.class, ()-> {new FactoriaDAO().getAlumnoDAO().delAlumno("33333333C");});
        String expectedMessage = "Error al conectar con BD";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
