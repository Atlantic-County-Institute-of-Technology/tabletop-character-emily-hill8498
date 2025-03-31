import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character test = new Character("Amongus", 8);
        System.out.println(test.toString());
        Character test2 = new Character();
        System.out.println(test2);
        Barbarian test3 = new Barbarian();
        System.out.println(test3);
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

    public static class Barbarian extends Character {

        public Barbarian() {
            super();
            add_bonuses();
        }

        public  Barbarian(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            strength+=2;
            constitution+=1;
            addFeat("Rage");
            addFeat("Unarmored Defense");
        }
    }

    public static class Bard extends Character {

        public Bard() {
            super();
            add_bonuses();
        }

        public  Bard(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            charisma+=2;
            dexterity+=1;
            addFeat("Inspiration");
            addFeat("Jack of All Trades");
        }
    }

    public static class Cleric extends Character {

        public Cleric() {
            super();
            add_bonuses();
        }

        public Cleric(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            wisdom+=2;
            constitution+=1;
            addFeat("Channel Divinity");
            addFeat("Turn Undead");
        }
    }

    public static class Druid extends Character {

        public Druid() {
            super();
            add_bonuses();
        }

        public Druid(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            wisdom+=2;
            constitution+=1;
            addFeat("Wild Shape");
            addFeat("Commune with Nature");
        }
    }

    public static class Fighter extends Character {

        public Fighter() {
            super();
            add_bonuses();
        }

        public Fighter(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            dexterity+=2;
            constitution+=1;
            addFeat("Action Surge");
            addFeat("Second Wind");
        }
    }

    public static class Monk extends Character {

        public Monk() {
            super();
            add_bonuses();
        }

        public Monk(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            dexterity+=2;
            wisdom+=1;
            addFeat("Unarmored Movement");
            addFeat("Stunning Strike");
        }
    }

    public static class Paladin extends Character {

        public Paladin() {
            super();
            add_bonuses();
        }

        public Paladin(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            strength+=2;
            charisma+=1;
            addFeat("Divine Smite");
            addFeat("Aura of Protection");
        }
    }

    public static class Ranger extends Character {

        public Ranger() {
            super();
            add_bonuses();
        }

        public Ranger(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            dexterity+=2;
            intelligence+=1;
            addFeat("Favored Enemy");
            addFeat("Surefooted");
        }
    }

    public static class Rogue extends Character {

        public Rogue() {
            super();
            add_bonuses();
        }

        public  Rogue(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            dexterity+=2;
            intelligence+=1;
            addFeat("Sneak Attack");
            addFeat("Uncanny Dodge");
        }
    }

    public static class Sorcerer extends Character {

        public Sorcerer() {
            super();
            add_bonuses();
        }

        public Sorcerer(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            charisma+=2;
            constitution+=1;
            addFeat("Wild Magic");
            addFeat("Flexible Spellcasting");
        }
    }

    public static class Warlock extends Character {

        public Warlock() {
            super();
            add_bonuses();
        }

        public Warlock(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            charisma+=2;
            constitution+=1;
            addFeat("Eldritch Patron");
            addFeat("Pact Magic");
        }
    }

    public static class Wizard extends Character {

        public Wizard() {
            super();
            add_bonuses();
        }

        public Wizard(String name, int level) {
            super(name, level);
            add_bonuses();
        }

        private void add_bonuses() {
            intelligence+=2;
            constitution+=1;
            addFeat("Arcane Recovery");
            addFeat("Spell Mastery");
        }
    }
}
