package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    static final int CAPACITY = 12;
    static final int TOP_INDEX = 11;
    static final int EMPTY_RHYMER_INDICATOR = -1;
    static final int DEFAULT_RETURN_VALUE = -1;

    private int[] numbers = new int[CAPACITY];

    public int total = EMPTY_RHYMER_INDICATOR;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    public boolean isFull() {
        return total == TOP_INDEX;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total--];
    }

}
