public class quicksort{ 
    public void quicksort(Cliente[] clientes, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        Cliente pivote = clientes[(inicio + fin) / 2];
        int i = inicio;
        int d = fin;
        do {
            while (clientes[i].getNombre().compareTo(pivote.getNombre()) < 0) {
                i++;
            }
            while (clientes[d].getNombre().compareTo(pivote.getNombre()) > 0) {
                d--;
            }
            if (i <= d) {
                Cliente temp = clientes[i];
                clientes[i] = clientes[d];
                clientes[d] = temp;
                i++;
                d--;
            }
        } while (i <= d);
        if (inicio < d) {
            quicksort(clientes, inicio, d);
        }
        if (fin > i) {
            quicksort(clientes, i, fin);
        }
    }
}