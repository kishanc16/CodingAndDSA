import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author 503132605
 *Implements blocking queue manually
 */
public class BlockQueueExample1 {
	private Queue<Integer> queue;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock(true);
	
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	static int item = 1;

	static int createItem() {
		return item++;
	}
	BlockQueueExample1(int size){
		queue = new LinkedList<>();
		this.max = size;
	}
	
	public void put(int val){
		lock.lock();
		try{
			while(queue.size() == max){
				notFull.await();
			}
			queue.add(val);
			notEmpty.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public int take(){
		lock.lock();
		int val = 0;
		try{
			while(queue.size() == 0){
				notEmpty.await();
			}
			val = queue.remove();
			notFull.signalAll();
			return val;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return val;
		}finally{
			lock.unlock();
		}
		
	}
	public static void main(String[] args) {
		BlockQueueExample1 queue = new BlockQueueExample1(10);
		queue.put(createItem());
		

	}

}
