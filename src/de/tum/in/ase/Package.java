package de.tum.in.ase;

import java.util.Comparator;
import java.util.Objects;

public class Package implements Comparable<Package>{
	private String sender;
	private String address;
	private double weight;

	public Package(String sender, String address, double weight) {
		this.sender = sender;
		this.address = address;
		this.weight = weight;
	}

	@Override
	public int compareTo(Package o) {
		return Double.compare(o.getWeight(),this.getWeight());
		//if this.weight>o return 1/ this.weight<o return -1/this.weight==o return -1
	}



	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String toString() {
		return "Package from \"" + sender + "\" to \"" + address + "\" with weight " + weight;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Package otherPackage = (Package) other;
		return Double.compare(weight, otherPackage.weight) == 0
		       && Objects.equals(address, otherPackage.address)
		       && Objects.equals(sender, otherPackage.sender);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sender, address, weight);
	}

	public static void main(String[] args) {
		Package p1=new Package("Iceavenue 5", "Penguinway 4", 85);
		Package p2=new Package("Iceavenue 5", "Penguinway 1", 100);
		Package p3=new Package("Iceavenue 5", "Penguinway 1", 73);
		System.out.println(p1.compareTo(p2));

	}
}
