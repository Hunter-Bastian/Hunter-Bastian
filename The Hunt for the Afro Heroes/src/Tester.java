import java.util.Scanner;
public class Tester {

    public static void main(String[] args) {
    	
    	boolean flag = false;
        // TODO Auto-generated method stub
    	
    	Scanner input = new Scanner(System.in);
    	
    	Title title = new Title();
    	
    	title.frame.setVisible(true);
    	
    	int exp = 0;
    	int classSelectBuffer;
    	System.out.println("Select your class!");
    	System.out.println("[1] Paladin");
    	System.out.println("[2] Archer");
    	System.out.println("[3] Mage");
    	System.out.println("[4] Rogue");
    	System.out.println("[5] Hacker");
    	System.out.println("[6] Warrior");
    	System.out.print(">");
    	playerClass[] hero = new playerClass[1];
       
    	while(1 == 1){
            classSelectBuffer = input.nextInt();
            if(classSelectBuffer == 1){
                hero[0] = new Paladin();
                break;
            }
            else if(classSelectBuffer == 2){
                hero[0] = new Archer();
                break;
            }
            else if(classSelectBuffer == 3){
                hero[0] = new Mage();
                break;
            }
            else if(classSelectBuffer == 4){
                hero[0] = new Rogue();
                break;
            }
            else if(classSelectBuffer == 5){
                hero[0] = new Hacker();
                break;
            }
            else if(classSelectBuffer == 6){
                hero[0] = new Warrior();
                break;
            }
            else{
                System.out.println("Whoops! You selected a non-existent class.  Deviant!  Try again!");
            }
        }
       
        
        enemyClass[] sheldons = new enemyClass[2];
        sheldons[0] = new Shelldon();
        sheldons[1] = new Shelldon();
        
        Potion pot = new Potion();
        HairsprayGrenade boom = new HairsprayGrenade();
      
        hero[0].addItem(pot);
        hero[0].addItem(boom);
       
        //CombatController encounter1 = new CombatController(sheldons, hero);
        
       // for(int i = 0; i < sheldons.length; i++) {
     //   	exp += sheldons[i].getExperienceValue();
    //    }
    //    for (int i = 0; i < hero.length; i++) {
  //      	hero[i].gainExperience(exp);
      //  }
       
        playerClass[] hero2 = new playerClass[2];
        hero2[0] = hero[0];
        hero2[1] = new Paladin();
        System.out.println("finished carrying over hero data");
        System.out.println("hero2 has a length of " + hero2.length);
        
     
        
    	System.out.println("second class selection passed");
       enemyClass[] secondRound = new enemyClass[2];
       secondRound[0] = new Barbera();
       secondRound[1] = new Naughtilus();
     
       hero2[0].addItem(pot);
       hero2[0].addItem(boom);
     
       hero2[1].addItem(pot);
       hero2[1].addItem(boom);
       System.out.println("about to start second combat- items added");
      // CombatController round2 = new CombatController(secondRound, hero2);
    }

}