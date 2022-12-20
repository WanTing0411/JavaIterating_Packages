package de.tum.in.ase;

import java.util.*;

// TODO: implement interface
public class Delivery<E> implements Iterable<E> {

    private final String address;
    private final Map<String, Set<Package>> packagesByAddress;

    public Delivery(String address, Map<String, Set<Package>> packages) {
        this.address = address;
        this.packagesByAddress = packages;
    }

    public Delivery(String address) {
        this.address = address;
        this.packagesByAddress = new HashMap<>();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private Set address= packagesByAddress.keySet();
            private List<Set<Package>> packageList = new ArrayList<Set<Package>>();
            private List<Map<String, Set<Package>>>addressList= new ArrayList<Map<String, Set<Package>>>();
            private int position=0;

            private void addPackList(){

            }
            @Override
            public boolean hasNext() {
                return position<packagesByAddress.size();
            }

            @Override
            public E next() {
                if(position==packagesByAddress.size()){
                    throw new NoSuchElementException();
                }

                return null;
            }
        };
    }


    public String getAddress() {
        return address;
    }

    public void add(Package aPackage) {
        // TODO implement method
        Set<Package> p = new HashSet<>();
        if (!packagesByAddress.containsKey(aPackage.getAddress())) {
            p.add(aPackage);
            packagesByAddress.put(aPackage.getAddress(), p);
        } else {
            p.add(aPackage);
            packagesByAddress.get(aPackage.getAddress()).add(aPackage);
        }
        //System.out.println(packagesByAddress);
        System.out.println("how many address: "+packagesByAddress.size());
        System.out.println("each packages detail: "+p);
        System.out.println("The key for each address: "+packagesByAddress.keySet());
        System.out.println("The value for each address: "+packagesByAddress.values());

        System.out.println();
    }

    @Override
    public String toString() {
        return "Delivery:\n  Address: " + address;
    }

    // TODO: implement iterator


    public static void main(String[] args) {
        // TODO test your code:

        Delivery delivery = new Delivery("Deliveryplace 1");
        delivery.add(new Package("Iceavenue 5", "Penguinway 4", 100));
        delivery.add(new Package("Iceavenue 5", "Penguinway 1", 85));
		delivery.add(new Package("Iceavenue 5", "Penguinway 1", 73));
//		delivery.add(new Package("Snowlane 3", "Antarcticplace 3", 107));
//		delivery.add(new Package("Winterhighway 89", "Antarcticplace 27", 20));
//		delivery.add(new Package("Penguinway 6", "Tierpark Hellabrunn, Tierparkstr. 30", 1));
//		delivery.add(new Package("Tierpark Hellabrunn, Tierparkstr. 30", "Penguinway 6", 0.3));
//		delivery.add(new Package("Antarcticplace 123", "Penguroad 1", 6));

//        Iterator<Delivery> it=delivery.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }


        Set<Integer>num = new HashSet<>();
        num.add(20);
        num.add(45);
        num.add(3);
        Map<String,Integer> a=new HashMap<>();
        a.put("one",1);
        a.put("two",2);
        a.put("three",3);
        System.out.println();
        System.out.println(a.keySet());
        System.out.println(a.values());
    }
}
