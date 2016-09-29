import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    /////////////////////////HASHMAP PART:
    private Map<String, Persona> personaMapDni = new HashMap<>();
    private Map<String, Persona> personaMapNumeroSS = new HashMap<>();
    //A PARTIR DE AQUI HACER LOS METODOS CON HASH....
    public void altaPersonaMap(Persona persona) {
        if (!personaMapDni.containsKey(persona.getDni()) && !personaMapNumeroSS.containsKey(persona.getNumSS())){
            personaMapDni.put(persona.getDni(), persona);
            personaMapNumeroSS.put(persona.getNumSS(), persona);
        }
    }

    public void bajaPersonaMap(String dni){
        personaMapNumeroSS.remove(personaMapDni.get(dni).getNumSS());
        personasList.removeIf(persona -> persona.getDni().equals(dni));
    }

    public Persona obtenerPersonaPorDNIMap(String dni){
        return personaMapDni.get(dni);
    }

    public Persona obtenerPersonaPorNumSSMap(String numSS){
        return  personaMapNumeroSS.get(numSS);
    }

    public List<Persona> obtenerPersonaRangoSalarialMap(double min, double max){
        return personaMapNumeroSS.values().stream().filter(persona -> persona.getSalario()>=min&&persona.getSalario()<max).collect(Collectors.toList());
    }

    //////////////////////ARRAYLIST PART:
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

    public Persona obtenerPersonaPorDNI(String dni) { return personasList.get(obtenerPosDNI(dni)); }

    public Persona obtenerPersonaPorNumSS(String numSS) {
            boolean enc = false;
            int i = 0;
            do {
                Persona a = personasList.get(i);
                if (a.getNumSS().equals(numSS)) {
                    enc = true;
                } else {
                    i++;
                }
            } while (enc = false);
            if (enc = false) {
                return null;
            } else {
                return personasList.get(i);
            }
    }

    /*public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
    }
    */
    public List<Persona> obtenerTodas(){
        return personasList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}

/*HASHMAP PART
    private Map<Persona> =
 */

