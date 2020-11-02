
/**
 *
 * @author User
 */
public interface CalculateInterface {

    void setFirstNumber(String number);

    void setSecondNumber(String number);

    void setOperator(char operator);

    public float getFirstNumber();

    public char getOperator();

    public float getSecondNumber();

    float calculate();

    float sum();

    float product();

    float divide();

    float decrease();

    float sqrtNumber();

    float square();
}
