public interface Calculator<T> {

    T calculate(double...a);
    T interpret(T paramTiInterpret);

}
