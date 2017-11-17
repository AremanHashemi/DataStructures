package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.ListIterator;
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
		return null;
	}

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
	private int getHashIndex(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index+=table.length;
		}
		return index; 
	}
//	private class SetIterator
//	{
//		private int index = 0;
//		private int lastItemReturned = -1;
//		private SetIterator()
//		{
//			
//		}
//		public boolean hasNext()
//		{
//			public boolean hasNext()
//	        {
//	            return nextItem != null;
//	        }
//		}
//		public Entry next()
//		{
//			
//		}
//		public Entry remove()
//		{
//			
//		}
//	}
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
