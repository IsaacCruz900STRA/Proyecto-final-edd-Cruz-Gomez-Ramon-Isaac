import java.util.Comparator;
public class ComparadorClientePorId implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        return Integer.compare(cliente1.getId(), cliente2.getId()); 
    }
}
 
