package KAGO_framework.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Mesh {

    public static final class MeshBuilder{
        private final ArrayList<Triangle> triangles = new ArrayList<>();

        public void add(Triangle triangle){
            triangles.add(triangle);
        }

        public Mesh build(){
            return new Mesh(triangles.toArray(new Triangle[0]));
        }

        public static Mesh loadFromFile(String path){
            File file = new File(path);

            if(!file.exists())
                throw new RuntimeException("File "+path+" does not exist");
            if(!path.endsWith(".obj"))
                throw new RuntimeException("Expected .obj file");

            Scanner sc;

            try{
                sc = new Scanner(file);
            }catch(FileNotFoundException e){
                throw new RuntimeException(e);
            }

            ArrayList<Vector3D> points = new ArrayList<>();
            ArrayList<Triangle> triangles = new ArrayList<>();

            while(sc.hasNextLine()){
                String[] args = sc.nextLine().split(" ");

                switch(args[0]){
                    case "v" -> points.add(new Vector3D(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])));
                    case "f" -> triangles.add(new Triangle(points.get(Integer.parseInt(args[1]) - 1), points.get(Integer.parseInt(args[2]) - 1), points.get(Integer.parseInt(args[3]) - 1)));
                }
            }

            return new Mesh(triangles.toArray(new Triangle[0]));
        }
    }

    private final Triangle[] triangles;

    private Mesh(Triangle[] triangles){
        this.triangles = triangles;
    }

    public Triangle[] getTriangles(){
        return triangles;
    }
}
