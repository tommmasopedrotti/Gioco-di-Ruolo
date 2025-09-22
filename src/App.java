public class App {
    public static void main(String[] args) throws Exception {

        Squadra team = new Squadra();
              
        Giocatore aragorn = new Guerriero("Aragorn", 100, 0, 80, Razza.Umano);
        Giocatore gandalf = new Mago("Gandalf", 80, 100, 20, Razza.Ent);
        Giocatore legolas = new Arciere("Legolas", 90, 0, 50, Razza.Elfo);

        team.aggiungiGiocatore(aragorn);
        team.aggiungiGiocatore(gandalf);
        team.aggiungiGiocatore(legolas);
        team.salutaTutti();

        Equip spada = new Equip("Anduril", 20, TipoEquip.ArmaMelee);
        aragorn.aggiungiEquip(spada);
        System.out.println("peso inventario: " + aragorn.getPeso());

        Equip elmo = new Equip("Elmo", 5, TipoEquip.Armatura);
        Equip armour = new Equip("Armatura", 30, TipoEquip.ArmaRanged);

        aragorn.attaccaMischia(legolas, 90);
    }
}
