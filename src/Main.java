import java.util.Scanner;
import java.util.Random;
public class Main {

    private static int at = 3;
    private static int sp = 3;
    private static int hp =10;
    private static int wd =0;
    private static int def = 4;
    private static String line1;
    private static String line2;
    private static int fightnumber=1;
    public static void main(String[] args) {
        int weapon;
        String name;
        System.out.println("The princess of the Kingdom of fire has been kidnapped.");
        System.out.println("Brave Knight, it is your job to retrieve the princess.");
        Scanner pname = new Scanner(System.in);
        System.out.println("What is our brave knight called?");
        name = pname.nextLine();
        System.out.println("We entrust our princess's saftey to you, Sir " + name);
        Scanner weaponchoice = new Scanner(System.in);
        System.out.println("What weapon will you choose? A sword, a lance, or a shield?");
        System.out.println("Enter 1 for sword, 2 for lance and 3 for spear.");
        weapon = weaponchoice.nextInt();
        weapontype(weapon);
        System.out.println("Moving out of the city, you end up at a bar in a nearby village.\n there, a drunken man challenges you to a battle");
        battle(2,1,2,8,4);
    }

    public static void weapontype(int weapon) {
        if (weapon == 1) {
            wd = wd+3;
            at = at+1;
            line1 = "Your blade ignites into flames, and you slash at your opponent.";
            line2 = "Sword ablaze, your swing leaves a small burn on the path.";
        } else if (weapon == 2) {
            sp = sp + 1;
            wd = wd+2;
            line1 = "Lance crackling with lighting, it pierces the enemies defenses";
            line2 = "Your slash your lance at the opponent, making a thunderous boom.";
        } else {
            def = def + 1;
            wd=  +wd+2;
            line1 = "Your shield tempature drops to absolute 0, your enemy is still shivering from the attack.";
            line2 = "Your shield is encased in ice, before you throw it at your opponent. " +
                    "\nIt magically flies back into your hand";
        }
    }
    public static boolean battle(int owd, int oat, int osp, int ohp, int odef){
        int choice;
        while(hp>0||ohp>0){
            System.out.println(hp+"/10");
            System.out.println(ohp+"8");
            System.out.println("What will you do, [1]attack, [2]heal or [3]buff?");
            Scanner move = new Scanner (System.in);
            choice = move.nextInt();
            if (sp>osp) {
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
                    if (hp < 10) {
                        System.out.println("Using magic, your recover one health.");
                    } else {
                        System.out.println("Your tried to restore hp, but you were at full health...");
                    }
                } else {
                    Random rand = new Random();
                    int rando = rand.nextInt(3) + 1;
                    if (rando == 1) {
                        System.out.println("Your attack went up");
                        at += 1;
                    } else if (rando == 2) {
                        System.out.println("Your defense went up");
                        def += 1;
                    } else {
                        System.out.println("Your speed went up");
                        sp += 1;
                    }
                }
                System.out.println(enemylines());
                hp -= takedamage(oat, owd);
            }

            else if (osp>sp){
                System.out.println(enemylines());
                hp -= takedamage(oat,owd);
                if (choice == 1){
                    Random random = new Random();
                    int randomnum = random.nextInt(2) + 1;
                    if (randomnum == 1) {
                        System.out.println(line1);
                    } else {
                        System.out.println(line2);
                    }
                    ohp = ohp - damage(odef);
                }
                else if (choice == 2){
                    if (hp<10){
                        System.out.println("Using magic, you recover one health");
                    }
                    else{
                        System.out.println("You tried to restore hp, but your alraedy at full health...");
                    }
                }
                else{
                    Random rand = new Random();
                    int rando = rand.nextInt(3)+1;
                    if (rando == 1){
                        System.out.println("Your attack went up");
                        at+=1;
                    }
                    else if (rando == 2){
                        System.out.println("Your defense went up");
                        def+=1;
                    }
                    else{
                        System.out.println("Your speed went up");
                        sp+=1;
                }
            }
        }

    }
    public static int damage(int odef){
        int damage = (at+wd)-(odef/2);
        return damage;

    }
    public static int takedamage(int oat, int owd){
        int damage = (oat+owd)-(def/2);
        return damage;
    }

    public static String enemylines() {
        if (fightnumber == 1) {
            return "The drunken knight swings at you";

        }
        return "hi";
    }
    public static void reset(){
            at = 3;
            sp = 3;
            hp = 10;
    }
}
