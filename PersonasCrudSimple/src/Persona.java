public class Persona {


    private int id;
    private String name;
    private boolean activa;

    public Persona() {
    }
    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.activa = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + name + " Activa: " + activa;
    }

    public boolean isSctive() {
        return false;
    }

    public void setSctive(boolean b) {
    }

    public void setNombre(String nuevo) {
    }
}

