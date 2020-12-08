package exercicio01.modelo;

public class Item {

    private Integer numero;
    private double valor;

    public Item() {

    }

    public Item(Integer numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
