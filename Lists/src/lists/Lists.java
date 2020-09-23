/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Scanner;
/**
 *
 * @author samaniw
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner Dato = new Scanner (System.in);
        
        int Menu;
        System.out.println("Ingrese un Numero Dependiendo de la Lista: ");
        System.out.println("1. Lista Simple. ");
        System.out.println("2. Lista Doble. ");
        System.out.println("3. Lista Circular Simple. ");
        System.out.println("4. Lista CIrcular Doble. ");
        Menu = Dato.nextInt();
        
        switch (Menu) {
            case 1:
                SingleLinkedList<Integer> miListaS = new SingleLinkedList<>();
                miListaS.addLast(11);
                miListaS.addLast(99);
                miListaS.addLast(22);
                miListaS.addLast(55);
                miListaS.addLast(66);
                miListaS.addLast(77);
                miListaS.addLast(88);
                miListaS.addLast(100);

                System.out.println(miListaS.showData());
                System.out.println(miListaS.datos());
                miListaS.deleteLast();          
                System.out.println(miListaS.showData());
                System.out.println(miListaS.datos());
                break;
            case 2:
                DoubleLinkedList<Double> miListaD = new DoubleLinkedList<>();
                miListaD.add(1.1);
                miListaD.add(5.5);
                miListaD.add(3.3);
                miListaD.add(4.4);
                miListaD.add(2.2);

                System.out.println("Lista Enlazada Doble: " + miListaD.showData());
                miListaD.delete();
                System.out.println("Lista Enlazada Doble Primer Dato Eliminado: " + miListaD.showData());
                System.out.println("Ingrese el Dato que Desea Buscar(Con Decimal): ");
                Double Buscar = Dato.nextDouble();
                System.out.println(miListaD.exist(Buscar));
                break;
            case 3:
                CircularSingleLinkedList<String> miListaCS = new CircularSingleLinkedList<>();
                CircularSingleLinkedList<String> miListaCSDos = new CircularSingleLinkedList<>();

                miListaCSDos.add("22");
                miListaCSDos.add("11");
                miListaCSDos.add("66");

                miListaCS.add("33");
                miListaCS.add("44");
                miListaCS.add("55");
                miListaCS.add("77");
                miListaCS.add("88");
                miListaCS.add("99");

                System.out.println("Lista Circular Simple: " + miListaCS.showData());
                miListaCS.deleteLast();
                System.out.println("Lista Circular Simple Ultimo Dato Eliminado: " + miListaCS.showData());
                miListaCS.joinList(miListaCSDos);
                System.out.println("Lista Circular Simple Añadiendo Otra Lista: " + miListaCS.showData());
                break;
            case 4:
                CircularDoubleLinkedList<Integer> miListaCD = new CircularDoubleLinkedList<>();
                miListaCD.add(11);
                miListaCD.add(33);
                miListaCD.add(22);
                miListaCD.add(55);
                miListaCD.add(55); 
                miListaCD.add(88);
                miListaCD.add(77);               
                miListaCD.add(99);
                System.out.println("Listas Circular Doble: " + miListaCD.showData());
                miListaCD.delete();
                System.out.println("Listas Circular Doble Primer Dato Eliminado: "+ miListaCD.showData());
                miListaCD.deleteLast();
                System.out.println("Listas Circular Doble Ultimo Dato Eliminado: "+ miListaCD.showData());
                System.out.println("Listas Circular Doble Descendiente: "+ miListaCD.showDataDesc());                
                break;                
        }
    }
}
