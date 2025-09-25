public class Equip {
    
    private String nome;
    private int peso;
    private TipoEquip tipo;

    public Equip(String nome, int peso, TipoEquip tipo) {
        this.nome = nome;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }
    
    public TipoEquip getTipo() {
        return tipo;
    }

}