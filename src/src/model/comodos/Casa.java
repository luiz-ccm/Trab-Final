package model.comodos;

import java.util.List;

public class Casa {
    private List<Comodo> comodos;

    public Casa(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}
