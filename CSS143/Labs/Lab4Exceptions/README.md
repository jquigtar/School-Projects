Summary

            In this part of the lab, you will fix errors and modify the code to handle exceptions for three different cases below.

 

Simple exception handling
Download the following file from the class website: TestExceptions.javaPreview the document
Compile the code and notice the compilation error message.
Modify the main() method to propagate the IOException (this is an ancestor of FileNotFoundException). This is done using a throws clause when the method is first declared.
While there are multiple exceptions that might be thrown by this code, this change should propagate all of them, since they all inherit from IOException.
Execute the program and notice the run-time error.
Modify the code to handle the exceptions using a try-catch block instead of propagating the exception. When the exception occurs print: “The file you have requested cannot be found.”
Test your changes.
 

Handling exceptions
Download the following file from the class website: CallStack.javaPreview the document
Examine the code to determine what it does.
Compile and execute the code.
Modify the main() method to handle the exception that is propagated to it. Use a try-catch block to display a meaningful error message when the exception occurs.
Test your code. Notice that, although the exception was thrown in func2, it is caught by the catch block in the main method.
 

Handling exceptions with a finally clause
Download the following file from the class website: TestFinally.javaPreview the document
Examine the code to determine what it does.
Compile the code and notice the error.
Modify TestFinally.java to handle the exception following these instructions (and those embedded in the code):
Embedded in the code is a note showing the location for the try statement.
The first line of the catch block should look like this:                               catch(IOException e) {
Display a meaningful error message to indicate the error that has occurred and include the following statement in your catch clause:                        System.out.println("The exception is: " + e);
Even when an error occurs in a method, there may be clean-up activities that are required before the method or program terminates. In this case, any open files should be closed prior to terminating the program.
Include a finally block that closes the files using notes 4 and 5 in the code that show where to place the beginning and end of the block.
You will need to add a try-catch block inside the finally block to handle any IOExceptions associated with the file close operation.
Test your code. When it is working, you will generate another type of exception.
Add a second catch clause inside the finally block with a meaningful message to handle this new exception.
