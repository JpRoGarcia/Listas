/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 */
public class SingleLinkedList<T extends Number & Comparable> implements Ilist<T> {

    private Node<T> head;
    private int max;
    private int min;    
    private int sum;    
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;        
    }   
    
    @Override
    public boolean isEmpty() {
        return head==null;
        /*
        if(head==null){
            return true;
        }else{
            return false;
        }
        */
    }
     
    @Override
    public void add(T d) {
        //1. Crear el nodo
        Node<T> newNode = new Node<>(d);
        //2. Modificar el siguiente nodo del nuevo nodo para sea la cabeza
        newNode.setNextNode(head);
        //3. Modificar la cabeza de la estructura: nuevo nodo
        head = newNode;
        //4. Incrementar el tamaño
        size++;
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
    }
    
    @Override
    public void addLast(T d) {
        if(isEmpty()){
            add(d);
        }else{
            Node<T> current=head;
            while(current.getNextNode()!=null){
                current = current.getNextNode();
            }
            Node<T> newNode = new Node<>(d);
            current.setNextNode(newNode);
        }    
        size++;
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
    }

    @Override
    public void addOrdered(T d) {
        /*Si la lista esta vacía, 
        o el valor del primer elemento de la lista(cabeza) 
        es mayor que el nuevo, insertar el nuevo nodo en la 
        primera posición de la lista y modificar la cabecera 
        respectivamente.
        */
        if(isEmpty() || head.getData().compareTo(d)>0){
            add(d);
        }else{
        /*
        Si no se cumple el caso anterior, buscar el lugar adecuado
        para la inserción: recorrer la lista conservando el nodo
        actual. Inicializar nodo actual con el valor de primera
        posición, y avanzar mientras el siguiente nodo no sea nulo 
        y el dato que contiene la siguiente posición sea menor 
        o igual que el dato a insertar.
        */
        
        Node<T> current = head;
        while(current.getNextNode()!=null
              && current.getNextNode().getData().compareTo(d)<0
                ){
            current = current.getNextNode();
        }        
        /*Con esto el nodo actual señala al nodo adecuado,
        a continuación insertar el nuevo nodo después de él.
        */
        Node<T> newNode = new Node<>(d);
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);        
        }
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
        size++;
    }

    @Override
    public void delete() {
        if(isEmpty()){
            System.out.println("Lista vacia");
        }else{
            //apuntar la cabeza al segundo dato
            head = head.getNextNode();
            if((getMax() == head.getData().intValue())||(getMin()== head.getData().intValue()))
            {
                size--;
                System.out.println(datos());
                size++;
            }          
        }
        size--;
        //verificar si el dato eliminado es el mínimo o máximo: actualizar(recorrer estructura)
        //restar de la suma de datos
    }

    
    
    
    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            //localizar el nodo anterior a getNextNode()==null
            Node<T> i = head;
            Node<T> previousNode = null;
            while (i.getNextNode() != null) {
                previousNode = i;
                i = i.getNextNode();
            }

            previousNode.setNextNode(null);
            
            if((getMax() == previousNode.getData().intValue())||(getMin()== previousNode.getData().intValue()))
            {
                size--;
                System.out.println(datos());
                size++;
            }
        }
        size--;
        
    }
    
    @Override
    public String showData() {        
        if(isEmpty()){
            return "Lista vacia";
        }else{
            String data = "";
            //Forma tradicional de recorrer la estructura
//            Node<T> current=head;
//            while(current!=null){
//                data += current.getData() + " ";
//                current = current.getNextNode();
//            }
            for (Node<T> i = head; i != null; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            //verificar si el dato eliminado es el mínimo o máximo: actualizar(recorrer estructura)
            return data;
        }
    }
    
     /**
     * Muestra el total de datos
     * @return El total de datos
     */
    public double getAverage(){
        sum = 0;
        for(Node<T> i = head;i != null;i = i.getNextNode()){
            sum += i.getData().intValue();
        } 
        return sum/(getSize()-1);
    }
    
    public int getSize() {
        return size;
    }

    /**
     * @return the maj
     */
    public int getMax() {
        max = 0;
        if (isEmpty())
        {
            System.out.println("Lista Vacia");
        }
        else
        {
            for(Node<T> i = head; i!=null; i=i.getNextNode())
                if(i.getData().intValue() > max)
                {
                    max = i.getData().intValue();
                } 
        }
        return max; 
    }

    /**
     * @return the min
     */
    public int getMin() {
        min = Integer.MAX_VALUE;
        if (isEmpty())
        {
            System.out.println("Lista Vacia");
        }
        else
        {
            for(Node<T> i = head; i.getNextNode()!=null; i=i.getNextNode())
                if(min > i.getData().intValue())
                {
                    min = i.getData().intValue();
                } 
        }
        return min;
    } 
    
    public String datos()
    {
        System.out.println("Lista Simple Dato Mayor: " + getMax());
        System.out.println("Lista Simple Dato Menor: " + getMin());
        System.out.println("Lista Simple Promedio  : " + getAverage());
        return "";
    }
}
