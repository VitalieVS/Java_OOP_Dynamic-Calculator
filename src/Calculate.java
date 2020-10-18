 import static java.lang.Math.sqrt;

public class Calculate  { 
    float firstNumber = 0;
    float secondNumber = 0;
    char operator = ' ';


    void setFirstNumber(String number) {
        float convertedNumber = Float.parseFloat(number);
        this.firstNumber = convertedNumber;
    }

    void setSecondNumber(String number) {
        float convertedNumber = Float.parseFloat(number);
        this.secondNumber = convertedNumber;
    }

    void setOperator(char operator) {
        this.operator = operator;
    }

    /**
     *
     * @return
     */
    public float getFirstNumber() {
        return this.firstNumber;
    }
    
    public char getOperator() {
        return this.operator;
    }

    /**
     *
     * @return
     */
    public float getSecondNumber() {
        return this.secondNumber;
    }

    float calculate() {
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
            }
            catch (Exception e) {
                this.firstNumber = 0;
            }
            
            return this.firstNumber;
        }  

    float sum() {
        return this.firstNumber + this.secondNumber;
    }

    float product() {
        return this.firstNumber * this.secondNumber;
    }

    float divide() {
        if (this.secondNumber == 0) {
            return 0;
        } else 
        return this.firstNumber / this.secondNumber;
    }
    
    float decrease() {
        return this.firstNumber - this.secondNumber;
    }
    
    float square() {
        return this.firstNumber*this.firstNumber;
    }
    
    float sqrtNumber() {
        return (float) sqrt(this.firstNumber);
    }

}
