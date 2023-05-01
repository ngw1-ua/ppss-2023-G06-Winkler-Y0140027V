import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarioStub extends Calendario{
    ArrayList<Boolean> thingsToReturn;
    public String exMsg;

    public void setThingsToReturn(ArrayList<Boolean> thingsToReturn){
        this.thingsToReturn = thingsToReturn;
    }

    public ArrayList<Boolean> getThingsToReturn(){
        return this.thingsToReturn;
    }
    @Override
    public boolean es_festivo(LocalDate otroDia) throws CalendarioException{
        if (thingsToReturn == null) throw new CalendarioException(exMsg);
        Boolean aux = thingsToReturn.remove(thingsToReturn.size()-1);
        return aux.booleanValue();
    }
}
