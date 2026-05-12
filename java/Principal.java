public class Principal {

    public static void main(String[] args) {

        Personaje guerrero = new Personaje("Aragorn", "Guerrero", 100, 18, 12);
        Personaje mago     = new Personaje("Gandalf", "Mago",      70, 28,  5);

        System.out.println("===== PERSONAJES =====");
        System.out.println(guerrero);
        System.out.println(mago);

        System.out.println("\n===== COMBATE =====");
        guerrero.recibirDano(25);
        guerrero.mostrarEstado();

        System.out.println("\n===== CURACION =====");
        guerrero.curar(10);
        guerrero.mostrarEstado();

        System.out.println("\nGuerrero vivo: " + guerrero.estaVivo());

        System.out.println("\n===== SETTER NIVEL =====");
        guerrero.setNivel(0);
        System.out.println("Nivel con 0:  " + guerrero.getNivel());
        guerrero.setNivel(75);
        System.out.println("Nivel con 75: " + guerrero.getNivel());
        guerrero.setNivel(10);
        System.out.println("Nivel con 10: " + guerrero.getNivel());

        System.out.println("\n===== CLASE INVALIDA =====");
        guerrero.setClase("Dios");
        System.out.println("Clase: " + guerrero.getClase());
    }
}