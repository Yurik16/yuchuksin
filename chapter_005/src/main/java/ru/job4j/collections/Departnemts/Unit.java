package ru.job4j.collections.Departnemts;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.08.2017.
 */
public class Unit implements Comparable<Unit>{

   private String name;

   Unit(String name) {
       this.name = name;
   }

   public String getName() {
       return this.name;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        return name != null ? name.equals(unit.name) : unit.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Unit o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
