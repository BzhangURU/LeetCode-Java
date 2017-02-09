// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
int value;
		Iterator<Integer> iterator;
		boolean no_next;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			this.iterator=iterator;
		    if(iterator.hasNext()){
		    	this.value=iterator.next();
		    	no_next=false;
		    }else no_next=true;
		    
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return value;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			int old_value=value;
			if(iterator.hasNext()){
				value=iterator.next();
				no_next=false;
			}
			else no_next=true;
			
			return old_value;
		}

		@Override
		public boolean hasNext() {
		    return !no_next;
		}
}
