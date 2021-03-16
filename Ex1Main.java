package view;

import java.util.concurrent.Semaphore;

import controller.Ex1Thread;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes=1;
		Semaphore semaforo=new Semaphore(permissoes);
		for(int idThread=1;idThread<=21;idThread++){
			Thread tCalc=new Ex1Thread(idThread,semaforo);
			tCalc.start();
		}
	}

}
