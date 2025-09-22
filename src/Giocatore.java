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
        this.peso = 0;
        this.razza = razza;

        this.inventario = new ArrayList<>();
        this.PESO_MAX = 0;
    }

    public void attaccaMischia(Giocatore target, int danno) {

        boolean haArma = false;

        // cerco nell'inventario se ho almeno un'arma da mischia
        for (Equip e : inventario) {

            if (e.getTipo() == TipoEquip.ArmaMelee) {
                haArma = true;
                break;
            }
        }

        // controllo l'istanza del mio oggetto e attacco solo se ho l'arma
        if (!(this instanceof Guerriero) || !haArma) {
            return;
        }

        // verifico se il target ha armature e le conto
        int armature = 0;
        for (Equip e : target.getInventario()) {
            
            if (e.getTipo() == TipoEquip.Armatura)
                armature++;
        }

        // modifico i puntivita del target
        target.setHp(target.getHp() - danno / (armature + 1)); 
    }

    private void aggioraPeso() {
        peso = 0;
        for (Equip e : inventario) {
            peso += e.getPeso();
        }
        
    }

    private void svuotaInventario() {
        inventario.clear();
        aggioraPeso();
    }

    private boolean isTroppoCarico() {
        return peso > PESO_MAX;
        
    }

    public boolean aggiungiEquip(Equip e) {

       if(e.getPeso() + peso > PESO_MAX) return false;
       inventario.add(e);
        aggioraPeso();
       return true;
    }

    public boolean isMorto() {
        return hp <= 0;
    }
    public void Saluta() {
        System.out.println("Ciao, sono " + nome +   " di razza " + razza);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {

        if (hp >= HP_MAX)
            this.hp = HP_MAX;
        else
            this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public int getPeso() {
        return peso;
    }

    public ArrayList<Equip> getInventario() {
        return inventario;
    }

    
}
