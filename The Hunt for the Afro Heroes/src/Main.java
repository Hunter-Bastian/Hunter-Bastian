
public class Main {

	public static void main(String[] args) {
		//title screen
		Title title = new Title();
		
		title.frame.setVisible(true);
		title.panel.setVisible(true);
		title.label.setVisible(true);
		
		while(title.getNewGame() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
		title.panel.setVisible(false);
		title.label.setVisible(false);
		
		//character selection
		CharacterSelection charSelect = new CharacterSelection(title.frame);
		while(charSelect.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
		//1st char selection
		System.out.println( charSelect.getName() );
		int classSelectBuffer;
		classSelectBuffer = charSelect.getCharSelectionBuffer();
		playerClass[] hero = new playerClass[1];
		
		if(classSelectBuffer == 0){
            hero[0] = new Paladin();
        }
        else if(classSelectBuffer == 1){
            hero[0] = new Mage();
        }
        else if(classSelectBuffer == 2){
            hero[0] = new Rogue();
        }
		hero[0].setName(charSelect.getName());
		
		Transition_1 t1 = new Transition_1(title.frame);
		
		enemyClass[] sheldons = new enemyClass[2];
        sheldons[0] = new Shelldon();
        sheldons[1] = new Shelldon();
        
        Potion pot = new Potion();
        HairsprayGrenade boom = new HairsprayGrenade();
      
        hero[0].addItem(pot);
        hero[0].addItem(boom);
        while(t1.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
        t1.setContFlag(false);
        while(t1.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
        t1.setContFlag(false);
        while(t1.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
        Loading load1 = new Loading(title.frame);
        CombatController encounter1 = new CombatController(sheldons, hero, title.frame);
        while(load1.getContFlag() == false){
		    try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
		}
			
	        System.out.print("Making new party now");
	        playerClass[] hero2 = new playerClass[2];
	        hero2[0] = hero[0];
	        hero2[1] = new Warrior();
	        System.out.println("second Transition reached.");
	        Transition_2 t2 = new Transition_2(title.frame);
	        while(t2.getContFlag() == false){
			    try {
			       Thread.sleep(200);
			    } catch(InterruptedException e) {
			    }
			}
	        t2.setContFlag(false);
	        while(t2.getContFlag() == false){
			    try {
			       Thread.sleep(200);
			    } catch(InterruptedException e) {
			    }
			}
	        t2.setContFlag(false);
	        while(t2.getContFlag() == false){
			    try {
			       Thread.sleep(200);
			    } catch(InterruptedException e) {
			    }
			}
	        System.out.println("second Transition passed.");
	        //second encounter
	        enemyClass[] naughtyBarbera = new enemyClass[2];
	        naughtyBarbera[0] = new Naughtilus();
	        naughtyBarbera[1] = new Barbera();
	        
	        naughtyBarbera[0].levelUp();
	      
	        hero2[0].addItem(pot);
	        hero2[0].addItem(boom);
	        hero2[1].addItem(pot);
	        hero2[1].addItem(boom);
	        
	        hero2[0].levelUp();
	        hero2[1].levelUp();
	        
	       
	        CombatController encounter2 = new CombatController(naughtyBarbera, hero2, title.frame);
	        Loading load2 = new Loading(title.frame);
	        load2.panel.setVisible(false);
		        //3rd char select
		       
		        playerClass[] hero3 = new playerClass[3];
		        hero3[0] = hero2[0];
		        hero3[1] = hero2[1];
		        hero3[2] = new Archer();
				
		        Transition_3 t3 = new Transition_3(title.frame);
		        while(t3.getContFlag() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
		        t3.setContFlag(false);
		        while(t3.getContFlag() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
		        t3.setContFlag(false);
		        while(t3.getContFlag() == false){
				    try {
				       Thread.sleep(200);
				    } catch(InterruptedException e) {
				    }
				}
		        //encounter 3
		        enemyClass[] knottyHair = new enemyClass[3];
		        knottyHair[0] = new Naughtilus();
		        knottyHair[1] = new Hairizzle();
		        knottyHair[2] = new Knotty();
		        
		        knottyHair[0].levelUp();
		        knottyHair[0].levelUp();
		        knottyHair[0].levelUp();
		        
		        knottyHair[1].levelUp();
		        knottyHair[1].levelUp();
		        
		        knottyHair[2].levelUp();
		      
		        hero3[0].addItem(pot);
		        hero3[0].addItem(boom);
		        hero3[1].addItem(pot);
		        hero3[1].addItem(boom);
		        hero3[2].addItem(pot);
		        hero3[2].addItem(boom);
		        
		        hero3[0].levelUp();
		        hero3[1].levelUp();
		        hero3[2].levelUp();
		        hero3[2].levelUp();
		       
		        CombatController encounter3 = new CombatController(knottyHair, hero3, title.frame);
		        Loading load3 = new Loading(title.frame);
		        load3.panel.setVisible(false);
			        //4th char select
			        playerClass[] hero4 = new playerClass[4];
			        hero4[0] = hero3[0];
			        hero4[1] = hero3[1];
			        hero4[2] = hero3[2];
			        hero4[3] = new Hacker();
					
			        Transition_4 t4 = new Transition_4(title.frame);
			        while(t4.getContFlag() == false){
					    try {
					       Thread.sleep(200);
					    } catch(InterruptedException e) {
					    }
					}
			        t4.setContFlag(false);
			        while(t4.getContFlag() == false){
					    try {
					       Thread.sleep(200);
					    } catch(InterruptedException e) {
					    }
					}
			        t4.setContFlag(false);
			        while(t4.getContFlag() == false){
					    try {
					       Thread.sleep(200);
					    } catch(InterruptedException e) {
					    }
					}
			        //encounter 4
			        enemyClass[] wetHair = new enemyClass[4];
			        wetHair[0] = new Droplet();
			        wetHair[1] = new Hairizzle();
			        wetHair[2] = new Droplet();
			        wetHair[3] = new Droplet();
			        
			        wetHair[1].levelUp();
			        wetHair[1].levelUp();
			        wetHair[1].levelUp();
			        wetHair[1].levelUp();
			        
			        wetHair[0].levelUp();
			        wetHair[0].levelUp();
			        wetHair[0].levelUp();
			        wetHair[0].levelUp();
			        
			        wetHair[2].levelUp();
			        wetHair[2].levelUp();
			        wetHair[2].levelUp();
			    
			        wetHair[3].levelUp();
			        wetHair[3].levelUp();
			      
			        hero4[0].addItem(pot);
			        hero4[0].addItem(boom);
			        hero4[1].addItem(pot);
			        hero4[1].addItem(boom);
			        hero4[2].addItem(pot);
			        hero4[2].addItem(boom);
			        hero4[3].addItem(pot);
			        hero4[3].addItem(boom);
			        
			        hero4[0].levelUp();
			        hero4[1].levelUp();
			        hero4[2].levelUp();
			        hero4[3].levelUp();
			        hero4[3].levelUp();
			        hero4[3].levelUp();
			       
			        CombatController encounter4 = new CombatController(wetHair, hero4, title.frame);
			        Loading load4 = new Loading(title.frame);
			        load4.panel.setVisible(false);
				        //final char selection
				        playerClass[] hero5 = new playerClass[5];
				        hero5[0] = hero4[0];
				        hero5[1] = hero4[1];
				        hero5[2] = hero4[2];
				        hero5[3] = hero4[3];
				        hero5[4] = new Rogue();
				        
				        Transition_5 t5 = new Transition_5(title.frame);
				        while(t5.getContFlag() == false){
						    try {
						       Thread.sleep(200);
						    } catch(InterruptedException e) {
						    }
						}
				        t5.setContFlag(false);
				        while(t5.getContFlag() == false){
						    try {
						       Thread.sleep(200);
						    } catch(InterruptedException e) {
						    }
						}
				        t5.setContFlag(false);
				        while(t5.getContFlag() == false){
						    try {
						       Thread.sleep(200);
						    } catch(InterruptedException e) {
						    }
						}
				        
				      //encounter 5
				        enemyClass[] froForce = new enemyClass[5];
				        froForce[0] = new Droplet();
				        froForce[1] = new Hairizzle();
				        froForce[2] = new Froseidon();
				        froForce[3] = new Naughtilus();
				        froForce[4] = new Shelldon();
				        
				        froForce[0].levelUp();
				        froForce[0].levelUp();
				        froForce[0].levelUp();
				        froForce[0].levelUp();
				        
				        froForce[1].levelUp();
				        froForce[1].levelUp();
				        froForce[1].levelUp();
				        froForce[1].levelUp();
				        
				        froForce[2].levelUp();
				        froForce[2].levelUp();
				        froForce[2].levelUp();
				        froForce[2].levelUp();
				        
				        froForce[3].levelUp();
				        froForce[3].levelUp();
				        froForce[3].levelUp();
				        froForce[3].levelUp();
				        froForce[3].levelUp();
				        froForce[3].levelUp();
				        
				        froForce[4].levelUp();
				        froForce[4].levelUp();
				        froForce[4].levelUp();
				        froForce[4].levelUp();
				        
				      
				        hero5[0].addItem(pot);
				        hero5[0].addItem(boom);
				        hero5[1].addItem(pot);
				        hero5[1].addItem(boom);
				        hero5[2].addItem(pot);
				        hero5[2].addItem(boom);
				        hero5[3].addItem(pot);
				        hero5[3].addItem(boom);
				        hero5[4].addItem(pot);
				        hero5[4].addItem(boom);
				        
				        hero5[0].levelUp();
				        hero5[1].levelUp();
				        hero5[2].levelUp();
				        hero5[3].levelUp();
				        hero5[4].levelUp();
				        hero5[4].levelUp();
				        hero5[4].levelUp();
				        hero5[4].levelUp();
				       
				        
				       
				        CombatController encounter5 = new CombatController(froForce, hero5, title.frame);
				        Loading load5 = new Loading(title.frame);
				        load5.panel.setVisible(false);
					       // victory Victory = new victory();
					        
		
		
        
        
        
	}

}

