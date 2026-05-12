public class Personaje {

    private String nombre;
    private String clase;
    private int    nivel;
    private double vida;
    private double vidaMaxima;
    private int    ataque;
    private int    defensa;

    private static final String[] CLASES = {"Guerrero", "Mago", "Arquero"};

    public Personaje(String nombre, String clase,
                     double vidaMax, int ataque, int defensa) {
        this.nombre     = nombre;
        setClase(clase);
        this.nivel      = 1;
        this.vidaMaxima = vidaMax;
        this.vida       = vidaMax;
        this.ataque     = ataque;
        this.defensa    = defensa;
    }

    public String getNombre()     { return nombre; }
    public String getClase()      { return clase; }
    public int    getNivel()      { return nivel; }
    public double getVida()       { return vida; }
    public double getVidaMaxima() { return vidaMaxima; }
    public int    getAtaque()     { return ataque; }
    public int    getDefensa()    { return defensa; }

    public void setVida(double v) {
        if      (v < 0)          this.vida = 0;
        else if (v > vidaMaxima) this.vida = vidaMaxima;
        else                     this.vida = v;
    }

    public void setClase(String c) {
        for (String valida : CLASES) {
            if (valida.equals(c)) {
                this.clase = c;
                return;
            }
        }
        System.out.println("Clase invalida: " + c + ". Se asigna Guerrero.");
        this.clase = "Guerrero";
    }

    public void setNivel(int n) {
        if      (n < 1)  this.nivel = 1;
        else if (n > 50) this.nivel = 50;
        else             this.nivel = n;
    }

    public void recibirDano(int dano) {
        int danoReal = dano - this.defensa;
        if (danoReal < 1) danoReal = 1;
        setVida(this.vida - danoReal);
        System.out.printf("%s recibe %d de dano. HP:%.0f%n",
                nombre, danoReal, vida);
    }

    public void curar(double cantidad) {
        setVida(this.vida + cantidad);
        System.out.printf("%s curado. HP:%.0f/%.0f%n",
                nombre, vida, vidaMaxima);
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

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

    @Override
    public String toString() {
        return String.format("[%s] %s Nv%d | HP:%.0f/%.0f",
                clase, nombre, nivel, vida, vidaMaxima);
    }
}