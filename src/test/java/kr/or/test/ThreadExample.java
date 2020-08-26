package kr.or.test;

public class ThreadExample {

	public static void main(String[] args) {
		Thread threadMovie = new MovieThread();
		threadMovie.setDaemon(true);//백드라운드로 실행
		threadMovie.start();
		
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		threadMovie.interrupt();
		
		Thread threadMusic = new Thread(new MusicRunnable());
		threadMusic.start();

	}

}

class MovieThread extends Thread {
	@Override
	public void run() {
		
		for(int i=0;i<3;i++) {
			System.out.println("동영상을 재생합니다.");
		}
		
		while(true) {
			System.out.println("동영상을 무한재생 합니다.");
			/*try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.toString());
				break;
			}*/
			if(Thread.interrupted()) {
				System.out.println("인터럽트가 발생 되었습니다. 반복문을 종료 합니다.");
				break;
			}
		}
		
	}
}

class MusicRunnable implements Runnable {
	@Override
	public void run() {
		
		for(int i=0;i<3;i++) {
			System.out.println("음악을 재생합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
		
	}
}
