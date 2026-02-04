public class Heroe {
    
    // 1. ATRIBUTOS (Características / Estado)
    // Son variables que pertenecen al objeto, no a un método.
    String nombre;
    int salud;
    int ataque;
    
    // 2. CONSTRUCTOR (El nacimiento)
    // Es un método especial que se llama IGUAL que la clase.
    // Se ejecuta automáticamente cuando creas un "new Heroe()".
    public Heroe(String nombreAsignado) {
        this.nombre = nombreAsignado; // "this" se refiere a "este objeto que está naciendo"
        this.salud = 100; // Todos nacen con 100 de vida
        this.ataque = 10; // Todos nacen con 10 de fuerza
    }
    
    // 3. MÉTODOS (Comportamiento / Lo que puede hacer)
    
    // Método para recibir un golpe
    public void recibirDanio(int danio) {
        this.salud = this.salud - danio;
        if (this.salud < 0) {
            this.salud = 0; // Para que no tenga vida negativa
        }
    }
    
    // Método para curarse (poción)
    public void curarse() {
        this.salud = this.salud + 20;
        if (this.salud > 100) {
            this.salud = 100; // No puede tener más de 100
        }
    }
    
    // Método para saber si sigue vivo (devuelve true o false)
    public boolean estaVivo() {
        return this.salud > 0;
    }
}