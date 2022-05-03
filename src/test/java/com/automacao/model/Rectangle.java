package com.automacao.model;

import java.io.*;

public class Rectangle implements Serializable {
    private double height;
    private double width;

    public Rectangle(double height, double width)
    {
        this.height = height;
        this.width = width;
    }

    public double Area()
    {
        return height * width;
    }

    public double Perimeter()
    {
        return 2 * (height + width);
    }
    public static void SerializeToFile(Object classObject, String fileName)
    {
        try {

            // Etapa 1: Abra um fluxo de saída de arquivo para criar um objeto de arquivo no disco.
            // Este objeto de arquivo será usado para escrever os bytes serializados de um objeto
            FileOutputStream fileStream = new FileOutputStream(fileName);

            // Etapa 2: Crie um ObjectOutputStream, essa classe recebe um fluxo de arquivos.
            // Esta classe é responsável por converter o Object de qualquer tipo em
            // um fluxo de bytes
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            //ObjectOutputStream.writeObject recebe um Object e
            // converte em um ByteStream. Em seguida, ele grava o fluxo de bytes em
            // o arquivo usando o fluxo de arquivo que criamos na etapa 1.
            objectStream.writeObject(classObject);

            // Etapa 4: feche os streams com facilidade
            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Object DeSerializeFromFileToObject(String fileName)
    {
        try {

            // Step 1: Create a file input stream to read the serialized content
            // of rectangle class from the file
            FileInputStream fileStream = new FileInputStream(new File(fileName));

            // Step 2: Create an object stream from the file stream. So that the content
            // of the file is converted to the Rectangle Object instance
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            // Step 3: Read the content of the stream and convert it into object
            Object deserializeObject = objectStream.readObject();

            // Step 4: Close all the resources
            objectStream.close();
            fileStream.close();

            // return the deserialized object
            return deserializeObject;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(18, 78);
        SerializeToFile(rect, "rectSerialized");

        Rectangle deSerializedRect = (Rectangle) DeSerializeFromFileToObject("rectSerialized");
        System.out.println("Rect area is " + deSerializedRect.Area());

    }


}
