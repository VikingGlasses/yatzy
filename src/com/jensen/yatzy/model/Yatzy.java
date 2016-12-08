package com.jensen.yatzy.model;

import java.util.HashSet;
import java.util.Set;

public class Yatzy {
	
	private int numberOfRollsLeft = 3;
	
	private Dice[] dices;
	
	
	public Yatzy() {
		dices = new Dice[Constant.DEFUALT_NUMBER_OF_DICES];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
	}

	
	public Dice[] getDices() {
		return dices;
	}
        
        public int sum(){
            int sum=0;
            for(Dice dice: dices){
                sum += dice.getValue();
                
            }
            return sum;
        }
        
        public int sum(int value){
            int sum=0;
            for(Dice dice: dices){
                if(dice.getValue()==value)
                    sum += dice.getValue();
                
            }
            return sum;
        }
        
        public int onePair(){
            int sum=0;
            for(int i=0; i<dices.length; i++){
                int diceValue=dices[i].getValue();
                for(int nextDice=i+1; nextDice<dices.length; nextDice++){
                    if(diceValue == dices[nextDice].getValue()){
                        int tempSum = diceValue*2;
                        if(tempSum > sum){
                            sum = tempSum;
                            break;
                        }
                    }
                }
            }
            return sum;
        }
        
        public int twoPair(){
            int highestPair=onePair();
            int sum=0;
            for(int i=0; i<dices.length; i++){
                int diceValue=dices[i].getValue();
                for(int nextDice=i+1; nextDice<dices.length; nextDice++){
                    if(diceValue == dices[nextDice].getValue()){
                        sum = diceValue*2;
                        if(sum != highestPair){
                            return sum+ highestPair;
                        }
                    }
                }
            }
            return 0;
                
        }
        
        public int numberOfAKind(int number){
            
            for(int s=0; s<dices.length; s++){
                int numberOfEqualDices=1;
                int diceValue=dices[s].getValue();
                for(int nextDice=s+1; nextDice<dices.length; nextDice++){
                    if(diceValue == dices[nextDice].getValue()){
                        numberOfEqualDices++;
                    }
                }
                if(numberOfEqualDices >= number){
                    return number*diceValue;
                }
                
            }
            return 0;
        }
        
        public int fullHouse(){
            Set set = new HashSet();
            for(Dice dice: dices){
                set.add(dice.getValue());
                
            }
            if(set.size()==2){
                    Object[] values = set.toArray();
                    int value = (Integer)values[0];
                    int numberOf = sum(value) / value;
                    if (numberOf == 2 || numberOf == 3)
                        return sum();
                }
            return 0;
        }

	public int getNumbersOfRollsLeft() {
		return this.numberOfRollsLeft;
	}

	public void decreaseRolls() {
		this.numberOfRollsLeft -= 1;
	}

}
