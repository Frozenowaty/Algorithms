package listimpl;

public class ArrayList2x<T> implements IList<T> {
    private T[] array;
    private final int lengthMultiplier = 2;
    private int size = 0;

    public ArrayList2x() {
        array = (T[]) new Object[lengthMultiplier];
    }

    public ArrayList2x(int startLength) {
        array = (T[]) new Object[startLength]; //przyjmuje wartość początkową pozyskaną od użytkownika
    }

    private void checkInsertBounds(int index) { //sprawdza czy index podany przez
        // użytkownika nie wychodzi po za obszar tablicy
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkGetBounds(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isEmpty() { //sprawdzenie czy lista jest pusta, czyli gdy rozmiar listy jest 0 zwraca "true"
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) { //dodawanie wartości zadanej przez użytkownika na koniec listy
        if (array.length == size)
            extendTable();
        array[size++] = value; //size++ jest postinkrementowane po wykonaniu linijki kodu
    }

    @Override
    public void add(T value, int index) {   //dodawanie wartości zadanej przez
        // użytkownika na zadane przez niego miejsce tablicy
        checkInsertBounds(index);
        if (index == size) {
            add(value);
            return;
        }
        if (array.length == size) {
            extendTable();
        }
        T[] tmp = (T[]) new Object[array.length];
        for (int i = 0; i < index; i++) {
            tmp[i] = array[i];
        }
        tmp[index] = value;
        for (int i = index; i < size; i++) {
            tmp[i + 1] = array[i];
        }
        array = tmp;
        size++;

    }

    @Override
    public T get(int index) {
        checkGetBounds(index);
        return array[index];
    }

    @Override
    public void set(T value, int index) {
        checkGetBounds(index);
        array[index] = value;
    }

    @Override
    public void remove(int index) {
        checkGetBounds(index);
        T[] tmp = (T[]) new Object[array.length];
        for (int i = 0; i < index; i++) {
            tmp[i] = array[i];
        }
        for (int i = index + 1; i < size; i++) {
            tmp[i - 1] = array[i];
        }
        array = tmp;
        size--;
    }

    @Override
    public void swap(int index1, int index2) {
        checkGetBounds(index1);
        checkGetBounds(index2);
        T tmp = array[index1];
        array[index1]=array[index2];
        array[index2]=tmp;
    }

    private void extendTable() {
        T[] tmp = (T[]) new Object[array.length * lengthMultiplier];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }
}






