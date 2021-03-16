package controller;

import java.util.concurrent.Semaphore;

public class Ex1Thread extends Thread {
	private int idThread;
	private int tempo;
	private int repeticoes;
	private Semaphore semaforo;

	public Ex1Thread(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo=semaforo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (idThread % 3 == 1) {
			restoUm(idThread);
		} else if (idThread % 3 == 2) {
			restoDois(idThread);
		} else if (idThread % 3 == 0) {
			restoZero(idThread);
		}
	}

	private void restoUm(int idThread) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			tempo = (int) ((Math.random() * 801) + 200);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("#"+idThread+" fez calculos por "+tempo+" milissegundos");
			try {
				semaforo.acquire();
				Transacoes(1000,idThread);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	private void restoDois(int idThread) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			tempo = (int) ((Math.random() * 1001) + 500);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("#"+idThread+" fez calculos por "+tempo+" milissegundos");
			try {
				semaforo.acquire();
				Transacoes(1500,idThread);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	private void restoZero(int idThread) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			tempo = (int) ((Math.random() * 1001) + 1000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("#"+idThread+" fez calculos por "+tempo+" milissegundos");
			try {
				semaforo.acquire();
				Transacoes(1500,idThread);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	private void Transacoes(int tempo, int idThread) {
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#"+idThread+" fez transacoes por "+tempo+" milissegundos");
	}
}
