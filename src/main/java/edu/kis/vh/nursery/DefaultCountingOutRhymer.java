package edu.kis.vh.nursery;

/**
 * Prosta struktura danych o stałej pojemności, działająca jak stos (LIFO),
 * wykorzystywana do symulowania mechanizmu „wyliczanki”.
 * Elementy są dodawane metodą {@code countIn} i usuwane metodą {@code countOut}.
 * Struktura przechowuje maksymalnie 12 elementów.
 * W przypadku próby odczytu z pustej struktury zwracana jest wartość domyślna (-1).
 */
public class DefaultCountingOutRhymer {

    /** Maksymalna liczba elementów, które można przechować. */
    private static final int CAPACITY = 12;

    /** Indeks ostatniego elementu przy pełnej strukturze. */
    private static final int TOP_INDEX = 11;

    /** Wartość oznaczająca pustą strukturę. */
    private static final int EMPTY_RHYMER_INDICATOR = -1;

    /** Domyślna wartość zwracana w przypadku błędu lub pustej struktury. */
    private static final int DEFAULT_RETURN_VALUE = -1;

    /** Tablica przechowująca elementy. */
    private final int[] numbers = new int[CAPACITY];

    /** Indeks aktualnego „szczytu” stosu. */
    private int total = EMPTY_RHYMER_INDICATOR;

    /**
     * Zwraca indeks aktualnego elementu na szczycie.
     *
     * @return indeks szczytu lub -1, jeśli struktura jest pusta
     */
    public int getTotal(){
        return total;
    }

    /**
     * Dodaje element do struktury, jeśli nie jest ona pełna.
     *
     * @param in liczba do dodania
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Sprawdza, czy struktura jest pusta.
     *
     * @return true, jeśli brak elementów; false w przeciwnym przypadku
     */
    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    /**
     * Sprawdza, czy struktura osiągnęła maksymalną pojemność.
     *
     * @return true, jeśli struktura jest pełna; false w przeciwnym przypadku
     */
    public boolean isFull() {
        return total == TOP_INDEX;
    }

    /**
     * Zwraca element ze szczytu bez jego usuwania.
     *
     * @return element ze szczytu lub -1, jeśli struktura jest pusta
     */
    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total];
    }

    /**
     * Usuwa i zwraca element ze szczytu struktury.
     *
     * @return usunięty element lub -1, jeśli struktura jest pusta
     */
    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total--];
    }

}