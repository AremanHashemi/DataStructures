package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;
public class HashtableChain<K, V>  implements KWHashMap<K, V>
{
	private LinkedList<Entry<K,V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 20;
	private static final int LOAD_THRESHOLD =  8;
	public HashtableChain()
	{
		table = new LinkedList[CAPACITY];
	}
	/**
	 * returns the value associated with the specified key
	 * returns null if key is not present
	 */
	@Override
	public V get(Object key)
	{
		int index = getHashIndex(key);
		if(table[index] == null)
		{
			return null;
		}
		for(Entry<K,V> element : table[index])
		{
			if(element.getKey() == key)
			{
				return element.getValue();
			}
		}
		return null;
	}
	/**
	 * prints every value in the hashTable
	 */
	public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			if(table[i] != null)
			{
				for(Entry element : table[i])
				{
					System.out.print(element);
				}
			}
			
		}
	}
	/**
	 * Associates the specified value with the s-pecified key, returns
	 * the previous value associated with the specified key or null
	 */
	@Override
	public V put(K key, V value)
	{
		int index = getHashIndex(key);
		if(table[index] == null)
		{
			table[index] = new LinkedList<>();
			Entry newEntry = new Entry(key,value);
			table[index].add(newEntry);
			numKeys++;
			return null;
		}
		for(Entry<K,V> element : table[index])
		{
			if(element.getKey() == key)
			{
				V oldValue = element.getValue();
				element.setValue(value);
				return oldValue;
			}
		}
		Entry newEntry = new Entry(key,value);
		table[index].add(newEntry);
		numKeys++;
		return null;
	}
	/**
	 * Removing mapping for the given key
	 * if not present returns null
	 * if present returns previous value
	 */
	@Override
	public V remove(Object key)
	{
		int index = getHashIndex(key);
		if(table[index] == null)
		{
			return null;
		}
		ListIterator iterator = table[index].listIterator();
		while(iterator.hasNext())
		{
			Entry element = (Entry)iterator.next();
			if(element.getKey() == key)
			{
				iterator.remove();
				numKeys--;
				if(table[index].isEmpty())
				{
					table[index] = null;
				}
				return (V) element.getValue();
			}
		}
		return null;
	}
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return numKeys;
	}
	/**
	 * returns true if empty
	 */
	@Override
	public boolean isEmpty()
	{
		if(numKeys == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * returns index in table based off keys hashcode
	 * @param key
	 * @return
	 */
	private int getHashIndex(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index+=table.length;
		}
		return index; 
	}
	private class SetIterator
	{
		private int index = 0;
		private ListIterator indexIterator;
		public SetIterator()
		{
			if(!isEmpty())
			{
				while(table[index].isEmpty() && index < table.length)
				{
					index++;
				}
				indexIterator = table[index].listIterator();
			}
		}
		public boolean hasNext()
		{
			if(indexIterator.hasNext())
			{
				return true;
			}
			while(table[index] != null && index < table.length)
			{
				index++;
			}
			if(index < table.length)
			{
				return true;
			}
			return false;
		}
		public Entry next()
		{
			if(!hasNext())
            {
                throw new NoSuchElementException();
            }
			if(indexIterator.hasNext())
			{
				return (Entry) indexIterator.next();
			}
			while(table[index]!= null && index < table.length)
			{
				index++;
			}
			if(index < table.length)
			{
				indexIterator = table[index].listIterator();
				return (Entry) indexIterator.next();
			}
			return (Entry)indexIterator.next();
		}
		public void remove()
		{
			try
			{
				numKeys--;
				indexIterator.remove();
			}
			catch(IllegalStateException e)
			{
				throw new IllegalStateException();
			}
		}
	}
	/**
	 * Container class for key value pairs
	 * @author arema
	 *
	 * @param <K>
	 * @param <V>
	 */
	private class Entry<K,V>
	{
		K key;
		V value;
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		public K getKey()
		{
			return key;
		}
		public V getValue()
		{
			return value;
		}
		public V setValue(V val)
		{
			return this.value = value;
		}
		public String toString()
		{
			return "(Key : " + key.toString() + " Value : " + value.toString() + "),";
		}
	}
}
