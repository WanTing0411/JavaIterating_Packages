package de.tum.in.ase;

import java.util.stream.*;
import java.util.stream.Collectors;

import java.util.*;

// TODO: implement interface
public class Delivery implements Iterable<Package> {

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

    public String getAddress() {
        return address;
    }

    public void add(Package aPackage) {
        // TODO implement method
        if (!packagesByAddress.containsKey(aPackage.getAddress())) {
            Set<Package> p = new HashSet<>();
            p.add(aPackage);
            packagesByAddress.put(aPackage.getAddress(), p);
        } else {
            packagesByAddress.get(aPackage.getAddress()).add(aPackage);
        }
    }

    @Override
    public String toString() {
        return "Delivery:\n  Address: " + address;
    }

    // TODO: implement iterator
    @Override
    public Iterator<Package> iterator() {
        return new Iterator<Package>() {
            private List<String> sortedKeys = new ArrayList<String>();
            private List<Set<Package>> value = new ArrayList<>();
            private List<Package> eachP = new ArrayList<>();
            private int position = 0;

            private void sortbykey() {
                HashMap<String, Set<Package>> tmp = packagesByAddress.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
                sortedKeys = new ArrayList<String>(tmp.keySet());
                value = new ArrayList<>(tmp.values());
                for (int j = 0; j < value.size(); j++) {
                    for (Package a : value.get(j).stream().sorted((o1, o2)-> o1.compareTo(o2)).collect(Collectors.toList())) {
                        eachP.add(a);
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return position < eachP.size();
            }

            @Override
            public Package next() {
                sortbykey();
                if (position == eachP.size()) {
                    throw new NoSuchElementException();
                }
                for(int i=0;i<eachP.size();i++){
                    position++;
                    return eachP.get(i);
                }
//                for (int i = 0; i < sortedKeys.size(); i++) {
//                    for (int j = 0; j < value.size(); j++) {
//                        for (Package a : value.get(j)) {
//                            return a;
//                        }
//                    }
//                }
                return null;
            }

            @Override
            public void remove() {
                throw new NoSuchElementException();
            }
        };
    }


    public static void main(String[] args) {
        // TODO test your code:
        Delivery delivery = new Delivery("Deliveryplace 1");
        delivery.add(new Package("Iceavenue 5", "Penguinway 4", 100));
        delivery.add(new Package("Iceavenue 5", "Penguinway 1", 85));
        delivery.add(new Package("Iceavenue 5", "Penguinway 1", 73));
//        delivery.add(new Package("Snowlane 3", "Antarcticplace 3", 107));
//        delivery.add(new Package("Winterhighway 89", "Antarcticplace 27", 20));
//        delivery.add(new Package("Penguinway 6", "Tierpark Hellabrunn, Tierparkstr. 30", 1));
//		delivery.add(new Package("Tierpark Hellabrunn, Tierparkstr. 30", "Penguinway 6", 0.3));
//		delivery.add(new Package("Antarcticplace 123", "Penguroad 1", 6));
        //System.out.println(delivery.iterator().next());
        while (delivery.iterator().hasNext()) {
            System.out.println(delivery.iterator().next());
        }



    }
}
