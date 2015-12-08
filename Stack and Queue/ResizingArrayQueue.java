public class ResizingArrayQueue<Item> 
{
	private Item[] q;
	private int head = 0;
	private int tail = 0;
		
	@SuppressWarnings("unchecked")
	public ResizingArrayQueue()
	{	q = (Item[]) new Object[1];	}
	
	public boolean isEmpty()
	{	return head == tail;	}
	
	private void resize(int capacity)
	{
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = head, j = 0; i < tail; ++i, ++j)
			copy[j] = q[i];
		q = copy;
		tail = tail - head;
		head = 0;
	}
	
	public void enqueue(Item item)
	{
		if (tail == q.length)
		{
			if (tail - head > q.length/2) 	resize(2 * q.length);
			else							resize(q.length);
		}
		q[tail++] = item;
	}
	
	public Item dequeue()
	{
		Item item = q[head];
		q[head++] = null;
		if (tail - head < q.length/4)	resize(q.length/2);
		return item;
	}

}
