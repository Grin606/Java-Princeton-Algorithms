public class MergeBU
{
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		// precondition: a[lo..mid], a[mid+1..hi] sorted
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		// copy:
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		// merge:
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)					a[k] = aux[j++];
			else if (j > hi)				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))	a[k] = aux[j++];
			else							a[k] = aux[i++];
		}

		// postcondition: a[lo..hi] sorted
		assert isSorted(a, lo, hi);
	}

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz)
			for (int lo = 0; lo < N - sz; lo += sz + sz)
				merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}

	private static boolean less(Comparable v, Comparable w)
	{	return v.compareTo(w) < 0;	}

	private static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for (int i = lo; i <= hi; ++i)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

}
