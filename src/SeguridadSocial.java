import java.util.List;
import java.util.ArrayList;

public class SeguridadSocial {
    private List<Persona> personasList;
    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {
        personasList.add(persona);
    }

    public void bajaPersona(String dni) {
        personasList.remove(obtenerPosDNI(dni));
    }

    public int obtenerPosDNI(String dni){
        boolean enc = false;
        int i = 0;
        do {
            Persona a =personasList.get(i);
            if (a.getDni().equals(dni)) {
                enc = true;
            }
            else{
                i++;
            }

        }while (enc=false);

        if (enc=false){
            return -1;
        }
        else{
            return i;
        }
    }

    public Persona obtenerPersonaPorDNI(String dni) {
    
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
    }

    public List<Persona> obtenerTodas(){
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}

