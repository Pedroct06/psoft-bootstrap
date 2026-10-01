import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Time> times = new ArrayList<>();
    private Funcionario productOwner;

    public Empresa(String nome, Funcionario productOwner) {
        this.nome = nome;
        this.productOwner = productOwner;
        if (!productOwner.temPapel(ProductOwner.class)) {
            productOwner.adicionaPapel(new ProductOwner());
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void addTimes(Time time) {
        if (!times.contains(time)) {
            times.add(time);
        }
    }

    public void removeTimes(Time time) {
        times.remove(time);
    }

    public Funcionario getPO() {
        return productOwner;
    }

    public void promoverPO(Funcionario gerente) {
        gerente.removePapel(Gerente.class);
        gerente.removePapel(Desenvolvedor.class);
        gerente.removePapel(Lider.class);
        if (!gerente.temPapel(ProductOwner.class)) {
            gerente.adicionaPapel(new ProductOwner());
        }
        this.productOwner = gerente;
    }
}
