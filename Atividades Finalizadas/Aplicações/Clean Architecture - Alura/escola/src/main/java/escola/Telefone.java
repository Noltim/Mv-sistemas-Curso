package escola;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if(numero == null || ddd == null){
            throw new IllegalArgumentException("DDD e Número são obrigatorios");
        }
        if(!ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("DDD é invalido");
        }
        if(!numero.matches("\\d{8}|\\d{9}")){
            throw new IllegalArgumentException("Número é invalido");
        }
        this.ddd = ddd;
        this.numero = numero;
    }
}
