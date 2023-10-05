import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
public class Main {
    private static boolean win = false;
    private static boolean ruby = false;
    private static boolean genocide = false;
    private static int steal = 0;
    private static int healing=20;
    private static int at = 30;
    private static int ogat = 30;
    private static int sp = 30;
    private static int ogsp = 30;
    private static int hp = 100;
    private static int maxhp = 100;
    private static int wd = 0;
    private static int def = 40;
    private static int ogdef = 40;
    private static String line1;
    private static String line2;
    private static int fightnumber = 1;
    private static int karma = 0;
    private static int finish = 0;
    private static int gold = 100;
    private static int buffnum = 10;

    public static void main(String[] args) throws InterruptedException {
        int weapon;
        String name;
        System.out.println("The princess of the Kingdom of nature has been kidnapped by the Kingdom of the void");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Brave Knight, it is your job to retrieve the princess.");
        TimeUnit.SECONDS.sleep(1);
        Scanner pname = new Scanner(System.in);
        System.out.println("What is our brave knight called?");
        TimeUnit.SECONDS.sleep(1);
        name = pname.nextLine();
        System.out.println("We entrust our princess's saftey to you, Sir " + name);
        TimeUnit.SECONDS.sleep(1);
        Scanner weaponchoice = new Scanner(System.in);
        System.out.println("What weapon will you choose? A sword, a lance, or a shield?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Enter 1 for sword, 2 for lance and 3 for shield.");
        weapon = weaponchoice.nextInt();
        weapontype(weapon);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Moving out of the city, you end up at a bar in a nearby village." +
                "\n there, a drunken man challenges you to a battle");
        boolean win = battle(30, 20, 20, 80, 60);
        if (win == false) {
            System.exit(0);
        }
        reset();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You stare at the drunken knight on the floor. Do you want to finish the job?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Enter [1] for yes, and [2] for no.");
        karma = scanner.nextInt();
        if (karma==2){
            karma=0;
        }
        if (karma == 1) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("His head flies off his body, and blood splatters on the road." +
                    "\nYour stats increased");
            ogat += 5;
            ogdef += 5;
            ogsp += 5;
        } else {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("You leave the man along, continuing on your path to the Kingdom of the void ");
        reset();
        }
        if (karma == 1) {
            genocide = true;
            fightnumber += 1;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("A man approaches you, and hisses 'I sense your impurity'");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("'You've killed someone innocent, haven't you");
            TimeUnit.SECONDS.sleep(1);
            win = battle(10, 35, 40, 90, 55);
            if (win == false) {
                System.out.println("Dirty scum like you will always get be the victim of karmic balance");
                System.exit(0);
            }
            scanner = new Scanner(System.in);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Do you finish him off?" + "\n [1] for yes, [2] for no");
            finish = scanner.nextInt();

            if (finish == 1) {
                System.out.println("The man was stabbed through the heart by your hands");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You stats increased.");
                maxhp += 10;
                ogdef += 5;
                karma += 1;
                genocide = true;
            } else {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You decide that enough lives have ended, and moved on.");
            }
            reset();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("In the next village, you find a shopkeeper, selling artifacts and armor.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("What would you like?");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("[1] for the enchanting ooze, [2] for the Jade necklace, or [3] for a soul fragment");
            Scanner shop = new Scanner(System.in);
            int shopping = shop.nextInt();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Would you like to [1] purchase this item for 80 gold, or [2] steal the item?");
            Scanner stealing = new Scanner(System.in);

            steal = stealing.nextInt();
            if (steal == 2) {
                fightnumber += 1;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You tried to steal the item, only for the shopkeeper to catch you, and engage in battle.");
                boolean battle = battle(35, 30, 50, 70, 60);
                if (battle==false){
                    System.exit(0);
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("[1] Finish him or [2] spare him?");
                shop = new Scanner (System.in);
                int xx = shop.nextInt();
                TimeUnit.SECONDS.sleep(1);
                if (shopping <= 3){
                    System.out.println("Your stats went up");
                    ogat+=10;
                    maxhp+=10;
                    karma+=1;
                }
                TimeUnit.SECONDS.sleep(1);
                if (shopping==1){
                    System.out.println("The amount of healing you can do is increased by the liquid");
                    healing += 30;
                }
                else if (shopping == 2){
                    System.out.println("The jade necklace increases the level buff skill.");
                    buffnum+=10;
                }
                else{
                    System.out.println("The soul fragment adds to your health");
                    maxhp +=10;
                }
            }else{
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You bought the item for 80 gold. You have 20 gold left");
                gold-=80;
                TimeUnit.SECONDS.sleep(1);
                if (shopping==1){
                    System.out.println("The amount of healing you can do is increased by the liquid");
                    healing += 30;
                }
                else if (shopping == 2){
                    System.out.println("The jade necklace increases the level buff skill.");
                    buffnum+=10;
                }
                else {
                    System.out.println("The soul fragment adds to your health");
                    maxhp += 10;
                }
            }
            TimeUnit.SECONDS.sleep(1);
            reset();
            System.out.println("You walk away from the shop, and towards the castle of the kingdom of the void.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("A guard challenges you to a battle");
            fightnumber+=1;
            boolean guard = battle(15,30,10,100,80);
            if (guard==false){
                System.exit(0);
            }
            if (karma == 3){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You killed him without a second though. Your stats barely went up");
                maxhp+=5;
                ogsp+=5;
                karma+=1;
            }
            else{
                shop = new Scanner(System.in);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Do you want to [1] finish him, or [2] spare him?");
                int answer = shop.nextInt();
                if (answer == 1){
                    karma+=1;
                    maxhp+=10;
                    ogsp+=10;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("You spilt his head off from his body, blood oozed out.");
                }



            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("You enter the castle searching for the princess.");

        }
        else{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Continuing on your path, you meet a traveling merchant");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("What would you like to purchase?");
            TimeUnit.SECONDS.sleep(1);
            Scanner shop = new Scanner(System.in);
            System.out.println("[1] Sturdy armor, [2] Flaming Ruby, [3] Grindstone.");
            int shopping = shop.nextInt();
            TimeUnit.SECONDS.sleep(1);
            if (shopping == 1){
                System.out.println("You purchased the Sturdy armor for 90 gold");
                gold -=90;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You equipped the sturdy armor.");
                ogdef+=10;

            }
            else if (shopping == 2){
                System.out.println("You purchased the flaming ruby for all of your gold");
                gold=0;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The flaming ruby increases the chances of landing critical hits");

            }
            else{
                System.out.println("You purchased the grindstone for 50 gold");
                gold -=50;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The grindstone sharpens your weapon. ");
                wd+=10;
            }
            reset();
            fightnumber+=1;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("A creature of the void surprises both you and the merchant, \nthe creature screams and attacks.");
            boolean creature = battle(20,15,60,80,50);
            if (creature==false){
                System.exit(0);

            }
            else{
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The creature is left screaming on the floor");
                Scanner monster = new Scanner(System.in);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("[1]Finish it, or [2] spare it?");
                int choice = monster.nextInt();
                TimeUnit.SECONDS.sleep(1);
                if (choice == 1){
                    System.out.println("You kill it, and you feel yourself growing stronger");
                    ogsp+=10;
                    ogat+=10;
                }
                else{
                    System.out.println("You leave the creature be, and bid farewell to the merchant.");
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You arrive at the capital of the void kingdom. " +
                        "\nYou approach the castle, but a guard blocks your way.");
                reset();
                fightnumber+=1;
                boolean guard = battle(15,20,10,100,70);
                if(guard==false){
                    System.exit(0);
                }
                else{
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("The guard falls to the ground defeated");
                    Scanner knight = new Scanner(System.in);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Do you [1] kill him, or [2] spare him?");
                    int knights = knight.nextInt();
                    TimeUnit.SECONDS.sleep(1);
                    if (knights == 1){
                        System.out.println("You killed him, and your soul blackens with strength.");
                        ogdef+=10;
                        maxhp+=10;
                        karma+=1;
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You entered the castle of the void.");
                    }
                    else{
                        System.out.println("You leave the knight in pain, and storm into the castle.");
                    }
                }
            }

        }
        if (karma==0){
            System.out.println("You search the castle for the princess, " +
                    "\nonly to find the princess and king at the dining hall." +
                    "\n'Oh, so a knight has come to save me. But I don't need saving, this kidnapping scheme \n" +
                    "was created so I could take over the kingdom");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("You refuse to budge, and the princess glares at you. The king exits the room, \n" +
                    "and the princess engages you in battle.");
            reset();
            healing = 50;
            sp = 0;
            TimeUnit.SECONDS.sleep(1);
            System.out.println("'After learning the ways of the void, I can change the battlefield' the princess declares.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Your movement is sluggish, while the princess seems to have no problem. " +
                    "\n The princess will always be faster then you");
            fightnumber +=1;
            genocide = false;
            boolean princess;
            if (weapon==1) {
                princess = battle(10, 20, 40, 150, 45);
            }
            else if (weapon==2){
                princess = battle (20,20,40,140,45);

            }
            else{
                princess = battle(20,20,40,150,55) ;
            }
            if (princess == false){
                System.out.println("THe princess grins as she extracts your soul from your body.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Every part of your body is burning with pain.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("And when you look at yourself again, you are a creature of the void, " +
                        "\nskin the color of the abyss.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Your no longer"+pname+"You are a mindless monster.");
                System.exit(0);
            }
            else{
                System.out.println("The moment the princess falls to the ground, " +
                        "\nthe king shoots an arrow and kills her");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("I can't have information such as the elemental princess betraying her kingdom for me" +
                        "\n escaping now can I? Be a nice boy and go home.");
                TimeUnit.SECONDS.sleep(1);
                Scanner royalty = new Scanner(System.in);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("[1]Abide to the king or [2]refuse his offer");
                int king = royalty.nextInt();
                if (king == 1){
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("'As compensation for your silence, you shall receive gold. Now run along please.'");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("You received 200 gold.");
                    gold+=200;
                    ending();
                }
                else{
                    System.out.println("The king slames his trident into the ground, as you prepare for battle");
                    TimeUnit.SECONDS.sleep(1);
                    reset();
                    healing = 30;
                    fightnumber+=1;
                    boolean finale = battle(20,30,20,190,50);
                    if (finale = false){
                        System.out.println("The king laughs as the world fades around you");
                        System.exit(0);
                    }
                    else{
                        System.out.println("The king falls to the ground, and dies of his injuries");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You return the elemental kingdom as a disgrace, \n" +
                                "for allowing the princess to die.");
                        ending();
                    }

                }

            }
        }
        else if (karma == 4){
            System.out.println("Searching the castle for the princess, \n" +
                    "you sense an overwhelming dreadful power fall upon you");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("You find the source of the power to be the princess itself, " +
                    "\nabsorbing the god of the void ");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The amalgamation that was the princess grins at you, before saying \n" +
                    "'Don't worry dear knight, my transformation was intentional");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Your attacked by the ¿Princess?");
            TimeUnit.SECONDS.sleep(1);
            genocide=true;
            ogat+=20;
            wd+=10;
            reset();
            fightnumber+=1;
            boolean princess = battle(20,35,80,200,45);
            if (princess == false){
                System.out.println("You can hear the ¿Princess? shreaking in laughter as you die.");
                System.exit(0);
            }
            else{
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The ¿Princess? falls to the ground unconscious, " +
                        "\n as the void jumps out of her body.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You bring the princess home and are hailed a hero.");
                win = true;
            }
        }
        else{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Before you can get any progress of finding the princess, \n" +
                    "a man with a large battle axe slashes at you from behind.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("I am the kings right hand man, and you will die now.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Your powers feel altered, and you stare at the man.\n" +
                    "I switched your attack and defense stats. Now, lets battle.");
            TimeUnit.SECONDS.sleep(1);
            healing =40;
            reset();
            at = ogdef;
            def = ogat;
            boolean execute = battle(25,15,50,140,60);
            if (execute = false){
                System.out.println("An axe chops your head off");
                System.exit(0);
            }
            else{
                System.out.println("You defeated the knight, only for a massive surge of power to cripple you");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("It seems, that knight was simply stalling for the king to prepare something bigger");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Alas, you are too weak and die to your injuries");
                ending();
            }
        }

    }

    public static void weapontype(int weapon) {
        if (weapon == 1) {
            wd = wd + 30;
            at = at + 10;
            line1 = "Your blade ignites into flames, and you slash at your opponent.";
            line2 = "Sword ablaze, your swing leaves a small burn on the path.";
        } else if (weapon == 2) {
            sp = sp + 10;
            wd = wd + 30;
            line1 = "Lance crackling with lighting, it pierces the enemies defenses";
            line2 = "Your slash your lance at the opponent, making a thunderous boom.";
        } else {
            def = def + 10;
            wd = +wd + 30;
            line1 = "Your shield tempature drops to absolute 0, your enemy is still shivering from the attack.";
            line2 = "Your shield is encased in ice, before you throw it at your opponent. " +
                    "\nIt magically flies back into your hand";
        }
    }

    public static boolean battle(int owd, int oat, int osp, int ohp, int odef) throws InterruptedException{
        int choice;
        int health = hp;
        int ophp = ohp;
        while (hp > 0 && ohp > 0) {
            System.out.println("Hp" + hp + "/" + health);
            System.out.println("Opponents hp " + ohp + "/" + ophp);
            System.out.println("What will you do, [1]attack, [2]heal or [3]buff?");
            Scanner move = new Scanner(System.in);
            choice = move.nextInt();
            TimeUnit.SECONDS.sleep(1);
            if (sp > osp) {
                if (choice == 1) {
                    Random random = new Random();
                    int randomnum = random.nextInt(2) + 1;
                    if (randomnum == 1) {
                        System.out.println(line1);
                    } else {
                        System.out.println(line2);
                    }
                    ohp = ohp - damage(odef);
                    if (ohp <= 0) {
                        break;
                    }
                } else if (choice == 2) {
                    if (hp < maxhp && hp + healing <= maxhp) {
                        System.out.println("Using magic, your recovered some health.");
                        hp += healing;

                    } else if (hp < maxhp) {
                        System.out.println("Using magic, you recover to max health");
                        hp = maxhp;
                    } else {
                        System.out.println("Your tried to restore hp, but you were at full health...");
                    }
                } else {
                    Random rand = new Random();
                    int rando = rand.nextInt(3) + 1;
                    if (rando == 1) {
                        System.out.println("Your attack went up");
                        at += buffnum;
                    } else if (rando == 2) {
                        System.out.println("Your defense went up");
                        def += buffnum;
                    } else {
                        System.out.println("Your speed went up");
                        sp += buffnum;
                    }
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println(enemylines());
                hp -= takedamage(oat, owd);
            } else if (osp > sp) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(enemylines());
                hp -= takedamage(oat, owd);
                TimeUnit.SECONDS.sleep(1);
                if (hp<=0){
                    break;
                }
                if (choice == 1) {
                    Random random = new Random();
                    int randomnum = random.nextInt(2) + 1;
                    if (randomnum == 1) {
                        System.out.println(line1);
                    } else {
                        System.out.println(line2);
                    }
                    ohp = ohp - damage(odef);

                } else if (choice == 2) {
                    if (hp < maxhp && hp+healing <= maxhp) {
                        System.out.println("Using magic, you recover some health");
                        hp+=healing;
                    }
                    else if (hp<100){
                        System.out.println("You healed to full health");
                        hp=maxhp;
                    }
                    else {
                        System.out.println("You tried to restore hp, but your already at full health...");
                    }
                } else {
                    Random rand = new Random();
                    int rando = rand.nextInt(3) + 1;
                    if (rando == 1) {
                        System.out.println("Your attack went up");
                        at += buffnum;
                    } else if (rando == 2) {
                        System.out.println("Your defense went up");
                        def += buffnum;
                    } else {
                        System.out.println("Your speed went up");
                        sp += buffnum;
                    }
                }
            }
        }
        if (hp <= 0) {
            System.out.println("You perished in battle.");
            return false;
        } else {
            System.out.println("You defeated the enemy");
            return true;
        }

    }

    public static int damage(int odef) {
        int damage = (at + wd) - (odef / 2);
        Random random = new Random();
        if (ruby == true){
            int crit = random.nextInt(6)+1;
            if (crit==6){
                damage*=1.5;
                System.out.println("You hit a critical spot.");
            }
        }
        else {
            int crit = random.nextInt(12) + 1;
            if (crit==12){
                damage*=1.5;
                System.out.println("You hit a critical spot.");
            }
        }

        return damage;

    }

    public static int takedamage(int oat, int owd) {
        double defense = (def/2);
        int damage;
        if (defense %2==0){
             damage = (oat+owd)-(def/2);
        }
        else {
            int formula = (int) Math.round(defense);
             damage = (oat + owd)- formula;
        }
        Random random = new Random();
        int crit = random.nextInt(12) + 1;
        if (crit == 12) {
            damage *= 1.5;
            System.out.println("That was a critical hit.");
        }
        return damage;
    }

    public static String enemylines() {
        if (fightnumber == 1) {
            return "The drunken knight swings at you";
        }
        if (genocide == true) {
            if (fightnumber == 2) {
                return "The bringer of justice jabs his staff at you";
            }
            else if (fightnumber == 3) {
                if (steal == 2) {
                    return "You hear the jingle of coins as the shop keeper attacks";
                }
                else {
                    return "The guard smashes his axe against your armor.";
                }


            }
            else if (fightnumber == 4 ){
                return "The guard smashes his axe against your armor";
            }
            else if (fightnumber == 5){
                return "The ¿Princess? drowns you in the abyss. You feel a shard of your soul scream in pain";
            }
        }
        else {
            if (fightnumber == 2) {
                return "The creature of the void screams in distorted voice, claws ravaging your armor.";
            } else if (fightnumber == 3) {

                return "The guard smashes his axe against your armor";
            } else if (fightnumber == 4) {
                return "The princess swings her sword at you, its darkness sends chills down your spine";
            }
            else if (fightnumber == 5){
                return "The king thrust his trident at your armor.";
            }
        }
        return "hi";
    }
    public static void reset() {
        at = ogat;
        sp = ogsp;
        hp = maxhp;
        def = ogdef;


    }
    public static void ending(){
        int score = gold/2;
        if (win == true ){
            score +=5;
        }
        score += karma*2*10;
        System.out.println("Thank you for playing the game");
        System.out.println("This is your score: "+score);
        System.exit(0);
    }
}
