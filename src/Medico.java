public class Medico extends Giocatore {
    
    public Medico(String nome, int hp, int mana, int peso, Razza razza) {
        super(nome, hp, mana, peso, razza);  

        
    }

    private final int MANA_ATT = 20;
    private final int MANA_CURA = 10;
    private final int cura = 30;
    
    public void ricaricaMana() {
    
        mana = MANA_MAX;
    }

    @Override
    public int attacca(Giocatore target, int danno) {
    
        if(target.isMorto()) return 0;

        if(mana - MANA_ATT>=0){
            mana -= MANA_CURA;
           
            int nuovoHp = target.getHp() + cura;
            target.setHp(nuovoHp > HP_MAX? target.HP_MAX:  nuovoHp);
            return cura;
        }
        return 0;

    }

    public boolean rianima(Giocatore target) {
    
        if(!target.isMorto()) return false;

       
        target.setHp(HP_MAX/4);
        return true;
    }

}
