function verificarPalimdromo(palavra) {
    let contrario = "";

    for (let index = palavra.length - 1; index >= 0; index--) {
        contrario += palavra[index];

    }

    return palavra === contrario ? console.log("True") : console.log("False")
}

module.exports = {verificarPalimdromo};