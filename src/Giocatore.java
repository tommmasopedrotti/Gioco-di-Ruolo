import java.util.ArrayList;

public abstract class Giocatore {
    
    protected String nome;
    protected int hp;
    protected int mana;
    protected int peso;
    protected final int HP_MAX, MANA_MAX, PESO_MAX;
    protected Razza razza;
    protected ArrayList<Equip> inventario;

    public Giocatore(String nome, int hp, int mana, int peso, Razza razza) {
        this.nome = nome;
        this.hp = this.HP_MAX = hp;
        this.mana = this.MANA_MAX = mana;
        this.peso = this.PESO_MAX = peso;
        this.razza = razza;

        this.inventario = new ArrayList<>();
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getPeso() {
        return peso;
    }

    
}
