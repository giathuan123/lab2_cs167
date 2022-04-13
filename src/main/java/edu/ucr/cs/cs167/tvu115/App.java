// Replace <UCRNetID> with your UCR Net ID, not student ID.
package edu.ucr.cs.cs167.tvu115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;


/**
 * Word Count MapReduce Example.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        if(args.length != 2){
            System.err.println("Incorrect number of arguments! Expected two arguments.");
            System.exit(-1);
        }
        Path first_path = new Path(args[0]);
        Path second_path = new Path(args[1]);
        FileSystem fs1 = first_path.getFileSystem(conf);
        FileSystem fs2 = second_path.getFileSystem(conf);

        if(!fs1.exists(first_path)){
            System.err.printf("Input file '%s' does not exist!\n", first_path);
            System.exit(-1);
        }

        if(fs2.exists(second_path)){
            System.err.printf("Output fiel '%s' already exists!\n", second_path);
            System.exit(-1);
        }
        FSDataInputStream inputStream = fs1.open(first_path);
    }
}