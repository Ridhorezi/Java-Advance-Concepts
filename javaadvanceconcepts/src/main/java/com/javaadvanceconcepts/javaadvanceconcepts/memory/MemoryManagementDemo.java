package com.javaadvanceconcepts.javaadvanceconcepts.memory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MemoryManagementDemo {
    
    // Contoh memory leak
    private static List<Object> leakyList = new ArrayList<>();
  
    public static void createMemoryLeak() {
        for (int i = 0; i < 1000; i++) {
            leakyList.add(new Object());
        }
        System.out.println("Created memory leak with 1000 objects");
    }
    
    public static void demonstrateGC() {
        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);
        System.out.println("Before GC - WeakReference: " + weakRef.get());
        obj = null; // Hapus strong reference
        // Sarankan GC untuk berjalan (tidak dijamin)
        System.gc();
        System.out.println("After GC - WeakReference: " + weakRef.get());
    }
    
    public static void demonstrateFinalize() {
        Object obj = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Finalize method called!");
                super.finalize();
            }
        };
        obj = null;
        System.gc();
    }
}