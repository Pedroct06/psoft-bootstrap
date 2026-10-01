import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String produto;
    private Funcionario gerente;
    private List<Funcionario> equipe = new ArrayList<>();
    private List<Sprint> sprints = new ArrayList<>();

    public Time(String nome, String produto, Funcionario gerente) {
        this.nome = nome;
        this.produto = produto;
        this.gerente = gerente;
        if (!gerente.temPapel(Gerente.class)) {
            gerente.adicionaPapel(new Gerente());
        }
    }

    public String getNome() {
        return nome;
    }

    public String getProduto() {
        return produto;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public List<Funcionario> getEquipe() {
        return equipe;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void addDev(Funcionario dev) {
        if (!dev.temPapel(Desenvolvedor.class)) {
            dev.adicionaPapel(new Desenvolvedor());
        }
        if (!equipe.contains(dev)) {
            equipe.add(dev);
        }
    }

    public void removDev(Funcionario dev) {
        equipe.remove(dev);
    }

    public void addSprint(Sprint sprint) {
        sprints.add(sprint);
    }

    public void removeSprint(Sprint sprint) {
        sprints.remove(sprint);
    }

   
    public void promoveGerente(Funcionario dev) {
        dev.removePapel(Desenvolvedor.class);
        dev.removePapel(Lider.class);
        if (!dev.temPapel(Gerente.class)) {
            dev.adicionaPapel(new Gerente());
        }
        equipe.remove(dev);
        this.gerente = dev;
    }
}
