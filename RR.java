class Persona {
    String nombre;
}

public class RR {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.nombre = "Ana";
        reasignarPersona(persona);
        System.out.println("Nombre después de reasignarPersona: " + persona.nombre);  
    }

    public static void reasignarPersona(Persona persona) {
        persona = new Persona();  
        persona.nombre = "María";
    }
}
