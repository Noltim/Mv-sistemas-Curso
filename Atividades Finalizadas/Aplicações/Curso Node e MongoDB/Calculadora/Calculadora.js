export class Calculadora {
    constructor(number1, number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    somar(){
        return this.number1 + this.number2 
    }
    subtrair(){
        return this.number1 - this.number2;
    }
    multiplicar(){
        return this.number1 * this.number2;
    }
    dividir(){
        return this.number1 / this.number2;
    }
}

