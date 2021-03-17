# CodingChallengeMongoDB
To run this program via the command line, we have to provide exactly one argument, representing the absolute path of the JSON file we want to flatten.
This absolute path may be unique for each local machine. 
For example, to flatten the sample1.json file, I had to run Main with an argument "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample1.json".
This string representing a file's address is the first element of the args[] array in stdin. 

Therefore, my program reads args[0] (the first argument of args[] array), creates the corresponding JSONObject using org.json library, and 
prints the flattened version of JSONObject to stdout.

(I had the second contributor to this project because I used a template provided in my Program Design class, which contains all JUnit libraries)
