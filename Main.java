import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character test = new Character("amongus", 8);
        System.out.println(test.toString());
    }

    public static class Character {
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
            hitPoints = calculateHP();
            armorClass = calculateAC();
            feats = new ArrayList<>();
        }

        protected int calculateHP() {
            return calculateHP(level);
        }

        private int calculateHP(int level) {
            if (level <= 1) {
                return 10 + calculateAbilityModifier(constitution);
            }
            return calculateHP(level-1) + (level-1) * (6 + calculateAbilityModifier(constitution));
        }

        protected int calculateAbilityModifier(int score) {
            return (score-10)/2; // rounds down because integer division
        }

        protected int calculateAC() {
            return 10 + calculateAbilityModifier(dexterity);
        }

        protected void levelUp() {
            level+=1;
            hitPoints = calculateHP();
            armorClass = calculateAC();
        }

        protected int rollStat() {
            Random rand = new Random();
            int stat = 0;
            for (int i=0; i<3; i++) {
                stat += rand.nextInt(6) + 1;
            }
            return stat;
        }

        protected void addFeat(String feat) {
            feats.add(feat);
        }

        @Override
        public String toString() {
            return "Character: " + name + " Level: " + level + "\n" +
                    "HP: " + hitPoints + " | AC: " + armorClass + "\n" +
                    "STR: " + strength + " | DEX: " + dexterity + " | CON: " + constitution + "\n" +
                    "INT: " + intelligence + " | WIS: " + wisdom + " | CHA: " + charisma + "\n" +
                    "Feats: " + feats.toString();
        }
    }
}
