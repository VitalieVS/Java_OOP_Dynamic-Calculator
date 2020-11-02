
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
class CalculateInterfaceImpl implements CalculateInterface {

    float firstNumber = 0;
    float secondNumber = 0;
    char operator = ' ';

    @Override
    public void setFirstNumber(String number) {
        float convertedNumber = Float.parseFloat(number);
        this.firstNumber = convertedNumber;
    }

    @Override
    public void setSecondNumber(String number) {
        float convertedNumber = Float.parseFloat(number);
        this.secondNumber = convertedNumber;
    }

    @Override
    public void setOperator(char operator) {
        this.operator = operator;
    }

    /**
     *
     * @return
     */
    @Override
    public float getFirstNumber() {
        return this.firstNumber;
    }

    @Override
    public char getOperator() {
        return this.operator;
    }

    /**
     *
     * @return
     */
    @Override
    public float getSecondNumber() {
        return this.secondNumber;
    }

    @Override
    public float calculate() {
        try {
            switch (this.operator) {
                case '+':
                    this.firstNumber = sum();
                    this.secondNumber = 0;
                    break;
                case '/':
                    this.firstNumber = divide();
                    this.secondNumber = 1;
                    break;
                case '*':
                    this.firstNumber = product();
                    this.secondNumber = 1;
                    break;
                case '-':
                    this.firstNumber = decrease();
                    this.secondNumber = 0;
                    break;
            }
        } catch (Exception e) {
            this.firstNumber = 0;
        }

        return this.firstNumber;
    }

    @Override
    public float sum() {
        return this.firstNumber + this.secondNumber;
    }

    @Override
    public float product() {
        return this.firstNumber * this.secondNumber;
    }

    @Override
    public float divide() {
        if (this.secondNumber == 0) {
            return 0;
        } else {
            return this.firstNumber / this.secondNumber;
        }
    }

    @Override
    public float decrease() {
        return this.firstNumber - this.secondNumber;
    }

    @Override
    public float square() {
        return this.firstNumber * this.firstNumber;
    }

    @Override
    public float sqrtNumber() {
        return (float) sqrt(this.firstNumber);
    }
}
