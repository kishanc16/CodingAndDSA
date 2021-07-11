import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
	static int item = 1;

	static int createItem() {
		return item++;
	}

	public static void main(String[] args) throws InterruptedException {
		//BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10); // Handles concurrent thread access
		BlockQueueExample1 queue = new BlockQueueExample1(10);
						
		//Thread block if queue is full
		final Runnable producer = () -> {
			while (true) {
				queue.put(createItem());
			}
		};

		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();

		//Thread block if queue is empty
		final Runnable consumer = () -> {
			while (true) {
				int i = 0;
				i = queue.take();
				System.out.println("Item : " + i);
			}
		};

		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();

		Thread.sleep(100000);
	}

}
