package fraction;


public class Fraction {
    int numerator;
    int denominator;
    
    public Fraction(int numr, int denr){
        numerator = numr;
        denominator = denr;
        reduce();
    }
    
    public int getNumerator(){
        return numerator;
    }
    
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }
    
    public int getDenominator() {
	return denominator;
    }
    
    public void setDenominator(int deninominator){
        this.denominator = denominator;
    }
    
    
    public int calculateGCD(int numerator, int denominator){
        if (numerator % denominator == 0){
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }
    
    
    void reduce(){
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    
    
    public Fraction add(Fraction fractionTwo){
        int numer = (numerator * fractionTwo.getDenominator()) +
                (fractionTwo.getNumerator() * denominator);
        int denr = denominator * fractionTwo.getDenominator();
        return new Fraction(numer, denr);
    }
    
    
    public Fraction subtract(Fraction fractionTwo){
        int newNumerator = (numerator * fractionTwo.denominator) - 
                        (fractionTwo.numerator * denominator);
        int newDenominator = denominator * fractionTwo.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }
    
    public Fraction Multiply(Fraction fractionTwo){
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }
    
    public Fraction divide(Fraction fractionTwo) {
	int newNumerator = numerator * fractionTwo.getDenominator();
	int newDenominator = denominator * fractionTwo.numerator;
	Fraction result = new Fraction(newNumerator, newDenominator);
	return result;
    }
    
    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    
    public static void main(String[] args) {
        Fraction f1 = new Fraction(5, 7);
        System.out.println(f1.toString());
        Fraction f2 = new Fraction(2, 7);
        Fraction f3 = f1.add(f2);
        System.out.println("Hasil " + f1 + " + " + f2 + " adalah : " + f3);
        f3 = f1.subtract(f2);
        System.out.println("Hasil " + f1 + " + " + f2 + " adalah : " + f3);
        f3 = f1.divide(f2);
        System.out.println("Hasil " + f1 + " + " + f2 + " adalah : " + f3);
        f3 = f1.Multiply(f2);
        System.out.println("Hasil " + f1 + " + " + f2 + " adalah : " + f3);
        
        
    }
    
}
