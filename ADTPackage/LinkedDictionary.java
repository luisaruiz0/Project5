package ADTPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a chain of linked nodes.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedDictionary<K, V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
	
	public LinkedDictionary()
	{
      initializeDataFields();
	} // end default constructor
	
	public void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
   public V add(K key, V value)
	{
		V result = null;
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         // Search chain until you either find a node containing key
         // or locate where it should be
         Node currentNode = firstNode;
         Node nodeBefore = null;
         
         while ( (currentNode != null) && (key.equals(currentNode.getKey())) ) // key.compareTo(currentNode.getKey()) > 0
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
         if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; replace corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode.setValue(value);     // Replace value
         }
         else // Key not in dictionary; add new node in proper order
         {
            // Assertion: key and value are not null
            Node newNode = new Node(key, value); // Create new node
            
            if (nodeBefore == null)
            {                                    // Add at beginning (includes empty chain)
               newNode.setNextNode(firstNode);
               firstNode = newNode;
            }
            else                                 // Add elsewhere in non-empty chain
            {
               newNode.setNextNode(currentNode); // currentNode is after new node
               nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
            } // end if

            numberOfEntries++;                   // Increase length for both cases
         } // end if
      } // end if

		return result;
	} // end add

/* Implementations of other methods in DictionaryInterface.
   . . .
   Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */
   
   public V remove(K key)
	{
  	V result = null;  // return value
  	
		if (!isEmpty())
		{	
   	// search chain for a node containing key;
	    // save reference to preceding node
			Node currentNode = firstNode;
			Node nodeBefore = null;
			
   	while ( (currentNode != null) && !key.equals(currentNode.getKey()) )
			{
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			} // end while
			
			if (currentNode != null)
			{
				// node found; remove it
				Node nodeAfter = currentNode.getNextNode(); // node after the one to be removed

				if (nodeBefore == null)
					firstNode = nodeAfter;
				else
					nodeBefore.setNextNode(nodeAfter);        // disconnect the node to be removed

				result = currentNode.getValue();            // get ready to return removed entry
			  numberOfEntries--;                              // decrease length for both cases
			} // end if
		} // end if
			
   return result;  
 } // end remove

	public V getValue(K key) {
		V result = null;
		Node currentNode = firstNode;
			
	    while ( (currentNode != null) && !key.equals(currentNode.getKey()) )
			{
				currentNode = currentNode.getNextNode();
			} 

			if (currentNode != null)
			{
				result = currentNode.getValue();
			} 
			
			return result;
	}

	public boolean contains(K key) {
		return getValue(key) != null;
	}

	//Iterator classes
	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	} 
	
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	} 

  // 18.26
	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;
		
		private KeyIterator()
		{
			nextNode = firstNode;
		} 
		
		public boolean hasNext() 
		{
			return nextNode != null;
		}
		
		public K next()
		{
			K result;
			
			if (hasNext())
			{
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			} 
		
			return result;
		} 
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		} 
	} // end KeyIterator 
	
	private class ValueIterator implements Iterator<V>
	{
		private Node nextNode;
		
		private ValueIterator()
		{
			nextNode = firstNode;
		} 
		
		public boolean hasNext() 
		{
			return nextNode != null;
		}
		
		public V next()
		{
			V result;
			
			if (hasNext())
			{
				result = nextNode.getValue();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			} 
		
			return result;
		}
		
		public void remove()
		{
			throw new java.lang.UnsupportedOperationException();
		} 
	} // end getValueIterator

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public int getSize() {
		return numberOfEntries;
	}

	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}
   
   
   
   //NODE CLASS
	private class Node
	{
		private K key;
		private V value;
		private Node next;

/*    Constructors and the methods getKey, getValue, setValue, getNextNode,
      and setNextNode are here. There is no setKey.
      . . . */
		
		private Node(K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
			next = null;	
		} // end constructor
		
		private Node(K searchKey, V dataValue, Node nextNode)
		{
			key = searchKey;
			value = dataValue;
			next = nextNode;	
		} // end constructor
		
		private K getKey()
		{
			return key;
		} // end getKey
		
		private V getValue()
		{
			return value;
		} // end getValue

		private void setValue(V newValue)
		{
			value = newValue;
		} // end setValue

		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode

	} // end Node

} // end SortedLinkedDictionary
