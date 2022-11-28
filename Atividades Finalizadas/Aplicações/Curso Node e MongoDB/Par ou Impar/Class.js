
export class imparOuPar {
    constructor(number){
        this.number = number;
    }

    result(){
       return ((this.number % 2) == 0)? console.log("Par"): console.log("Impar")
    }
}