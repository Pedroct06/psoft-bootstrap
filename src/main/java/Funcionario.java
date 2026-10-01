import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private List<Papel> papeis = new ArrayList<>();

    public Funcionario(String nome, Papel papelInicial) {
        this.nome = nome;
        if (papelInicial != null) {
            this.papeis.add(papelInicial);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getPapeis() {
        if (papeis.isEmpty()) {
            return "";
        }
        String resultado = "";
        for (int i = 0; i < papeis.size(); i++) {
            Papel p = papeis.get(i);
            resultado = resultado + p.getClass().getSimpleName();
            if (i < papeis.size() - 1) {
                resultado = resultado + " ";
            }
        }
        return resultado;
    }

    public List<Papel> getListaPapeis() {
        return papeis;
    }

    public void adicionaPapel(Papel papel) {
        papeis.add(papel);
    }

    public void removePapel(Class<? extends Papel> tipo) {
        for (int i = papeis.size() - 1; i >= 0; i--) {
            Papel p = papeis.get(i);
            if (p.getClass().equals(tipo)) {
                papeis.remove(i);
            }
        }
    }

    public boolean temPapel(Class<? extends Papel> tipo) {
        for (int i = 0; i < papeis.size(); i++) {
            Papel p = papeis.get(i);
            if (p.getClass().equals(tipo)) {
                return true;
            }
        }
        return false;
    }
}
