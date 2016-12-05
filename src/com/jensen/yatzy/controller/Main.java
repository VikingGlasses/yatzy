package com.jensen.yatzy.controller;

import com.jensen.yatzy.model.Dice;
import com.jensen.yatzy.model.Yatzy;
import com.jensen.yatzy.view.GameView;
import com.jensen.yatzy.view.Window;

public class Main {

    
    
    
	public static void main(String[] args) {
		Window window = new Window();
		Yatzy yatzy = new Yatzy();
		Controller controller = new Controller(window, yatzy);
		
		
		/*
		GameView game = new GameView();
		window.setCurrentPanel(game);
		System.out.println(game.getHeight());

		
	*/
		window.pack();
		window.setVisible(true);
	}

}
