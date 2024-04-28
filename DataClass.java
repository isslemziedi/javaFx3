package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class DataClass implements ObservableList<Person> {
	private List<Person> importList;
    private List<Person> exportList;

    public DataClass() {
        importList = new ArrayList<Person>();
        importList.add(new Person("Sami", "BenAli", "sami@example.com"));
        importList.add(new Person("Alia", "BenSalah", "alia@example.com"));
        importList.add(new Person("Ali", "BenSalah", "ali@example.com"));
        exportList = new ArrayList<Person>();
    }

    public List<Person> getImportList() {
        return importList;
    }

    public List<Person> getExportList() {
        return exportList;
    }

    public void setExportList(List<Person> exportList) {
        this.exportList.addAll(exportList);
        for (Person p : this.exportList) {
            System.out.println(p);
        }
    }
    
    public boolean add(Person person) {
        return importList.add(person);
    }

	@Override
	public int size() {
		return importList.size();
	}

	@Override
	public boolean isEmpty() {
		return importList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return importList.contains(o);
	}

	@Override
	public Iterator<Person> iterator() {
		return importList.iterator();
	}

	@Override
	public Object[] toArray() {
		return importList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return importList.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return importList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Person> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Person> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person set(int index, Person element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Person element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Person> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Person> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Person... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addListener(ListChangeListener<? super Person> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeAll(Person... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ListChangeListener<? super Person> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean retainAll(Person... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Person... arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAll(Collection<? extends Person> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
