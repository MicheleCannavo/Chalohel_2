package chalohel.menu.Choose;

import chalohel.utility.validator.ValidateGeneric;

/**
 * The type Choose.
 */
public class Choose {

    private static final String scelta = "\nSelect an option\n";
    private final String nameChoose;
    private final ValidateGeneric rangeChoose ;
    private int numerChoose;

    /**
     * Permette ad un utente di inserire un intero compreso tra
     * min e max inclusi. La funzione opera anche controlli di correttezza dell'input.
     *
     */
    public Choose ( String nameChoose, int numItem ) {
        this.nameChoose = nameChoose;
        String regexChoose = "[1-" + numItem + "]";
        rangeChoose= new ValidateGeneric(nameChoose, regexChoose);
        rangeChoose.setValidationRules("Insert a number between "+ regexChoose);
    }

    public void requestChoose(){
        numerChoose = Integer.parseInt(rangeChoose.request());
    }

    public int getNumerChoose() {
        return numerChoose;
    }
}