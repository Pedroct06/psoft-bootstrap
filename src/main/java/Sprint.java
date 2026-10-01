public class Sprint {
    private int id;
    private String data;
    private Funcionario lider;

    public Sprint(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getID() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void promoverLider(Funcionario dev) {
        if (!dev.temPapel(Lider.class)) {
            dev.adicionaPapel(new Lider());
        }
        this.lider = dev;
    }
}
