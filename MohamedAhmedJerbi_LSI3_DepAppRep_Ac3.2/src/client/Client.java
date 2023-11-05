package client;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import operation.Operation;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("je suis un client non connecté ");
        //connexion au serveur
        Socket s = new Socket("localhost", 501);
        System.out.println("je suis connecté ");
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        ObjectInputStream in = new ObjectInputStream(is);//lire l'objet
        ObjectOutputStream out = new ObjectOutputStream(os);//Utilisation de ObjectOutputStream pour pouvoir convertir
        // un objet (Serializable) à un fichier binair
        //ObjectOutputStream oos = new (os);
        Scanner scanner = new Scanner(System.in);
        System.out.println("choisir le premier valeur ");
        int nb =scanner.nextInt();
        int x;
        //verification de l'operation seulement 4 operation
        do {
            System.out.println("choisir un nombre 1:multiplication  2:soustraction 3:division 4:addition");
            x = scanner.nextInt();
        }while(x>4 || x<1);
        //pw.println(x);
        int y;
        System.out.println("choisr le deuxieme nombre ");
        y=scanner.nextInt();

        Operation v1 = new Operation(nb,y,x);//creation instance  a partir de la saisie de l'utilisateur
        out.writeObject(v1);
        Operation p = (Operation) in.readObject();
        System.out.println("le resultat:"+p.getRes());
        s.close();//deconnexion
    }
}