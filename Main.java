import java.util.ArrayList;

public class Main {
    public class Character {
        protected int strength;
        protected int dexterity;
        protected int constitution;
        protected int intelligence;
        protected int wisdom;
        protected int charisma;
        protected String name;
        protected int level;
        protected int hitPoints;
        protected int armorClass;
        protected ArrayList<String> feats;


        public Character() {
            name = "Player";
            level = 1;
            strength = 10;
            dexterity = 10;
            constitution = 10;
            intelligence = 10;
            wisdom = 10;
            charisma = 10;
            hitPoints = calculateHP();
            armorClass = calculateAC();
            feats = new ArrayList<>();
        }

        public Character(String name, int level) {
            this.name = name;
            this.level = level;
            strength = rollStat();
            dexterity = rollStat();
            constitution = rollStat();
            intelligence = rollStat();
            wisdom = rollStat();
            charisma = rollStat();
        }
    }
}
