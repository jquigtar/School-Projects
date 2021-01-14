import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Main
 *
 * This is the main class of program 3 for CSS 436. this program uses amazon aws java sdk
 * to both backup local contents to the cloud, and restore contents from cloud to local computer.
 * this program assumes that aws cli is already configured for user with their own credentials and
 * region set up.
 */
public class AWS_Backup_Restore {

    /**
     * main
     *
     * this is the main method of the AWS_Backup_Restore program that takes in 3 arguments
     * the first is a command either backup or restore, and the next two are s3 bucket name
     * and a local file directory. the program will use these arguments to either backup local
     * files to the aws cloud, or restore contents from the cloud to the given local directory
     * @param args
     */
    public static void main(String[] args) {
        String cmd;
        String bucket = "";
        String directory = "";
        if(args.length == 3) { // checking to make sure 3 arguments passed into command line
            cmd = args[0];
            if(cmd.equals("backup")) {
                directory = args[1];
                bucket = args[2];
                backup(directory,bucket);
            }else if(cmd.equals("restore")){
                bucket = args[1];
                directory = args[2];
                restore(bucket,directory);
            }else{ //handle bad input to command line
                System.out.println("Incorrect command: " + cmd + ". Exiting program.");
                System.out.println("Must enter either 'backup' or 'restore' to command line.");
                System.exit(0);
            }
        }else{ // following program 3 PDF
            System.out.println("Must enter either 'backup' or 'restore' to command line.");
            System.out.println("If backup command: enter [directory-name] [bucket-name].");
            System.out.println("If restore command: enter [bucket-name] [directory-name]");
            System.out.println("Exiting program.");
            System.exit(0);
        }
        System.exit(0);
    }

    /**
     * backup
     *
     * this is a method that finds all files and directories to backup from given directory in
     * paramter, and backs up those files to aws cloud in a given bucket in parameter.
     * this method will make sure both directory and bucket exist, and then execute backup of files.
     * @param directory
     * @param bucket
     */
    private static void backup(String directory, String bucket){
        System.out.println("Backing up contents of local directory: " + directory + " to s3 bucket: " + bucket);
        ArrayList<Path> paths = new ArrayList<>();
        Path inputPath = Paths.get(directory);
        Path fullPath = inputPath.toAbsolutePath(); //making sure to use absolute path
        try {
            if(Files.exists(fullPath)) {
                Files.list(fullPath).forEach(path -> paths.add(path));  //creating list of paths from this directory
            }else{  //directory does not exist
                System.out.println("file path entered not found. exiting program.");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        AmazonS3Client s3 = new AmazonS3Client();
        if(s3.doesBucketExist(bucket)){
            recursiveBackup(paths, bucket, s3);
        }else{  //bucket does not exist
            System.out.println("bucket entered does not exist. exiting program.");
            System.exit(0);
        }
        System.out.println("Successfully backed up to cloud.");
    }

    /**
     * recursiveBackup
     *
     * This is a helper method that recursively searches through given directories and once
     * it gets to a file it will back that file up to the aws s3 bucket
     * @param paths
     * @param bucket
     * @param s3
     */
    private static void recursiveBackup(ArrayList<Path> paths, String bucket,AmazonS3Client s3 ){
        for (Path f : paths) {  //for each path from starting directory
            if (Files.isDirectory(f.toAbsolutePath())) {    // if it is a directory search through this directory
                ArrayList<Path> newPaths = new ArrayList<Path>();
                try {
                    Files.list(f.toAbsolutePath()).forEach(path -> newPaths.add(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recursiveBackup(newPaths, bucket, s3,f.toFile().toString());
            }
            if (Files.isRegularFile(f.toAbsolutePath())) {  //if it is a file backup to s3 bucket
                File toPut = f.toAbsolutePath().toFile();
                try {   //checking to see if object already exists in s3 bucket
                    S3Object get = s3.getObject("css436prog3", f.getParent().toString() + "/" + toPut.getName());
                    Date local = new Date(toPut.lastModified());
                    if(get.getObjectMetadata().getLastModified().before(local)){
                        //is file has not been modified locally since last upload to cloud, no need to upload
                        s3.putObject(bucket, f.getParent().toString() + "/" + toPut.getName(), toPut);
                    }
                }catch(AmazonS3Exception e) {
                    s3.putObject(bucket, f.getParent().toString() + "/" + toPut.getName(), toPut);
                }
            }
        }
    }

    /**
     * recursiveBackup
     *
     * This is a helper method that recursively searches through given directories and once
     * it gets to a file it will back that file up to the aws s3 bucket.
     * @param paths
     * @param bucket
     * @param s3
     * @param folder
     */
    private static void recursiveBackup(ArrayList<Path> paths, String bucket,AmazonS3Client s3,String folder){
        for (Path f : paths) {
            if (Files.isDirectory(f.toAbsolutePath())) {
                ArrayList<Path> newPaths = new ArrayList<Path>();
                try {
                    Files.list(f.toAbsolutePath()).forEach(path -> newPaths.add(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                folder = folder + f.getParent().toString() + "/";
                recursiveBackup(newPaths, bucket, s3);
            }
            if (Files.isRegularFile(f.toAbsolutePath())) {
                File toPut = f.toAbsolutePath().toFile();
                try {
                    S3Object get = s3.getObject("css436prog3", folder + "/" + toPut.getName());
                    Date local = new Date(toPut.lastModified());
                    if(get.getObjectMetadata().getLastModified().before(local)){
                        s3.putObject(bucket, folder + "/" + toPut.getName(), toPut);
                    }
                }catch(AmazonS3Exception e) {
                    s3.putObject(bucket, folder + "/" + toPut.getName(), toPut);
                }            }
        }
    }

    /**
     * restore
     *
     * This is a method that finds all files in given s3 bucket and restores them to given local
     * file directory.
     * @param bucket
     * @param directory
     */
    private static void restore(String bucket, String directory){
        System.out.println("Restoring contents of bucket : " + bucket + " to local directory: " + directory);
        AmazonS3Client s3 = new AmazonS3Client();
        TransferManager transferManager = new TransferManager();
        if(s3.doesBucketExist(bucket)){
            File toPut = Paths.get(directory).toFile();
            if(Files.isDirectory(toPut.toPath().toAbsolutePath())) {    //making sure passed in directory and not a file
                ObjectListing listing = s3.listObjects(bucket);
                List<S3ObjectSummary> bucketObjects = listing.getObjectSummaries(); //getting all objects in s3 bucket
                if(bucketObjects.size() >0) {
                    for (S3ObjectSummary object : bucketObjects) {  // for each object download to given directory
                        File newFile = new File(Paths.get(directory + object.getKey()).toString());
                        String key = object.getKey();
                        transferManager.download(bucket, key, newFile);
                    }
                }else{  //no objects in s3 bucket
                    System.out.println("No Objects in selected bucket. Exiting");
                    System.exit(0);
                }
            }else{
                System.out.println("Directory entered does not exist. Exiting program");
                System.exit(0);
            }
        }else{  //bucket does not exist in s3
            System.out.println("Bucket entered does not exist. Exiting program.");
            System.exit(0);
        }
        System.out.print("Successfully restored contents from cloud.");
    }
}

