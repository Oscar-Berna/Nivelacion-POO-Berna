public class Personaje {

    // Atributos del personaje
    String nombre;
    String clase;
    int    nivel;
    double vida;
    double vidaMaxima;
    int    ataque;
    int    defensa;

    // Constructor
    public Personaje(String nombre, String clase,
                     double vidaMax, int ataque, int defensa) {
        this.nombre     = nombre;
        this.clase      = clase;
        this.nivel      = 1;
        this.vida       = vidaMax;
        this.vidaMaxima = vidaMax;
        this.ataque     = ataque;
        this.defensa    = defensa;
    }

    // toString
    @Override
    public String toString() {
        return String.format("[%s] %s Nv%d | HP:%.0f/%.0f",
                clase, nombre, nivel, vida, vidaMaxima);
    }

    // Ejercicio 1A: barra de vida
    public void mostrarEstado() {
        double pct     = (vida / vidaMaxima) * 100;
        int    relleno = (int)(pct / 10);
        String barra   = "#".repeat(relleno) + ".".repeat(10 - relleno);

        String estado;
        if      (pct <= 0)  estado = "MUERTO";
        else if (pct <= 25) estado = "CRITICO";
        else if (pct <= 50) estado = "HERIDO";
        else if (pct <= 75) estado = "ESTABLE";
        else                estado = "SALUDABLE";

        System.out.printf("[%s] %.0f%% - %s%n", barra, pct, estado);
    }
}   
