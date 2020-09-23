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
public class CircularDoubleLinkedList<T> implements Ilist<T> {

    DoubleNode<T> head;

    public CircularDoubleLinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    private boolean exist(T d) {

        DoubleNode<T> current = head;
        while (current.getNextNode() != head) {
            if (current.getData() == d) {
                return true;
            }
            current = current.getNextNode();
        }

        return current.getData() == d;
    }

    @Override
    public void add(T d) {
        DoubleNode<T> newNode= new DoubleNode<>(d);
        if(isEmpty()){
            head= newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        }else{
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            head=newNode;
            
        }
    }

    @Override
    public void addLast(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrdered(T d) {
       //Agregar datos ordenados sin repetir valor
       //(si el dato ya se encuentra en la lista, no ingresarlo y mostrar advertencia).}
       //Eso No Me Funciono :(
    }

    @Override
    public void delete() {
        //Eliminar el primer dato.
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            head.getPreviousNode().setNextNode(head.getNextNode());
            head.getNextNode().setPreviousNode(head.getPreviousNode());
            head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() {
        //Eliminar el último dato.
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            head.getPreviousNode().getPreviousNode().setNextNode(head);
            head.setPreviousNode(head.getPreviousNode().getPreviousNode());
        }
        
    }
/**
 * Mostrar los datos de forma descendente.
 * @return LIsta de datos en orden descendente
 */
    public String showDataDesc(){
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            DoubleNode<T> tail = head.getPreviousNode();
            for (DoubleNode<T> i = tail; i != head; i = i.getPreviousNode()) {
                data += i.getData() + " ";
            }
            return data += head.getData();

        }
    }
    
    @Override
    public String showData() {
               if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            DoubleNode<T> tail = head.getPreviousNode();
            for (DoubleNode<T> i = head; i != tail; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            return data += tail.getData();
        }
    }
}
